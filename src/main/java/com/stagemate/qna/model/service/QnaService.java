package com.stagemate.qna.model.service;

import java.sql.Connection;
import java.util.List;
import static com.stagemate.common.JDBCTemplate.*;
import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.commit;
import static com.stagemate.common.JDBCTemplate.getConnection;
import static com.stagemate.common.JDBCTemplate.rollback;

import com.stagemate.qna.model.dao.QnaDao;
import com.stagemate.qna.model.vo.Qna;
import com.stagemate.qna.model.vo.QnaComment;

public class QnaService {

	private QnaDao dao = new QnaDao();
	
	public List<Qna> selectQna(int cPage, int numPerpage){
		Connection conn = getConnection();
		List<Qna> qnas = dao.selectQna(conn,cPage,numPerpage);
		close(conn);
		return qnas;
	}
	
	public int selectQnaCount() {
		Connection conn = getConnection();
		int result=dao.selectQnaCount(conn);
		close(conn);
	return result;
	}
	
	
	 public Qna selectInquiryByNo(int no) { 
		  Connection conn = getConnection(); 
		  Qna q= dao.selectInquiryByNo(conn,no); 
		  close(conn); 
		  return q;
	 }
	 
	
	
	public int insertQna (Qna q) {
		Connection conn = getConnection();
		int result = dao.insertQna(conn, q);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int updateQna(Qna q) {
		return 0;
	}
	public int deleteQna(int no) {
		return 0;
	}
	
	public List<QnaComment> selectQnaComment(int qnaNo){
		  Connection conn = getConnection(); 
		  List<QnaComment> list= dao.selectQnaComment(conn,qnaNo); 
		  close(conn); 
		  return list;
	}
	
	
	public int insertQnaComment(QnaComment bc) {
		Connection conn=getConnection();
		int result=dao.insertQnaComment(conn,bc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
}
