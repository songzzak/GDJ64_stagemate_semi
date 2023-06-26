package com.stagemate.payment.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PrdOrderDetail {
	private String orderDetailNo;
	private String orderNo;
	private int productNo;
	private int orderAmt;
}
