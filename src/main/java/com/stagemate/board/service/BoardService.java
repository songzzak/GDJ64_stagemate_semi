package com.stagemate.board.service;

import static com.stagemate.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import com.stagemate.board.model.dao.BoardDao;
import com.stagemate.board.model.vo.Board;
public class BoardService {

	private BoardDao dao=new BoardDao();
	
	public List<Board> selectBoard(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Board> boards=dao.selectBoard(conn,cPage,numPerpage);
		close(conn);
		return boards;
	}
	
	public int selectBoardCount() {
		Connection conn=getConnection();
		int result=dao.selectBoardCount(conn);
		close(conn);
		return result;
	}
	
	public Board selectBoardByBo(int no) {
		Connection conn=getConnection();
		Board b=dao.selectBoardByNo(conn,no);
		close(conn);
		return b;
	}
	
	public int insertBoard(Board b) {
		Connection conn=getConnection();
		int result=dao.insertBoard(conn,b);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateBoard(Board b) {
		return 0;
	}
	
	public int deleteBoard(int no) {
		return 0;
	}
}
