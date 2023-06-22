<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%-- <%@ page import="java.util.List,com.stagemate.member.model.vo.Member"%> --%>
<%-- <%
List<Member> members = (List) request.getAttribute("member");
%> --%>
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
							<li><a href="">상품 관리</a>
								<ul>
									<li><a href="">예매</a></li>
									<li><a href="<%=contextPath%>/admin/selectAllProduct.do">스토어</a></li>
								</ul></li>
							<li><a href="">판매 관리</a>
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
					<h1 id="Playmanagement_title">판매관리>예매</h1>
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
							<div class="datebox">
								예매일자별 조회 <select class="btnbox3 btnbox-white3" id="year"
									name="year"></select> <select class="btnbox3 btnbox-white3"
									id="month" name="month"></select> <input type="submit"
									class="btnbox3 btnbox-brown3" value="조회">
							</div>
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
								<tr>
									<td class="book_no">S123910481</td>
									<td class="book_no">kimdogung</td>
									<td class="book_no">010-1111-2222</td>
									<td class="book_no">2023-05-20</td>
									<td class="book_no">kimdogung@naver.com</td>
									<td class="book_no">예매완료</td>
									<td><button class="play-mg-detail" 
									onclick="SearchPlayInfo()">정보</button></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="salesDetail_store">
						<!-- 기간 조회 버튼  -->
						<div class="SM-search-btn" style="padding: 10px 0px 0px 0px;">
							<div class="datebox">
								예매일자별 조회 <select class="btnbox3 btnbox-white3" id="year"
									name="year"></select> <select class="btnbox3 btnbox-white3"
									id="month" name="month"></select> <input type="submit"
									class="btnbox3 btnbox-brown3" value="조회">
							</div>
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





					</div>

				</div>
			</div>

			<!-- 페이징바 -->
			<div class="page-bar">
				<svg class="arrow-left" width="30" height="31" viewBox="0 0 30 31"
					fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
						d="M21.9873 23.4766L23.7498 21.7141L18.0248 15.9766L23.7498 10.2391L21.9873 8.47656L14.4873 15.9766L21.9873 23.4766Z"
						fill="black" />
                <path
						d="M13.75 23.4766L15.5125 21.7141L9.7875 15.9766L15.5125 10.2391L13.75 8.47656L6.25 15.9766L13.75 23.4766Z"
						fill="black" />
            </svg>
				<svg class="double-arrow-left" width="30" height="31"
					viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
						d="M19.2625 21.7141L13.5375 15.9766L19.2625 10.2391L17.5 8.47656L10 15.9766L17.5 23.4766L19.2625 21.7141Z"
						fill="black" />
            </svg>
				<a class="page-num select">1</a> <a class="page-num">2</a> <a
					class="page-num">3</a>
				<svg class="arrow-right" width="30" height="31" viewBox="0 0 30 31"
					fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
						d="M10.7375 10.2391L16.4625 15.9766L10.7375 21.7141L12.5 23.4766L20 15.9766L12.5 8.47656L10.7375 10.2391Z"
						fill="black" />
            </svg>
				<svg class="double-arrow-right" width="30" height="31"
					viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
						d="M8.0127 8.47656L6.2502 10.2391L11.9752 15.9766L6.2502 21.7141L8.0127 23.4766L15.5127 15.9766L8.0127 8.47656Z"
						fill="black" />
                <path
						d="M16.25 8.47656L14.4875 10.2391L20.2125 15.9766L14.4875 21.7141L16.25 23.4766L23.75 15.9766L16.25 8.47656Z"
						fill="black" />
            </svg>

			</div>


		</div>

		<script>
			$(document).ready(function() {
				setDateBox();
			});
			function setDateBox() {
				var date = new Date();
				var year = date.getFullYear();

				$("#year").append("<option value=''>년도</option>");
				for (var y = 2021; y <= (year + 1); y++) {
					$("#year")
							.append(
									"<option value='"+ y +"'>" + y + " 년"
											+ "</option>");
				}

				$("#month").append("<option value=''>월</option>");
				for (var i = 1; i <= 12; i++) {
					if (String(i).length == '1') {
						$("#month").append(
								"<option value='"+"0" + i +"'>" + "0" + i + "월"
										+ "</option>");
					} else {
						$("#month").append(
								"<option value='"+ i +"'>" + i + "월"
										+ "</option>");
					}
				}
			}
		</script>




		<script>
        //상품명 검색 팝업 
   		const SearchPlayInfo=()=>{
	   		const childWindow=open("<%=request.getContextPath()%>/admin/SalesPlayInfo.do","_blank","width=1100,height=670");
   		}
	   
   		const SearchStoreInfo=()=>{
   			const childWindow=open("<%=request.getContextPath()%>/admin/SalesStoreInfo.do","_blank","width=1100,height=670");
   		}
    	</script>



		</div>
	</section>
	<!-----------   위에서 HTML 작업  ----------->
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
	<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
	<script src="<%=contextPath%>/js/yelin/salesDetail.js"></script>
	<!-------------------------------------------->
</body>
</html>