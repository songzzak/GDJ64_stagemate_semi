package com.stagemate.notice.model.service;
import static com.stagemate.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.stagemate.notice.model.dao.NoticeDao;
import com.stagemate.notice.model.vo.Notice;

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
	
}
