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
import com.stagemate.board.model.vo.BoardComment;

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

	public int boardCount(Connection conn, int boardNo, String memberId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("boardCount"));
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, memberId);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
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

	public Board selectBoardByNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board b = null;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoardByNo"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next())
				b = getBoard(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return b;
	}

	public int insertBoard(Connection conn, Board b) {

		return 0;
	}

	public int updateBoardViewCNT(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updateboardViewCNT"));
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int boardWrite(Connection conn, String boardWriter, String boardTitle, String boardContent) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("boardWrite"));
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardWriter);
			pstmt.setString(3, boardContent);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		int result =0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteBoard"));
			pstmt.setInt(1, boardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertBoardComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertBoardComment"));
			pstmt.setInt(1, bc.getLevel());
			pstmt.setString(2, bc.getCmtWriter());
			pstmt.setString(3, bc.getCmtContent());
			pstmt.setInt(4, bc.getBoardRef());
			pstmt.setString(5, bc.getCmtRef() == 0 ? null : String.valueOf(bc.getCmtRef()));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	

	private Board getBoard(ResultSet rs) throws SQLException {
		return Board.builder().boardNo(rs.getInt("board_no")).boardTitle(rs.getString("board_title"))
				.boardWriter(rs.getString("board_writer")).boardContent(rs.getString("board_content"))
				.boardLikeCNT(rs.getInt("board_Like_CNT")).boardLikeCNT(rs.getInt("board_View_CNT"))
				.boardDate(rs.getDate("board_insert_dt")).build();
	}

	
	//윤진작성
	public List<Board> selectBoardById(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoardById"));
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(getBoard(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public List<BoardComment> selectBoardComment(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardComment> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoardComment"));
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(getBoardComment(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	private BoardComment getBoardComment(ResultSet rs) throws SQLException {
		return BoardComment.builder()
				.cmtNo(rs.getInt("cmt_no"))
				.level(rs.getInt("cmt_level"))
				.cmtWriter(rs.getString("cmt_writer"))
				.cmtContent(rs.getString("cmt_content"))
				.boardRef(rs.getInt("board_ref"))
				.cmtRef(rs.getInt("cmt_ref"))
				.cmtDate(rs.getDate("cmt_date"))
				.build();
	}
	
	public List<Board> selectBoardByKeyword(
			Connection conn, String type, String keyword
			,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String query=sql.getProperty("selectBoardByKeyword");
		query=query.replace("#COL", type);
		List<Board> boards=new ArrayList();
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,
					type.equals("content")?keyword:"%"+keyword+"%");
			pstmt.setInt(2,(cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				boards.add(getBoard(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return boards;
	}
	public int selectBoardByKeywordCount(
			Connection conn, String type, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String query=sql.getProperty("selectBoardByKeywordCount")
				.replace("#COL", type);
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,type.equals("content")?keyword
					:"%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

	
	//윤진작성
	public List<BoardComment> selectBoardCommentById(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardComment> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoardComment"));
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(getBoardComment(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
