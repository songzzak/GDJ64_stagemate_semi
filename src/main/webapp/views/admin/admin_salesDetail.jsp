<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page import="java.util.List,com.stagemate.admin.model.vo.PlayInfo"%>
<%
List<PlayInfo> playInfos = (List) request.getAttribute("playinfo");
%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<link rel="stylesheet"
	href="<%=contextPath%>/css/joonho/style_admin_membermanage.css">
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/style_sales_detail.css">
<!---------------------------------------->
<title>STAGEMATE/회원관리</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<!-----------   아래에서 HTML 작업  ----------->
	<section class="min1280px">
		<div class="max1280px">
			<div id="maincontainer">
				<!-- 관리자 사이드메뉴 -->
				<div id="store_admin_nav">
					<nav>
						<ul id="store_admin_nav_ul">
							<li><a href="<%=contextPath%>/admin/membermanage" class="select_nav_admin">회원 관리</a></li>
							<li><a href="<%=contextPath%>/admin/eventlist">상품 관리</a>
								<ul>
									<li><a href="<%=contextPath%>/admin/eventlist">행사</a></li>
									<li><a href="<%=contextPath%>/admin/selectAllProduct.do">스토어</a></li>
								</ul></li>
							<li><a href="<%=contextPath%>/admin/SalesDetail.do">판매 관리</a>
								<ul>
									<li><a href="<%=contextPath%>/admin/SalesDetail.do">판매내역관리</a></li>
									<li><a href="">결제 취소 요청</a></li>
									<li><a href="">반품/교환 관리</a></li>
								</ul></li>
							<li><a href="">커뮤니티 관리</a>
								<ul>
									<li><a href="">게시판 관리</a></li>
									<li><a href="">신고 관리</a></li>
								</ul></li>
							<li><a href="">고객센터</a>
								<ul>
									<li><a href="">공지사항 관리</a></li>
									<li><a href="">1:1문의 관리</a></li>
								</ul></li>
						</ul>
					</nav>
				</div>

				<!-- 예매/스토어 검색 창-->
				<div class="Playmanagement_title_bigchart">
					<h1 id="Playmanagement_title">판매내역관리</h1>
					<div class="division-line"></div>

					<!-- 예매/스토어 버튼 -->
					<div class="SM-click" id="SM-click"
						style="padding: 5px 0pc 0px 0px;">
						<input type="button" class="SM-btn1 active" id="Play-btn" onclick="change_btn(event)" value="예매"><input
							type="button" class="SM-btn1" id="Store-btn" onclick="change_btn(event)" value="스토어">
					</div>
					<script>
						function change_btn(e) {
							var btns = document.querySelectorAll(".SM-btn1");
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





					<!-- 예매 구간 -->
					<div class="salesDetail_play">
						<!-- 기간 조회 버튼  -->
						<div class="SM-search-btn" style="padding: 10px 0px 0px 0px;">
						</div>
						<!-- 아이디/예매번호로 검색 -->
						<div class="SM-idsearch-btn" style="padding: 10px 0px 0px 0px;">
							<select name="btnbox3 btnbox-white3" id="idsearch"
								name="idsearch">
								<option value="아이디 검색">아이디</option>
								<option value="예매번호 검색">예매번호 검색</option>
							</select> <input type="text" class="idsearch-txt"> <input
								type="submit" class="idsearch-submit" value="조회">
						</div>

						<!-- 판매관리 테이블 -->
						<table class="PlayManagement_List">
							<colgroup>
								<col style="width: 200px">
								<col style="width: 200px">
								<col style="width: 400px">
								<col style="width: 300px">
								<col style="width: 300px">
								<col style="width: 200px">
								<col style="width: 160px">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">예매번호</th>
									<th scope="col">아이디</th>
									<th scope="col">휴대폰</th>
									<th scope="col">예매일시</th>
									<th scope="col">이메일</th>
									<th scope="col"><select name="PM-select" id="PM-select"
										style="background-color: #1C0808; color: white; border-style: none";>
											<option value="예매전체">예매전체</option>
											<option value="예매완료">예매완료</option>
											<option value="예매취소">예매취소</option>
									</select></th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
		                     <%
		                     for (PlayInfo p : playInfos) {
		                     %>
								<tr>
									<td class="book_no"><%=p.getRsvNo()%></td>
									<td class="book_no"><%=p.getMemberId()%></td>
									<td class="book_no"><%=p.getMemberPhone()%></td>
									<td class="book_no"><%=p.getRsvDate()%></td>
									<td class="book_no"><%=p.getMemberEmail()%></td>
									<td class="book_no"><%=p.getOrderStatus()%></td>
									<td><button class="play-mg-detail" 
									onclick="SearchPlayInfo('<%=p.getMemberId()%>')">정보</button></td>
								</tr>
								<%} %>
							</tbody>
						</table>
						<div id="page">
							<div class="pageBar">
								<%=request.getAttribute("pageBar") %>
							</div>
						</div>
					</div>

					<div class="salesDetail_store">
						<!-- 기간 조회 버튼  -->
						<div class="SM-search-btn" style="padding: 10px 0px 0px 0px;">
						</div>
						<!-- 아이디/예매번호로 검색 -->
						<div class="SM-idsearch-btn3" style="padding: 10px 3px 0px 0px;">
							<select name="btnbox3 btnbox-white3" id="idsearch"
								name="idsearch">
								<option value="아이디 검색">아이디</option>
								<option value="예매번호 검색">주문일자별 검색</option>
							</select> <input type="text" class="idsearch-txt"> <input
								type="submit" class="idsearch-submit" value="조회">
						</div>


						<!-- 판매관리 테이블 -->
						<table class="StoreManagement_List">
							<colgroup>
								<col style="width: 200px">
								<col style="width: 200px">
								<col style="width: 400px">
								<col style="width: 300px">
								<col style="width: 300px">
								<col style="width: 200px">
								<col style="width: 160px">

							</colgroup>
							<thead>
								<tr>
									<th scope="col">주문번호</th>
									<th scope="col">아이디</th>
									<th scope="col">휴대폰</th>
									<th scope="col">주문일시</th>
									<th scope="col">이메일</th>
									<th scope="col"><select name="PM-select" id="PM-select"
										style="background-color: #1C0808; color: white; border-style: none";>
											<option value="배송전체">배송전체</option>
											<option value="배송중">배송중</option>
											<option value="배송완료">배송완료</option>
									</select></th>
									<th scope="col"></th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="book_no">S123910325</td>
									<td class="book_no">kimdodo</td>
									<td class="book_no">010-3333-2222</td>
									<td class="book_no">2023-06-11</td>
									<td class="book_no">kimdodo@daum.com</td>
									<td class="book_no">배송중</td>
									<td><button class="play-mg-detail" onclick="SearchStoreInfo();">정보</button></td>
								</tr>
							</tbody>
						</table>


						<div id="page">
							<div class="pageBar">
								<%=request.getAttribute("pageBar") %>
							</div>
						</div>


					</div>

				</div>
			</div>

			

		</div>






		<script>
        //상품명 검색 팝업 
   		const SearchPlayInfo=(userId)=>{
	   		const childWindow=open("<%=request.getContextPath()%>/admin/SalesPlayInfo.do?userId="+userId,"_blank","width=1100,height=640");
   		}
	   
   		const SearchStoreInfo=()=>{
   			const childWindow=open("<%=request.getContextPath()%>/admin/SalesStoreInfo.do","_blank","width=1100,height=670");
   		}
    	</script>



	</section>
	<!-----------   위에서 HTML 작업  ----------->
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
	<script src="<%=contextPath%>/js/yelin/salesDetail.js"></script>
	<!-------------------------------------------->
</body>
</html>