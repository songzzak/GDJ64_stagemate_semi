<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/style_detailList.css">
<%@ page import="java.util.List,com.stagemate.detail.model.vo.Detail"%>
<%@ page import="java.util.List,com.stagemate.detail.model.vo.StoreDetail"%>
<title>STAGEMATE</title>
</head>
<body>
	<%
	//PlayDetail 정보 가져와야 한다. 
	List<Detail> details = (List) request.getAttribute("DetailList");
	%>
	<%
	//StoreDetail 정보 가져와야 한다. 
	List<StoreDetail> stores = (List) request.getAttribute("StoreList");
	%>
	<%@ include file="/views/common/header.jsp"%>

	<div class="BookList min1280px">
		<div class=BookingList_bigchart>
			<h1 id="BookingList_title">구매상세내역</h1>
			<div class="division-line"></div>

			<div class="btn-wrapper" style="padding: 30px 0px 0px 320px">
				<ul class="btnsBox" style="margin: 0 auto;">
					<li><button class="BLbtn active" id="play_btn"
							onclick="change_btn(event)">예매</button></li>
					<li><button class="BLbtn" id="store_btn"
							onclick="change_btn(event)">스토어</button></li>
				</ul>
			</div>
			<script>
				function change_btn(e) {
					var btns = document.querySelectorAll(".BLbtn");
					btns.forEach(function(btn, i) {
						if (e.currentTarget == btn) {
							btn.classList.add("active");
						} else {
							btn.classList.remove("active");
						}
					});
					console.log(e.currentTarget);
				}
			</script>






			<div class="PlayBookingList">
				<div class="Play_Main">
					<!-- 기간 조회 버튼  -->
					<div class="search-btn"
						style="padding: 60px 0px 0px 0px; float: right;">
						<div class="termsearchbox" style="margin-right: 30px;">

							기간별 조회
							<button name="filterDate" class="perbtn active" value="1"
								onclick="search_btn(event)">7일</button>
							<button name="filterDate" class="perbtn" value="2"
								onclick="search_btn(event)">1개월</button>
							<button name="filterDate" class="perbtn" value="3"
								onclick="search_btn(event)">3개월</button>

							<!-- 기간검색 : 시작일 종료일로 리스트 조회  -->
							<!-- 시작일<input type="text" name="startDate">
							종료일<input type="text" name="endDate">
							<button onclick="">검색</button>
								
						<script>
							
						</script> -->

						</div>
						<div class="datebox">
							예매일자별 조회 <select class="btnbox btnbox-white" id="year1"
								name="year"></select> <select class="btnbox btnbox-white"
								id="month1" name="month"></select> <input type="submit"
								class="btnbox btnbox-brown" value="조회">
						</div>
					</div>

					<script>
						function search_btn(e) {
							var btns = document.querySelectorAll(".perbtn");
							btns.forEach(function(btn, i) {
								if (e.currentTarget == btn) {
									btn.classList.add("active");
								} else {
									btn.classList.remove("active");
								}
							});
							console.log(e.currentTarget);
						}
					</script>

					<div class="BLP-radio" align="right"
						style="padding: 20px 0px 20px 700px;">
						<p class="txt">총 3건의 예매내역이 있습니다</p>
						<div class="stateP-btn" style="float: right">
							예매상태별 조회 <input type="radio" name="gender" value="M">전체 <input
								type="radio" name="gender" value="F">예매 <input
								type="radio" name="gender" value="F">취소
						</div>
					</div>
				</div>




				<!-- 예매내역 -->

				<div class="BookingList">
					<table class="BookingList-table"
						style="margin: 5px auto; margin-right: auto;">
						<colgroup>
							<col style="width: 120px">
							<col>
							<col style="width: 180px">
							<col style="width: 80px">
							<col style="width: 185px">
							<col style="width: 120px">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">예매번호</th>
								<th scope="col">티켓명</th>
								<th scope="col">관람일시</th>
								<th scope="col">매수</th>
								<th scope="col">취소가능일</th>
								<th scope="col">상태</th>
								<th scope="col">리뷰작성</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Detail d : details) {
							%>
							<tr>
								<td class="book_no"><a href="" style="color: gray"><%=d.getRsvNo()%></a></td>
								<td class="book_no"><a href=""
									style="text-decoration: none; color: black"><%=d.getEventName()%></a></td>
								<td class="book_no">2023-06-04 18:00</td>
								<td class="book_no">1매</td>
								<td class="book_no">2023-06-03 17:00</td>
								<td class="book_no">예매</td>
								<td class="book_no"><a href="">리뷰작성</a></td>
							</tr>
							<%
							}
							%>


						</tbody>
					</table>

				</div>
				<p class="Play_guidetxt" style="padding: 5px 0px 30px 60px">예매번호를
					클릭하면 예매 상세 정보를 확인할 수 있습니다.</p>



			</div>
			<!--스토어내역 -->
			<div class="StoreBookingList">
				<div class="Play_Main">
					<div class="search-btn"
						style="padding: 60px 0px 0px 0px; float: right;">
						<div class="termsearchbox" style="margin-right: 30px;">
							기간별 조회 <input type="button" class="perbtn active" value="7일"
								onclick="search_btn(event)"> <input type="button"
								class="perbtn" value="1개월" onclick="search_btn(event)">
							<input type="button" class="perbtn" value="3개월"
								onclick="search_btn(event)">
						</div>
						<div class="datebox">
							배송일자별 조회 <select class="btnbox btnbox-white" id="year"
								name="year"></select> <select class="btnbox btnbox-white"
								id="month" name="month"></select> <input type="submit"
								class="btnbox btnbox-brown" value="조회">
						</div>
					</div>


					<div class="BLS-radio" align="right"
						style="padding: 20px 0px 0px 700px;">
						<p class="txt">총 3건의 주문내역이 있습니다</p>
						<div class="stateS-btn" style="float: right">
							배송 조회 <input type="radio" name="gender" value="M">배송 중 <input
								type="radio" name="gender" value="F">배송 전 <input
								type="radio" name="gender" value="F">배송 완료
						</div>
					</div>

					<div class="btn-move" style="padding: 60px 60px 7px 55px;">
						<input type="button" class="ordersearch-btn" value="정상주문조회">
					</div>
					<div class="Storedb" style="padding: 0px 0px 5px 60px">
						날짜별 조회 <select class="btnbox btnbox-white" id="date" name="date">
							<option value="lately">최근 순</option>
							<option value="old">오래된 순</option>
						</select>
					</div>
				</div>

				<div class="OrderList-store">
					<table class="OrderList-table"
						style="margin: 5px auto; margin-right: auto;">
						<colgroup>
							<col style="width: 120px">
							<col>
							<col style="width: 135px">
							<col style="width: 135px">
							<col style="width: 120px">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">주문일자</th>
								<th scope="col">주문번호</th>
								<th scope="col">상품명</th>
								<th scope="col">총 구매금액</th>
								<th scope="col">배송상태</th>
								<th scope="col">리뷰작성</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (StoreDetail s : stores) {
							%>
							<tr>
								<td class="book_no">2023-04-16</a></td>
								<td class="book_no"><a href="" style="color: gray;"><%=s.getOrderNo()%></a></td>
								<td class="book_no"><a href=""><%=s.getProductNm()%></a></td>
								<td class="book_no"><%=s.getTotalPrice()%></td>
								<td class="book_no">배송 중</td>
								<td class="book_no"><a href=""
									style="text-decoration: none;">리뷰작성</a></td>
							</tr>
							<%
							}
							%>

						</tbody>
					</table>
					<p class="Store_guidetxt"
						style="float: left; padding: 0px 0px 5px 60px">주문번호를 클릭하면 주문
						상세 정보를 확인할 수 있습니다.</p>
				</div>

			</div>

		</div>


		

	</div>
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/yelin/detailList.js"></script>
</body>

</html>