<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->

<!---------------------------------------->
<title>페이지 타이틀 입력</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<!-----------   아래에서 HTML 작업  ----------->
<section class="min1280px">
    <div class="max1280px">
        <h2 style="margin: 200px; text-align: center;">관리자 페이지 (사이드바 include 하기)</h2>
        <div>
            <input type="button" class="btn-layout btn-brown" value="버튼">
        </div>
        <div>
            <input type="submit" class="btn-layout btn-white" value="버튼">
        </div>
        <div>
            <button class="btn-layout btn-yellow">버튼</button>
        </div>
        <p style="margin-top:150px">아이콘 쓸 거면 아래 요소 그대로 복붙하면 됩니다.</p>
        <div class="icon-container">
            <i class="fa-solid fa-check fa-lg"></i>
        </div>
        <div class="icon-container">
            <i class="fa-regular fa-question fa-lg"></i>
        </div>
        <div class="icon-container">
            <i class="fa-solid fa-cart-shopping fa-lg"></i>
        </div>
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