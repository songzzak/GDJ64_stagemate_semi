package com.stagemate.detail.model.vo;

import java.sql.Date;

import com.stagemate.review.model.vo.PlaySearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Detail {
		private String rsvNo;
		private String eventName;
		private Date watchDt;
//		private String orderStatus;
}
