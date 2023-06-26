package com.stagemate.review.model.vo;

import java.sql.Date;

import com.stagemate.store.model.vo.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Imoji {
	private String imojiNo;
	private String imojiNm;
}
