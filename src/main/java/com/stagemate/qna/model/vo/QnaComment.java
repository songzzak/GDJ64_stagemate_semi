package com.stagemate.qna.model.vo;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class QnaComment  {
	private int qnaCommentNo;
	private int level;
	private String qnaCommentWriter;
	private String qnaCommentContent;
	private Date qnaCommentDate;
	private int qnaCommentRef;
	private int qnaRef;
	
}
