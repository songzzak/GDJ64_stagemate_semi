package com.stagemate.payment.model.vo;

import java.sql.Date;

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
	private String eventNo;
	private Date rsvDate;
	private String whatchDt;
	private int rsvPrice;
	private String memberId;
	private String paymentNo;
	private String orderStatus;
}
