$(document).ready(function() { //jquery시작할때 무조건 이걸로 시작
	//기본창이 예매페이지므로 상품 페이지 숨기고 시작
	setDateBox();
	setDateBox1()
	$('.salesDetail_play').show();
	$('.salesDetail_store').hide();
});

$("#Play-btn").click(function() {
	$(".salesDetail_play").show();
	$(".salesDetail_store").hide();
	
	
});

$("#Store-btn").click(function() {
	$(".salesDetail_store").show();
	$(".salesDetail_play").hide();
});



function setDateBox() {
	var date = new Date();
	var year = date.getFullYear();

	$("#year1").append("<option value=''>년도</option>");
	for (var y = 2021; y <= (year + 1); y++) {
		$("#year1").append("<option value='" + y + "'>" + y + " 년" + "</option>");
	}

	$("#month1").append("<option value=''>월</option>");
	for (var i = 1; i <= 12; i++) {
		if (String(i).length == '1') {
			$("#month1").append("<option value='" + "0" + i + "'>" + "0" + i + "월" + "</option>");
		} else {
			$("#month1").append("<option value='" + i + "'>" + i + "월" + "</option>");
		}
	}
}
function setDateBox1() {
	var date = new Date();
	var year = date.getFullYear();

	$("#year").append("<option value=''>년도</option>");
	for (var y = 2021; y <= (year + 1); y++) {
		$("#year").append("<option value='" + y + "'>" + y + " 년" + "</option>");
	}

	$("#month").append("<option value=''>월</option>");
	for (var i = 1; i <= 12; i++) {
		if (String(i).length == '1') {
			$("#month").append("<option value='" + "0" + i + "'>" + "0" + i + "월" + "</option>");
		} else {
			$("#month").append("<option value='" + i + "'>" + i + "월" + "</option>");
		}
	}
}

