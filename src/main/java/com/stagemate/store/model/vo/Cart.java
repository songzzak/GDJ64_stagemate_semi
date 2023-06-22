package com.stagemate.store.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cart {
	private String cartCd;
	private String memberId;
	private int productNo;
	private int cartAmt;
}
