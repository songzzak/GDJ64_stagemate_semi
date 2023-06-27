package com.stagemate.event.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.commit;
import static com.stagemate.common.JDBCTemplate.getConnection;
import static com.stagemate.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.stagemate.common.JDBCTemplate;
import com.stagemate.event.dao.EventDao;
import com.stagemate.event.model.vo.Casting;
import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventSchedule;
import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.event.model.vo.EventWish;
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
	
	public List<EventSchedule> selectTimeByEvent(String eventNo){
		Connection conn=getConnection();
		List<EventSchedule> et=dao.selectTimeByEvent(conn,eventNo);
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
	
	public int insertEventWish(String eventNo,String memberId) {
		Connection conn=getConnection();
		int result=dao.insertEventWish(conn,eventNo,memberId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int deleteEventWish(String eventNo,String memberId) {
		Connection conn=getConnection();
		int result=dao.deleteEventWish(conn,eventNo,memberId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public List<EventWish> selectAllEventWish(){
		Connection conn=getConnection();
		List<EventWish> ew=dao.selectAllEventWish(conn);
		close(conn);
		return ew;
	}
	
	// ------------------------- jaehun -------------------------
	public List<String> selectLocation(String location) {
		Connection conn = JDBCTemplate.getConnection();
		List<String> locations = dao.selectLocation(conn, location);
		JDBCTemplate.close(conn);
		return locations;
	}
	
	public int insertEvent(Event eventInfo, List<Casting> castings,
						List<EventSchedule> eventSchedule, List<EventUpfile> upfiles) 
	{
		Connection conn = JDBCTemplate.getConnection();
		int resultTotal = 0;
		int resultOfInfo = dao.insertEventInfo(conn, eventInfo);
		int resultOfCasting = dao.insertEventCasting(conn, castings);
		int resultOfSchedule = dao.insertEventSchedule(conn, eventSchedule);
		int resultOfFiles = dao.insertEventFiles(conn, upfiles);
		
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
	
	public String selectCastingByEventNo(String eventNo) {
		Connection conn = JDBCTemplate.getConnection();
		String casting = dao.selectCastingByEventNo(conn, eventNo);
		JDBCTemplate.close(conn);
		return casting;
	}
	
	public Map<String, String> selectDaysByEventNo(String eventNo) {
		Connection conn = JDBCTemplate.getConnection();
		Map<String, String> schedule = dao.selectDaysByEventNo(conn, eventNo);
		JDBCTemplate.close(conn);
		return schedule;
	}
	
	public int updateEvent(Event eventInfo, List<Casting> castings, List<EventUpfile> upfiles) 
	{
		Connection conn = JDBCTemplate.getConnection();
		int resultTotal = 0;
		int resultOfInfo = dao.updateEventInfo(conn, eventInfo);
		int resultOfCastingDelete = dao.deleteEventCastingByEventNo(conn, eventInfo.getEventNo());
		int resultOfCastingInsert = dao.reInsertEventCasting(conn, castings);
		int resultOfFilesDelete = dao.deleteEventFilesByEventNo(conn, eventInfo.getEventNo());
		int resultOfFilesInsert = dao.reInsertEventFiles(conn, upfiles);
		
		if (resultOfInfo == 0 || resultOfCastingDelete == 0 || resultOfCastingInsert == 0 
				|| resultOfFilesDelete == 0 || resultOfFilesInsert == 0) 
		{
			JDBCTemplate.rollback(conn);
		} else {
			resultTotal = 1;
			JDBCTemplate.commit(conn);
		}
		
		JDBCTemplate.close(conn);
		return resultTotal;
	}
	//윤진작성
	public List<EventWish> selectWishById(String userId) {
		Connection conn=getConnection();
		List<EventWish> list=dao.selectWishById(conn,userId);
		close(conn);
		return list;
	}
	
}