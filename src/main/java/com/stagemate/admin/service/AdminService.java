package com.stagemate.admin.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.commit;
import static com.stagemate.common.JDBCTemplate.getConnection;
import static com.stagemate.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.stagemate.admin.model.dao.AdminDao;
import com.stagemate.admin.model.vo.PlayInfo;
import com.stagemate.detail.model.vo.EventOrder;
import com.stagemate.detail.model.vo.StoreOrder;
import com.stagemate.member.model.vo.Member;

public class AdminService {
	private AdminDao dao=new AdminDao();
	
	public List<Member> listMember(int cPage,int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.memberManage(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	public int selectMemberCount() {
		Connection conn=getConnection();
		int result=dao.memberCount(conn);
		close(conn);
		return result;
	}
	public int selectMemberCountByType(String keyword, String type) {
		Connection conn=getConnection();
		int result=dao.selectMemberCountByType(conn,keyword,type);
		close(conn);
		return result;
	}
	
	public List<Member> searchMemberByType(String keyword, String type, int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.searchMember(conn,keyword,type,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	//관리자페이지 예매
	public List<PlayInfo> listPlayInfo(){
		Connection conn=getConnection();
		List<PlayInfo> list=dao.playInfo(conn);
		close(conn);
		return list;
	}
	
	
	//사용자 애매내역
	public List<EventOrder> selectSalesInfo(String userId){
		Connection conn=getConnection();
		
		List<EventOrder> eventOrder=new AdminDao().selectEventOrder(conn,userId);
		
		close(conn);
		return eventOrder;
	}
	public int outmember(String outid) {
		Connection conn=getConnection();
		int result=dao.outmember(conn,outid);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	
	//공연 결제 취소창
	public List<EventOrder> selectCancelOrder(String rsvNo){
		Connection conn=getConnection();
		
		List<EventOrder> eventOrder=new AdminDao().selectCancelOrder(conn,rsvNo);
		
		close(conn);
		return eventOrder;
	}
	
	
	
	
	
	
	//사용자 멤버 정보
	public List<Member> MemberInfo(String userId){
		Connection conn=getConnection();
		
		List<Member> memberInfo=new AdminDao().MemberInfoma(conn,userId);
		
		close(conn);
		return memberInfo;
	}
	//관리자페이지 스토어 리스트
	/*
	 * public List<StoreInfo> listStoreInfo(){ Connection conn=getConnection();
	 * List<StoreInfo> list=dao.storeInfo(conn); close(conn); return list; }
	 */
		//사용자 구매정보
		/*
		 * public List<StoreOrder> selectStoresInfo(String userId){ Connection
		 * conn=getConnection();
		 * 
		 * List<StoreOrder> storeOrder=new AdminDao().selectStoreOrder(conn,userId);
		 * 
		 * close(conn); return storeOrder; }
		 */
			
			/*
			 * //스토어 결제 취소창 public List<StoreOrder> selectStoreCancel(String orderNo){
			 * Connection conn=getConnection();
			 * 
			 * List<StoreOrder> storeOrder=new AdminDao().selectStoreCancel(conn,orderNo);
			 * 
			 * close(conn); return storeOrder; }
			 */
	
}
