package com.stagemate.detail.model.dao;

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

import com.stagemate.detail.model.vo.StoreDetail;

public class StoreListDao {
	private final Properties sql = new Properties();
	
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
		return StoreDetail.builder()
				.orderNo(rs.getInt("ORDER_NO"))
				.productNm(rs.getString("PRODUCT_NM"))
				.totalPrice(rs.getInt("TOTAL_PRICE"))
				.build();
	}
		
	}
	
	
	
	

