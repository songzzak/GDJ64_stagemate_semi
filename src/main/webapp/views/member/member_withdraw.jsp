<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/style_member_withdraw.css">
<%@ page
	import="java.util.List,com.stagemate.review.model.vo.ReviewPlay"%>
<title>STAGEMATE</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="min1280px">

		<div class="SB_bigchart">
			<p class="WithDraw_eng">My Page</p>
			<p class="WithDraw_kor">회원 탈퇴</p>
			<div class="withdraw-bigchart">
				<div class="cancel_box">
					<p style="font-size: 20px; font-weight: bold; padding: 5px 0px 10px 5px;">탈퇴
						시 안내사항</p>
					<ul>
						<li>탈퇴 즉시, 회원 정보는 전부 삭제되며 재가입 시에도 복구되지 않습니다.</li>
						<li>회원 탈퇴 시, 즉시 기존에 가입했던 아이디로 재가입이 불가능합니다.</li>
						<li>회원 탈퇴 시, 포인트 및 쿠폰은 삭제되며 재가입 시 복구되지 않습니다.</li>
						<li>진행 중인 거래 내역, 배송 반품 중인 내역이 있을 경우 서비스 탈퇴는 불가합니다. 해당 이용 서비스
							종료 후 회원 탈퇴를 진행해주시길 바랍니다.</li>
						<li>전자상거래 등에서의 소비자 보호에 관한 법률 제6조(거래기록의 보존 등)에 의거, 주문정보는 회원 탈퇴
							후 5년간 보존됩니다.</li>
						<li>회원 탈퇴 후, 7일 이내에 기존 정보의 휴대폰 번호, 이메일로 사이트 가입이 불가능합니다.</li>
						<br>
					</ul>
					<div class="line"></div>
					<p style="font-size: 20px; font-weight: bold; padding: 10px 0px 10px 5px;">게시물
						안내사항</p>
					<ul>
						<li>상품 리뷰 및 문의, 커뮤니티 작성 게시물은 탈퇴 후에 자동으로 삭제되지 않습니다. 탈퇴 이후에는
							작성자 본인 여부를 확인할 수 없으므로, 게시물 수정 및 삭제 처리가 불가능합니다.</li>
						<li>삭제를 원하는 게시글은 먼저 해당 게시글을 삭제하신 후 탈퇴를 신청해주시길 바랍니다.</li>
					</ul>
				</div>
				<div class="withdraw-smallchart">
					<input type="checkbox" id="check_withdraw"> 상기 사항을 모두 확인하였으며, 동의합니다.
					<p>탈퇴 시 포인트 소멸,<span style="color:red; font-weight:bold;"> 30일 이내</span> 재가입 불가에 대해 동의합니다.</p>
				</div>
					<div class="withdraw_choice">
						<input type="button" class="cancel_btn" value="돌아가기"> 
						<input type="button" class="withdraw_btn" value="탈퇴하기">
					</div>
			</div>
		</div>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<%-- <script src="<%=contextPath%>/js/yelin/ReviewList.js"></script> --%>
</html>