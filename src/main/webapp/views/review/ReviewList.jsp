<%@page import="com.stagemate.review.model.vo.StoreReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/ReviewList.css">
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
 <%@ page import="java.util.List,com.stagemate.review.model.vo.EventReview" %>  
<title>STAGEMATE</title>
</head>
<body>
<%
//reviewPlay 정보 가져와야 한다. 
   	List<EventReview> reviews = (List)request.getAttribute("ReviewList");
	List<StoreReview> storeReviews = (List)request.getAttribute("storeReview");
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
					<li><button class="BLbtn" id="ps_play_btn">예매</button></li>
					<li><button class="BLbtn" id="ps_store_btn">스토어</button></li>
				</ul>
				
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
								<th scope="col"><%=reviews!=null?"공연명":"상품명"%></th>
								<th scope="col">한줄평</th>
								<th scope="col">작성일</th>
								<th scope="col"><%=reviews!=null?"예매일":"구매일"%></th>
							</tr>
						</thead>
						<tbody>
						<%if(reviews!=null){ 
							for (EventReview r: reviews) {%>
								<tr>
								<td class="book_no"></td>
								<td class="book_no"></td>
								<td class="book_no"></td>
								<td class="book_no"></td>
							</tr>
							<button class="write_Playreview" onclick="location.assign('<%=request.getContextPath()%>/Review/ReviewWritePlay.do')">리뷰작성</button>
							
							<%}
						}else{
							for (StoreReview r: storeReviews) {%>
							<tr>
								<td class="book_no"><%= r.getReviewProduct().getProductNm() %></td>
								<td class="book_no"><%= r.getReviewContent() %></td>
								<td class="book_no"><%= r.getReviewDt() %></td>
								<td class="book_no"></td>
							</tr>
							
							<% }
							}%>
						</tbody>
					</table>

					<!-- <input type="button" class="write_Playreview" value="리뷰 작성"> -->
					<button class="write_Playreview" onclick="location.assign('<%=request.getContextPath()%>/Review/ReviewWritePlay.do')">리뷰작성</button>

				</div>





		<!-- 페이징바 -->
		<div class="page-bar">
			<%=request.getAttribute("pageBar") %>
		</div>

	</section>
	<script>
		$(()=>{
			if(<%=reviews!=null%>){
				$("#ps_play_btn").addClass("active");
			}else{
				$("#ps_store_btn").addClass("active");
			}
		})
	</script>
	<%@ include file="/views/common/footer.jsp"%>
</body>

<script src="<%=contextPath%>/js/yelin/ReviewList.js"></script>
</html>