package com.stagemate.member.service;

import java.sql.Connection;

import com.stagemate.common.JDBCTemplate;
import com.stagemate.member.model.dao.MemberDao;
import com.stagemate.member.model.vo.Member;

public class MemberService {
	private final MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	public Member selectByIdAndPw(String id, String pw) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = memberDao.selectByIdAndPw(conn, id, pw);
		JDBCTemplate.close(conn);
		return member;
	}
	
	public Member selectById(String id) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = memberDao.selectById(conn, id);
		JDBCTemplate.close(conn);
		return member;
	}

	public Member selectByEmail(String email) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = memberDao.selectByEmail(conn, email);
		JDBCTemplate.close(conn);
		return member;
	}
	
	public int insertMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = memberDao.insertMember(conn, member);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
