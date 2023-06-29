package com.stagemate.qna.model.dao;

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
import static com.stagemate.common.JDBCTemplate.getConnection;

import com.stagemate.notice.model.vo.Notice;
import com.stagemate.notice.model.vo.NoticeFileData;
import com.stagemate.qna.model.vo.Qna;
import com.stagemate.qna.model.vo.QnaComment;
import com.stagemate.qna.model.vo.QnaFileData;
import com.stagemate.qna.model.vo.Qna;


public class QnaDao {

	private Properties sql = new Properties();
	
	public QnaDao() {
		String path = QnaDao.class.getResource("/sql/qna/qnasql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Qna> selectQna(Connection conn, int cPage,int numPerpage){
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	List<Qna> list= new ArrayList();
	try {
		pstmt= conn.prepareStatement(sql.getProperty("selectQna"));
		pstmt.setInt(1, (cPage-1)*numPerpage+1);
		pstmt.setInt(2,  cPage*numPerpage);
		rs=pstmt.executeQuery();
		
		while(rs.next()) list.add(getQna(rs));
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return list;
	}

public int selectQnaCount(Connection conn) {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(sql.getProperty("selectQnaCount"));
				rs=pstmt.executeQuery();
		if(rs.next()) result=rs.getInt(1);
		
	}catch(SQLException e) {
		e.printStackTrace();
		
	}finally {
		close (rs);
		close(pstmt);
		
	}return result;
}

public Qna selectInquiryByNo(Connection conn, int no) {
	PreparedStatement pstmt= null;
	ResultSet rs= null;
	Qna q = null;
	try {
		pstmt=conn.prepareStatement( sql.getProperty("selectInquiryByNo"));
		pstmt.setInt(1,  no);
		rs=pstmt.executeQuery();
		if(rs.next()) q= getQna(rs);
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	
	return q;
}

public int insertQna(Connection conn, Qna q) {
	PreparedStatement pstmt=null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(sql.getProperty("insertQna"));
		pstmt.setString(1, q.getInquiryContent());
		pstmt.setString(2, q.getInquiryTitle());
		pstmt.setString(3, q.getWriterId());
		pstmt.setString(4, q.getInquiryLockFlg()!=null?q.getInquiryLockFlg():"N");
		result=pstmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}

public int deleteQna (Connection conn, int inquiryNo) {
	PreparedStatement pstmt= null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(sql.getProperty("deleteQna"));
		pstmt.setInt(1, inquiryNo);
		
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}

public int updateQna(Connection conn, Qna q) {
	PreparedStatement pstmt=null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(sql.getProperty("updateQna"));
		pstmt.setString(1,  q.getInquiryTitle());
		pstmt.setString(2,  q.getInquiryContent());
		pstmt.setInt(3, q.getInquiryNo());
		result=pstmt.executeUpdate();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
		
	}
	return result;
}

public int selectQnaSquence(Connection conn) {
	PreparedStatement pstmt=null;
	ResultSet rs= null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(sql.getProperty("selectQnaSquence"));
		rs=pstmt.executeQuery();
		if(rs.next()) result=rs.getInt(1);
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	return result;
}

public int insertQnaFile(Connection conn, QnaFileData file) {
	PreparedStatement pstmt=null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(sql.getProperty("insertQnaFile"));
		pstmt.setString(1,file.getImgFilenameOri());
		pstmt.setString(2, file.getImgFileRename());
		pstmt.setInt(3, file.getInquiryNo());
		result=pstmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
private Qna getQna(ResultSet rs) throws SQLException{
	return Qna.builder()
			.inquiryNo(rs.getInt("inquiry_no"))
			.inquiryContent(rs.getString("inquiry_content"))
			.inquiryTitle(rs.getString("inquiry_title"))
			.ctgNum(rs.getInt("ctg_num"))
			.writerId(rs.getString("writer_id"))
			.inquiryInsertDt(rs.getDate("inquiry_insert_dt"))
			.inquiryLockFlg(rs.getString("inquiry_lock_flg"))
			.ctgNm(rs.getString("ctg_nm"))
			.build();
	
			
}

public int insertQnaComment(Connection conn, QnaComment qc) {
	PreparedStatement pstmt=null;
	int result=0;
	try {
		pstmt=conn.prepareStatement(sql.getProperty("insertQnaComment"));
		pstmt.setInt(1,qc.getLevel());
		pstmt.setString(2, qc.getQnaCommentWriter());
		pstmt.setString(3, qc.getQnaCommentContent());
		pstmt.setInt(4,qc.getQnaRef());
		pstmt.setString(5,qc.getQnaCommentRef()==0?null:
							String.valueOf(qc.getQnaCommentRef()));
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;
}

public List<QnaComment> selectQnaComment(Connection conn,int qnaNo){
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	List<QnaComment> list=new ArrayList();
	try {
		pstmt=conn.prepareStatement(sql.getProperty("selectQnaComment"));
		pstmt.setInt(1,qnaNo);
		rs=pstmt.executeQuery();
		while(rs.next())
			list.add(getQnaComment(rs));
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return list;
}

//윤진작성
public List<Qna> selectQnaById(Connection conn, String id) {
 PreparedStatement pstmt = null;
 ResultSet rs=null;
 List<Qna> list= new ArrayList();
 try {
    pstmt= conn.prepareStatement(sql.getProperty("selectQnaById"));
    pstmt.setString(1, id);
    rs=pstmt.executeQuery();
    while(rs.next()) list.add(getQna(rs));
 }catch(SQLException e) {
    e.printStackTrace();
 }finally {
    close(rs);
    close(pstmt);
 }return list;
}

private QnaComment getQnaComment(ResultSet rs) throws SQLException{
	return QnaComment.builder()
			.qnaCommentNo(rs.getInt("INQUIRY_COMMENT_NO"))
			.level(rs.getInt("INQUIRY_COMMENT_LEVEL"))
			.qnaCommentWriter(rs.getString("INQUIRY_COMMENT_WRITER"))
			.qnaCommentContent(rs.getString("INQUIRY_COMMENT_CONTENT"))
			.qnaCommentDate(rs.getDate("INQUIRY_COMMENT_DATE"))
			.qnaCommentRef(rs.getInt("INQUIRY_COMMENT_REF"))
			.qnaRef(rs.getInt("INQUIRY_REF"))
			
			.build();
}

//윤진작성
public List<Qna> selectQnaById(Connection conn, String id) {
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	List<Qna> list= new ArrayList();
	try {
		pstmt= conn.prepareStatement(sql.getProperty("selectQnaById"));
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		while(rs.next()) list.add(getQna(rs));
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return list;
}


}






