package com.stagemate.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.stagemate.common.JDBCTemplate;
import com.stagemate.common.MemberGenerator;
import com.stagemate.common.PropertiesGenerator;
import com.stagemate.member.model.vo.Member;

public class MemberDao {
private static final String SQL_PATH = "/sql/member/member_sql.properties";
	
	private final Properties sql;
	private final String path = MemberDao.class.getResource(SQL_PATH).getPath();
	
	public MemberDao() {
		sql = PropertiesGenerator.by(path);
	}

	public Member selectByIdAndPw(Connection conn, String id, String pw) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectByIdAndPw"));
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = MemberGenerator.by(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}
}
