package com.stagemate.detail.model.vo;

import java.sql.Date;

import com.stagemate.event.model.vo.Event;
import com.stagemate.member.model.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventOrder {
	
	private String rsvNo;
	private Event event;
	private Date rsvDate;
	private int rsv_price;
	private Member member;
	private String paymentNo;
	private String orderStatus;
	private Date esDate;
	private int tcnt;
	
	
	
	
	
}
