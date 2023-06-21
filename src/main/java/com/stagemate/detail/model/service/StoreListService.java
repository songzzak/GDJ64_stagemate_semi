package com.stagemate.detail.model.service;
import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;
import java.sql.Connection;
import java.util.List;

import com.stagemate.detail.model.dao.StoreListDao;
import com.stagemate.detail.model.vo.StoreDetail;

public class StoreListService {
	private StoreListDao dao=new StoreListDao();
	
	public List<StoreDetail> selectStoreDetail(){
		Connection conn=getConnection();
		List<StoreDetail> result=dao.selectStoreDetail(conn);
		close(conn);
		return result;
	}
}
