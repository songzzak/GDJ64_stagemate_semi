package com.stagemate.deliveryAddress.service;

import static com.stagemate.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import com.stagemate.deliveryAddress.dao.DlvAddressDao;
import com.stagemate.deliveryAddress.model.vo.DlvAdress;

public class DlvAddressService {

	private DlvAddressDao dao=new DlvAddressDao();

	public List<DlvAdress> selectDlvAddressById(String memberId) {
		Connection conn=getConnection();
		List<DlvAdress> dlvList=dao.selectDlvAddressById(conn, memberId);
		close(conn);
		return dlvList;
	}
	
	
}
