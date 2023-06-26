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
				.orderNo(rs.getInt("ORDER_NO"))
				.productNm(rs.getString("PRODUCT_NM"))
				.totalPrice(rs.getInt("TOTAL_PRICE"))
				.orderDate(formattedDate)
				.orderStatus(rs.getString("ORDER_STATUS"))
				.build();
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
	
	public int selectStoreDetailCount(Connection conn, String userId, String day, String yyyy, String mm, String status){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= 0;
		try { 
			String query = sql.getProperty("searchStoreDetailCount");
			query +=  " WHERE (ORDER_DATE >= CASE "
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
}
	
	
	
	

