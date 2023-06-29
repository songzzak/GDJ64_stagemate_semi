<%@page import="com.stagemate.review.model.vo.StoreReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/ReviewList.css">
<link rel="stylesheet" href="<%=contextPath%>/css/yoonjin/style_mypage_nav.css">
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
	<div class="maincontainer">
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
							<li class="li1"><a href="#">내 정보 관리</a></li>
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
		<div class="ReviewList_bigchart">
			<h1 id="ReviewList_title">나의 리뷰</h1>
			<div class="division-line"></div>
			<p class="review-txt">
				내가 작성한 리뷰를 확인할 수 있습니다.<br> 평가와 무관한 글은 관리자에 의하여 사전 통보 없이 삭제될 수
				있습니다.
			</p>
				<ul class="btnsBox" style="padding: 30px 0pc 0px 0px;">
					<li><button class="BLbtn active" id="ps_play_btn" onclick="change_btn(event)">예매</button></li>
					<li><button class="BLbtn" id="ps_store_btn" onclick="change_btn(event)">스토어</button></li>
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
	</div>
	</section>
	<%@ include file="/views/common/footer.jsp"%>
</body>
<<<<<<< HEAD
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%=contextPath%>/js/yelin/ReviewList.js"></script>
</html>