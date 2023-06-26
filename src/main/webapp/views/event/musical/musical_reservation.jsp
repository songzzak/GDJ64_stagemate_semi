<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page
	import="java.util.List,com.stagemate.event.model.vo.Seat"%>
<%
	List<Seat> seats = (List) request.getAttribute("seats");
	String eventNo = (String)request.getAttribute("eventNo");
	String round = (String)request.getAttribute("round");
	String choiceday = (String)request.getAttribute("choiceday");
	String esNo = (String)request.getAttribute("esNo");
	int vip = (int)request.getAttribute("vip");
	int r = (int)request.getAttribute("r");
	int s = (int)request.getAttribute("s");
	int a = (int)request.getAttribute("a");
%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<link rel="stylesheet"
	href="<%=contextPath%>/css/joonho/style_musical_reservation.css">
<!---------------------------------------->
<title>STAGEMATE/좌석선택</title>
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
			<!-- 좌석배치 -->
			<div id="seat_main">
				<div id="first_seat">
					<div>
						<h4>1F</h4>
						<h2>STAGE</h2>
						<div id="seatMap1F">
							<!-- 좌석 표시를 위한 공간 -->
						</div>
						<div id="wheelchair_seat">
							<div>
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
							</div>
							<div>
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
								<img src="<%=contextPath%>/images/joonho/wheelchair.png">
							</div>
						</div>
					</div>
				</div>
				<div id="second_seat">
					<div>
						<h4>2F</h4>
						<div id="seatMap2F">
							<!-- 좌석 표시를 위한 공간 -->
						</div>
					</div>
				</div>
			</div>
			<!-- 좌석 선택창 -->
			<div id="seat_choice">
				<!-- 좌석등급/가격 -->
				<div id="seat_class_price">
					<h2>좌석등급/가격</h2>
					<hr>
					<div>
						<div class="seat unavailable" style="background-color: #CE3500"></div>
						<h3>VIP석 150,000원</h3>
						<h3>(잔여 : <%=vip-4==0?"매진":vip-4+"석" %></h3>
					</div>
					<div>
						<div class="seat unavailable" style="background-color: #9900C9"></div>
						<h3>R석 120,000원</h3>
						<h3>(잔여 : <%=r-4==0?"매진":r-4+"석" %></h3>
					</div>
					<div>
						<div class="seat unavailable" style="background-color: #00CCCC"></div>
						<h3>S석 90,000원</h3>
						<h3>(잔여 : <%=s-6==0?"매진":s-6+"석" %></h3>
					</div>
					<div>
						<div class="seat unavailable" style="background-color: #5529DD"></div>
						<h3>A석 70,000원</h3>
						<h3>(잔여 : <%=a-10==0?"매진":a-10+"석" %></h3>
					</div>
				</div>
				<!-- 선택한좌석 -->
				<div id="select_seat">
					<h2>선택한 좌석</h2>
					<hr>
					<div id="selectedSeat"></div>
				</div>
				<!-- 선택 버튼 -->
				<div id="seat_choice_button">
					<div>
						<button onclick="prev_page('<%=eventNo%>');">이전 단계</button>
						<button onclick="seat_reset();">좌석 초기화</button>
					</div>
					<button onclick="toPayment('<%=eventNo%>','<%=round%>','<%=choiceday%>','<%=esNo%>')">좌석선택 완료</button>
				</div>
			</div>
		</div>
	</section>
	<!-----------   위에서 HTML 작업  ----------->
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
	<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
	<script src="<%=contextPath%>/js/joonho/script_musical_reservation.js"></script>
	<script>
		var seatA=[];
		var seatB=[];
		var seatC=[];
		var seatD=[];
		var seatE=[];
		var seatF=[];
		var seatG=[];
		var seatH=[];
		var seatI=[];
		var seatJ=[];
		var seatK=[];
		var seatL=[];
		<%for (Seat seat : seats) {%>
			esdatecheck=new Date('<%=seat.getEsDate()%>')
			esdatechoice=new Date('<%=choiceday%>')
			if(esdatecheck.getDate()==esdatechoice.getDate()){
				switch('<%=seat.getSeatRow()%>'){
					case 'A' : if('<%=seat.getIsReserved()%>'=='N'){
									seatA.push(1);break;
								}else{
									seatA.push(0);break;
								}
					case 'B' : if('<%=seat.getIsReserved()%>'=='N'){
									seatB.push(1);break;
								}else{
									seatB.push(0);break;
								}
					case 'C' : if('<%=seat.getIsReserved()%>'=='N'){
									seatC.push(1);break;
								}else{
									seatC.push(0);break;
								}
					case 'D' : if('<%=seat.getIsReserved()%>'=='N'){
									seatD.push(1);break;
								}else{
									seatD.push(0);break;
								}
					case 'E' : if('<%=seat.getIsReserved()%>'=='N'){
									seatE.push(1);break;
								}else{
									seatE.push(0);break;
								}
					case 'F' : if('<%=seat.getIsReserved()%>'=='N'){
									seatF.push(1);break;
								}else{
									seatF.push(0);break;
								}
					case 'G' : if('<%=seat.getIsReserved()%>'=='N'){
									seatG.push(1);break;
								}else{
									seatG.push(0);break;
								}
					case 'H' : if('<%=seat.getIsReserved()%>'=='N'){
									seatH.push(1);break;
								}else{
									seatH.push(0);break;
								}
					case 'I' : if('<%=seat.getIsReserved()%>'=='N'){
									seatI.push(1);break;
								}else{
									seatI.push(0);break;
								}
					case 'J' : if('<%=seat.getIsReserved()%>'=='N'){
									seatJ.push(1);break;
								}else{
									seatJ.push(0);break;
								}
					case 'K' : if('<%=seat.getIsReserved()%>'=='N'){
									seatK.push(1);break;
								}else{
									seatK.push(0);break;
								}
					case 'L' : if('<%=seat.getIsReserved()%>'=='N'){
									seatL.push(1);break;
								}else{
									seatL.push(0);break;
								}
				}
			}
		<%}%>
	</script>
	<!-------------------------------------------->
</body>
</html>