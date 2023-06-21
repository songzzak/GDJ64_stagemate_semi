

// store는 가리고 예매만 창을 띄운 채로 시작
//클릭했을 때 보여주는 이벤트
//클릭할 때 해당 버튼이 까맣게 변해야 한다. 
$(document).ready(function() { //jquery시작할때 무조건 이걸로 시작
	//기본창이 예매페이지므로 상품 페이지 숨기고 시작
	setDateBox();
	setDateBox1()
	$('.PlayBookingList').show();
	$('.StoreBookingList').hide();
});

$("#play_btn").click(function() {
	$(".PlayBookingList").show();
	$(".StoreBookingList").hide();
	
	
});

$("#store_btn").click(function() {
	$(".StoreBookingList").show();
	$(".PlayBookingList").hide();
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

