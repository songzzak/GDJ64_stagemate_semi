package com.stagemate.store.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private int productNo;
	private String productTitle;
	private String productNm;
	private int productPrice;
	private int productAmt;
	private String productComment;
	private Date productInsertDate;
	private int productLikeCnt;
}
