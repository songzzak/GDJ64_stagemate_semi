<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/ReviewList.css">
 <%@ page import="java.util.List,com.stagemate.review.model.vo.ReviewPlay" %>  
  <%@ page import="java.util.List,com.stagemate.review.model.vo.ReviewStore" %> 
<title>STAGEMATE</title>
</head>
<body>
<% //reviewPlay 정보 가져와야 한다. 
   List<ReviewPlay> reviewPlay = (List)request.getAttribute("ReviewPlay");
%>
<%  
   List<ReviewStore> reviewStore = (List)request.getAttribute("ReviewStore");
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
						<% for (ReviewPlay r: reviewPlay) {%>
							<tr>
								<td class="book_no"><%= r.getEventNm() %></td>
								<td class="book_no"><%= r.getErvConTent() %></td>
								<td class="book_no"><%= r.getErvDate() %></td>
								<td class="book_no"><%= r.getRsvDate()%></td>
							</tr>
						<% }%>
						</tbody>
					</table>

					<!-- <input type="button" class="write_Playreview" value="리뷰 작성"> -->
					<button class="write_Playreview" onclick="reviewWritePage('1');">리뷰작성</button>

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
							<% for (ReviewStore r: reviewStore) {%>
							<tr>
								<td class="book_no"><%= r.getProductNm() %></td>
								<td class="book_no"><%= r.getReviewContent() %></td>
								<td class="book_no"><%= r.getReviewDate() %></td>
								<td class="book_no"><%= r.getOrderDate() %></td>
							</tr>
							<% }%>
						</tbody>
					</table>
			
					<button class="write_Storereview" onclick="reviewWritePage('2');">리뷰작성</button>
				</div>
			</div>
		<!-- 페이징바 -->
		<div id="page">
			<div class="pageBar">
				<%=request.getAttribute("pageBar") %>
			</div>
		</div>

	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%=contextPath%>/js/yelin/ReviewList.js"></script>
</html>