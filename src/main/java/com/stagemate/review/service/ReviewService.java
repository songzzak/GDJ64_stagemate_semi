package com.stagemate.review.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.stagemate.review.model.dao.ReviewDao;
import com.stagemate.review.model.vo.PlaySearch;
import com.stagemate.review.model.vo.ReviewPlay;
import com.stagemate.review.model.vo.ReviewStore;
import com.stagemate.review.model.vo.StoreSearch;
import com.stagemate.review.model.vo.StoreReview;

public class ReviewService {

	private ReviewDao dao = new ReviewDao();
	
	//리뷰를 쓸 글 리스트 가져오기(팝업에서 사용)
//	public List<PlaySearch> selectPlayName(String name) {
//		Connection conn = getConnection();
//		List<PlaySearch> result = dao.selectPlayName(conn, name);
//		close(conn);
//		return result;
//	}
	
	public List<PlaySearch> selectPlaySearch(String userId){
		Connection conn=getConnection();
		List<PlaySearch> result = dao.selectPlaySearch(conn, userId);
		close(conn);
		return result;
	}
	
	public int selectPlayReviewCount(String userId){
		Connection conn=getConnection();
		int result = dao.selectPlayReviewCount(conn, userId);
		close(conn);
		return result;
	}
	
	public List<ReviewPlay> selectPlayReviewCondition(String userId, int startRow, int endRow){
		Connection conn=getConnection();
		List<ReviewPlay> result = dao.selectPlayReviewCondition(conn, userId, startRow, endRow);
		close(conn);
		return result;
	}
	
	public int insertPlayReview(String userId, String rsvNo, String content, String emotion){
		Connection conn=getConnection();
		int result = dao.insertPlayReview(conn, userId, rsvNo, content, emotion);
		close(conn);
		return result;
	}
	
	public List<StoreSearch> selectStoreSearch(String userId){
		Connection conn=getConnection();
		List<StoreSearch> result = dao.selectStoreSearch(conn, userId);
		close(conn);
		return result;
	}
	
	public int selectStoreReviewCount(String userId){
		Connection conn=getConnection();
		int result = dao.selectStoreReviewCount(conn, userId);
		close(conn);
		return result;
	}
	
	public List<ReviewStore> selectStoreReviewCondition(String userId, int startRow, int endRow){
		Connection conn=getConnection();
		List<ReviewStore> result = dao.selectStoreReviewCondition(conn, userId, startRow, endRow);
		close(conn);
		return result;
	}
	
	public int insertStoreReview(String userId, String orderNo, String fileName, String content, String emotion, String productNo){
		Connection conn=getConnection();
		int result = dao.insertStoreReview(conn, userId, orderNo, fileName, content, emotion, productNo);
		close(conn);
		return result;
	}	
	public List<StoreReview> selectStoreReviewList(int cPage, int numPerPage, String userId){
		Connection conn = getConnection();
		List<StoreReview> result = dao.selectStoreReviewList(conn, cPage,numPerPage,userId);
		close(conn);
		return result;
	}


}


