$(".btn-login").hover(() => {
	changeBtnLoginStyle();
}, () => {
	changeBtnLoginStyle();
});

function changeBtnLoginStyle() {
	$(".btn-login").toggleClass("btn-login_active");
}

function loginByEnter() {
	if (window.event.keyCode === 13) {
		changeBtnLoginStyle();
		setTimeout(() => {
			changeBtnLoginStyle();
		}, 50);
		setTimeout(() => {
		validateAccount();
		}, 60);
	}
}

function validateAccount() {
	const userId = $('#userId').val();
	const password = $('#password').val();
	const saveId = $('#saveId').is(":checked");
	const accessFailed = $("#accessFailed");
	
	accessFailed.html("");
	if (userId.length === 0 || password.length === 0) {
		accessFailed.append(generatePTag("아이디 또는 비밀번호가"))
					.append(generatePTag("입력되지 않았습니다."));
		return;
	}
	
	if (userId.length < 8 || userId.length > 15) {
		accessFailed.append(generatePTag("아이디는 8글자 이상,"))
					.append(generatePTag("15자 이하로 입력해주세요."));
		return;
	}
	
	if (password.length < 8 || password.length > 15) {
		accessFailed.append(generatePTag("비밀번호는 8글자 이상,"))
					.append(generatePTag("15자 이하로 입력해주세요."));
		return;
	}
	
	$.ajax({
		type: "post",
		url: getContextPath() + "/loginEnd.do",
		data: {
			"userId": userId,
			"password": password,
			"saveId": saveId
		},
		dataType: "text",
		beforeSend: showLoading,
		success: (data) => {
			accessFailed.html("");
			if (data === "true") {
				// 추후 원래 있던 페이지로 가는 코드로 수정
				location.replace(getContextPath());
			} else {
				accessFailed.append(generatePTag("아이디 또는 비밀번호가"))
							.append(generatePTag("일치하지 않습니다."));
			}
		},
		error:(request, status, error) => {
			if (request.status === 500) {
				showModalError();
			}
		}
	});
}

function generatePTag(msg) {
	return $("<p>").addClass("font-color-yellow font-size-small")
				.text(msg);
}

function showLoading() {
	const $div = $("<div>");
	const loading = $(`<img src='${getContextPath()}/images/jaehun/login_page/loading.gif'>`);
	$("#accessFailed").append($div.append(loading));
	$div.width("100%").height("100%");
	loading.height("100%")
			.width(loading.height())
			.css("margin", "0 auto");
}

function showModalError() {
	$(".popup-error-bg").css("transition", "all 0.8s")
							.addClass("popup-error-show");
	$(".popup-error-content").css("transition", "all 0.8s")
							.addClass("popup-error-slide");
}

function closeModalError() {
	$("#accessFailed").html("");
	$(".popup-error-bg").css("transition", "")
						.removeClass("popup-error-show");
	$(".popup-error-content").css("transition", "")
							.removeClass("popup-error-slide");
}