package com.stagemate.notice.model.service;
import static com.stagemate.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.stagemate.notice.model.dao.NoticeDao;
import com.stagemate.notice.model.vo.Notice;
import com.stagemate.qna.model.vo.QnaComment;

public class NoticeService {
private NoticeDao dao = new NoticeDao();

public List<Notice> selectNotice(int cPage, int numPerpage){
	Connection conn= getConnection();
	List<Notice> list=dao.selectNotice(conn,cPage,numPerpage);
	close(conn);
	return list;
	
}
public int selectNoticeCount() {
	Connection conn = getConnection();
	int result=dao.selectNoticeCount(conn);
	close(conn);
	return result;
	
}
	public int insertNotice(Notice n)
	{
		Connection conn= getConnection();
		int result= dao.insertNotice(conn,n);
		int noticeNo=dao.selectNoticeSquence(conn);
		n.getFiles().setNoticeNo(noticeNo);
		if(result>0) {
			//공지사항이 등록이 되면....
			//첨부파일 저장
			result=dao.insertNoticeFile(conn,n.getFiles());
			if(result>0) commit(conn);
			else rollback(conn);
		}else {
			rollback(conn);
		}
//		if(result>0) commit(conn);
//		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Notice selectNoticeByNo(int no) {
		Connection conn = getConnection();
		Notice n= dao.selectNoticeByNo(conn, no);
		close(conn);
		return n;
	}
	
}
