<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<%@page import="java.sql.Date,java.util.List,com.stagemate.payment.model.vo.PrdOrder,com.stagemate.deliveryAddress.model.vo.DlvAdress"%>
<link rel="stylesheet" href="<%=contextPath %>/css/yoonjin/style_store_order_complete.css">
<title>StageMate | 결제완료</title>
<%
PrdOrder po=(PrdOrder)request.getAttribute("po");
DlvAdress d=(DlvAdress)request.getAttribute("d");
%>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section class="min1280px">
	<div id="sectionContainer" class="max1280px container_style01">
		<div id="nav_order_complete">
			<span>상품선택</span>
            <span><img src="<%=contextPath %>/images/yoonjin/button/arrow.svg" alt=""></span>
            <span>배송정보입력</span>
            <span><img src="<%=contextPath %>/images/yoonjin/button/arrow.svg" alt=""></span>
            <span style="color: #1C0808">결제완료</span>
		</div>
		<hr class="hr_margin_style01">
		<div id="order_detail_view">
			<div id="order_result_dlv">
				<div class="order_result_title">
					<h3>상품 결제 완료</h3>
				</div>
				<ul>
					<li class="underline-gray">
						<span class="bgc-gray">배송지</span>
						<div>
							<span class="vertical-center"><%=d.getDlvNm() %></span>
						</div>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">받는 분</span>
						<div>
							<span class="vertical-center"><%=d.getDlvPerson() %></span>
						</div>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">연락처</span>
						<span class="vertical-center"><%=d.getDlvPhone() %></span>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">주소</span>
						<div class="vertical-center"><%=d.getDlvAddress() %></div>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">배송 요청사항</span>
						<div>
							<span class="vertical-center">
								<% if (po.getShipMsg() != null && !po.getShipMsg().isEmpty()) { %>
							        <%= po.getShipMsg() %>
							    <% } else { %>
							        &nbsp; <!-- 공백 출력 -->
							    <% } %>
							</span>
						</div>
					</li>
				</ul>
			</div>
			<div id="order_result_payment">
				<div class="payment_result_title">
					<p>결제내역</p>
				</div>
				<ul>
					<li class="underline-gray">
						<span class="bgc-gray">결제일</span>
						<span class="vertical-center"><%=po.getOrderDate() %></span>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">총 결제금액</span>
						<span class="vertical-center"><%=po.getTotalPrice() %></span>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">결제수단</span>
						<span class="vertical-center">카드결제</span>
					</li>
				</ul>
			</div>
		</div>
		<div id="btn_order_coplete">
			<button class="btn-layout btn-brown" id="goto_home_btn" onclick="toMainPage();">홈으로 가기</button>
			<button class="btn-layout btn-brown">결제내역으로 가기</button>
		</div>
		<div id="cancle_info_container">
			<span>결제 취소 및 환불 안내</span>
			<hr class="hr_margin_style01">
			<img src="<%=contextPath %>/images/yoonjin/information/교환반품안내서.jpg">
		</div>
</section>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%= contextPath %>/js/yoonjin/store_order_complete.js"></script>

</body>
</html>