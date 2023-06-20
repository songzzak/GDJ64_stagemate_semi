<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<style>
#seat_title * {
	margin-right: 2%;
}

#seat_title {
	display: flex;
	align-items: center;
	font-size: 30px;
	margin-top: 5%;
	margin-bottom: 3%;
}
#seat_title>h2:nth-child(3) , #seat_title>h3 {
	color: var(--sm-brown);
	font-weight: bold;
}

#seat_title>h2:not(:nth-child(3)) {
	color: var(--gray-light);
	font-weight: bold;
}
</style>
<!---------------------------------------->
<title>페이지 타이틀 입력</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<!-----------   아래에서 HTML 작업  ----------->
<section class="min1280px">
    <div class="max1280px">
        <div id="seat_title">
				<h2>좌석 선택</h2>
				<h3>></h3>
				<h2>결제</h2>
				<h3>></h3>
				<h2>완료</h2>
			</div>
			<hr>
    </div>
</section>
<!-----------   위에서 HTML 작업  ----------->
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->

<!-------------------------------------------->
</body>
</html>