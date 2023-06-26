package com.stagemate.payment.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.commit;
import static com.stagemate.common.JDBCTemplate.getConnection;
import static com.stagemate.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import com.stagemate.event.model.vo.Seat;
import com.stagemate.payment.dao.PaymentDao;
import com.stagemate.payment.model.vo.EventOrder;
import com.stagemate.payment.model.vo.Payment;
import com.stagemate.payment.model.vo.PrdOrder;
import com.stagemate.payment.model.vo.PrdOrderDetail;

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
	
	public int updateMusicalSeatRes(String row,int col,String eventNo,String choiceday) {
		Connection conn=getConnection();
		int result=dao.updateMusicalSeatRes(conn,row,col,eventNo,choiceday);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int updateActSeatRes(String row,int col,String eventNo,String choiceday) {
		Connection conn=getConnection();
		int result=dao.updateActSeatRes(conn,row,col,eventNo,choiceday);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int updateConcertSeatRes(String row,int col,String eventNo,String choiceday) {
		Connection conn=getConnection();
		int result=dao.updateConcertSeatRes(conn,row,col,eventNo,choiceday);
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
	
	public Seat selectMusicalSeatNo(String row,int col,String eventNo,String esNo) {
		Connection conn=getConnection();
		Seat SeatNo=dao.selectMusicalSeatNo(conn,row,col,eventNo,esNo);
		close(conn);
		return SeatNo;
	}
	public Seat selectActSeatNo(String row,int col,String eventNo,String esNo) {
		Connection conn=getConnection();
		Seat SeatNo=dao.selectActSeatNo(conn,row,col,eventNo,esNo);
		close(conn);
		return SeatNo;
	}
	public Seat selectConcertSeatNo(String row,int col,String eventNo,String esNo) {
		Connection conn=getConnection();
		Seat SeatNo=dao.selectConcertSeatNo(conn,row,col,eventNo,esNo);
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

	public int insertPrdOrder(PrdOrder po) {
		Connection conn = getConnection();
	    int result = dao.insertPrdOrder(conn, po);
	    if (result > 0) {
	        commit(conn);
	    } else {
	        rollback(conn);
	    }
	    close(conn);

	    return result;
	}

	public int insertPrdOrderDetail(PrdOrderDetail pod) {
		Connection conn=getConnection();
		int result=dao.insertPrdOrderDetail(conn,pod);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public String selectOrderNo() {
		Connection conn=getConnection();
		String orderNo=dao.selectOrderNo(conn);
		close(conn);
		return orderNo;
	}

	public PrdOrder selectPrdOrderByOrderNo(String orderNo) {
		Connection conn=getConnection();
		PrdOrder po=dao.selectPrdOrderByOrderNo(conn, orderNo);
		close(conn);
		return po;
	}

}
