<%@page import="com.stagemate.detail.model.vo.DetailInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/play/style_Detailed_play.css">
<%@ page import="java.util.List,com.stagemate.review.model.vo.PlaySearch"%>
<%@ page import="java.util.List,com.stagemate.detail.model.vo.DetailInfo"%>
<%@ page import="java.util.List,com.stagemate.detail.model.vo.DetailTicketList"%>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%=contextPath%>/js/yelin/detailList.js"></script>
<title>STAGEMATE</title>
<%
	DetailInfo detailInfo = (DetailInfo)request.getAttribute("DetailInfo");
%>
<%
	List<DetailTicketList> ticketList = (List) request.getAttribute("TicketList");
%>
<script>
let rsvNo = '<%= detailInfo.getRsvNo()%>';
let esNo = '<%= detailInfo.getEsNo()%>';
$(document).ready(function() {
  $('input[name="choice"]').on('click', function() {
    var isChecked = $(this).prop('checked');
    $('tbody input[name="choice"]').prop('checked', isChecked);
  });
  
  $('tbody input[name="choice"]').on('click', function() {
    var isAllChecked = $('tbody input[name="choice"]').length === $('tbody input[name="choice"]:checked').length;
    $('input[name="choice"]').prop('checked', isAllChecked);
  });
  
  let orderStatus = '<%= detailInfo.getOrderStatus()%>';
  if (orderStatus == '취소') {
		$('.re-btn').removeClass('re-btn').addClass('disable-btn');
		$('.disable-btn').attr('onclick', "alert('이미 취소한 내역입니다')");
  }
});

