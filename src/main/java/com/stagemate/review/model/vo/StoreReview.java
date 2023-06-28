package com.stagemate.review.model.vo;

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
public class StoreReview {
	private int reviewNo;
	private String reviewContent;
	private Date reviewDt;
	private Product reviewProduct;
	private Imoji reviewImoji;
	private Member reviewWriter;
}
