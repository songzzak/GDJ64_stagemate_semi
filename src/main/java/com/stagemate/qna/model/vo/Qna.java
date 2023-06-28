package com.stagemate.qna.model.vo;

import java.sql.Date;

import com.stagemate.notice.model.vo.NoticeFileData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Qna {
	private int inquiryNo;
	private String inquiryContent;
	private String inquiryTitle;
	private int ctgNum;
	private String writerId;
	private Date inquiryInsertDt;
	private String inquiryLockFlg;
	private QnaFileData files;
	
	
}
