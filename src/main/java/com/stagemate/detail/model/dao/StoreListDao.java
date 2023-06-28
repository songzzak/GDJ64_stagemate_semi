package com.stagemate.detail.model.dao;

import static com.stagemate.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.stagemate.detail.model.vo.Detail;
import com.stagemate.detail.model.vo.StoreDetail;
import com.stagemate.detail.model.vo.StoreDetailInfo;
import com.stagemate.detail.model.vo.StoreDetailOrderDlv;

public class StoreListDao {
	private final Properties sql = new Properties();
	static SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public StoreListDao() {
		String path=StoreListDao.class.getResource("/sql/detail/detail_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<StoreDetail> selectStoreDetail(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StoreDetail> result=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchStoreDetail"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getStoreDetailList(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public static StoreDetail getStoreDetailList(ResultSet rs) throws SQLException{
		String formattedDate = dateFormat1.format(rs.getDate("ORDER_DATE"));
		return StoreDetail.builder()
				.orderNo(rs.getString("ORDER_NO"))
				.productNm(rs.getString("PRODUCT_NM"))
				.totalPrice(rs.getInt("TOTAL_PRICE"))
				.orderDate(formattedDate)
				.orderStatus(rs.getString("ORDER_STATUS"))
				.build();
	}
	
	public static StoreDetailInfo getStoreDetailInfo(ResultSet rs) throws SQLException{
		String formattedDate = dateFormat1.format(rs.getDate("ORDER_DATE"));
		return StoreDetailInfo.builder()
				.orderNo(rs.getString("ORDER_NO"))
				.orderStatus(rs.getString("ORDER_STATUS"))
				.totalPirce(rs.getInt("TOTAL_PRICE"))
				.orderAMT(rs.getInt("ORDER_AMT"))
				.orderDate(formattedDate)
				.productTitle(rs.getString("PRODUCT_TITLE"))
				.productNm(rs.getString("PRODUCT_NM"))
				.productPrice(rs.getInt("PRODUCT_PRICE"))
				.imgFileRename(rs.getString("IMG_FILE_RENAME"))
				.build();
	}
	
	public static StoreDetailOrderDlv getStoreDetailOrderDlv(ResultSet rs) throws SQLException{
		return StoreDetailOrderDlv.builder()
				.orderNo(rs.getString("ORDER_NO"))
				.shipMsg(rs.getString("SHIP_MSG"))
				.memberId(rs.getString("MEMBER_ID"))
				.memberNm(rs.getString("MEMBER_NM"))
				.memberEmail(rs.getString("MEMBER_EMAIL"))
				.memberPhone(rs.getString("MEMBER_PHONE"))
				.dlvPerson(rs.getString("DLV_PERSON"))
				.dlvPhone(rs.getString("DLV_PHONE"))
				.dlvAddress(rs.getString("DLV_ADDRESS"))
				.build();
	}
	
	public int selectStoreDetailCount(Connection conn, String userId, String day, String yyyy, String mm, String status){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= 0;
		try { 
			String query = "SELECT COUNT(*) AS row_count " +
		              "FROM PRD_ORDER_TB A JOIN PRD_ORDER_DETAIL_TB B ON A.ORDER_NO = B.ORDER_NO JOIN PRODUCT_TB C ON B.PRODUCT_NO = C.PRODUCT_NO ";
			query +=  "WHERE (ORDER_DATE >= CASE "
					+ "    WHEN '" + day + "' = '1' THEN SYSDATE - INTERVAL '7' DAY "
					+ "    WHEN '" + day + "' = '2' THEN SYSDATE - INTERVAL '1' MONTH "
					+ "    WHEN '" + day + "' = '3' THEN SYSDATE - INTERVAL '3' MONTH "
					+ "END)";
			if (!yyyy.equals("")) {
				query += " AND (TO_CHAR(ORDER_DATE, 'YYYY') = '" + yyyy + "')";
			}
			
			if (mm != "") {
				query += " AND (TO_CHAR(ORDER_DATE, 'MM') = '" + mm + "')";
			}
			
			query += " AND (MEMBER_ID = '" + userId + "')";	
			query += " AND (ORDER_STATUS = '" + status + "')";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			    result = rs.getInt("row_count");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public List<StoreDetail> selectStoreDetailCondition(Connection conn, String userId, String day, String yyyy, String mm, String status, int startRow, int endRow, String order){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StoreDetail> result = new ArrayList();
		try { 
			String query = "SELECT * FROM (SELECT A.*, B.PRODUCT_NO, C.PRODUCT_NM, ROW_NUMBER() OVER (ORDER BY A.ORDER_DATE " + order + ") AS RN " +
		             "FROM PRD_ORDER_TB A JOIN PRD_ORDER_DETAIL_TB B ON A.ORDER_NO = B.ORDER_NO JOIN PRODUCT_TB C ON B.PRODUCT_NO = C.PRODUCT_NO " +
		             "WHERE (ORDER_DATE >= CASE " + 
					 "    WHEN '" + day + "' = '1' THEN SYSDATE - INTERVAL '7' DAY " + 
					 "    WHEN '" + day + "' = '2' THEN SYSDATE - INTERVAL '1' MONTH " + 
					 "    WHEN '" + day + "' = '3' THEN SYSDATE - INTERVAL '3' MONTH " + 
					 "END)";
			
			if (!yyyy.equals("")) {
				query += " AND (TO_CHAR(ORDER_DATE, 'YYYY') = '" + yyyy + "')";
			}
			
			if (!mm.equals("")) {
				query += " AND (TO_CHAR(ORDER_DATE, 'MM') = '" + mm + "')";
			}
			
			query += " AND (MEMBER_ID = '" + userId + "')";	
			query += " AND (ORDER_STATUS = '" + status + "')";
			query += ") T WHERE (RN BETWEEN ? AND ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getStoreDetailList(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public StoreDetailInfo selectStoreDetailInfo(Connection conn, String userId, String orderNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StoreDetailInfo result = new StoreDetailInfo();
		try { 
			String query = "SELECT A.ORDER_NO, A.ORDER_STATUS, A.TOTAL_PRICE, A.ORDER_DATE, B.ORDER_AMT, C.PRODUCT_TITLE, C.PRODUCT_NM, C.PRODUCT_PRICE, D.IMG_FILE_RENAME "
					+ "FROM PRD_ORDER_TB A JOIN PRD_ORDER_DETAIL_TB B ON A.ORDER_NO = B.ORDER_NO JOIN PRODUCT_TB C ON B.PRODUCT_NO = C.PRODUCT_NO "
					+ "JOIN STORE_UPFILE_TB D ON C.PRODUCT_NO=D.PRODUCT_NO "
					+ "WHERE A.ORDER_NO = ? AND A.MEMBER_ID = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, orderNo);
			pstmt.setString(2, userId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = getStoreDetailInfo(rs);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public StoreDetailOrderDlv selectStoreDetailOrderDlv(Connection conn, String userId, String orderNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StoreDetailOrderDlv result = new StoreDetailOrderDlv();
		try { 
			String query = "SELECT A.ORDER_NO, A.SHIP_MSG, B.MEMBER_ID, B.MEMBER_NM, B.MEMBER_EMAIL, B.MEMBER_PHONE, C.DLV_PERSON, C.DLV_PHONE, C.DLV_ADDRESS "
					+ "FROM PRD_ORDER_TB A JOIN MEMBER_TB B ON A.MEMBER_ID=B.MEMBER_ID JOIN DLV_ADDRESS_TB C ON A.DLV_ID = C.DLV_ID "
					+ "WHERE A.ORDER_NO = ? AND A.MEMBER_ID = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, orderNo);
			pstmt.setString(2, userId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = getStoreDetailOrderDlv(rs);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public int selectStoreDetailInfoCancel(Connection conn, String userId, String orderNo){
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int result = 0;
	    try {
	        conn.setAutoCommit(false); // 트랜잭션 시작
	        
	        if (!userId.equals("")) {
//		        String query1 = "DELETE FROM PRD_ORDER_DETAIL_TB "
//		        		+ "WHERE ORDER_NO = ?";
//		        pstmt = conn.prepareStatement(query1);
//		        pstmt.setString(1, orderNo);
//		        int updateCnt = pstmt.executeUpdate();
		        
		        String query2 = "UPDATE PRD_ORDER_TB  "
		                + "SET ORDER_STATUS = '결제 취소' "
		                + "WHERE ORDER_NO = ? AND MEMBER_ID = ?";

		        pstmt = conn.prepareStatement(query2);
		        pstmt.setString(1, orderNo);
		        pstmt.setString(2, userId);
		        result = pstmt.executeUpdate();

		        conn.commit();
	        }
	    } catch (SQLException e) {
	        try {
	            conn.rollback();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        e.printStackTrace();

	    } finally {
	        try {
	            conn.setAutoCommit(true);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        close(rs);
	        close(pstmt);
	    }

	    return result;
	}
}
	
	
	
	

