$(document).ready(function(){
	$('.ReviewList_play').show();
	$('.ReviewList_store').hide();	
	
});

$("#ps_play_btn").click(function(){
		$('.ReviewList_play').show();
	$('.ReviewList_store').hide();
	
});

$("#ps_store_btn").click(function(){
	$('.ReviewList_play').hide();
	$('.ReviewList_store').show();
});

function showLoading() {
	const $div = $("<div>");
	const loading = $(`<img src='${getContextPath()}/images/jaehun/login_page/loading.gif'>`);
	$("#accessFailed").append($div.append(loading));
	$div.width("100%").height("100%");
	loading.height("100%")
			.width(loading.height())
			.css("margin", "0 auto");
}

function reviewWritePage(type) {
	if (type == '1') {
		window.location.href = getContextPath() + "/Review/ReviewWritePlay";
	} else {
		window.location.href = getContextPath() + "/Review/ReviewWriteStore";
	} 
}

function reviewWriteSerchPage(type) {
	if (type == '1') {
		window.location.href = getContextPath() + "/Review/ReviewWritePlay_Title?type=1";
	} else {
		window.location.href = getContextPath() + "/Review/ReviewWritePlay_Title?type=2";
	} 
}

function revieWritePlay() {
	let reqData = {};
	let url = '';
	reqData['rsvNo'] = rsvNo;
	reqData['content'] = $('textarea').val().trim();
	let emotion = $('input[name="emoticon"]:checked').val();
	reqData['emotion'] = emotion;
	url = getContextPath() + "/Review/InsertReviewWritePlayServlet";

	$.ajax({
		type: "post",
		url: url,
		data: reqData,
		dataType: "text",
		beforeSend: showLoading,
		success: (data) => {
			if (data == '1') {
				alert("리뷰 작성을 완료했습니다.");
				location.replace(getContextPath() + "/Review/ReviewListServlet.do");
			} else {
				alert("리뷰 작성을 실패했습니다.");
			}
		},
		error:(response, status, error) => {
			if (response.status === 500) {
				alert("code:" + response.status + "\n" + "message:" + response.responseText + "\n" + "error:" + error);
			}
		}
	});
}

function revieWriteStore() {
	let url = '';
	var fileInput = $('#fileInput')[0];
    var file = fileInput.files[0];
    var formData = new FormData();
    let emotion = $('input[name="emoticon"]:checked').val();
    formData.append('orderNo', orderNo);
    formData.append('file', file);
    formData.append('content', $('textarea').val().trim());
    formData.append('emotion', emotion);
	url = getContextPath() + "/Review/InsertReviewWriteStoreServlet";

	$.ajax({
		type: "post",
		url: url,
		data: formData,
      	processData: false,
      	contentType: false,
		beforeSend: showLoading,
		success: (data) => {
			if (data == '1') {
				alert("리뷰 작성을 완료했습니다.");
				location.replace(getContextPath() + "/Review/ReviewListServlet.do");
			} else {
				alert("리뷰 작성을 실패했습니다.");
			}
		},
		error:(response, status, error) => {
			if (response.status === 500) {
				alert("code:" + response.status + "\n" + "message:" + response.responseText + "\n" + "error:" + error);
			}
		}
	});
}

