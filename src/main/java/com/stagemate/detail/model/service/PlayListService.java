package com.stagemate.detail.model.service;
import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.stagemate.admin.service.AdminService;
import com.stagemate.detail.model.dao.PlayListDao;
import com.stagemate.detail.model.vo.Detail;
import com.stagemate.member.model.vo.Member;

public class PlayListService {
	//dao와 연결
	private PlayListDao dao = new PlayListDao();
	
	//여기서 db연결 시작 pstmt 과 rs
	//예매내역서 가져오기 
	public List<Detail> selectPlayDetail(){
		Connection conn=getConnection();
		List<Detail> result=dao.selectPlayDetail(conn);
		close(conn);
		return result;
	}
	
	public int selectPlayDetailCount(String userId, String day, String yyyy, String mm, String status){
		Connection conn=getConnection();
		int result = dao.selectPlayDetailCount(conn, userId, day, yyyy, mm, status);
		close(conn);
		return result;
	}
	
	public List<Detail> selectPlayDetailCondition(String userId, String day, String yyyy, String mm, String status, int startRow, int endRow){
		Connection conn=getConnection();
		List<Detail> result = dao.selectPlayDetailCondition(conn, userId, day, yyyy, mm, status, startRow, endRow);
		close(conn);
		return result;
	}
}
