package com.stagemate.detail.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDetail {
	private int orderNo;
	private String productNm;
	private int totalPrice;
	
}
