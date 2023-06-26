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

import org.apache.tomcat.util.digester.ArrayStack;

import com.stagemate.common.PropertiesGenerator;
import com.stagemate.store.model.vo.Cart;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.model.vo.StoreLike;
import com.stagemate.store.model.vo.StoreUpfile;

import oracle.jdbc.proxy.annotation.Pre;

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

    public int updateProduct(Connection conn, Product product) {
    	PreparedStatement pstmt = null;
        int result = 0;
        try {
        	pstmt = conn.prepareStatement(sql.getProperty("updateProduct"));
            pstmt.setString(1, product.getProductTitle());
            pstmt.setString(2, product.getProductNm());
            pstmt.setInt(3, product.getProductPrice());
            pstmt.setInt(4, product.getProductAmt());
            pstmt.setString(5, product.getProductComment());
            pstmt.setInt(6, product.getProductNo());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	close(pstmt);
        }
        return result;
    }

    public int updateFileData(Connection conn, StoreUpfile file, int productNo) {
    	PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = conn.prepareStatement(sql.getProperty("updateFileData"));
            pstmt.setString(1, file.getImgFilenameOri());
            pstmt.setString(2, file.getImgFileRename());
            pstmt.setInt(3, productNo);
            pstmt.setString(4, String.valueOf(file.getIsMainImg()));
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	close(pstmt);
        }
        return result;
    }

	public int deleteProductByNo(Connection conn, int pNo) {
		PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = conn.prepareStatement(sql.getProperty("deleteProductByNo"));
            pstmt.setInt(1, pNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	close(pstmt);
        }
        return result;
	}

	public int insertStoreLike(Connection conn, StoreLike sl) {
		if (isProductInWishList(conn,sl)) {
	        return 0; // 이미 찜한 상품이므로 추가하지 않고 종료
	    }
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertStoreLike"));
			pstmt.setString(1, sl.getStrLikeCd());
			pstmt.setString(2, sl.getMemberId());
			pstmt.setInt(3, sl.getProductNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int deleteStoreLike(Connection conn, int productNo, String userId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteStoreLike"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, productNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	private boolean isProductInWishList(Connection conn,  StoreLike sl) {
		boolean result=false;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("isProductInWishList"));
			pstmt.setString(1, sl.getStrLikeCd());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public List<StoreLike> selectAllLike(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StoreLike> likes=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllLike"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				likes.add(getLike(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return likes;
	}

	private StoreLike getLike(ResultSet rs) throws SQLException {
		return StoreLike.builder()
				.strLikeCd(rs.getString("str_like_cd"))
				.memberId(rs.getString("member_id"))
				.productNo(rs.getInt("product_no"))
				.build();
	}

	public int insertCart(Connection conn, Cart c) {
		if (isProductInCartList(conn,c)) {
	        return 0; // 이미 추가한 상품이므로 추가하지 않고 종료
	    }
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertCart"));
			pstmt.setString(1, c.getCartCd());
			pstmt.setString(2, c.getMemberId());
			pstmt.setInt(3, c.getProductNo());
			pstmt.setInt(4, c.getCartAmt());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	private boolean isProductInCartList(Connection conn, Cart c) {
		boolean result=false;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("isProductInCartList"));
			pstmt.setString(1, c.getCartCd());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		//System.out.println("체크"+result);
		return result;
	}

	public List<Cart> selectCartByUserId(Connection conn, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Cart> carts=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectCartByUserId"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				carts.add(getCart(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return carts;
	}

	private Cart getCart(ResultSet rs) throws SQLException {
		return Cart.builder()
				.cartCd(rs.getString("cart_cd"))
				.memberId(rs.getString("member_id"))
				.productNo(rs.getInt("product_no"))
				.cartAmt(rs.getInt("cart_amt"))
				.build();
	}

	public List<Product> selectAllProductOrderBySort(Connection conn, int cPage, int numPerPage, String sort) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<>();
		try {
			switch (sort) {
			case "popular":pstmt=conn.prepareStatement(sql.getProperty("productOrderByPopular")); break;
			case "price_low":pstmt=conn.prepareStatement(sql.getProperty("productOrderByPriceLow")); break;
			case "price_high":pstmt=conn.prepareStatement(sql.getProperty("productOrderByPriceHigh")); break;
			case "review_high":pstmt=conn.prepareStatement(sql.getProperty("productOrderByReviewHigh")); break;
			}
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

	public int deleteCart(Connection conn, int pNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteCart"));
			pstmt.setInt(1, pNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}



}
