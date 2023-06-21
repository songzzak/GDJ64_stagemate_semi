<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<link rel="stylesheet" href="<%= contextPath %>/css/jaehun/style_enroll_success.css">
<title>페이지 타이틀 입력</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section class="enroll_success min1280px centering-children">
    <article class="max1280px">
    	<div class="success-top">
    		<h2 class="enroll-form-title fw-bold">회원가입이 완료되었습니다!</h2>
        	<p>우리는 MATE에게 다음과 같은 서비스를 제공합니다.</p>
    	</div>
    	<div class="success-middle">
    		<img src="<%= contextPath %>/images/jaehun/page_enroll/enroll_success.svg">
    	</div>
    	<div class="success-bottom">
    		<p>두근거림을 함께 나눌 수 있는 공간이 될 수 있도록</p>
			<p>STAGEMATE는 언제나 노력하겠습니다.</p>
    		<div>
            	<input type="button" class="btn-layout btn-brown" value="메인 페이지로 이동"
            			onclick="location.assign(getContextPath())">
        	</div>
    	</div>
    </article>
</section>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
</body>
</html>