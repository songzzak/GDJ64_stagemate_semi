package com.stagemate.detail.model.dao;

import static com.stagemate.common.JDBCTemplate.close;
import com.stagemate.detail.model.vo.Detail;
import com.stagemate.detail.model.vo.DetailInfo;
import com.stagemate.detail.model.vo.DetailTicketList;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class PlayListDao {

	private final Properties sql = new Properties();
	static SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public PlayListDao() {
	String path=PlayListDao.class.getResource("/sql/detail/detail_sql.properties").getPath();
	try {
		sql.load(new FileReader(path));
	} catch (IOException e) {
		e.printStackTrace();
	}

}

	public List<Detail> selectPlayDetail(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Detail> result=new ArrayList();
		try { 
			pstmt = conn.prepareStatement(sql.getProperty("searchPlayDetail"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getDetailList(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
		

	
	public static Detail getDetailList(ResultSet rs) throws SQLException{
		String formattedDate1 = dateFormat1.format(rs.getDate("RSV_DATE"));
		String formattedDate2 = dateFormat1.format(rs.getDate("ES_DATE"));
		return Detail.builder()
				.rsvNo(rs.getString("RSV_NO"))
				.eventName(rs.getString("EVENT_NM"))
				.rsvDate(formattedDate1)
				.esDate(formattedDate2)
				.orderStatus(rs.getString("ORDER_STATUS"))
				.tickets(rs.getString("TICKETS"))
				.build();
	}
	
	public static DetailInfo getDetailInfo(ResultSet rs) throws SQLException{
		String formattedDate = dateFormat1.format(rs.getDate("RSV_DATE"));
		return DetailInfo.builder()
				.rsvNo(rs.getString("RSV_NO"))
				.esNo(rs.getString("ES_NO"))
				.rsvDate(formattedDate)
				.rsvPirce(rs.getInt("RSV_PRICE"))
				.memberId(rs.getString("MEMBER_ID"))
				.memberNm(rs.getString("MEMBER_NM"))
				.orderStatus(rs.getString("ORDER_STATUS"))
				.tickets(rs.getString("TICKETS"))
				.eventName(rs.getString("EVENT_NM"))
				.fileName(rs.getString("EU_NAME_ORIGINAL"))
				.location(rs.getString("LOCATION"))
				.build();
	}
	
	public static DetailTicketList getDetailTicketList(ResultSet rs) throws SQLException{
		return DetailTicketList.builder()
				.seatNo(rs.getString("SEAT_NO"))
				.esNo(rs.getString("ES_NO"))
				.isReserved(rs.getString("IS_RESERVED"))
				.seatRow(rs.getString("SEAT_ROW"))
				.seatCol(rs.getString("SEAT_COL"))
				.slvNM(rs.getString("SLV_NM"))
				.slvPrice(rs.getInt("SLV_PRICE"))
				.build();
	}
	
	public int selectPlayDetailCount(Connection conn, String userId, String day, String yyyy, String mm, String status) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= 0;
		try { 
			String query = "SELECT COUNT(*) AS row_count "
					+ "FROM EVENT_ORDER_TB A JOIN EVENT_SCHEDULE_TB B ON A.ES_NO=B.ES_NO "
					+ "JOIN EVENT_TB C ON B.EVENT_NO=C.EVENT_NO";

			
			query +=  " WHERE (RSV_DATE >= CASE "
					+ "    WHEN '" + day + "' = '1' THEN SYSDATE - INTERVAL '7' DAY "
					+ "    WHEN '" + day + "' = '2' THEN SYSDATE - INTERVAL '1' MONTH "
					+ "    WHEN '" + day + "' = '3' THEN SYSDATE - INTERVAL '3' MONTH "
					+ "END)";
			if (!yyyy.equals("")) {
				query += " AND (TO_CHAR(RSV_DATE, 'YYYY') = '" + yyyy + "')";
			}
			
			if (!mm.equals("")) {
				query += " AND (TO_CHAR(RSV_DATE, 'MM') = '" + mm + "')";
			}
			
			if (!status.equals("전체")) {
				query += " AND (ORDER_STATUS = '" + status + "')";	
			}
			
			query += " AND (MEMBER_ID = '" + userId + "')";	
			
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
	
	public List<Detail> selectPlayDetailCondition(Connection conn, String userId, String day, String yyyy, String mm, String status, int startRow, int endRow){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Detail> result = new ArrayList();
		try { 
			String query = "SELECT * FROM (SELECT A.*, C.EVENT_NM, B.ES_DATE, (SELECT COUNT(*) FROM EVENT_ORDER_DETAIL_TB WHERE RSV_NO = A.RSV_NO) AS TICKETS, "
					+ "ROW_NUMBER() OVER (ORDER BY A.RSV_DATE DESC) AS RN "
					+ "FROM EVENT_ORDER_TB A JOIN EVENT_SCHEDULE_TB B ON A.ES_NO=B.ES_NO "
					+ "JOIN EVENT_TB C ON B.EVENT_NO=C.EVENT_NO " 
					+ "WHERE (RSV_DATE >= CASE "
					+ "    WHEN '" + day + "' = '1' THEN SYSDATE - INTERVAL '7' DAY "
					+ "    WHEN '" + day + "' = '2' THEN SYSDATE - INTERVAL '1' MONTH "
					+ "    WHEN '" + day + "' = '3' THEN SYSDATE - INTERVAL '3' MONTH "
					+ "END)";
			if (!yyyy.equals("")) {
				query += " AND (TO_CHAR(RSV_DATE, 'YYYY') = '" + yyyy + "')";
			}
			
			if (!mm.equals("")) {
				query += " AND (TO_CHAR(RSV_DATE, 'MM') = '" + mm + "')";
			}
			
			if (!status.equals("전체")) {
				query += " AND (ORDER_STATUS = '" + status + "')";	
			}
			
			query += " AND (MEMBER_ID = '" + userId + "'))";	
			query += " WHERE (RN BETWEEN ? AND ?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getDetailList(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	

	public DetailInfo selectPlayDetailInfo(Connection conn, String userId, String rsvNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DetailInfo result = new DetailInfo();
		try { 
			String query = "SELECT A.RSV_NO, A.RSV_DATE, A.RSV_PRICE, A.MEMBER_ID, A.ORDER_STATUS, (SELECT MEMBER_NM FROM MEMBER_TB m WHERE m.MEMBER_ID = A.MEMBER_ID) AS MEMBER_NM, "
					+ "(SELECT COUNT(*) FROM EVENT_ORDER_DETAIL_TB WHERE RSV_NO = A.RSV_NO) AS TICKETS, B.*, C.*, D.EU_NAME_ORIGINAL "
					+ "FROM EVENT_ORDER_TB A JOIN EVENT_SCHEDULE_TB B ON A.ES_NO=B.ES_NO JOIN EVENT_TB C ON B.EVENT_NO=C.EVENT_NO "
					+ "JOIN EVENT_UPFILE_TB D ON B.EVENT_NO=D.EVENT_NO "
					+ "WHERE D.PURPOSE_NO = 'PUR1' AND A.RSV_NO = ? AND A.MEMBER_ID = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rsvNo);
			pstmt.setString(2, userId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = getDetailInfo(rs);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	

	public List<DetailTicketList> selectPlayDetailTicketList(Connection conn, String rsvNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DetailTicketList> result = new ArrayList();
		try { 
			String query = "SELECT C.SEAT_NO, A.RSV_NO, A.ES_NO, C.IS_RESERVED, C.SEAT_ROW, C.SEAT_COL, C.SLV_NO, D.SLV_NM, D.SLV_PRICE "
					+ "FROM EVENT_ORDER_TB A JOIN EVENT_ORDER_DETAIL_TB B ON A.RSV_NO=B.RSV_NO "
					+ "JOIN SEAT_TB C ON B.SEAT_NO=C.SEAT_NO JOIN SEAT_LEVEL_TB D ON C.SLV_NO=D.SLV_NO  "
					+ "WHERE A.RSV_NO = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rsvNo);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getDetailTicketList(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	} 
	
	public int selectPlayDetailInfoCancel(Connection conn, String userId, String rsvNo, String esNo){
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int result = 0;
	    try {
	        conn.setAutoCommit(false); // 트랜잭션 시작
	        
	        if (!userId.equals("")) {
	        	String query1 = "UPDATE SEAT_TB "
		                + "SET ES_NO = NULL, IS_RESERVED = 'N' "
		                + "WHERE ES_NO = ? AND IS_RESERVED = 'Y'";

		        pstmt = conn.prepareStatement(query1);
		        pstmt.setString(1, esNo);
		        int updateCnt = pstmt.executeUpdate();

//		        String query2 = "DELETE FROM EVENT_ORDER_DETAIL_TB "
//		        		+ "WHERE RSV_NO = ?";
//		        pstmt = conn.prepareStatement(query2);
//		        pstmt.setString(1, rsvNo);
//		        updateCnt = pstmt.executeUpdate();
		        
		        String query3 = "UPDATE EVENT_ORDER_TB  "
		                + "SET ORDER_STATUS = '취소' "
		                + "WHERE RSV_NO = ? AND ES_NO = ? AND MEMBER_ID = ?";

		        pstmt = conn.prepareStatement(query3);
		        pstmt.setString(1, rsvNo);
		        pstmt.setString(2, esNo);
		        pstmt.setString(3, userId);
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
