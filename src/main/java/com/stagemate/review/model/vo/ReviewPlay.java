package com.stagemate.review.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ReviewPlay {
	private String ervNo;
	private String ervConTent;
	private String memberId;
	private String ervDate;
	private String rsvNo;
	private String memberNm;
	private String eventNm;
	private String rsvDate;
}
