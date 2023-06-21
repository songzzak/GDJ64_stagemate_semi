package com.stagemate.event.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.stagemate.event.dao.EventDao;
import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventUpfile;

public class EventService {
	
	private EventDao dao=new EventDao();
	
	public List<Event> selectAllEventMusical(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventMusical(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public int selectEventCountMusical() {
		Connection conn=getConnection();
		int result=dao.selectEventCountMusical(conn);
		close(conn);
		return result;
	}
	public List<EventUpfile> selectAllFile(){
		Connection conn=getConnection();
		List<EventUpfile> files=dao.selectAllFile(conn);
		close(conn);
		return files;
	}
	public List<Event> selectAllEventConcert(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventConcert(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public int selectEventCountConcert() {
		Connection conn=getConnection();
		int result=dao.selectEventCountConcert(conn);
		close(conn);
		return result;
	}
	public List<Event> selectAllEventAct(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventAct(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public int selectEventCountAct() {
		Connection conn=getConnection();
		int result=dao.selectEventCountAct(conn);
		close(conn);
		return result;
	}
	
	public Event selectEventByEventNo(String eventNo) {
		Connection conn=getConnection();
		Event event=dao.selectEventByEventNo(conn,eventNo);
		close(conn);
		return event;
		
	}
	public List<EventUpfile> selectFileByEventNo(String eventNo) {
		Connection conn=getConnection();
		List<EventUpfile> files=dao.selectFileByEventNo(conn,eventNo);
		close(conn);
		return files;
		
	}
	

}
