package com.stagemate.review.model.dao;

import static com.stagemate.review.model.dao.ReviewPlayNameDao.getReviewList;
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

import com.stagemate.admin.model.dao.AdminDao;
import com.stagemate.review.model.vo.PlaySearch;

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

}
