package com.stagemate.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.stagemate.common.JDBCTemplate.close;

import com.stagemate.notice.model.vo.Notice;

public class NoticeDao {

	private Properties sql= new Properties();
	
	public NoticeDao() {
		String path= NoticeDao.class.getResource("/sql/notice/noticesql.properties").getPath();
			try {
				sql.load(new FileReader(path));
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	private Notice getNotice(ResultSet rs) throws SQLException{
		return Notice.builder()
				.noticeNo(rs.getInt("notice_no"))
				.noticeContent(rs.getString("notice_content"))
				.noticeTitle(rs.getString("notice_title"))
				.noticeWriter(rs.getString("notice_writer"))
				.noticeInsertDt(rs.getDate("notice_date"))
				.build();
	}
	
	public List<Notice> selectNotice(Connection conn, int cPage,int numPerpage){
	PreparedStatement pstmt = null;
	ResultSet rs= null;
	List<Notice> list = new ArrayList();
	try {
		pstmt=conn.prepareStatement(sql.getProperty("selectNotice"));
		pstmt.setInt(1, (cPage-1)*numPerpage+1);
		pstmt.setInt(2,  cPage*numPerpage);
		rs= pstmt.executeQuery();
		while(rs.next()) {
			list.add(getNotice(rs));
		}
		
	}catch(SQLException e) {
		close(rs);
		close(pstmt);
	}return list;
	}
	
	public int selectNoticeCount(Connection conn) {
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectNoticeCount"));
			rs= pstmt.executeQuery();
			if(rs.next()) result= rs.getInt("RN");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
			 
			
		}
	
	
}
