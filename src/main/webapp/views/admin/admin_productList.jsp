<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@page import="java.util.List,com.stagemate.store.model.vo.Product"%>
<%
List<Product> products = (List) request.getAttribute("products");
%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/yoonjin/style_product_list_for_admin.css">
<title>Store Management</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="min1280px">
		<div id="sectionContainer" class="max1280px body_height div_flex_style">
			<div id="store_admin_nav">
				<nav>
					<ul id="store_admin_nav_ul">
						<li><a href="<%=contextPath%>/admin/membermanage">회원 관리</a></li>
						<li class="select_nav_admin">
							<a href="<%=contextPath%>/admin/eventlist">상품 관리</a>
							<ul>
								<li><a href="<%=contextPath%>/admin/eventlist">행사</a></li>
								<li class="select_nav_admin"><a href="<%=contextPath%>/admin/selectAllProduct.do">스토어</a></li>
							</ul>
						</li>
						<li>
							<a href="<%=contextPath%>/admin/SalesDetail.do">판매 관리</a>
							<ul>
								<li><a href="<%=contextPath%>/admin/SalesDetail.do">판매내역관리</a></li>
								<li><a href="">결제 취소 요청</a></li>
								<li><a href="">반품/교환 관리</a></li>
							</ul>
						</li>
						<li>
							<a href="">커뮤니티 관리</a>
							<ul>
								<li><a href="">게시판 관리</a></li>
								<li><a href="">신고 관리</a></li>
							</ul>
						</li>
						<li>
							<a href="">고객센터</a>
							<ul>
								<li><a href="">공지사항 관리</a></li>
								<li><a href="">1:1문의 관리</a></li>
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
				<div id="store_manager_list">
					<button id="insert_product_btn" class="btn-layout btn-white">상품등록</button>
					<table id="store_manager_tbl">
						<tr>
							<th id="manageTbl_productNo">번호</th>
							<th>행사</th>
							<th>상품명</th>
							<th>판매가격</th>
							<th>재고</th>
							<th>관리자 비고</th>
							<th>등록일</th>
							<th></th>
						</tr>
						<%
					if (products.isEmpty()) {
					%>
					<tr>
						<td colspan="7">등록된 상품이 없습니다.</td>
					</tr>
				    <%}else{ 
				    	for(Product p : products){%>
						<tr>
							<td><%=p.getProductNo() %></td>
							<td><%=p.getProductTitle() %></td>
							<td><%=p.getProductNm() %></td>
							<td><%=p.getProductPrice() %></td>
							<td><%=p.getProductAmt() %></td>
							<td><%=p.getProductComment()==null?"":p.getProductComment() %> </td>
							<td><%=p.getProductInsertDate() %></td>
							<td>
								<button class="btn_store_mng btn_product_update">수정</button>
								<button class="btn_store_mng btn_product_delete">삭제</button>
							</td>
						</tr>
						<%}
					}%>
					</table>
				</div>
				<div class="page-bar">
					<%=request.getAttribute("pageBar")%>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
	<script src="<%=contextPath%>/js/yoonjin/product_list_for_admin.js"></script>
</body>
</html>