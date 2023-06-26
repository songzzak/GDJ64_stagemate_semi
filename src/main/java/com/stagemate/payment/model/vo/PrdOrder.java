package com.stagemate.payment.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PrdOrder {
	private String orderNo;
	private String dlvId;
	private String paymentNo;
	private String memberId;
	private String shipMsg;
	private int totalPrice;
	private String orderStatus;
	private Date orderDate;
}

