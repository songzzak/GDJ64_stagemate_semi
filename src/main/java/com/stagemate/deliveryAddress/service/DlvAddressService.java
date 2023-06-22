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

	public int insertDlvAddress(DlvAdress newAddress) {
		Connection conn=getConnection();
		int seqNo=dao.selectDlvSeqNo(conn);
		int result=dao.insertDlvAddress(conn,newAddress,seqNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public DlvAdress selectDlvAddressByDlvId(String dlvId) {
		Connection conn=getConnection();
		DlvAdress d=dao.selectDlvAddressByDlvId(conn, dlvId);
		close(conn);
		return d;
	}

	public int updateDlvAddress(DlvAdress newAddress, String dlvId) {
		Connection conn=getConnection();
		int result=dao.updateDlvAddress(conn, newAddress, dlvId);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int deleteDlvAddress(String dlvId) {
		Connection conn=getConnection();
		int result=dao.deleteDlvAddress(conn, dlvId);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	
}
