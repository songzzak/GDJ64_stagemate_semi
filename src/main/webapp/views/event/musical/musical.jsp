<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<link rel="stylesheet" href="<%= contextPath %>/css/joonho/style_event.css">
<!---------------------------------------->
<title>페이지 타이틀 입력</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<!-----------   아래에서 HTML 작업  ----------->
<section class="min1280px">
    <div class="max1280px">
        <div id="gold_maincontainer">
			<!-- 제목장소등 -->
			<div id="gold_title">
				<h1>나르치스와 골드문트</h1>
				<div>
					<h4>2023.05.13~2023.07.23</h4>
					<h3>|</h3>
					<h4>광림아트센터 BBCH홀</h4>
					<img id="movemap" src="<%= contextPath %>/images/joonho/map.png" width="24" height="24">
				</div>
			</div>
			<hr>
			<!-- 포스터 간단한 내용 -->
			<div id="gold_poster">
				<!-- 포스터 -->
				<div>
					<img src="<%= contextPath %>/images/joonho/나르치스와골드문트.png"
						width="320" height="450">
				</div>
				<!-- 간단내용 -->
				<div id="gold_content">
					<!-- 등급 -->
					<div>
						<div>
							<h3>등급</h3>
						</div>
						<div>
							<h3>8세 이상 관람가</h3>
						</div>
					</div>
					<!-- 관람시간 -->
					<div>
						<div>
							<h3>관람시간</h3>
						</div>
						<div>
							<h3>150분(인터미션 20분 포함)</h3>
						</div>
					</div>
					<!-- 가격 -->
					<div>
						<div>
							<h3>가격</h3>
						</div>
						<div id="money" class="money">
							<div>
								<h3>VIP석</h3>
								<h3>150,000원</h3>
							</div>
							<div>
								<h3>R석</h3>
								<h3>120,000원</h3>
							</div>
							<div>
								<h3>S석</h3>
								<h3>90,000원</h3>
							</div>
							<div>
								<h3>A석</h3>
								<h3>70,000원</h3>
							</div>
						</div>
					</div>
				</div>
				<!-- 아이콘 -->
				<div id="gold_icon">
					<div>
						<button>
							<img src="<%= contextPath %>/images/joonho/blackheart.svg">
							<p>23</p>
						</button>
						<img id="urlcopy"
							src="<%= contextPath %>/images/joonho/urlcopy.png" onclick="urlcopy();">
					</div>
				</div>
			</div>
			<hr>
			<div id="gold_choice">
				<!-- 달력예매칸 -->
				<div id="reservation">
					<!-- 달력 -->
					<div>
						<div>
							<h2 class="gold_h2">날짜/시간선택</h2>
							<hr>
						</div>
						<div id="reservation_calendar">
							<div id=gold_calender>
								<table class="Calendar">
									<thead>
										<tr>
											<td onClick="prevCalendar();" style="cursor: pointer;">&#60;</td>
											<td colspan="5"><span id="calYear"></span>년 <span
												id="calMonth"></span>월</td>
											<td onClick="nextCalendar();" style="cursor: pointer;">&#62;</td>
										</tr>
										<tr>
											<td>일</td>
											<td>월</td>
											<td>화</td>
											<td>수</td>
											<td>목</td>
											<td>금</td>
											<td>토</td>
										</tr>
									</thead>

									<tbody>
									</tbody>
								</table>
							</div>
							<div id="gold_bar"></div>
							<div>
								<div id="gold_button">
									<button id="schedule">1회 오후 7시 30분</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 예매 -->
				<div id="gold_seat">
					<div>
						<h2 class="gold_h2">예매 가능좌석</h2>
					</div>
					<hr>
					<div id="seat_money" class="money">
						<div>
							<h3>VIP석 150,000원</h3>
							<h3>(잔여 : 매진)</h3>
						</div>
						<div>
							<h3>R석 120,000원</h3>
							<h3>(잔여 : 18석)</h3>
						</div>
						<div>
							<h3>S석 90,000원</h3>
							<h3>(잔여 : 16석)</h3>
						</div>
						<div>
							<h3>A석 70,000원</h3>
							<h3>(잔여 : 2석)</h3>
						</div>
					</div>
					<div>
						<button>예매 하기</button>
					</div>
				</div>
			</div>
			<!-- 상세내용 -->
			<div>
				<div id="gold_details">
					<div id="detail_information"
						style="border-bottom: 14px solid black; font-weight: bolder">
						<a>상세정보</a>

					</div>
					<div id="reservation_cancel">
						<a>예매/취소 안내</a>
					</div>
					<div id="gold_review">
						<a>리뷰(7)</a>
					</div>
					<div id="gold_location">
						<a>장소</a>
					</div>
				</div>
				<hr>
				<div class="gold_info">
					<div id="detail_information_img"
						style="display: inline-flex; flex-direction: column; align-items: center;">
						<img src="<%= contextPath %>/images/joonho/gold1.jpg"> 
						<img src="<%= contextPath %>/images/joonho/gold2.jpg"> 
						<img src="<%= contextPath %>/images/joonho/gold3.jpg"> 
						<img src="<%= contextPath %>/images/joonho/gold4.jpg"> 
						<img src="<%= contextPath %>/images/joonho/gold5.jpg"> 
						<img src="<%= contextPath %>/images/joonho/gold6.jpg"> 
						<img src="<%= contextPath %>/images/joonho/gold7.jpg"> 
						<img src="<%= contextPath %>/images/joonho/gold8.jpg"> 
						<img src="<%= contextPath %>/images/joonho/gold9.jpg"> 
					</div>
					<div id="reservation_cancel_info" style="display: none">
						<div id="reservation_info" class="info">
							<div>
								<h1>예매</h1>
							</div>
							<div>
								<div id="reservation_info_content">
									<p>예매는 PC, 모바일, 고객센터 를 통해 신용카드, 가상계좌(무통장 입금), YES머니,
										YES상품권, 예치금 등으로 예매하실 수 있습니다.</p>
									<p>(단, 상품마다 사용 가능한 결제 수단이 다르게 적용될 수 있으니 상품 상세페이지 안내 사항을
										확인해주세요.)</p>
									<p>(단, 상품에 따라 예매 당일 밤 11시 29분에 마감되는 경우가 있으니 예매 전후 반드시
										확인해주시기 바랍니다.)</p>
									<p>예매수수료는 다음과 같습니다.(상품의 특성에 따라 예매수수료 정책은 다를 수 있습니다.)</p>
								</div>
								<div id="reservation_info_table" class="info_table">
									<table class="info_table_detail">
										<tr>
											<th>장르</th>
											<th>PC</th>
										</tr>
										<tr>
											<td>콘서트, 뮤지컬, 클래식, 국악, 무용</td>
											<td>장당 1,000원</td>
										</tr>
										<tr>
											<td>연극, 전시</td>
											<td>장당 500원</td>
										</tr>
										<tr>
											<td>체험, 행사</td>
											<td>장당 300원</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<hr>
						<div id="cancel_info" class="info">
							<div>
								<h1>취소 수수료</h1>
							</div>
							<div>
								<div id="cancel_info_table" class="info_table">
									<table class="info_table_detail">
										<tr>
											<th>취소일</th>
											<th>취소 수수료</th>
										</tr>
										<tr>
											<td>예매 후 7일 이내</td>
											<td>없음</td>
										</tr>
										<tr>
											<td>예매 후 8일~관람일 10일 전까지</td>
											<td>뮤지컬, 콘서트, 클래식 : 장당 4,000원 / 연극, 전시 : 장당 2,000원(단, 티켓
												금액의 10% 이내)</td>
										</tr>
										<tr>
											<td>관람일 9일~관람일 7일 전까지</td>
											<td>티켓 금액의 10%</td>
										</tr>
										<tr>
											<td>관람일 6일~관람일 3일 전까지</td>
											<td>티켓 금액의 20%</td>
										</tr>
										<tr>
											<td>관람일 2일~취소마감일시까지</td>
											<td>티켓 금액의 30%</td>
										</tr>
									</table>
								</div>
								<div id="cancel_info_content">
									<p>예매 후 7일 이내라도 취소시점이 관람일로부터 10일 이내라면 그에 해당하는 취소수수료가 부과됩니다.</p>
									<p>관람일 당일 취소 가능한 상품의 경우 관람일 당일 취소 시 티켓금액의 90%가 부과됩니다.</p>
									<p>(단, 상품에 따라 예매 당일 밤 11시 29분에 마감되는 경우가 있으니 예매 전후 반드시
										확인해주시기 바랍니다.)</p>
									<p>상품의 특성에 따라 취소수수료 정책이 달라질 수 있습니다.(각 상품 예매 시 취소수수료 확인)</p>
								</div>
							</div>
						</div>
					</div>
					<div id="gold_details_map" style="display:none">
						<div><h1>광림아트센터 BBHC홀</h1></div>
						<div id="map" style="width: 80%; height: 650px;"></div>
					</div>
				</div>
			</div>
		</div>
    </div>
</section>
<!-----------   위에서 HTML 작업  ----------->
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=51321917c05ca5a38fbce7ed8b6a981c"></script>
<script src="<%= contextPath %>/js/joonho/musical.js"></script>
<!-------------------------------------------->
</body>
</html>