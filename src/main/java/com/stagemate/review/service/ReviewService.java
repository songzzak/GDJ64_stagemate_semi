package com.stagemate.review.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.stagemate.review.model.dao.ReviewDao;
import com.stagemate.review.model.vo.PlaySearch;
import com.stagemate.review.model.vo.StoreReview;

public class ReviewService {

	private ReviewDao dao = new ReviewDao();
	
	//리뷰를 쓸 극 리스트 가져오기(팝업에서 사용)
	public List<PlaySearch> selectPlayName(String name) {
		Connection conn = getConnection();
		List<PlaySearch> result = dao.selectPlayName(conn, name);
		close(conn);
		return result;
	}
	
	public List<StoreReview> selectStoreReviewList(int cPage, int numPerPage, String userId){
		Connection conn = getConnection();
		List<StoreReview> result = dao.selectStoreReviewList(conn, cPage,numPerPage,userId);
		close(conn);
		return result;
	}
	public int selectStoreReviewCount(String userId) {
		Connection conn = getConnection();
		int result = dao.selectStoreReviewCount(conn,userId);
		close(conn);
		return result;
	}
}


