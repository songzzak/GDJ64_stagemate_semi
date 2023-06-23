package com.stagemate.notice.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeFileData {
	private String imgFilenameOri;
	private String imgFileRename;
	private int noticeNo;
	
}
