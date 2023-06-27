package com.stagemate.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardComment {
	
	private int cmtNo;
	private int level;
	private String cmtWriter;
	private String cmtContent;
	private int boardRef;
	private int cmtRef;
	private Date cmtDate;
}
