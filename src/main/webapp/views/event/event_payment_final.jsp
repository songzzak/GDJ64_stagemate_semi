<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page
	import="java.util.List,com.stagemate.event.model.vo.Event,com.stagemate.event.model.vo.EventUpfile,com.stagemate.payment.model.vo.EventOrder"%>
<%
	Event event = (Event) request.getAttribute("event");
	List<EventUpfile> files = (List) request.getAttribute("files");
	EventOrder eventOrder = (EventOrder) request.getAttribute("eventOrder");
	String round = (String)request.getAttribute("round");
	String choiceday = (String)request.getAttribute("choiceday");
	String chkDate = (String)request.getAttribute("chkDate");
%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<link rel="stylesheet"
	href="<%=contextPath%>/css/joonho/style_event_payment_final.css">
<!---------------------------------------->
<title>STAGEMATE/결제</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<!-----------   아래에서 HTML 작업  ----------->
	<section class="min1280px">
		<div class="max1280px">
			<div id="seat_title">
				<h2>좌석 선택</h2>
				<h3>></h3>
				<h2>결제</h2>
				<h3>></h3>
				<h2>완료</h2>
			</div>
			<hr>
			<!-- 예매 결과 -->
			<div id="res_pay_fin">
				<!-- 제목 -->
				<div id="res_pay_fin_title">
					<h2><%=event.getEventNm() %></h2>
				</div>
				<!-- 예약 사항 -->
				<div id="res_pay_fin_detail">
					<%for (EventUpfile f : files) {
						if ((f.getPurposeNo().equals("PUR1"))) {
						%> 
						<img src="<%=contextPath%>/upload/joonho/<%=f.getEuRename()%>"
									width="250" height="350">
					<%}} %>
					<table>
						<tr>
							<td>예매자</td>
							<td><%=loginMember.getMemberNm() %></td>
						</tr>
						<tr>
							<td>예매번호</td>
							<td><%=eventOrder.getRsvNo() %></td>
						</tr>
						<tr>
							<td>관람일시</td>
							<td>2023년 5월 24일 (수) 19:30</td>
						</tr>
						<tr>
							<td>장소</td>
							<td>광림아트센터 BBCH홀</td>
						</tr>
						<tr>
							<td>좌석</td>
							<td>1층 VIP석 A열 10번, 1층 R석 C열 6번, 1층 S석 C열 2번, 2층 E열 6번</td>
						</tr>
						<tr>
							<td>티켓 수령방법</td>
							<td>현장수령</td>
						</tr>
					</table>
				</div>
				<!-- 결제내역 -->
				<div id="res_pay_fin_payment">
					<h2>결제내역</h2>
					<table>
						<tr>
							<td>예매일</td>
							<td>2023.05 15 14:01</td>
						</tr>
						<tr>
							<td>총 결제 금액</td>
							<td>427,000원</td>
						</tr>
						<tr>
							<td>결제수단</td>
							<td>신용카드[신한카드]</td>
						</tr>
					</table>
				</div>
				<!-- 취소 안내 -->
				<div id="res_pay_fin_cancel_info">
					<h1>취소 가능 마감 시간 : 2023년 5월 23일 17:00까지</h1>
					<div>
						<h3>예매 취소 안내</h3>
						<hr>
						<p>취소 마감시간 : 2023.06.03 (금) 17:00 까지</p>
						<p>취소 관련 기타 자세한 내용은 공연 별별 상세페이지 안내를 이용해주세요. </p>
						<p>신용카드 결제의 경우, 일반적으로 당사의 취소처리 완료 후, 영업일기준 3~4일 뒤에 카드사의 승인취소가 확인됩니다. (체크카드 동일)- 기존 결제금액을 취소한 뒤, 동일카드로 취소시점에 따른 취소수수료를 재승인합니다.(※ 예매취소시점과 해당 카드사의 환불 처리기준에 따라 환급방법과 환급일자는 다소 차이가 있을 수 있습니다.) </p>
						<p>취소마감시간 : 공연일 1일 전 오후 5시 / 공연일이 일요일, 월요일인 경우 토요일 낮 12시(단, 공연일 1일 전이 공휴일인 경우 공휴일 전 평일 오후 5시, 토요일 낮 12시)- 예매수수료는 예매한 당일 취소 시에만 환불되며, 이후 취소 시에는 환불되지 않습니다.- 취소 마감시간 이후 또는 관람일 당일 예매하신 건에 대해서는 취소/변경/환불이 불가합니다.</p>
						<p>관람일 당일 예매하신 건은 취소, 변경, 환불 불가합니다.</p>
						<p>환불접수 후 입금까지 영업일 기준 1~3일 정도가 소요됩니다.</p>
						<p>[마이페이지 > 예매내역 확인/취소] 메뉴에서 직접 취소하시거나 고객센터 (1577 - 3363) 를 통해 취소할 수 있습니다.</p>
					</div>
				</div>
				<!-- 버튼 -->
				<div id="res_pay_fin_button">
					<button>홈으로 가기</button>
					<button>예매내역으로 가기</button>
				</div>
			</div>
		</div>
	</section>
	<!-----------   위에서 HTML 작업  ----------->
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
	<script src="<%= contextPath %>/js/script_common.js"></script>
	<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
	<!-------------------------------------------->
</body>
</html>