</script>
<style>
	.disable-btn{
		border: none;
                    padding: 8px 45px;
                    text-align: center;
                    text-decoration: none;
                    border-radius: 5px;
                    font-weight: bold;
                    background-color: var(--sm-brown);
                    border: 2px solid var(--sm-brown);
                    color: white;
                    margin: 0 auto;    /* 버튼 글씨정렬 후 버튼 일자 정렬 */
                    display: flex;
                    margin-bottom:30px;
				}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="BookDetail_min1280px">
		<div class="BookingDetailPlay_bigchart">

			<h1 id="BookingDetailPlay_title">예매내역</h1>
			<div class="division-line"></div>

			<div class="bigchart" style="height: auto;">
				<!-- 제목 -->
				<p class="play_title"><%=detailInfo.getEventName() %></p>

				<div class="bookchart" id="bookchart2"
					style="padding: 10px 10px 10px 10px">


					<!-- 포스터 -->
					<div class="ticketbook">
						<p class="poster">
							<a href=''
								Title='<%=detailInfo.getEventName() %>'>
								<img src='../upload/joonho/<%=detailInfo.getFileName() %>'
								width='180' height='220' alt='' /></a>
						</p>
					</div>
					<table class="book_info">
						<tr>
							<th>예매자</th>
							<td><%=detailInfo.getMemberNm() %></td>
						</tr>
						<tr>
							<th>예매번호</th>
							<td><%=detailInfo.getRsvNo() %></td>
						</tr>
						<tr>
							<th>관람일시</th>
							<td><%=detailInfo.getRsvDate() %></td>
						</tr>
						<tr>
							<th>장소</th>
							<td><%=detailInfo.getLocation() %></td>
						</tr>
						<tr>
							<th>좌석</th>
							<td>1층 R석 C열 11번</td>
						</tr>
						<tr>
							<th>티켓 수령방법</th>
							<td>현장수령</td>
						</tr>
					</table>
				</div>

				<!-- 두번째 차트 -->
				<div class="second-chart">
					<table class="secondchart" id="secondchart"
						style="margin: auto; margin-right: auto;">

						<colgroup>
							<col style="width: 90px">
							<col style="width: 120px">
							<col style="width: 135px">
							<col style="width: 90px">
							<col style="width: 90px">
							<col style="width: 80px">
						</colgroup>
						<thead>
							<tr>
								<th scope="col" class="th">좌석등급</th>
								<th scope="col" class="th">좌석번호</th>
								<th scope="col" class="th">할인권종</th>
								<th scope="col" class="th">가격</th>
								<th scope="col" class="th">취소여부</th>
								<th scope="col" class="th">전체선택 <input type="checkbox"
									name="choice" value="c">
								</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (DetailTicketList d : ticketList) {
							%>
							<tr>
								<td class="bk_no"><%=d.getSlvNM() %>석</td>
								<td class="bk_no"><%=d.getSeatRow() %>열 <%=d.getSeatCol() %>번</td>
								<td class="bk_no">재관람할인(1인1매)</td>
								<td class="bk_no"><%=d.getSlvPrice() %>원</td>
								<td class="bk_no">취소가능</td>
								<td class="bk_no">취소<input type="checkbox" name="choice" value="c"></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>

				<h4 class="font-pay">결제내역</h4>
				<table class="pay_chart">
					<tr>
						<th>예매일</th>
						<td><%=detailInfo.getRsvDate() %></td>
						<th>현재상태</th>
						<td><%=detailInfo.getOrderStatus() %></td>
					</tr>
					<tr>
						<th>결제수단</th>
						<td>신용카드[신한카드]</td>
						<th>결제 금액</th>
						<td><%=detailInfo.getRsvPirce() %>원</td>
					</tr>
				</table>
			</div>

			<p class="cancel-txt" align="right"
				style="padding: 0px 100px 3px 0px;">*취소를 원하시는 티켓을 선택하고 취소하기를
				눌러주세요.</p>
			<input type="button" class="re-btn" onclick="cacelDetailCheckPage('1')" value="취소하기">

			<div class="bigchart2">
				<h4 class="cancel-gd" style="color: red">예매취소 안내</h4>
				<div class="cancel-line"></div>
				<h4 class="cancel-date">취소 마감시간: 2023.06.03 (금) 17:00 까지</h4>
				<div class="cancel_box">
					<ul>
						<li>취소 관련 기타 자세한 내용은 공연 별 상세페이지 안내를 이용해주세요.</li>
						<li>신용카드 결제의 경우, 일반적으로 당사의 취소처리 완료 후, 영업일기준 3~4일 뒤에 카드사의
							승인취소가 확인됩니다.<br>(체크카드 동일) <br>기존 결제금액을 취소한 뒤, 동일카드로
							취소시점에 따른 취소수수료를 재승인합니다. <br> (※ 예매취소시점과 카드사의 환불 처리기준에 따라
							환급방법과 환급일자는 다소 차이가 있을 수 있습니다.)
						</li>
						<br>
						<li>취소마감시간 : 공연일 1일 전 오후 5시 / 공연일이 일요일, 월요일인 경우 토요일 낮 12시(단,
							공연일 1일 전이 공휴일인 경우 공휴일 전 평일 오후 5시, 토요일 낮 12시)- 예매수수료는 예매한 당일 취소
							시에만 환불되며, 이후 취소 시에는 환불되지 않습니다.<br>
						<br>취소 마감시간 이후 또는 관람일 당일 예매하신 건에 대해서는 취소/변경/환불이 불가합니다.
						</li>
						<li>관람일 당일 예매하신 건은 취소, 변경, 환불 불가합니다.</li>
						<li>환불접수 후 입금까지 영업일 기준 1~3일 정도가 소요됩니다.</li>
						<br>
						<li>[마이페이지 > 예매내역 확인/취소] 메뉴에서 직접 취소하시거나 고객센터 (1577 - 3363) 를
							통해 취소할 수 있습니다.</li>
					</ul>
				</div>
			</div>

			<input type="button" class="re-btn2"
				onclick="location.assign('<%=request.getContextPath()%>/Detail/DetailListServlet.do')"
				value="예매내역목록">
		</div>
		</div>
		</div>
	</section>
	
	
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>