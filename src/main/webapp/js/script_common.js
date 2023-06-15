// 외부 JS 파일에서 contextPath를 구할 때 사용
const getContextPath = () => {
	const hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf("/", hostIndex + 1));
};