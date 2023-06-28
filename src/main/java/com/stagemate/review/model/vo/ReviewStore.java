package com.stagemate.review.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ReviewStore {
	private String reviewNo;
	private String productNm;
	private String reviewContent;
	private String reviewDate;
	private String orderDate;
}
