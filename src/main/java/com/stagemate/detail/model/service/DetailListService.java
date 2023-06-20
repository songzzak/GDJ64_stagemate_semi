package com.stagemate.detail.model.service;
import java.sql.Connection;
import java.util.List;
import static com.stagemate.common.JDBCTemplate.close;
import com.stagemate.detail.model.dao.DetailListDao;
import com.stagemate.detail.model.vo.Detail;


public class DetailListService {
private DetailListDao dao=new DetailListDao(); //dao 만들어주기 
	//connection 연결 요청
	public List<Detail> selectDetails(){
		Connection conn=getConnection();
		
		List<Detail> details=dao.selectDetails(conn); //conn에서 dao로 전달
		conn.close();
		return details;
		
		
	}
}
