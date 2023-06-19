<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/yoonjin/style_product_list_for_admin.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/yoonjin/style_insertProduct.css">

<title>STAGEMATE</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section class="min1280px">
	<div id="sectionContainer" class="max1280px body_height div_flex_style">
		<div id="store_admin_nav">
			<nav>
				<ul id="store_admin_nav_ul">
					<li>회원 관리</li>
					<li class="select_nav_admin">
						상품 관리
						<ul>
							<li>예매</li>
							<li class="select_nav_admin">스토어</li>
						</ul>
					</li>
					<li>
						판매 관리
						<ul>
							<li>판매내역관리</li>
							<li>결제 취소 요청</li>
							<li>반품/교환 관리</li>
						</ul>
					</li>
					<li>
						커뮤니티 관리
						<ul>
							<li>게시판 관리</li>
							<li>신고 관리</li>
						</ul>
					</li>
					<li>
						고객센터
						<ul>
							<li>공지사항 관리</li>
							<li>1:1문의 관리</li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
		<div id="store_manager_container">
			<div id="store_manager_nav">
				<nav>
					<span>상품관리</span>
					<span><img src="<%=contextPath %>/images/yoonjin/button/arrow.svg" alt=""></span>
					<span>스토어</span>
				</nav>
			</div>
			<hr>
			<div id="product_insert_form">
				<form>
					<table>
						<tr>
							<th>행사*</th>
							<td><input type="text" name="" id=""></td>
						</tr>
						
					</table>
				</form>
			</div>
			<div class="page-bar">
				<%-- <%=request.getAttribute("pageBar")%> --%>
			</div>
		</div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%= contextPath %>/js/yoonjin/insertProduct.js"></script>
</body>
</html>