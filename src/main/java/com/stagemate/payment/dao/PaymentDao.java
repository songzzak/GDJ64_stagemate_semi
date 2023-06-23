package com.stagemate.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.stagemate.common.JDBCTemplate.*;

import com.stagemate.common.PropertiesGenerator;
import com.stagemate.payment.model.vo.EventOrder;
import com.stagemate.payment.model.vo.Payment;
import com.stagemate.store.dao.StoreDao;

public class PaymentDao {
	
	String path=StoreDao.class.getResource("/sql/payment/payment.properties").getPath();
	private final Properties sql;
	
	public PaymentDao() {
		sql = PropertiesGenerator.by(path);
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
	
	
}
