package com.stagemate.detail.model.service;
import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.stagemate.detail.model.dao.PlayListDao;
import com.stagemate.detail.model.vo.Detail;

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
	
	
}
