package com.stagemate.event.model.vo;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventTime {
	private String etNo;
	private String eventNo;
	private String etDay;
	private String etStartTime;

}
