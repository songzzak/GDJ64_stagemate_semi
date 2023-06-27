package com.stagemate.event.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventWish {
	private String eventWishCode;
	private String eventNo;
	private String memberId;

}
