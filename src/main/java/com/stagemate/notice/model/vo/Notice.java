package com.stagemate.notice.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder
public class Notice {
	private int noticeNo;
	private String noticeWriter;
	private String noticeContent;
	private Date noticeInsertDt;
	private String noticeTitle;
	private NoticeFileData files;
	

}
