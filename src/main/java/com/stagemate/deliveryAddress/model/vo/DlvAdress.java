package com.stagemate.deliveryAddress.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DlvAdress {
	private String dlvId;
	private String memberId;
	private String dlvPerson;
	private String dlvNm;
	private String dlvPhone;
	private String dlvAddress;
	private char isDefaultDlv;
}
