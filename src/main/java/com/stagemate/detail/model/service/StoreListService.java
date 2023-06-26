package com.stagemate.detail.model.service;
import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;
import java.sql.Connection;
import java.util.List;

import com.stagemate.detail.model.dao.StoreListDao;
import com.stagemate.detail.model.vo.Detail;
import com.stagemate.detail.model.vo.StoreDetail;

public class StoreListService {
	private StoreListDao dao=new StoreListDao();
	
	public List<StoreDetail> selectStoreDetail(){
		Connection conn=getConnection();
		List<StoreDetail> result=dao.selectStoreDetail(conn);
		close(conn);
		return result;
	}
	
	public int selectStoreDetailCount(String userId, String day, String yyyy, String mm, String status){
		Connection conn=getConnection();
		int result = dao.selectStoreDetailCount(conn, userId, day, yyyy, mm, status);
		close(conn);
		return result;
	}
	
	public List<StoreDetail> selectStoreDetailCondition(String userId, String day, String yyyy, String mm, String status, int startRow, int endRow, String order){
		Connection conn=getConnection();
		List<StoreDetail> result=dao.selectStoreDetailCondition(conn, userId, day, yyyy, mm, status, startRow, endRow, order);
		close(conn);
		return result;
	}
}
