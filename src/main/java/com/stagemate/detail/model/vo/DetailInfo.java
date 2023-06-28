package com.stagemate.detail.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailInfo {
	private String rsvNo;
	private String esNo;
	private String rsvDate;
	private int rsvPirce;
	private String memberId;
	private String memberNm;
	private String orderStatus;
	private String tickets;
	private String eventName;
	private String fileName;
	private String location;
}
