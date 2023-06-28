package com.stagemate.detail.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Detail {
	private String rsvNo;
	private String eventName;
	private String rsvDate;
	private String esDate;
	private String orderStatus;
	private String tickets;
}

