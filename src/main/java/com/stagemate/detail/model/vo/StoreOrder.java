package com.stagemate.detail.model.vo;

import java.sql.Date;

import com.stagemate.member.model.vo.Member;
import com.stagemate.store.model.vo.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreOrder {

	private Date OrderDate;
	private String OrderNo;
	private String ProductNm;
	private int TotalPrice;
	private String OrderStatus;
	private Member member;
	private Product product;
	private String paymentNo;
	
	
	
}
