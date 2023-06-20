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
import com.stagemate.store.model.vo.StoreUpfile;

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

	public List<Product> searchProductsByKeyword(Connection conn, int cPage, int numPerPage, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchProductsByKeyword"));
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, ((cPage-1)*numPerPage+1));
			pstmt.setInt(3, cPage*numPerPage);
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

	public int searchProductsByKeywordCnt(Connection conn, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchProductsByKeywordCnt"));
			pstmt.setString(1, "%"+keyword+"%");
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

	public int insertProduct(Connection conn, Product p) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertProduct"));
			pstmt.setString(1, p.getProductTitle());
			pstmt.setString(2, p.getProductNm());
			pstmt.setInt(3, p.getProductPrice());
			pstmt.setInt(4, p.getProductAmt());
			pstmt.setString(5, p.getProductComment() != null && !p.getProductComment().isEmpty() ? p.getProductComment() : null);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertFileData(Connection conn, StoreUpfile file, int pNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertFileData"));
			pstmt.setInt(1, pNo);
			pstmt.setString(2, file.getImgFilenameOri());
			pstmt.setString(3, file.getImgFileRename());
			pstmt.setString(4, String.valueOf(file.getIsMainImg())); 
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selectSeqCurrval(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectSeqCurrval"));
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

	public List<StoreUpfile> selectAllFile(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StoreUpfile> files=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllFile"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StoreUpfile f=StoreUpfile.builder()
						.upfileNo(rs.getInt("upfile_no"))
						.productNo(rs.getInt("product_no"))
						.imgFilenameOri(rs.getString("img_filename_ori"))
						.imgFileRename(rs.getString("img_file_rename"))
						.upfileDate(rs.getDate("upfile_date"))
						.isMainImg((rs.getString("is_main_img")).charAt(0))
						.build();
				files.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return files;
	}

	public Product selectProductByProductNo(Connection conn, int pNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product p=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductByProductNo"));
			pstmt.setInt(1, pNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=getProduct(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}

	public List<StoreUpfile> selectFileByProductNo(Connection conn, int pNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StoreUpfile> fileList=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectFileByProductNo"));
			pstmt.setInt(1, pNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StoreUpfile f=StoreUpfile.builder()
						.upfileNo(rs.getInt("upfile_no"))
						.productNo(rs.getInt("product_no"))
						.imgFilenameOri(rs.getString("img_filename_ori"))
						.imgFileRename(rs.getString("img_file_rename"))
						.upfileDate(rs.getDate("upfile_date"))
						.isMainImg((rs.getString("is_main_img")).charAt(0))
						.build();
				fileList.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return fileList;
	}

}
