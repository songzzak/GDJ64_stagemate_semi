package com.stagemate.store.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreUpfile {
	private int upfileNo;
	private int productNo;
	private String imgFilenameOri;
	private String imgFileRename;
	private char isMainImg;
	private Date upfileDate;
	
}
