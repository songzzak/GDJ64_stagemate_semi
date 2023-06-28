package com.stagemate.detail.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDetailOrderDlv {
	private String orderNo;
	private String shipMsg;
	private String memberId;
	private String memberNm;
	private String memberEmail;
	private String memberPhone;
	private String dlvPerson;
	private String dlvPhone;
	private String dlvAddress;
}
