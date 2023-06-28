package com.stagemate.detail.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDetailInfo {
	private String orderNo;
	private String orderStatus;
	private int totalPirce;
	private int orderAMT;
	private String orderDate;
	private String productTitle;
	private String productNm;
	private int productPrice;
	private String imgFileRename;	
}
