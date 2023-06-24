package com.stagemate.event.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.stagemate.common.JDBCTemplate;
import com.stagemate.event.dao.EventDao;
import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventTime;
import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.event.model.vo.Seat;

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
	
	public List<EventTime> selectTimeByEvent(String eventNo){
		Connection conn=getConnection();
		List<EventTime> et=dao.selectTimeByEvent(conn,eventNo);
		close(conn);
		return et;
		
	}
	public List<Event> listAllEvent(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEvent(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public int selectEventCount() {
		Connection conn=getConnection();
		int result=dao.selectEventCount(conn);
		close(conn);
		return result;
	}
	
	public List<Seat> selectSeatByEvnNoMusical(String eventNo){
		Connection conn=getConnection();
		List<Seat> seats=dao.selectSeatByEvnNoMusical(conn,eventNo);
		close(conn);
		return seats;
	}
	public List<Seat> selectSeatByEvnNoConcert(String eventNo){
		Connection conn=getConnection();
		List<Seat> seats=dao.selectSeatByEvnNoConcert(conn,eventNo);
		close(conn);
		return seats;
	}
	public List<Seat> selectSeatByEvnNoAct(String eventNo){
		Connection conn=getConnection();
		List<Seat> seats=dao.selectSeatByEvnNoAct(conn,eventNo);
		close(conn);
		return seats;
	}
	
	public List<Seat> selectSeatAllByEvnNo(String eventNo){
		Connection conn=getConnection();
		List<Seat> seats=dao.selectSeatAllByEvnNo(conn,eventNo);
		close(conn);
		return seats;
	}
	
	public int insertEvent(Map<String, String> info, 
							List<String> casting,
							String category,
							Map<Date, String> eventSchedule,
							Map<String, List<String>> eventFiles) 
	{
		Connection conn = JDBCTemplate.getConnection();
		int resultTotal = 0;
		int resultOfInfo = dao.insertEventInfo(conn, info);
		int resultOfCasting = dao.insertEventCasting(conn, casting);
		int resultOfSchedule = dao.insertEventSchedule(conn, category, eventSchedule);
		int resultOfFiles = dao.insertEventFiles(conn, eventFiles);
		
		if (resultOfInfo == 0 || resultOfCasting == 0 
			|| resultOfFiles == 0 || resultOfSchedule == 0) 
		{
			JDBCTemplate.rollback(conn);
		} else {
			resultTotal = 1;
			JDBCTemplate.commit(conn);
		}
		
		JDBCTemplate.close(conn);
		return resultTotal;
	}
}
