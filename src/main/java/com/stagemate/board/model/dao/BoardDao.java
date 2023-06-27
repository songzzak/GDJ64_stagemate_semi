package com.stagemate.board.model.dao;

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

import com.stagemate.board.model.vo.Board;

public class BoardDao {

	private Properties sql = new Properties();

	public BoardDao() {
		String path = BoardDao.class.getResource("/sql/board/boardsql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Board> selectBoard(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoard"));
			pstmt.setInt(1, (cPage - 1) * numPerpage + 1);
			pstmt.setInt(2, cPage * numPerpage);
			rs = pstmt.executeQuery();

			while (rs.next())
				list.add(getBoard(rs));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoardCount"));
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public Board selectBoardByNo(Connection conn,int no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Board b=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectBoardByNo"));
		pstmt.setInt(1, no);
		rs=pstmt.executeQuery();
		if(rs.next()) b=getBoard(rs);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return b;
	}

	public int insertBoard(Connection conn, Board b) {
		/*
		 * PreparedStatement pstmt=null; ResultSet rs=null; Board b1=null; try {
		 * pstmt=conn.prepareStatement(sql.getProperty("insertBoard"));
		 * rs=pstmt.executeQuery(); if(rs.next()) b=getBoard(rs); }catch(SQLException
		 * e){ e.printStackTrace(); }finally { close(rs); close(pstmt);
		 */
		return 0;
	}

	public int updateBoardViewCNT(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updateboardViewCNT"));
			pstmt.setInt(1, no);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
//	public int boardWrite(Connection conn, String boardTitle, String boardContent) {
//		PreparedStatement pstmt=null;
//		
//		try {
//			pstmt=conn.prepareStatement(sql.getProperty("boardWrite"));
//			pstmt.setString(1, boardTitle);
//			pstmt.setString(2, boardContent);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}
//		
//	}

	private Board getBoard(ResultSet rs) throws SQLException {
		return Board.builder().boardNo(rs.getInt("board_no")).boardTitle(rs.getString("board_title"))
				.boardWriter(rs.getString("board_writer")).boardContent(rs.getString("board_content"))
				.boardLikeCNT(rs.getInt("board_Like_CNT")).boardLikeCNT(rs.getInt("board_View_CNT"))
				.boardDate(rs.getDate("board_insert_dt")).build();
	}

	public List<Board> selectBoardById(Connection conn, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		 List<Board> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectBoardById"));
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			list.add(getBoard(rs));
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
