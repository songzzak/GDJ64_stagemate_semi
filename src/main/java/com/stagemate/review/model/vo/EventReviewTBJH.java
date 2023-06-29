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
public class EventReviewTBJH {
	private String ervNo;
	private String ervContent;
	private String memberId;
	private Date ervDate;
	private String rsvNo;
	private int imojiNo;
	private String eventNo;
}
