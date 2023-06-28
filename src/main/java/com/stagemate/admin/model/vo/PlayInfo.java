package com.stagemate.admin.model.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayInfo {

	private String rsvNo;
	private String orderStatus;
	private String rsvDate;
	//event_order_tb
	//member_tb
	private String memberId;
	private String memberPhone;
	private String memberEmail;
	


}
