package com.stagemate.admin.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.stagemate.admin.model.dao.AdminDao;
import com.stagemate.common.JDBCTemplate;
import com.stagemate.event.model.vo.Event;
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
}
