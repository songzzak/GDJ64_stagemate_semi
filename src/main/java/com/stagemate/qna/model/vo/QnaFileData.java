package com.stagemate.qna.model.vo;

import com.stagemate.notice.model.vo.NoticeFileData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QnaFileData {


		private String imgFilenameOri;
		private String imgFileRename;
		private int inquiryNo;
		
}
