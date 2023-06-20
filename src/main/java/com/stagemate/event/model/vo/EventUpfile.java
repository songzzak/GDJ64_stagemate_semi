package com.stagemate.event.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventUpfile {
	private String euNo;
	private String euNameOriginal;
	private String euRename;
	private String eventNo;
	private String purposeNo;
	private Date euDate;
}
