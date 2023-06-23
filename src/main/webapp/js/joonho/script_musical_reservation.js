let countSeat = 0;
$(document).ready(function() {
	// 좌석 맵 배열
	var seatMap = [
		seatA,
		seatB,
		seatC,
		seatD,
		seatE,
		seatF,
		seatG
	];
	var seatMap2 = [
		seatH,
		seatI,
		seatJ,
		seatK,
		seatL
	];

	// 선택한 좌석 변수
	var selectedSeat = null;

	// 좌석 맵 생성
	var seatMapElement = $("#seatMap1F");
	for (var i = 0; i < seatMap.length; i++) {
		let count = 1;
		var rowElement = $("<div>").addClass("row");
		for (var j = 0; j < seatMap[i].length; j++) {
			var seatClass = seatMap[i][j] === 1 ? "seat" : "seat unavailable";
			if (seatMap[i][j] === 0) {
				count++;
			}
			var seatElement = $("<div>").addClass(seatClass)
			if ((i == 0 || i == 1) && !seatElement.hasClass("unavailable")) {
				seatElement.css({ "backgroundColor": "var(--sm-brown)", "color": "white", "fontSize": "120%" });
				if (i == 0 && (j == 2 || j == 14)) {
					seatElement.text("A").addClass("unavailable");
				} else if (i == 1 && (j == 2 || j == 14)) {
					seatElement.text("B").addClass("unavailable");
				} else {
					seatElement.css({ "backgroundColor": "#CE3500" }).append("<div style='display: none'>" + "1층 " + String.fromCharCode([65 + i]) + "열" + count + "번 (VIP석)" + '</div>');
					count++;
				}
			} else if ((i == 2 || i == 3) && !seatElement.hasClass("unavailable")) {
				seatElement.css({ "backgroundColor": "var(--sm-brown)", "color": "white", "fontSize": "120%" });
				if (i == 2 && (j == 4 || j == 16)) {
					seatElement.text("C").addClass("unavailable");
				} else if (i == 3 && (j == 4 || j == 16)) {
					seatElement.text("D").addClass("unavailable");
				} else {
					seatElement.css({ "backgroundColor": "#9900C9" }).append("<div style='display: none'>" + "1층 " + String.fromCharCode([65 + i]) + "열" + count + "번 (R석)" + '</div>');
					count++;
				}
			} else if ((i == 4 || i == 5 || i == 6) && !seatElement.hasClass("unavailable")) {
				seatElement.css({ "backgroundColor": "var(--sm-brown)", "color": "white", "fontSize": "120%" })
				if (i == 4 && (j == 4 || j == 16)) {
					seatElement.text("E").addClass("unavailable");
				} else if (i == 5 && (j == 4 || j == 16)) {
					seatElement.text("F").addClass("unavailable");
				} else if (i == 6 && (j == 4 || j == 16)) {
					seatElement.text("G").addClass("unavailable");
				} else {
					seatElement.css({ "backgroundColor": "#00CCCC" }).append("<div style='display: none'>" + "1층 " + String.fromCharCode([65 + i]) + "열" + count + "번 (S석)" + '</div>');
					count++;
				}
			}
			seatElement.on("click", function() {
				selectSeat($(this));
			});
			rowElement.append(seatElement);
		}
		seatMapElement.append(rowElement);
	}
	var seatMapElement = $("#seatMap2F");
	for (var i = 0; i < seatMap2.length; i++) {
		let count = 1;
		var rowElement = $("<div>").addClass("row");
		for (var j = 0; j < seatMap2[i].length; j++) {
			var seatClass = seatMap2[i][j] === 1 ? "seat" : "seat unavailable";
			if (seatMap2[i][j] === 0) {
				count++;
			}
			var seatElement = $("<div>").addClass(seatClass)
			if (!seatElement.hasClass("unavailable")) {
				seatElement.css({ "backgroundColor": "var(--sm-brown)", "color": "white", "fontSize": "120%" });
				if (i == 0 && (j == 4 || j == 16)) {
					seatElement.text("H").addClass("unavailable");
				} else if (i == 1 && (j == 4 || j == 16)) {
					seatElement.text("I").addClass("unavailable");
				} else if (i == 2 && (j == 4 || j == 16)) {
					seatElement.text("J").addClass("unavailable");
				} else if (i == 3 && (j == 4 || j == 16)) {
					seatElement.text("K").addClass("unavailable");
				} else if (i == 4 && (j == 4 || j == 16)) {
					seatElement.text("L").addClass("unavailable");
				} else {
					seatElement.css({ "backgroundColor": "#5529DD" }).append("<div style='display: none'>" + "2층 " + String.fromCharCode([65 + i + 7]) + "열" + count + "번 (A석)" + '</div>');
					count++;
				}
			}
			seatElement.on("click", function() {
				selectSeat($(this));
			});
			rowElement.append(seatElement);
		}
		seatMapElement.append(rowElement);
	}


	// 좌석 선택 시 동작


	function selectSeat(seat) {
		if (seat.hasClass("seat")) {
			if (seat.hasClass("selected")) {
				seat.removeClass("selected");
				seat.children().remove("p");
				$("#selectedSeat").children().each((i, v) => {
					const value = $(v).text();
					if (value == (seat.text() + "X")) {
						v.remove();
						countSeat--;
					}
				});
			} else {
				if (countSeat < 5) {
					seat.addClass("selected");
					$("#selectedSeat").append("<div><div>" + seat.text() + '</div><button id="reser_cancel">X</button></div>');
					seat.append("<p>V</p>");
					countSeat++;
				} else {
					alert("5개 이하!!!");
				}
			}
		}

	}
	$(document).on("click", "#reser_cancel", function() {
		$("#seatMap2F>div>div>div").each((i, v) => {
			if ($(v).text() == $(this).prev().text()) {
				$(v).parent().removeClass("selected");
				$(v).parent().children().remove("p");
				countSeat--;
			}
		});
		$("#seatMap1F>div>div>div").each((i, v) => {
			if ($(v).text() == $(this).prev().text()) {
				$(v).parent().removeClass("selected");
				$(v).parent().children().remove("p");
				countSeat--;
			}
		});
		$(this).parent().remove()
	});
});

const seat_reset = () => {
	$("#selectedSeat").children().remove();
	$("#seatMap2F>div>div>div").each((i, v) => {
		$(v).parent().removeClass("selected");
		$(v).parent().children().remove("p");
	});
	$("#seatMap1F>div>div>div").each((i, v) => {
		$(v).parent().removeClass("selected");
		$(v).parent().children().remove("p");
	});
	countSeat = 0;
};
function prev_page(eventNo) {
	location.replace(getContextPath() + "/event/eventView.do?no="+eventNo);
}
function toPayment(eventNo,round,choiceday) {
		const seat=$("#selectedSeat>div>div").text();
		/*let choseat=seat.split(")");
		let row=[];
		let column=[];
		const pattern = /(?<=.)\d+/g;
		for(let i=0;i<choseat.length-1;i++){
			row.push(choseat[i].charAt(3));
			column.push(choseat[i].match(pattern));
			pattern.lastIndex = 0;
		}*/
		if(seat==""){
			alert("좌석을 선택해주세요")
			return;
		}
		location.replace(getContextPath() + "/event/payment.do?no="+eventNo+"&seat="+seat+"&round="+round+"&choiceday="+choiceday);
	}