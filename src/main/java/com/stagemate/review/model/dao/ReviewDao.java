package com.stagemate.review.model.dao;

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

import com.stagemate.admin.model.dao.AdminDao;
import com.stagemate.detail.model.vo.Detail;
import com.stagemate.review.model.vo.PlaySearch;
import com.stagemate.review.model.vo.ReviewPlay;
import com.stagemate.review.model.vo.ReviewStore;
import com.stagemate.review.model.vo.StoreSearch;

public class ReviewDao {

	private final Properties sql = new Properties();
	static SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public ReviewDao() {
		String path = ReviewDao.class.getResource("/sql/review/review_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ReviewPlay getReviewPlayList(ResultSet rs) throws SQLException{
		String formattedDate1 = dateFormat1.format(rs.getDate("ERV_DATE"));
		String formattedDate2 = dateFormat1.format(rs.getDate("RSV_DATE"));
		return ReviewPlay.builder()
				.ervNo(rs.getString("ERV_NO"))
				.ervConTent(rs.getString("ERV_CONTENT"))
				.memberId(rs.getString("MEMBER_ID"))
				.ervDate(formattedDate1)
				.rsvNo(rs.getString("RSV_NO"))
				.memberNm(rs.getString("MEMBER_NM"))
				.eventNm(rs.getString("EVENT_NM"))
				.rsvDate(formattedDate2)
				.build(); 
	}
	
	private ReviewStore getReviewStoreList(ResultSet rs) throws SQLException{
		String formattedDate1 = dateFormat1.format(rs.getDate("REVIEW_DT"));
		String formattedDate2 = dateFormat1.format(rs.getDate("ORDER_DATE"));
		return ReviewStore.builder()
				.reviewNo(rs.getString("REVIEW_NO"))
				.productNm(rs.getString("PRODUCT_NM"))
				.reviewContent(rs.getString("REVIEW_CONTENT"))
				.reviewDate(formattedDate1)
				.orderDate(formattedDate2)
				.build(); 
	}
	
	private PlaySearch getReviewPlaySearch(ResultSet rs) throws SQLException{
		String formattedDate = dateFormat1.format(rs.getDate("ES_DATE"));
		return PlaySearch.builder()
				.rsvNo(rs.getString("RSV_NO"))
				.eventNm(rs.getString("EVENT_NM"))
				.esDate(formattedDate)
				.build(); 
	}
	
	private StoreSearch getReviewStoreSearch(ResultSet rs) throws SQLException{
		String formattedDate = dateFormat1.format(rs.getDate("ORDER_DATE"));
		return StoreSearch.builder()
				.orderNo(rs.getString("ORDER_NO"))
				.productNo(rs.getString("PRODUCT_NO"))
				.productName(rs.getString("PRODUCT_NM"))
				.orderDate(formattedDate)
				.build(); 
	}	

	public int selectPlayReviewCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= 0;
		try { 
			String query = "SELECT COUNT(*) AS row_count "
					+ "FROM EVENT_REVIEW_TB A JOIN MEMBER_TB B ON A.MEMBER_ID=B.MEMBER_ID JOIN EVENT_ORDER_TB C ON C.RSV_NO=A.RSV_NO "
					+ "JOIN EVENT_SCHEDULE_TB D ON C.ES_NO=D.ES_NO JOIN EVENT_TB E ON D.EVENT_NO=E.EVENT_NO "
					+ "WHERE (A.MEMBER_ID = '" + userId + "')";
			
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
	
	public List<PlaySearch> selectPlaySearch(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PlaySearch> result = new ArrayList();
		try { 
			String query = "SELECT A.RSV_NO, C.EVENT_NM, B.ES_DATE "
					+ "FROM EVENT_ORDER_TB A JOIN EVENT_SCHEDULE_TB B ON A.ES_NO=B.ES_NO "
					+ "JOIN EVENT_TB C ON B.EVENT_NO=C.EVENT_NO "
					+ "WHERE SYSDATE >= B.ES_DATE AND (A.MEMBER_ID = '" + userId + "')";
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getReviewPlaySearch(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public List<ReviewPlay> selectPlayReviewCondition(Connection conn, String userId, int startRow, int endRow){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewPlay> result = new ArrayList();
		try { 
			String query = "SELECT * FROM (SELECT A.*, B.MEMBER_NM, E.EVENT_NM, C.RSV_DATE, "
					+ "ROW_NUMBER() OVER (ORDER BY C.RSV_DATE DESC) AS RN "
					+ "FROM EVENT_REVIEW_TB A JOIN MEMBER_TB B ON A.MEMBER_ID=B.MEMBER_ID JOIN EVENT_ORDER_TB C ON C.RSV_NO=A.RSV_NO "
					+ "JOIN EVENT_SCHEDULE_TB D ON C.ES_NO=D.ES_NO JOIN EVENT_TB E ON D.EVENT_NO=E.EVENT_NO "
					+ "WHERE (A.MEMBER_ID = '" + userId + "')) ";
			query +=  "WHERE (RN BETWEEN ? AND ?)";
					

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getReviewPlayList(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public int insertPlayReview(Connection conn, String userId, String rsvNo, String content, String emotion){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try { 
			String query = "INSERT INTO EVENT_REVIEW_TB "
					+ "(ERV_NO, ERV_CONTENT, MEMBER_ID, ERV_DATE, RSV_NO, IMOJI_NO) "
					+ "VALUES((SELECT NVL(MAX(ERV_NO), 0) + 1 FROM EVENT_REVIEW_TB), ?, ?, sysdate, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setString(2, userId);
			pstmt.setString(3, rsvNo);
			pstmt.setString(4, emotion);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	
	public int selectStoreReviewCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= 0;
		try { 
			String query = "SELECT COUNT(*) AS row_count "
					+ "FROM STORE_REVIEW_TB A JOIN PRD_ORDER_TB B ON A.ORDER_NO=B.ORDER_NO JOIN PRD_ORDER_DETAIL_TB C ON B.ORDER_NO=C.ORDER_NO AND A.PRODUCT_NO=C.PRODUCT_NO "
					+ "JOIN PRODUCT_TB D ON C.PRODUCT_NO=D.PRODUCT_NO " 
					+ "WHERE (A.MEMBER_ID = '" + userId + "')";
	
			
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
	
	public List<StoreSearch> selectStoreSearch(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StoreSearch> result = new ArrayList();
		try { 
			String query = "SELECT A.ORDER_NO, B.PRODUCT_NO, C.PRODUCT_NM, A.ORDER_DATE "
					+ "FROM PRD_ORDER_TB A JOIN PRD_ORDER_DETAIL_TB B ON A.ORDER_NO=B.ORDER_NO "
					+ "JOIN PRODUCT_TB C ON B.PRODUCT_NO=C.PRODUCT_NO "
					+ "WHERE A.ORDER_STATUS = '배송 완료' AND (MEMBER_ID = '" + userId + "')";
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getReviewStoreSearch(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public List<ReviewStore> selectStoreReviewCondition(Connection conn, String userId, int startRow, int endRow){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewStore> result = new ArrayList();
		try { 
			String query = "SELECT * FROM (SELECT A.REVIEW_NO, D.PRODUCT_NM, A.REVIEW_CONTENT, A.REVIEW_DT, B.ORDER_DATE, "
					+ "ROW_NUMBER() OVER (ORDER BY B.ORDER_DATE DESC) AS RN "
					+ "FROM STORE_REVIEW_TB A JOIN PRD_ORDER_TB B ON A.ORDER_NO=B.ORDER_NO JOIN PRD_ORDER_DETAIL_TB C ON B.ORDER_NO=C.ORDER_NO  AND A.PRODUCT_NO=C.PRODUCT_NO "
					+ "JOIN PRODUCT_TB D ON C.PRODUCT_NO=D.PRODUCT_NO "
					+ "WHERE (A.REVIEW_WRITER = '" + userId + "')) ";
			query +=  "WHERE (RN BETWEEN ? AND ?)";
					

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getReviewStoreList(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	public int insertStoreReview(Connection conn, String userId, String orderNo, String fileName, String content, String emotion, String productNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try { 
			String query = "INSERT INTO STORE_REVIEW_TB "
					+ "(REVIEW_NO, REVIEW_CONTENT, REVIEW_DT, ORDER_NO, IMOJI_CD, REVIEW_WRITER, PRODUCT_NO) "
					+ "VALUES((SELECT NVL(MAX(REVIEW_NO), 0) + 1 FROM STORE_REVIEW_TB), ?, sysdate, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setString(2, orderNo);
			pstmt.setString(3, emotion);
			pstmt.setString(4, userId);
			pstmt.setString(5, productNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}

}

