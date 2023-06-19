<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/ReviewList.css">
 <%@ page import="java.util.List,com.stagemate.review.model.vo.ReviewPlay" %>  
<title>STAGEMATE</title>
</head>
<body>
<% //reviewPlay 정보 가져와야 한다. 
   List<ReviewPlay> reviews = (List)request.getAttribute("ReviewList");
%>
	<%@ include file="/views/common/header.jsp"%>
	<section class="min1280px">
		<div class="ReviewList_bigchart">
			<h1 id="ReviewList_title">나의 리뷰</h1>
			<div class="division-line"></div>
			<p class="review-txt">
				내가 작성한 리뷰를 확인할 수 있습니다.<br> 평가와 무관한 글은 관리자에 의하여 사전 통보 없이 삭제될 수
				있습니다.
			</p>


				<ul class="btnsBox" style="padding: 30px 0pc 0px 0px;">
					<li><button class="BLbtn active" id="ps_play_btn"
							onclick="change_btn(event)">예매</button></li>
					<li><button class="BLbtn" id="ps_store_btn"
							onclick="change_btn(event)">스토어</button></li>
				</ul>


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





				<div class="ReviewList_play">
					<table class="PlayReview_List">
						<colgroup>
							<col style="width: 260px">
							<col style="width: 450px">
							<col style="width: 160px">
							<col style="width: 160px">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">제품명</th>
								<th scope="col">한줄평</th>
								<th scope="col">작성일</th>
								<th scope="col">예매일</th>
							</tr>
						</thead>
						<tbody>
						<% for (ReviewPlay r: reviews) {%>
							<tr>
								<td class="book_no"><%= r.getEventName() %></td>
								<td class="book_no"><%= r.getRpContent() %></td>
								<td class="book_no"><%= r.getRpDate() %></td>
								<td class="book_no"><%= r.getWatchDt()%></td>
							</tr>
							<% }%>
						</tbody>
					</table>

					<!-- <input type="button" class="write_Playreview" value="리뷰 작성"> -->
					<button class="write_Playreview" onclick="location.assign('<%=request.getContextPath()%>/Review/ReviewWritePlay.do')">리뷰작성</button>

				</div>

				<div class="ReviewList_store">
					<table class="StoreReview_List">
						<colgroup>
							<col style="width: 260px">
							<col style="width: 450px">
							<col style="width: 160px">
							<col style="width: 160px">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">예매명</th>
								<th scope="col">한줄평</th>
								<th scope="col">작성일</th>
								<th scope="col">구매일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="book_no">[셰퍼드 페어리 행동하라!]아크릴 마그넷_S.F</td>
								<td class="book_no">너무예쁘다 이러쿵저러쿵</td>
								<td class="book_no">2023-04-27</td>
								<td class="book_no">2023-04-20</td>
							</tr>
							
				

						</tbody>
					</table>

					<!-- <input type="button" class="write_Storereview" value="리뷰 작성"> -->
					
					<button class="write_Storereview" onclick="location.assign('<%=request.getContextPath()%>/notice/insertForm.do')">리뷰작성</button>
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

	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%=contextPath%>/js/yelin/ReviewList.js"></script>
</html>