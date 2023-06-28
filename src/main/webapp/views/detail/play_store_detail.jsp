<%@page import="com.stagemate.detail.model.vo.DetailInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/play/style_Detailed_play.css">
<%@ page import="java.util.List,com.stagemate.detail.model.vo.StoreDetailInfo"%>
<%@ page import="java.util.List,com.stagemate.detail.model.vo.StoreDetailOrderDlv"%>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%=contextPath%>/js/yelin/detailList.js"></script>
<title>STAGEMATE</title>
<%
	StoreDetailInfo storeDetailInfo = (StoreDetailInfo)request.getAttribute("StoreDetailInfo");
    StoreDetailOrderDlv storeDetailOrderDlv = (StoreDetailOrderDlv)request.getAttribute("StoreDetailOrderDlv");
%>
<script>
let orderNo = '<%= storeDetailInfo.getOrderNo()%>';

$(document).ready(function() {
  let orderStatus = '<%= storeDetailInfo.getOrderStatus()%>';
  if (orderStatus == '결제 취소') {
		$('.re-btn').removeClass('re-btn').addClass('disable-btn');
		$('.disable-btn').attr('onclick', "alert('이미 취소한 내역입니다')");
  }
});
</script>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="BookDetail_min1280px">
		<div class="BookingDetailPlay_bigchart">

			<h1 id="BookingDetailPlay_title">예매내역</h1>
			<div class="division-line"></div>

			<div class="bigchart">
				<!-- 제목 -->
				<p class="play_title">[<%=storeDetailInfo.getProductTitle() %>]<%=storeDetailInfo.getProductNm() %></p>

				<div class="bookchart" id="bookchart2"
					style="padding: 10px 10px 10px 10px">


					<!-- 포스터 -->
					<div class="ticketbook">
						<p class="poster">
							<a href=''
								Title='<%=storeDetailInfo.getProductNm() %>'>
								<img src='../upload/yoonjin/<%=storeDetailInfo.getImgFileRename() %>'
								width='180' height='220' alt='' /></a>
						</p>
					</div>
					<table class="book_info">
						<tr>
							<th>상품정보</th>
							<td><%=storeDetailInfo.getProductNm() %></td>
						</tr>
						<tr>
							<th>판매가</th>
							<td><%=storeDetailInfo.getProductPrice() %>원</td>
						</tr>
						<tr>
							<th>수량</th>
							<td><%=storeDetailInfo.getOrderAMT() %></td>
						</tr>
						<tr>
							<th>주무상태</th>
							<td><%=storeDetailInfo.getOrderStatus() %></td>
						</tr>
						<tr>
							<th>택배정보</th>
							<td>롯데택배 13124121</td>
						</tr>
					</table>
				</div>

				<h4 class="font-pay">구매자 정보</h4>
				<table class="pay_chart">
					<tr>
						<th>주문자</th>
						<td><%=storeDetailOrderDlv.getMemberNm() %></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><%=storeDetailOrderDlv.getMemberPhone() %></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%=storeDetailOrderDlv.getMemberEmail() %></td>
					</tr>
				</table>

				<h4 class="font-pay">결제내역</h4>
				<table class="pay_chart">
					<tr>
						<th>구매일자</th>
						<td><%=storeDetailInfo.getOrderDate() %></td>
					</tr>
					<tr>
						<th>총 결제 금액</th>
						<td><%=storeDetailInfo.getTotalPirce() %>원</td>
					</tr>
					<tr>
						<th>결제수단</th>
						<td>신용카드[신한카드]</td>
					</tr>
				</table>
				
				<h4 class="font-pay">배송지 정보</h4>
				<table class="pay_chart">
					<tr>
						<th>받으신분</th>
						<td><%=storeDetailOrderDlv.getDlvPerson() %></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><%=storeDetailOrderDlv.getDlvPhone() %></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><%=storeDetailOrderDlv.getDlvAddress() %></td>
					</tr>
					<tr>
						<th>배송요청사항</th>
						<td><%=storeDetailOrderDlv.getShipMsg() %></td>
					</tr>
				</table>
			</div>
			<div class="refund-btn-group">
				<input type="button" class="re-btn" onclick="cacelDetailCheckPage('2')" value="환불하기">
	
				<input type="button" class="re-btn2"
					onclick="location.assign('<%=request.getContextPath()%>/Detail/DetailListServlet.do')"
					value="구매내역목록">
			</div>
		</div>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>


</html>