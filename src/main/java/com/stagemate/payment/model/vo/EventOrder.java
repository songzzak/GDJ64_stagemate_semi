package com.stagemate.payment.model.vo;



import java.util.Date;

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
	private String esNo;
	private Date rsvDate;
	private int rsvPrice;
	private String memberId;
	private String paymentNo;
	private String orderStatus;
}
