package com.stagemate.store.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StoreLike {
	private String strLikeCd;
	private String memberId;
	private int productNo;
}
