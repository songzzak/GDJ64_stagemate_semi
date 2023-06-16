package com.stagemate.store.dao;

import static com.stagemate.common.JDBCTemplate.*;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.stagemate.common.PropertiesGenerator;
import com.stagemate.store.model.vo.Product;

public class StoreDao {

	String path=StoreDao.class.getResource("/sql/store/productsql.properties").getPath();
	private final Properties sql;
	
	public StoreDao() {
		sql = PropertiesGenerator.by(path);
	}
	
	public List<Product> selectAllProduct(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllProduct"));
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(getProduct(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}


	public int selectProductCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	private Product getProduct(ResultSet rs) throws SQLException {
		return Product.builder()
				.productNo(rs.getInt("product_no"))
				.productTitle(rs.getString("product_title"))
				.productNm(rs.getString("product_nm"))
				.productPrice(rs.getInt("product_price"))
				.productAmt(rs.getInt("product_amt"))
				.productComment(rs.getString("product_comment"))
				.productInsertDate(rs.getDate("product_insert_date"))
				.productLikeCnt(rs.getInt("product_like_cnt"))
				.build();
	}

	public int updateProductLikeCnt(Connection conn, int productNo, int likeCnt) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateProductLikeCnt"));
			pstmt.setInt(1, likeCnt);
			pstmt.setInt(2, productNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
