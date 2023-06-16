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
}
