package com.stagemate.review.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.stagemate.review.model.dao.ReviewDao;
import com.stagemate.review.model.vo.PlaySearch;

public class ReviewService {

	private ReviewDao dao = new ReviewDao();
	
	//리뷰를 쓸 극 리스트 가져오기(팝업에서 사용)
	public List<PlaySearch> selectPlayName(String name) {
		Connection conn = getConnection();
		List<PlaySearch> result = dao.selectPlayName(conn, name);
		close(conn);
		return result;
	}
}


