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
public class EventSchedule {
	private String esNo;
	private String eventNo;
	private Date esDate;
	private String esDay;
	private String esStartTime;

}
