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

public class EventReview {
	private String eventName;
	private int rpNo;
	private String rpContent;
	private Date rpDate;
	private String rsvNo;
	private int imojiCd;
	private String memberId;
	private Date watchDt;
	
	
}
