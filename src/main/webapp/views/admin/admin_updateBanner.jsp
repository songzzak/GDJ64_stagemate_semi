<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	final String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%= contextPath %>/images/common/favicon-32x32.png" type="image/x-icon">
<link rel="stylesheet" href="<%= contextPath %>/css/style_init.css">
<title>배너변경</title>
</head>
<body>
	<section class="banners">
		<h2>ㅎㅇ</h2>
	</section>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script>
	function closePopupBanners() {
		window.close();
	}
</script>
</body>
</html>