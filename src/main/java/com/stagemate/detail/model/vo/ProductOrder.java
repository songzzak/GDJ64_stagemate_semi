package com.stagemate.detail.model.vo;

import java.sql.Date;

import com.stagemate.event.model.vo.Event;
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
public class ProductOrder {

	private String orderNo; 
	private String orderStatus;
	private Date orderDate; 	//prd order tb
	private Product product;
	private Member member;
	private Number productNo;
	
}
