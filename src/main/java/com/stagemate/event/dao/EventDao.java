package com.stagemate.event.dao;

import static com.stagemate.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.stagemate.common.JDBCTemplate;
import com.stagemate.common.PropertiesGenerator;
import com.stagemate.event.model.vo.Casting;
import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventSchedule;
import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.event.model.vo.EventWish;
import com.stagemate.event.model.vo.Seat;
import com.stagemate.payment.model.vo.EventOrder;
import com.stagemate.review.model.vo.EventReviewTBJH;
import com.stagemate.store.dao.StoreDao;

public class EventDao {
	
	String path=StoreDao.class.getResource("/sql/event/eventsql.properties").getPath();
	private final Properties sql;
	
	public EventDao() {
		sql = PropertiesGenerator.by(path);
	}
	
	private Event getEvent(ResultSet rs) throws SQLException {
		return Event.builder()
				.eventNo(rs.getString("EVENT_NO"))
				.eventNm(rs.getString("EVENT_NM"))
				.eventStartDt(rs.getDate("EVENT_START_DT"))
				.eventEndDt(rs.getDate("EVENT_END_DT"))
				.rsvOpenDt(rs.getDate("RSV_OPEN_DT"))
				.evcNo(rs.getString("EVC_NO"))
				.location(rs.getString("LOCATION"))
				.eventAge(rs.getInt("EVENT_AGE"))
				.eventDuration(rs.getInt("EVENT_DURATION"))
				.eventInter(rs.getInt("EVENT_INTER"))
				.build();
	}
	
	private EventUpfile getEventUpfile(ResultSet rs) throws SQLException {
		return EventUpfile.builder()
				.euNo(rs.getString("EU_NO"))
				.euNameOriginal(rs.getString("EU_NAME_ORIGINAL"))
				.euRename(rs.getString("EU_RENAME"))
				.eventNo(rs.getString("EVENT_NO"))
				.purposeNo(rs.getString("PURPOSE_NO"))
				.euDate(rs.getDate("EU_DATE"))
				.build();
	}
	
	private Seat getSeat(ResultSet rs) throws SQLException {
		return Seat.builder()
				.seatNo(rs.getString("SEAT_NO"))
				.esNo(rs.getString("ES_NO"))
				.isReserved(rs.getString("IS_RESERVED").charAt(0))
				.slvNo(rs.getString("SLV_NO"))
				.seatRow(rs.getString("SEAT_ROW").charAt(0))
				.seatCol(rs.getInt("SEAT_COL"))
				.eventNo(rs.getString("EVENT_NO"))
				.esDate(rs.getDate("ES_DATE"))
				.esStartTime(rs.getString("ES_START_TIME"))
				.build();
	}
	
	private EventSchedule getEventSchedule(ResultSet rs) throws SQLException{
		return EventSchedule.builder()
				.esNo(rs.getString("ES_NO"))
				.eventNo(rs.getString("EVENT_NO"))
				.esDate(rs.getDate("ES_DATE"))
				.esDay(rs.getString("ES_DAY"))
				.esStartTime(rs.getString("ES_START_TIME"))
				.build();
	}
	
	private EventWish getEventWish(ResultSet rs) throws SQLException{
		return EventWish.builder()
				.eventWishCode(rs.getString("EVENT_WISH_CD"))
				.eventNo(rs.getString("EVENT_NO"))
				.memberId(rs.getString("MEMBER_ID"))
				.build();
	}
	
	private EventReviewTBJH getEventReviewTBJH(ResultSet rs)throws SQLException{
		return EventReviewTBJH.builder()
				.ervNo(rs.getString("ERV_NO"))
				.ervContent(rs.getString("ERV_CONTENT"))
				.memberId(rs.getString("MEMBER_ID"))
				.ervDate(rs.getDate("ERV_DATE"))
				.rsvNo(rs.getString("RSV_NO"))
				.imojiNo(rs.getInt("IMOJI_NO"))
				.build();
	}
	
