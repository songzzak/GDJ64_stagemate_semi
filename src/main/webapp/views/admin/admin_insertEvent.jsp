<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%= contextPath %>/css/jaehun/style_insertEvent.css">
<title>행사 등록</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="min1280px">
		<div id="insertEvent">
			<nav class="insertEvent-sidebar">
				<ul class="insertEvent-sidebar_big">
					<li><a href="">회원 관리</a></li>
					<li class="link_active"><a href="">상품 관리</a>
						<ul class="insertEvent-sidebar_small">
							<li><a href="">예매</a></li>
							<li><a
								href="<%=contextPath%>/admin/selectAllProduct.do">스토어</a></li>
						</ul>
					</li>
					<li><a href="">판매 관리</a>
						<ul class="insertEvent-sidebar_small">
							<li><a href="">판매내역관리</a></li>
							<li><a href="">결제 취소 요청</a></li>
							<li><a href="">반품/교환 관리</a></li>
						</ul>
					</li>
					<li><a href="">커뮤니티 관리</a>
						<ul class="insertEvent-sidebar_small">
							<li><a href="">게시판 관리</a></li>
							<li><a href="">신고 관리</a></li>
						</ul>
					</li>
					<li><a href="">고객센터</a>
						<ul class="insertEvent-sidebar_small">
							<li><a href="">공지사항 관리</a></li>
							<li><a href="">1:1문의 관리</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			<article class="insertEvent-content">
				<nav class="insertEvent-title">
					<p>상품관리</p>
					<div>
						<img src="<%=contextPath %>/images/yoonjin/button/arrow.svg" alt="">
					</div>
					<p>행사</p>
					<div>
						<img src="<%=contextPath %>/images/yoonjin/button/arrow.svg" alt="">
					</div>
					<p>등록</p>
				</nav>
				<hr>
				<form name="insertEventForm">

				</form>
			</article>
		</div>
	</section>
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
</body>
</html>