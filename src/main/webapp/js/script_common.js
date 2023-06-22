// 외부 JS 파일에서 contextPath를 구할 때 사용
function getContextPath() {
	const hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf("/", hostIndex + 1));
}

// redirection 방식으로 메인 페이지로 이동
function toMainPage() {
	location.replace(getContextPath());
}

// redirection 방식으로 로그인 페이지로 이동
function toLoginPage() {
	location.replace(getContextPath() + "/login.do");
}

// 헤더 아이콘 hover 하면 텍스트 등장
$('.header-container-icons input').hover(event => {
	$(event.target).next(".icons_text_lower").fadeToggle(500);
});

// 우편 번호 서비스를 불러옴
function openPostCode(inputZipcode, inputAddress, inputAddressDetail) {
	new daum.Postcode({
		oncomplete: (data) => {
			let address = "";
			let extraAddress = "";

			if (data.userSelectedType === "R") {
				address = data.roadAddress;
			} else {
				address = data.jibunAddress;
			}

			if (data.userSelectedType === "R") {
				if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
					extraAddress += data.bname;
				}
			}
			if (data.buildingName !== "" && data.apartment === "Y") {
				extraAddress += (extraAddress !== "" ? ", " + data.buildingName : data.buildingName);
			}
			if (extraAddress !== "") {
				extraAddress = ' (' + extraAddress + ')';
			}
			$(inputZipcode).val(address + extraAddress);
			$(inputAddress).val(data.zonecode);
			$(inputAddressDetail).focus();
		}
	}).open();
}