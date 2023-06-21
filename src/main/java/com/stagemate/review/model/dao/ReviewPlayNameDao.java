package com.stagemate.review.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.stagemate.review.model.vo.PlaySearch;

public class ReviewPlayNameDao {

	public static PlaySearch getReviewList(ResultSet rs) throws SQLException{
		return PlaySearch.builder()
				.eventName(rs.getString("EVENT_NAME"))
				.watchDt(rs.getDate("WATCH_DT"))
				.rsvNo(rs.getString("RSV_NO"))
				.build(); 
				
	}
}
