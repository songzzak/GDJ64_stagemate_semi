package com.stagemate.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.stagemate.member.model.vo.Member;

public class MemberGenerator {

	public static Member by(ResultSet rs) throws SQLException {
		Member member = Member.builder()
						.memberId(rs.getString("MEMBER_ID"))
						.memberPw(rs.getString("MEMBER_PW"))
						.memberNm(rs.getString("MEMBER_NM"))
						.memberBdate(rs.getDate("MEMBER_BDATE"))
						.memberEmail(rs.getString("MEMBER_EMAIL"))
						.memberPhone(rs.getString("MEMBER_PHONE"))
						.memberAddress(rs.getString("MEMBER_ADDRESS"))
						.enrrolDate(rs.getDate("ENROLL_DATE"))
						.wthdrDate(rs.getString("WTHDR_DATE") == null ? null : rs.getDate("WTHDR_DATE"))
						.build();
		
		try {
			member.setMemberEmail(AESEncryptor.decrypt(member.getMemberEmail()));
		} catch (Exception e) {
			// pass
		}
		
		try {
			member.setMemberPhone(AESEncryptor.decrypt(member.getMemberPhone()));
		} catch (Exception e) {
			// pass
		}
		return member;
	}
}
