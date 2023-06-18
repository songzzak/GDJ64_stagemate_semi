<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@page import="java.util.List,com.stagemate.store.model.vo.Product"%>
<%
List<Product> products = (List) request.getAttribute("products");
%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/yoonjin/style_store_main.css">
<title>Store</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="min1280px">
		<div id="sectionContainer" class="max1280px">
			<div id="store_nav">
				<div id="store_nav_title">
					<p>전체상품</p>
				</div>
				<nav id="store_nav_menu">
					<ul>
						<li class="menu_style"><span class="select-store-menu">최신등록순</span></li>
						<li class="bar">|</li>
						<li class="menu_style"><span class="">인기순</span></li>
						<li class="bar">|</li>
						<li class="menu_style"><span class="">낮은가격순</span></li>
						<li class="bar">|</li>
						<li class="menu_style"><span class="">높은가격순</span></li>
						<li class="bar">|</li>
						<li class="menu_style"><span class="">리뷰많은순</span></li>
					</ul>
				</nav>
				<div id="store_search">
					<input id="input_search_text" type="text" placeholder="Search...">
					<div id="search_button">
						<svg width="24" height="24" viewBox="0 0 24 24" fill="none"
							xmlns="http://www.w3.org/2000/svg">
                        <path
								d="M21.5 23.25L13.625 15.375C13 15.875 12.2812 16.2708 11.4688 16.5625C10.6562 16.8542 9.79167 17 8.875 17C6.60417 17 4.6825 16.2133 3.11 14.64C1.5375 13.0667 0.750833 11.145 0.75 8.875C0.75 6.60417 1.53667 4.6825 3.11 3.11C4.68333 1.5375 6.605 0.750833 8.875 0.75C11.1458 0.75 13.0675 1.53667 14.64 3.11C16.2125 4.68333 16.9992 6.605 17 8.875C17 9.79167 16.8542 10.6562 16.5625 11.4688C16.2708 12.2812 15.875 13 15.375 13.625L23.25 21.5L21.5 23.25ZM8.875 14.5C10.4375 14.5 11.7658 13.9529 12.86 12.8588C13.9542 11.7646 14.5008 10.4367 14.5 8.875C14.5 7.3125 13.9529 5.98417 12.8588 4.89C11.7646 3.79583 10.4367 3.24917 8.875 3.25C7.3125 3.25 5.98417 3.79708 4.89 4.89125C3.79583 5.98542 3.24917 7.31333 3.25 8.875C3.25 10.4375 3.79708 11.7658 4.89125 12.86C5.98542 13.9542 7.31333 14.5008 8.875 14.5Z"
								fill="white" />
                    </svg>
					</div>
				</div>
			</div>
			<div class="productContainer">
				<table>
					<%
					if (products.isEmpty()) {
					%>
					<tr>
						<td colspan="3">조회된 상품이 없습니다.</td>
					</tr>
					<%
					} else {
					int size = products.size();
					for (int i = 0; i < 2; i++) {
					%>
					<tr class="prod_tr">
						<%
						for (int j = 0; j < 3; j++) {
							int index = i * 3 + j;
							if (index < size) {
								Product p = products.get(index);
						%>
						<td class="prod_td1">
							<div class="product">
								<div class="imageContainer">
									<img src="<%=contextPath%>/images/yoonjin/information/default_img.gif" alt="Product Image">
								</div>
								<div class="productDetails">
									<input type="hidden" value="<%=p.getProductNo()%>">
									<span class="brand"><%=p.getProductTitle()%></span>
									<span class="name"><%=p.getProductNm()%></span>
									<div class="flex-container">
										<span class="price"><%=p.getProductPrice()%></span>
										<span class="wish"> <span class="wish-count"><%=p.getProductLikeCnt()%></span>
											<svg width="44" height="39" viewBox="0 0 44 39" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        		<path d="M12.9329 1.67188C6.67923 1.67188 1.60938 6.80209 1.60938 13.1302C1.60938 24.5885 14.9917 35.0052 22.1976 37.4281C29.4035 35.0052 42.7859 24.5885 42.7859 13.1302C42.7859 6.80209 37.716 1.67188 31.4623 1.67188C27.6329 1.67188 24.2461 3.59584 22.1976 6.54063C21.1535 5.03563 19.7663 3.80739 18.1536 2.95988C16.5409 2.11238 14.7501 1.67058 12.9329 1.67188Z"
												stroke="#BC0000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                                    	</svg>
										</span>
									</div>
								</div>
							</div>
						</td>
						<%
						}
						}
						%>
					</tr>
					<%
					}
					}
					%>
				</table>
			</div>
			<div class="page-bar">
				<%=request.getAttribute("pageBar")%>
			</div>
		</div>
	</section>
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
	<script src="<%=request.getContextPath()%>/js/yoonjin/store_main.js"></script>
</body>
</html>