	private EventOrder getEventOrder(ResultSet rs) throws SQLException{
		return EventOrder.builder()
			.rsvNo(rs.getString("RSV_NO"))
			.esNo(rs.getString("ES_NO"))
			.rsvDate(rs.getDate("RSV_DATE"))
			.rsvPrice(rs.getInt("RSV_PRICE"))
			.memberId(rs.getString("MEMBER_ID"))
			.paymentNo(rs.getString("PAYMENT_NO"))
			.orderStatus(rs.getString("ORDER_STATUS"))
			.build();
			
	}
	public List<Event> selectAllEventMusical(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventMusical"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> selectAllEventMusicalTitle(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventMusicalTitle"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> selectAllEventMusicalLike(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventMusicalLike"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> selectAllEventMusicalReview(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventMusicalReview"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int selectEventCountMusical(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("selectEventMusicalCount"));
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
	
	public List<EventUpfile> selectAllFile(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EventUpfile> files=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllFile"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EventUpfile f=getEventUpfile(rs);
				files.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return files;
		
	}
	public List<EventReviewTBJH> selectAllEventReview(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EventReviewTBJH> es=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventReview"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EventReviewTBJH f=getEventReviewTBJH(rs);
				es.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return es;
		
	}
	
	public List<Event> selectAllEventConcert(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventConcert"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public List<Event> selectAllEventConcertTitle(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventConcertTitle"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> selectAllEventConcertLike(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventConcertLike"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> selectAllEventConcertReview(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventConcertReview"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public List<EventWish> selectAllEventWish(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EventWish> ews=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventWish"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EventWish ew=getEventWish(rs);
				ews.add(ew);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return ews;
	}
	
	public int selectEventCountConcert(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("selectEventConcertCount"));
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
	public List<Event> selectAllEventAct(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventAct"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> selectAllEventActTitle(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventActTitle"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> selectAllEventActLike(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventActLike"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> selectAllEventActReview(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEventActReview"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int selectEventCountAct(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("selectEventActCount"));
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
	
	public Event selectEventByEventNo(Connection conn, String eventNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Event event=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectEventByEventNo"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				event=getEvent(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return event;	
	}
	
	public List<EventUpfile> selectFileByEventNo(Connection conn, String eventNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EventUpfile> files=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectFileByEventNo"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EventUpfile e=getEventUpfile(rs);
				files.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return files;
		
	}
	
	public List<EventSchedule> selectTimeByEvent(Connection conn, String eventNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EventSchedule> et=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectScheduleByEventNo"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EventSchedule e=getEventSchedule(rs);
				et.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return et;
	}
	public List<EventOrder> selectRsvNo(Connection conn, String eventNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EventOrder> rsv=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectRsvNo"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EventOrder eo=getEventOrder(rs);
				rsv.add(eo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return rsv;
	}
	public List<EventReviewTBJH> selectEventReview(Connection conn, String eventNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EventReviewTBJH> ertb=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectEventReview"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EventReviewTBJH er=getEventReviewTBJH(rs);
				ertb.add(er);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return ertb;
	}
	public List<Event> selectAllEvent(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllEvent"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int selectEventCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("selectEventCount"));
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
	
	public List<Seat> selectSeatByEvnNoConcert(Connection conn,String eventNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Seat> seats=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectSeatByEvnNoConcert"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Seat s=getSeat(rs);
				seats.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return seats;
	}
	public List<Seat> selectSeatByEvnNoAct(Connection conn,String eventNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Seat> seats=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectSeatByEvnNoAct"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Seat s=getSeat(rs);
				seats.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return seats;
	}
	public List<Seat> selectSeatByEvnNoMusical(Connection conn,String eventNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Seat> seats=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectSeatByEvnNoMusical"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Seat s=getSeat(rs);
				seats.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return seats;
	}
	
	public int insertEventWish(Connection conn,String eventNo,String memberId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertEventWish"));
			pstmt.setString(1,eventNo);
			pstmt.setString(2, memberId);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteEventWish(Connection conn,String eventNo,String memberId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteEventWish"));
			pstmt.setString(1,eventNo);
			pstmt.setString(2, memberId);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<Event> searchAllEventMusical(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchAllEventMusical"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setString(2, "%"+searchtext+"%");
			pstmt.setInt(3, (cPage-1)*numPerpage+1);
			pstmt.setInt(4, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> searchAllEventAct(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchAllEventAct"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setString(2, "%"+searchtext+"%");
			pstmt.setInt(3, (cPage-1)*numPerpage+1);
			pstmt.setInt(4, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	public List<Event> searchAllEventConcert(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchAllEventConcert"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setString(2, "%"+searchtext+"%");
			pstmt.setInt(3, (cPage-1)*numPerpage+1);
			pstmt.setInt(4, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int searchAllEventCountMusical(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchAllEventCountMusical"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setString(2, "%"+searchtext+"%");
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
	
	public List<Event> searchTitleEventMusical(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchTitleEventMusical"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int searchTitleEventCountMusical(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchTitleEventCountMusical"));
			pstmt.setString(1, "%"+searchtext+"%");
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
	public List<Event> searchLocationEventMusical(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchLocationEventMusical"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int searchLocationEventCountMusical(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchLocationEventCountMusical"));
			pstmt.setString(1, "%"+searchtext+"%");
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
	public int searchAllEventCountAct(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchAllEventCountAct"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setString(2, "%"+searchtext+"%");
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
	
	public List<Event> searchTitleEventAct(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchTitleEventAct"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int searchTitleEventCountAct(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchTitleEventCountAct"));
			pstmt.setString(1, "%"+searchtext+"%");
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
	public List<Event> searchLocationEventAct(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchLocationEventAct"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int searchLocationEventCountAct(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchLocationEventCountAct"));
			pstmt.setString(1, "%"+searchtext+"%");
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
	public int searchAllEventCountConcert(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchAllEventCountConcert"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setString(2, "%"+searchtext+"%");
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
	
	public List<Event> searchTitleEventConcert(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchTitleEventConcert"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int searchTitleEventCountConcert(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchTitleEventCountConcert"));
			pstmt.setString(1, "%"+searchtext+"%");
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
	public List<Event> searchLocationEventConcert(Connection conn,int cPage, int numPerpage,String searchtext){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Event> events=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchLocationEventConcert"));
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Event e=getEvent(rs);
				events.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return events;
		
	}
	
	public int searchLocationEventCountConcert(Connection conn,String searchtext) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql.getProperty("searchLocationEventCountConcert"));
			pstmt.setString(1, "%"+searchtext+"%");
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
	
	// ------------------------- jaehun -------------------------
	public List<String> selectLocation(Connection conn, String location) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> locations = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectLocation"));
			pstmt.setString(1, "%" + location + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				locations.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return locations;
	}
	
	public int insertEventInfo(Connection conn, Event eventInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertEventInfo"));
			pstmt.setString(1, eventInfo.getEventNm());
			pstmt.setDate(2, eventInfo.getEventStartDt());
			pstmt.setDate(3, eventInfo.getEventEndDt());
			pstmt.setDate(4, eventInfo.getRsvOpenDt());
			pstmt.setString(5, eventInfo.getEvcNo());
			pstmt.setString(6, eventInfo.getLocation());
			pstmt.setInt(7, eventInfo.getEventAge());
			pstmt.setInt(8, eventInfo.getEventDuration());
			pstmt.setInt(9, eventInfo.getEventInter());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertEventCasting(Connection conn, List<Casting> castings) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		if (castings.isEmpty()) {
			return 1;
		}
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertEventCasting"));
			for (Casting casting : castings) {
				pstmt.setString(1, casting.getCastingNm().trim());
				result = pstmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertEventSchedule(Connection conn, List<EventSchedule> eventSchedule) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertEventSchedule"));
			for (EventSchedule schedule : eventSchedule) {
				pstmt.setDate(1, schedule.getEsDate());
				pstmt.setString(2, schedule.getEsDay());
				pstmt.setString(3, schedule.getEsStartTime());
				result = pstmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertEventFiles(Connection conn, List<EventUpfile> upfiles) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertEventFiles"));
			for (EventUpfile upfile : upfiles) {
				pstmt.setString(1, upfile.getEuNameOriginal());
				pstmt.setString(2, upfile.getEuRename());
				pstmt.setString(3, upfile.getPurposeNo());
				result = pstmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public String selectCategoryByEventNo(Connection conn, String eventNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String eventCategory = "";
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectCategoryByEventNo"));
			pstmt.setString(1, eventNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				eventCategory = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return eventCategory;
	}

	public String selectCastingByEventNo(Connection conn, String eventNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> castings = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectCastingByEventNo"));
			pstmt.setString(1, eventNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				castings.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return String.join(",", castings.stream().toArray(String[]::new));
	}

	public Map<String, String> selectDaysByEventNo(Connection conn, String eventNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> schedule = new HashMap<>();
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectDaysByEventNo"));
			pstmt.setString(1, eventNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				schedule.put(rs.getString("ES_DAY"), rs.getString("ES_START_TIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return schedule;
	}

	public int updateEventInfo(Connection conn, Event eventInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updateEventInfo"));
			pstmt.setString(1, eventInfo.getEventNm());
			pstmt.setDate(2, eventInfo.getEventStartDt());
			pstmt.setDate(3, eventInfo.getEventEndDt());
			pstmt.setDate(4, eventInfo.getRsvOpenDt());
			pstmt.setString(5, eventInfo.getEvcNo());
			pstmt.setString(6, eventInfo.getLocation());
			pstmt.setInt(7, eventInfo.getEventAge());
			pstmt.setInt(8, eventInfo.getEventDuration());
			pstmt.setInt(9, eventInfo.getEventInter());
			pstmt.setString(10, eventInfo.getEventNo());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteEventCastingByEventNo(Connection conn, String eventNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("deleteEventCastingByEventNo"));
			pstmt.setString(1, eventNo);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int reInsertEventCasting(Connection conn, List<Casting> castings) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("reInsertEventCasting"));
			for (Casting casting : castings) {
				pstmt.setString(1, casting.getCastingNm().trim());
				pstmt.setString(2, casting.getEventNo());
				result = pstmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteEventFilesByEventNo(Connection conn, String eventNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("deleteEventFilesByEventNo"));
			pstmt.setString(1, eventNo);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int reInsertEventFiles(Connection conn, List<EventUpfile> upfiles) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("reInsertEventFiles"));
			for (EventUpfile upfile : upfiles) {
				pstmt.setString(1, upfile.getEuNameOriginal());
				pstmt.setString(2, upfile.getEuRename());
				pstmt.setString(3, upfile.getEventNo());
				pstmt.setString(4, upfile.getPurposeNo());
				result = pstmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public Map<Event, String> selectEventAndFileByDate(Connection conn, String date) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Event, String> events = new HashMap<>();
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectEventAndFileByDate"));
			System.out.println("pstmt.setString() 적용 전 sql.getProperty(): " + sql.getProperty("selectEventAndFileByDate"));
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				events.put(getEvent(rs), rs.getString("EU_RENAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return events;
	}

	public Map<String, EventUpfile> selectBanner(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, EventUpfile> banners = new HashMap<>();
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBanner"));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				banners.put(rs.getString("EVENT_NM"), getEventUpfile(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return banners;
	}

	//윤진작성
	public List<EventWish> selectWishById(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<EventWish> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectWishById"));
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
				while(rs.next()) {
					list.add(getEventWish(rs));
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
