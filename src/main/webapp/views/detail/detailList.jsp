<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/style_detailList.css">
	<link rel="stylesheet" href="<%=contextPath%>/css/yoonjin/style_mypage_nav.css">
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

		<div class=BookingList_bigchart >
				<div class=maincontainer>
			<div id="mypage_nav">
        		<div id="user_profile">
                    <img src="<%=contextPath%>/images/yoonjin/information/default_profile.png" alt="user_profile_img" id="img_profile">
        			<h5><%=loginMember.getMemberId() %> 님</h5>
        			<p><%=loginMember.getMemberEmail() %><p>
        		</div>
        		<hr>
        		<div id="user_nav">
					<nav>   
						<ul id="mypage_nav_ul">
							<li class="li1"><a href="<%= request.getContextPath() %>/member/UpdateMember.do?userId=<%=loginMember.getMemberId()%>">내 정보 관리</a></li>
							<li class="li1"><a href="<%= request.getContextPath() %>/mypage/wishList.do?userId=<%=loginMember.getMemberId()%>">관심목록</a></li>
							<li class="li1"><a href="<%=request.getContextPath()%>/store/selectCartList.do?id=<%=loginMember.getMemberId()%>">장바구니</a></li>
							<li class="li1">구매내역
								<ul>
									<li class="li2"><a href="<%=request.getContextPath()%>/Detail/DetailListServlet.do?id=<%=loginMember.getMemberId()%>">구매상세내역</a></li>
									<li class="li2"><a href="<%=request.getContextPath()%>/Review/ReviewListServlet.do?id=<%=loginMember.getMemberId()%>">리뷰 작성</a></li>
								</ul>
							</li>
							<li class="li1">내가 쓴 글
								<ul>
									<li class="li2"><a href="<%= request.getContextPath() %>/board/selectMyBoard.do?id=<%=loginMember.getMemberId()%>">커뮤니티</a></li>
									<li class="li2"><a href="<%= request.getContextPath() %>/views/mypage/myInquiry.jsp">1:1문의</a></li>
								</ul>
							</li class="li1">
							<li class="li1"><a href="<%= request.getContextPath() %>/views/member/member_withdraw.jsp">회원 탈퇴</a></li>
						</ul>
					</nav>
        		</div>
        		<div id="nav_btn_logout">
        			<a href="<%= request.getContextPath() %>/member/logout.do" id="logout_btn_mypage">로그아웃</a>
        		</div>
			</div>
			<div class="take">
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
							<button name="filterDate1" class="perbtn active" value="1"
								onclick="search_btn(event)">7일</button>
							<button name="filterDate1" class="perbtn" value="2"
								onclick="search_btn(event)">1개월</button>
							<button name="filterDate1" class="perbtn" value="3"
								onclick="search_btn(event)">3개월</button>


						</div>
						<div class="datebox">
							예매일자별 조회 <select class="btnbox btnbox-white" id="year1"
								name="year"></select> <select class="btnbox btnbox-white"
								id="month1" name="month"></select> <input type="button"
								class="btnbox btnbox-brown" value="조회" onclick="searchList('1', 1, 10)">
						</div>
					</div>

					<script>
						function search_btn(e) {
							var name = e.target.name;
							var btns = document.querySelectorAll('button[name="' + name + '"].perbtn');
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
						<p class="txt">총 <label id="searchCount1"><%=request.getAttribute("TotalCount") %></label>건의 예매내역이 있습니다</p>
						<div class="stateP-btn" style="float: right">
							예매상태별 조회 <input type="radio" name="status1" value="1" checked="checked">전체 <input
								type="radio" name="status1" value="2">예매 <input
								type="radio" name="status1" value="3">취소
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
								<th scope="col">예매 일자</th>
								<th scope="col">매수</th>
								<th scope="col">취소가능일</th>
								<th scope="col">상태</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Detail d : details) {
							%>
							<tr>
								<td class="book_no"><a class="page-link" onclick="detailListPage('1', this);" style="color: gray"><%=d.getRsvNo()%></a></td>
								<td class="book_no"><%=d.getEventName()%></a></td>
								<td class="book_no"><%=d.getRsvDate()%></td>
								<td class="book_no"><%=d.getTickets()%>매</td>
								<td class="book_no"><%=d.getEsDate()%></td>
								<td class="book_no"><%=d.getOrderStatus()%></td>
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
							기간별 조회
							<button name="filterDate2" class="perbtn active" value="1"
								onclick="search_btn(event)">7일</button>
							<button name="filterDate2" class="perbtn" value="2"
								onclick="search_btn(event)">1개월</button>
							<button name="filterDate2" class="perbtn" value="3"
								onclick="search_btn(event)">3개월</button>
						</div>
						<div class="datebox">
							배송일자별 조회 <select class="btnbox btnbox-white" id="year2"
								name="year"></select> <select class="btnbox btnbox-white"
								id="month2" name="month"></select> <input type="button"
								class="btnbox btnbox-brown" value="조회" onclick="searchList('2', 1, 10)">
						</div>
					</div>
					

					<div class="BLS-radio" align="right"
						style="padding: 20px 0px 0px 700px;">
						<p class="txt">총 <label id="searchCount2"><%=request.getAttribute("TotalCount") %></label>건의 주문내역이 있습니다</p>
						<div class="stateS-btn" style="float: right">
							배송 조회 <input type="radio" name="status2" value="1" checked="checked">배송 중 <input
								type="radio" name="status2" value="2">배송 전 <input
								type="radio" name="status2" value="3">배송 완료 <input
								type="radio" name="status2" value="4">결제 취소
						</div>
					</div>

					<div class="btn-move" style="padding: 60px 60px 7px 55px;">
						<input type="button" class="ordersearch-btn" value="정상주문조회">
					</div>
					<div class="Storedb" style="padding: 0px 0px 5px 60px">
						날짜별 조회 <select class="btnbox btnbox-white" id="order" name="date">
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
							</tr>
						</thead>
						<tbody>
							<%
							for (StoreDetail s : stores) {
							%>
							<tr>
								<td class="book_no"><%=s.getOrderDate()%></td>
								<td class="book_no"><a class="page-link" onclick="detailListPage('2', this);" style="color: gray"><%=s.getOrderNo()%></a></td>
								<td class="book_no"><%=s.getProductNm()%></td>
								<td class="book_no"><%=s.getTotalPrice()%></td>
								<td class="book_no"><%=s.getOrderStatus()%></td>
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
			<div id="page">
				<div class="pageBar">
					<%=request.getAttribute("pageBar") %>
				</div>
			</div>
		</div>
		</div>

		</div>

	</div>
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%= contextPath %>/js/script_common.js"></script>
	<script src="<%=contextPath%>/js/yelin/detailList.js"></script>
</body>

</html>