package com.stagemate.review.model.dao;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.review.model.dao.ReviewPlayNameDao.getReviewList;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.stagemate.common.MemberGenerator;
import com.stagemate.review.model.vo.Imoji;
import com.stagemate.review.model.vo.PlaySearch;
import com.stagemate.review.model.vo.StoreReview;
import com.stagemate.store.model.vo.Product;

public class ReviewDao {

	private final Properties sql = new Properties();

	public ReviewDao() {
		String path = ReviewDao.class.getResource("/sql/review/review_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<PlaySearch> selectPlayName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PlaySearch> result = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql.getProperty("searchPlayName"));
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.add(getReviewList(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	
	public List<StoreReview> selectStoreReviewList(Connection conn, int cPage, int numPerPage, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StoreReview> result = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectStoreReviewList"));
			pstmt.setString(1, userId);
			pstmt.setString(1, userId);
			pstmt.setInt(2, ((cPage-1)*numPerPage+1));
			pstmt.setInt(3, cPage*numPerPage);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result.add(getStoreReview(rs));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	public int selectStoreReviewCount(Connection conn,String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= 0;

		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectStoreReviewCount"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if(rs.next()) result=rs.getInt(1); 

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rs);
			close(pstmt);

		}

		return result;
	}
	
	
	private StoreReview getStoreReview(ResultSet rs) throws SQLException{
		StoreReview sr=StoreReview.builder()
				.reviewNo(rs.getInt("review_no"))
				.reviewContent(rs.getString("review_content"))
				.reviewDt(rs.getDate("review_dt"))
				.reviewImoji(Imoji.builder().imojiNm(rs.getString("imoji_nm")).imojiNo(rs.getString("imoji_no")).build())
				.reviewWriter(MemberGenerator.by(rs))
				.reviewProduct(getProduct(rs))
				.build();
		return sr;
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
	
	
	

}
