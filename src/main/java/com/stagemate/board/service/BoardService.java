package com.stagemate.board.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.*;
import static com.stagemate.common.JDBCTemplate.commit;
import static com.stagemate.common.JDBCTemplate.getConnection;
import static com.stagemate.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.stagemate.board.model.dao.BoardDao;
import com.stagemate.board.model.vo.Board;
import com.stagemate.board.model.vo.BoardComment;

public class BoardService {

	private BoardDao dao = new BoardDao();

	public List<Board> selectBoard(int cPage, int numPerpage) {
		Connection conn = getConnection();
		List<Board> boards = dao.selectBoard(conn, cPage, numPerpage);
		close(conn);
		return boards;
	}

	public int selectBoardCount() {
		Connection conn = getConnection();
		int result = dao.selectBoardCount(conn);
		close(conn);
		return result;
	}

	public Board selectBoardByNo(int no, boolean isRead) {
		Connection conn = getConnection();
		Board b = dao.selectBoardByNo(conn, no);
		if (b!= null&&!isRead) {
			int result = dao.updateBoardViewCNT(conn, no);
			if (result > 0) {
				commit(conn);
				b.setBoardViewCNT(b.getBoardViewCNT() + 1);
			} else
				rollback(conn);
		}
		close(conn);
		return b;
	}
	
	public int boardCount(int boardNo, String memberId) {
		Connection conn=getConnection();
		int result=dao.boardCount(conn,boardNo,memberId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int boardModify(Board b) {
		Connection conn=getConnection();
		int result=dao.boardModify(conn, b);
		if(result>0)
			commit(conn);
		close(conn);
		return result;
	}

	public int boardWrite(String boardWriter, String boardTitle, String boardContent) {
		Connection conn = getConnection();
		int result = dao.boardWrite(conn, boardWriter, boardTitle, boardContent);
		if (result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public int updateBoard(String boardWriter, String boardTitle, String boardContent) {
		Connection conn=getConnection();
		int result=dao.updateBoard(conn, boardWriter, boardTitle, boardContent);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int deleteBoard(int boardNo) {
		Connection conn=getConnection();
		int result=dao.deleteBoard(conn,boardNo);
		close(conn);
		return result;
	}
	
	public int reportBoard(int boardNo) {
		Connection conn=getConnection();
		int result=dao.deleteBoard(conn,boardNo);
		close(conn);
		return result;
	}
	
	public int insertLike(int boardNo,String memberId) {
		Connection conn=getConnection();
		int result=dao.insertLike(conn,boardNo,memberId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
	//윤진작성
	public List<Board> selectBoardById(String id) {
		Connection conn = getConnection();
		List<Board> list = dao.selectBoardById(conn, id);
		close(conn);
		return list;
	}

	public int insertBoardComment(BoardComment bc) {
		Connection conn = getConnection();
		int result = dao.insertBoardComment(conn, bc);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}


	
	public List<BoardComment> selectBoardComment(int boardNo) {
		Connection conn = getConnection();
		List<BoardComment> list = dao.selectBoardComment(conn, boardNo);
		close(conn);
		return list;
	}

	public List<Board> selectBoardByKeyword(String type, String keyword, int cPage, int numPerpage) {
		Connection conn = getConnection();
		List<Board> boards = dao.selectBoardByKeyword(conn, type, keyword, cPage, numPerpage);
		close(conn);
		return boards;

	}

	public int selectBoardByKeywordCount(String type, String keyword) {
		Connection conn = getConnection();
		int count = dao.selectBoardByKeywordCount(conn, type, keyword);
		close(conn);
		return count;
	}
	
	
	
//윤진작성
	public List<BoardComment> selectBoardCommentById(String id) {
		Connection conn = getConnection();
		List<BoardComment> list = dao.selectBoardCommentById(conn, id);
		close(conn);
		return list;
	}
//윤진작성
	public int deleteComment(int commentNo) {
		Connection conn=getConnection();
		int result=dao.deleteComment(conn,commentNo);
		close(conn);
		return result;
	}

	public List<Board> selectBoardAll() {
		Connection conn = getConnection();
		List<Board> list = dao.selectBoardAll(conn);
		close(conn);
		return list;
	}
}
