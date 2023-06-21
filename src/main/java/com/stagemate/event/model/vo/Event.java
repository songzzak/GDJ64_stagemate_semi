package com.stagemate.event.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
	private String eventNo;
	private String eventNm;
	private Date eventStartDt;
	private Date eventEndDt;
	private Date rsvOpenDt;
	private String evcNo;
	private String location;
	private int eventAge;
	private int eventDuration;
	private int eventInter;
}
