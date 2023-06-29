package com.stagemate.qna.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class QnaListCtg {

	private int ctgNum;
	private String ctgNm;
	
}
