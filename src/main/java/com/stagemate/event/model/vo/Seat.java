package com.stagemate.event.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
	private String seatNo;
	private char isReserved;
	private String slvNo;
	private char seatRow;
	private int seatCol;
	private String eventNo;
	private String evcNo;
}
