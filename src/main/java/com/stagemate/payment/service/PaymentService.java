package com.stagemate.payment.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.commit;
import static com.stagemate.common.JDBCTemplate.getConnection;
import static com.stagemate.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.stagemate.event.model.vo.Seat;
import com.stagemate.payment.dao.PaymentDao;
import com.stagemate.payment.model.vo.EventOrder;
import com.stagemate.payment.model.vo.Payment;

public class PaymentService {
	
	private PaymentDao dao=new PaymentDao();
	
	public int insertPayment(Payment p) {
		Connection conn=getConnection();
		int result=dao.insertPayment(conn,p);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int insertEventOrder(EventOrder eo) {
		Connection conn=getConnection();
		int result=dao.insertEventOrder(conn,eo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateSeatRes(String row,int col,String eventNo) {
		Connection conn=getConnection();
		int result=dao.updateSeatRes(conn,row,col,eventNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public EventOrder selectEventOrder(String paymentNo) {
		Connection conn=getConnection();
		EventOrder eventOrder=dao.selectEventOrder(conn,paymentNo);
		close(conn);
		return eventOrder;
	}
	
	public Seat selectSeatNo(String row,int col,String eventNo) {
		Connection conn=getConnection();
		Seat SeatNo=dao.selectSeatNo(conn,row,col,eventNo);
		close(conn);
		return SeatNo;
	}
	
	public int insertEventOrderDetail(String rsvNo,String seatNo) {
		Connection conn=getConnection();
		int result=dao.insertEventOrderDetail(conn,rsvNo,seatNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
