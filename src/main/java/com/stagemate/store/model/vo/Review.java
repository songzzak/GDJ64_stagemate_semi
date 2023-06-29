package com.stagemate.store.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Review {
	private int reviewNo;
	private String reviewContent;
	private Date reviewDt;
	private String orderNo;
	private String imojiCd;
	private String reviewWriter;
	private int productNo;
}
