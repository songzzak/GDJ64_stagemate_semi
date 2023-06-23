package com.stagemate.payment.service;

import java.sql.Connection;

import static com.stagemate.common.JDBCTemplate.*;

import com.stagemate.payment.dao.PaymentDao;
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

}
