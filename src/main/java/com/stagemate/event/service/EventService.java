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
import com.stagemate.payment.model.vo.EventOrder;
import com.stagemate.review.model.vo.EventReviewTBJH;

public class EventService {
	
	private EventDao dao=new EventDao();
	
	public List<Event> selectAllEventMusical(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventMusical(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Event> selectAllEventMusicalTitle(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventMusicalTitle(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Event> selectAllEventMusicalLike(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventMusicalLike(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Event> selectAllEventMusicalReview(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventMusicalReview(conn,cPage,numPerPage);
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
	public List<EventReviewTBJH> selectAllEventReview(){
		Connection conn=getConnection();
		List<EventReviewTBJH> er=dao.selectAllEventReview(conn);
		close(conn);
		return er;
	}
	public List<Event> selectAllEventConcert(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventConcert(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Event> selectAllEventConcertTitle(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventConcertTitle(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Event> selectAllEventConcertLike(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventConcertLike(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Event> selectAllEventConcertReview(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventConcertReview(conn,cPage,numPerPage);
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
	public List<Event> selectAllEventActTitle(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventActTitle(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Event> selectAllEventActLike(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventActLike(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Event> selectAllEventActReview(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Event> list=dao.selectAllEventActReview(conn,cPage,numPerPage);
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
	public List<EventOrder> selectRsvNo(String eventNo){
		Connection conn=getConnection();
		List<EventOrder> rsv=dao.selectRsvNo(conn,eventNo);
		close(conn);
		return rsv;
		
	}
	public List<EventReviewTBJH> selectEventReview(String ervNo){
		Connection conn=getConnection();
		List<EventReviewTBJH> ertb=dao.selectEventReview(conn,ervNo);
		close(conn);
		return ertb;
		
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
	
	public List<Event> searchAllEventMusical(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchAllEventMusical(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public List<Event> searchAllEventConcert(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchAllEventConcert(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public List<Event> searchAllEventAct(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchAllEventAct(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public int searchAllEventCountMusical(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchAllEventCountMusical(conn,searchtext);
		close(conn);
		return result;
	}
	public List<Event> searchTitleEventMusical(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchTitleEventMusical(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public int searchTitleEventCountMusical(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchTitleEventCountMusical(conn,searchtext);
		close(conn);
		return result;
	}
	public List<Event> searchLocationEventMusical(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchLocationEventMusical(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public int searchLocationEventCountMusical(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchLocationEventCountMusical(conn,searchtext);
		close(conn);
		return result;
	}
	public int searchAllEventCountConcert(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchAllEventCountConcert(conn,searchtext);
		close(conn);
		return result;
	}
	public List<Event> searchTitleEventConcert(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchTitleEventConcert(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public int searchTitleEventCountConcert(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchTitleEventCountConcert(conn,searchtext);
		close(conn);
		return result;
	}
	public List<Event> searchLocationEventConcert(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchLocationEventConcert(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public int searchLocationEventCountConcert(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchLocationEventCountConcert(conn,searchtext);
		close(conn);
		return result;
	}
	public int searchAllEventCountAct(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchAllEventCountAct(conn,searchtext);
		close(conn);
		return result;
	}
	public List<Event> searchTitleEventAct(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchTitleEventAct(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public int searchTitleEventCountAct(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchTitleEventCountAct(conn,searchtext);
		close(conn);
		return result;
	}
	public List<Event> searchLocationEventAct(int cPage, int numPerPage,String searchtext){
		Connection conn=getConnection();
		List<Event> list=dao.searchLocationEventAct(conn,cPage,numPerPage,searchtext);
		close(conn);
		return list;
	}
	public int searchLocationEventCountAct(String searchtext) {
		Connection conn=getConnection();
		int result=dao.searchLocationEventCountAct(conn,searchtext);
		close(conn);
		return result;
	}
	
	// ------------------------- jaehun -------------------------
	public List<String> selectLocation(String location) {
		Connection conn = JDBCTemplate.getConnection();
		List<String> locations = dao.selectLocation(conn, location);
		JDBCTemplate.close(conn);
		return locations;
	}
	
	public int insertEvent(Event eventInfo, 
							List<Casting> castings,
							List<EventSchedule> eventSchedule, 
							List<EventUpfile> upfiles) 
	{
		Connection conn = JDBCTemplate.getConnection();
		int finalResult = 0;
		List<Integer> results = List.of(dao.insertEventInfo(conn, eventInfo), 
										dao.insertEventCasting(conn, castings), 
										dao.insertEventSchedule(conn, eventSchedule), 
										dao.insertEventFiles(conn, upfiles));
		
		if (results.contains(0)) {
			JDBCTemplate.rollback(conn);
		} else {
			finalResult = 1;
			JDBCTemplate.commit(conn);
		}
		
		JDBCTemplate.close(conn);
		return finalResult;
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
	
	public Map<Event, String> selectEventAndFileByDate(String date) {
		Connection conn = JDBCTemplate.getConnection();
		Map<Event, String> events = dao.selectEventAndFileByDate(conn, date);
		JDBCTemplate.close(conn);
		return events;
	}
	
	public Map<String, EventUpfile> selectBanner() {
		Connection conn = JDBCTemplate.getConnection();
		Map<String, EventUpfile> banners = dao.selectBanner(conn);
		JDBCTemplate.close(conn);
		return banners;
	}
	
	public int deleteEventByNo(String eventNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteEventByNo(conn, eventNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	//윤진작성
	public List<EventWish> selectWishById(String userId) {
		Connection conn=getConnection();
		List<EventWish> list=dao.selectWishById(conn,userId);
		close(conn);
		return list;
	}
	
}