package com.stagemate.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
	private String memberId;
	private String memberPw;
	private String memberNm;
	private Date memberBdate;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private Date enrollDate;
	private Date wthdrDate;
}
