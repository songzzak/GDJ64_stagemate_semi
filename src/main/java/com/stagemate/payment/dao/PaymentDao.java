package com.stagemate.payment.dao;

import static com.stagemate.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.stagemate.common.PropertiesGenerator;
import com.stagemate.event.model.vo.Seat;
import com.stagemate.payment.model.vo.EventOrder;
import com.stagemate.payment.model.vo.Payment;
import com.stagemate.store.dao.StoreDao;

public class PaymentDao {
	
	String path=StoreDao.class.getResource("/sql/payment/payment.properties").getPath();
	private final Properties sql;
	
	public PaymentDao() {
		sql = PropertiesGenerator.by(path);
	}
	
	private EventOrder getEventOrder(ResultSet rs) throws SQLException{
		return EventOrder.builder()
			.rsvNo(rs.getString("RSV_NO"))
			.eventNo(rs.getString("EVENT_NO"))
			.rsvDate(rs.getDate("RSV_DATE"))
			.whatchDt(rs.getString("WATCH_DT"))
			.rsvPrice(rs.getInt("RSV_PRICE"))
			.memberId(rs.getString("MEMBER_ID"))
			.paymentNo(rs.getString("PAYMENT_NO"))
			.orderStatus(rs.getString("ORDER_STATUS"))
			.build();
			
	}
	
	private Seat getSeat(ResultSet rs) throws SQLException {
		return Seat.builder()
				.seatNo(rs.getString("SEAT_NO"))
				.isReserved(rs.getString("IS_RESERVED").charAt(0))
				.slvNo(rs.getString("SLV_NO"))
				.seatRow(rs.getString("SEAT_ROW").charAt(0))
				.seatCol(rs.getInt("SEAT_COL"))
				.eventNo(rs.getString("EVENT_NO"))
				.build();
	}
	
	public int insertPayment(Connection conn,Payment p) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertPayment"));
			pstmt.setString(1, p.getPaymentNo());
			pstmt.setInt(2, p.getPaymentPrice());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertEventOrder(Connection conn,EventOrder eo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertEventOrder"));
			pstmt.setString(1, eo.getEventNo());
			pstmt.setString(2, eo.getWhatchDt());
			pstmt.setInt(3, eo.getRsvPrice());
			pstmt.setString(4, eo.getMemberId());
			pstmt.setString(5, eo.getPaymentNo());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateSeatRes(Connection conn,String row,int col,String eventNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateSeatRes"));
			pstmt.setString(1, eventNo);
			pstmt.setString(2, row);
			pstmt.setInt(3, col);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public EventOrder selectEventOrder(Connection conn,String paymentNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EventOrder eventOrder=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectEventOrder"));
			pstmt.setString(1, paymentNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				eventOrder=getEventOrder(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return eventOrder;
	}
	
	public Seat selectSeatNo(Connection conn,String row,int col,String eventNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Seat seat=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectSeatNo"));
			pstmt.setString(1, eventNo);
			pstmt.setString(2, row);
			pstmt.setInt(3, col);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				seat=getSeat(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return seat;
	}
	
	public int insertEventOrderDetail(Connection conn,String rsvNo,String seatNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertEventOrderDetail"));
			pstmt.setString(1, rsvNo);
			pstmt.setString(2, seatNo);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
}
