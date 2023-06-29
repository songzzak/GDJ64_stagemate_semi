package com.stagemate.admin.model.dao;

import static com.stagemate.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.stagemate.common.JDBCTemplate;
import com.stagemate.common.MemberGenerator;
import com.stagemate.admin.model.vo.PlayInfo;
import com.stagemate.common.AESEncryptor;
import com.stagemate.detail.model.vo.EventOrder;
import com.stagemate.detail.model.vo.StoreOrder;
import com.stagemate.event.model.vo.Event;
import com.stagemate.member.model.vo.Member;

public class AdminDao {
	private final Properties sql = new Properties();

	public AdminDao() {
		String path = AdminDao.class.getResource("/sql/admin/adminsql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Member> memberManage(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("searchMember"));
			pstmt.setInt(1, (cPage - 1) * numPerpage + 1);
			pstmt.setInt(2, cPage * numPerpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = MemberGenerator.by(rs);
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return members;
	}

	public int memberCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectMemberCount"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int selectMemberCountByType(Connection conn,String keyword, String type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql=this.sql.getProperty("selectMemberCountByType");
		sql=sql.replace("#COL", type);
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public List<Member> searchMember(Connection conn,String keyword, String type, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> members=new ArrayList<>();
		String sql=this.sql.getProperty("searchMemberByType");
		sql=sql.replace("#COL", type);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=MemberGenerator.by(rs);
				members.add(m);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return members;
	}
	
	public int outmember(Connection conn,String outid) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("outmember"));
			pstmt.setString(1, outid);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public static Member getMemberDTO(ResultSet rs) throws SQLException {
		return Member.builder().memberId(rs.getString("MEMBER_ID")).memberPw(rs.getString("MEMBER_PW"))
				.memberNm(rs.getString("MEMBER_NM")).memberBdate(rs.getDate("MEMBER_BDATE"))
				.memberEmail(rs.getString("MEMBER_EMAIL")).memberPhone(rs.getString("MEMBER_PHONE"))
				.memberAddress(rs.getString("MEMBER_ADDRESS")).enrollDate(rs.getDate("ENROLL_DATE"))
				.wthdrDate(rs.getDate("WTHDR_DATE"))
				// .proImgNo(rs.getInt(""))
				.build();
	}
	
	//관리자페이지 예매내역 조회 playInfo
	public List<PlayInfo> playInfo(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PlayInfo> infos = new ArrayList<>();
		try { 
			String query = "SELECT EVENT_ORDER_TB.RSV_NO, EVENT_ORDER_TB.ORDER_STATUS, EVENT_ORDER_TB.RSV_DATE, MEMBER_TB.MEMBER_ID, MEMBER_TB.MEMBER_EMAIL, MEMBER_TB.MEMBER_PHONE "
					+ "FROM EVENT_ORDER_TB "
					+ "INNER JOIN MEMBER_TB ON MEMBER_TB.MEMBER_ID = EVENT_ORDER_TB.MEMBER_ID ";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PlayInfo m = getPlayInfoDTO(rs);
				infos.add(m);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return infos;
	}	
	public static PlayInfo getPlayInfoDTO(ResultSet rs) throws SQLException {
		
		String phone="";
		String email="";
		try {
			phone=AESEncryptor.decrypt(rs.getString("MEMBER_PHONE"));
		}catch(Exception e) {
			phone=rs.getString("MEMBER_PHONE");
		}
		try {
			email=AESEncryptor.decrypt(rs.getString("MEMBER_EMAIL"));
		}catch(Exception e) {
			email=rs.getString("MEMBER_EMAIL");
		}
		
		return PlayInfo.builder()
				.memberId(rs.getString("MEMBER_ID"))
				.rsvNo(rs.getString("RSV_NO"))
				.memberPhone(phone)
				.rsvDate(rs.getString("RSV_DATE"))
				.memberEmail(email)
				.orderStatus(rs.getString("ORDER_STATUS"))
				.build();
	}
	

	//예매 상세정보
	public List<EventOrder> selectEventOrder(Connection conn,String userId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EventOrder> eventOrder = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectEventOrder"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				eventOrder.add(getEventOrder(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return eventOrder;
	}
	
	private EventOrder getEventOrder(ResultSet rs) throws SQLException{
		String phone="",email="";
		try {
			phone=AESEncryptor.decrypt(rs.getString("member_phone"));
		}catch(Exception e) {
			phone=rs.getString("member_phone");
		}
		try {
			email=AESEncryptor.decrypt(rs.getString("member_email"));
		}catch(Exception e) {
			email=rs.getString("member_email");
		}
		return EventOrder.builder()
				.orderStatus(rs.getString("order_status"))
				.paymentNo(rs.getString("payment_no"))
				.rsv_price(rs.getInt("rsv_price"))
				.rsvDate(rs.getDate("rsv_date"))
				.rsvNo(rs.getString("rsv_no"))
				.esDate(rs.getDate("es_date"))
				.member(Member.builder()
						.memberId(rs.getString("member_id"))
						.memberNm(rs.getString("member_nm"))
						.memberBdate(rs.getDate("member_bdate"))
						.memberEmail(email)
						.memberPhone(phone)
						.memberAddress(rs.getString("member_address"))
						.build()
						)
				.tcnt(rs.getInt("tcnt"))
				.event(Event.builder()
						.eventNm(rs.getString("event_nm"))
						.build())
				.build();
		}
	
			
		
			//예매 결제 취소 요청 진행
			public List<EventOrder> selectCancelOrder(Connection conn,String rsvNo){
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<EventOrder> eventOrder = new ArrayList<>();
				try {
					String query=sql.getProperty("selectCancelOrder");
					pstmt = conn.prepareStatement(sql.getProperty("selectCancelOrder"));
					pstmt.setString(1, rsvNo);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						eventOrder.add(getEventOrder(rs));
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(rs);
					close(pstmt);
				}return eventOrder;
			}
			
			private EventOrder getCancelOrder(ResultSet rs) throws SQLException{
				return EventOrder.builder()
						
						.paymentNo(rs.getString("payment_no"))
						.rsv_price(rs.getInt("rsv_price"))
						.rsvNo(rs.getString("rsv_no"))
						.member(Member.builder()
								.memberNm(rs.getString("member_nm"))
								.build()
								)
						.build();
				}
			
			
			//스토어 회원 상세 정보
			/*
			 * public List<StoreOrder> selectStoreOrder(Connection conn,String userId){
			 * PreparedStatement pstmt = null; ResultSet rs = null; List<StoreOrder>
			 * storeOrder = new ArrayList<>(); try { pstmt =
			 * conn.prepareStatement(sql.getProperty("selectStoreOrder"));
			 * pstmt.setString(1, userId); rs = pstmt.executeQuery(); while (rs.next()) {
			 * storeOrder.add(getStoreOrder(rs)); } }catch(SQLException e) {
			 * e.printStackTrace(); }finally { close(rs); close(pstmt); }return storeOrder;
			 * }
			 */
			
			/*
			 * private StoreOrder getStoreOrder(ResultSet rs) throws SQLException{ String
			 * phone="",email=""; try {
			 * phone=AESEncryptor.decrypt(rs.getString("member_phone")); }catch(Exception e)
			 * { phone=rs.getString("member_phone"); } try {
			 * email=AESEncryptor.decrypt(rs.getString("member_email")); }catch(Exception e)
			 * { email=rs.getString("member_email"); } return StoreOrder.builder()
			 * .orderStatus(rs.getString("order_status"))
			 * .paymentNo(rs.getString("payment_no")) .totalPrice(rs.getInt("total_price"))
			 * .orderDate(rs.getDate("order_date")) .orderNo(rs.getString("order_no"))
			 * .member(Member.builder() .memberId(rs.getString("member_id"))
			 * .memberNm(rs.getString("member_nm")) .memberBdate(rs.getDate("member_bdate"))
			 * .memberEmail(email) .memberPhone(phone)
			 * .memberAddress(rs.getString("member_address")) .build() )
			 * .product(Product.builder() .productNm(rs.getString("product_nm")) .build())
			 * .build(); }
			 */
			//스토어 결제 취소 요청 진행
			/*
			 * public List<StoreOrder> selectStoreCancel(Connection conn,String orderNo){
			 * PreparedStatement pstmt = null; ResultSet rs = null; List<StoreOrder>
			 * storeOrder = new ArrayList<>(); try { String
			 * query=sql.getProperty("selectStoreCancel"); pstmt =
			 * conn.prepareStatement(sql.getProperty("selectStoreCancel"));
			 * pstmt.setString(1, orderNo); rs = pstmt.executeQuery(); while (rs.next()) {
			 * storeOrder.add(getStoreOrder(rs)); } }catch(SQLException e) {
			 * e.printStackTrace(); }finally { close(rs); close(pstmt); }return storeOrder;
			 * }
			 * 
			 * private StoreOrder getStoreCancel(ResultSet rs) throws SQLException{
			 * 
			 * return StoreOrder.builder() .paymentNo(rs.getString("payment_no"))
			 * .totalPrice(rs.getInt("total_price")) .orderNo(rs.getString("order_no"))
			 * .member(Member.builder() .memberNm(rs.getString("member_nm")) .build() )
			 * .build(); }
			 * 
			 */
			
			//예매 결제 취소 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//회원수정 멤버 정보
	public List<Member> MemberInfoma(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from member_tb");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = MemberGenerator.by(rs);
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return members;
	}

}
