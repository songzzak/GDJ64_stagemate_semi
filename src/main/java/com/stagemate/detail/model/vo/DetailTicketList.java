package com.stagemate.detail.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailTicketList {
	private String seatNo;
	private String esNo;
	private String isReserved;
	private String seatRow;
	private String seatCol;
	private String slvNM;
	private int slvPrice;
}
