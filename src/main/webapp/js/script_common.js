// 외부 JS 파일에서 contextPath를 구할 때 사용
function getContextPath() {
	const hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf("/", hostIndex + 1));
}

// 로그인 페이지로 이동
function toLoginPage() {
	location.replace(getContextPath() + "/login.do");
}

// 헤더 아이콘 hover 하면 텍스트 등장
$('.header-container-icons input').hover(event => {
    $(event.target).next(".icons_text_lower").fadeToggle(500);
});