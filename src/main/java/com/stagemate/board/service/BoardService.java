package com.stagemate.board.service;

import static com.stagemate.common.JDBCTemplate.close;
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

	public Board selectBoardByNo(int no) {
		Connection conn = getConnection();
		Board b = dao.selectBoardByNo(conn, no);
		close(conn);
		return b;
	}

	public int boardWrite(String boardWriter, String boardTitle, String boardContent) {
		Connection conn = getConnection();
		int result = dao.boardWrite(conn, boardWriter, boardTitle, boardContent);
		if (result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public int updateBoard(Board b) {
		return 0;
	}

	public int deleteBoard(int no) {
		return 0;
	}

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
}
