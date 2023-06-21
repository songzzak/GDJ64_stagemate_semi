package com.stagemate.event.dao;

import static com.stagemate.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.stagemate.common.PropertiesGenerator;
import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventTime;
import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.member.model.vo.Member;
import com.stagemate.store.dao.StoreDao;
import com.stagemate.store.model.vo.StoreUpfile;

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
	
	private EventTime getEventTime(ResultSet rs) throws SQLException{
		return EventTime.builder()
				.etNo(rs.getString("ET_NO"))
				.eventNo(rs.getString("EVENT_NO"))
				.etDay(rs.getString("ET_DAY"))
				.etStartTime(rs.getString("ET_START_TIME"))
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
	
	public List<EventTime> selectTimeByEvent(Connection conn, String eventNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EventTime> et=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectTimeByEventNo"));
			pstmt.setString(1, eventNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EventTime e=getEventTime(rs);
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
}
