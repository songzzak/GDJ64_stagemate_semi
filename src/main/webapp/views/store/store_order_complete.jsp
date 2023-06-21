<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<link rel="stylesheet" href="<%=contextPath %>/css/yoonjin/style_store_order_complete.css">
<title>Order Complete</title>
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
							<span class="vertical-center">기본배송지</span>
						</div>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">이름</span>
						<div>
							<span class="vertical-center"><%=loginMember.getMemberNm() %></span>
						</div>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">연락처</span>
						<span class="vertical-center"><%=loginMember.getMemberPhone() %></span>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">주소</span>
						<div class="vertical-center"><%=loginMember.getMemberAddress() %></div>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">배송 요청사항</span>
						<div>
							<span class="vertical-center">부재 시 경비실에 맡겨주세요</span>
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
						<span class="vertical-center">2023.06.15 20:56:06</span>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">총 결제금액</span>
						<span class="vertical-center">14,000원</span>
					</li>
					<li class="underline-gray">
						<span class="bgc-gray">결제수단</span>
						<span class="vertical-center">신용카드[신한카드]</span>
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