<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page import="java.util.List,com.stagemate.event.model.vo.Event"%>
<%
List<Event> events = (List) request.getAttribute("event");
%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<link rel="stylesheet"
	href="<%= contextPath %>/css/joonho/style_admin_eventrmanage.css">
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
							<li><a href="<%=contextPath%>/admin/membermanage"
								class="select_nav_admin">회원 관리</a></li>
							<li><a href="<%=contextPath%>/admin/eventlist">상품 관리</a>
								<ul>
									<li><a href="<%=contextPath%>/admin/eventlist">예매</a></li>
									<li><a href="<%=contextPath%>/admin/selectAllProduct.do">스토어</a></li>
								</ul></li>
							<li><a href="">판매 관리</a>
								<ul>
									<li><a href="">판매내역관리</a></li>
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
				<!-- 회원검색창 -->
				<div id="memberManage">
					<nav class="insertEvent-title">
						<p>상품관리</p>
						<div>
							<img src="<%=contextPath %>/images/yoonjin/button/arrow.svg"
								alt="">
						</div>
						<p>행사</p>
					</nav>
					<hr>
					<div>
						<div id="choice">
							<div>
								<p>전체</p>
								<input type="radio" name="hobby" checked value="전체">
							</div>
							<div>
								<p>뮤지컬</p>
								<input type="radio" name="hobby" value="뮤지컬">
							</div>
							<div>
								<p>콘서트</p>
								<input type="radio" name="hobby" value="콘서트">
							</div>
							<div>
								<p>연극</p>
								<input type="radio" name="hobby" value="연극">
							</div>
						</div>
						<div>
							
						</div>
					</div>
					<!-- 회원테이블 -->
					<table id="admin_membermanage_table">
						<thead>
							<tr>
								<th>공연명</th>
								<th>공연기간</th>
								<th>예매오픈일</th>
								<th>카테고리</th>
								<th>공연장소</th>
								<th>배너이미지</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
						if (events.isEmpty()) {%>
							<tr>
								<td colspan="8">등록된 행사가 없습니다.</td>
							</tr>
							<%} else {
							for (Event e : events) {
						%>
							<tr>
								<td><%=e.getEventNm() %></td>
								<td><%=e.getEventStartDt() %>~<%=e.getEventEndDt() %></td>
								<td><%=e.getRsvOpenDt() %></td>
								<td>
									<%if(e.getEvcNo().equals("EVC1")){ %> 뮤지컬 <%}else if(e.getEvcNo().equals("EVC2")){%>
									콘서트 <%}else{ %> 연극 <%} %>
								</td>
								<td><%=e.getLocation() %></td>
								<td><%=e.getLocation()%></td>
								<td><button>상세보기</button>
									<button>삭제</button></td>
							</tr>
							<%
						}
						}
						%>

						</tbody>
					</table>
					<br> <br>
					<!-- 강제탈퇴 버튼 -->
					<div id="withdrawal">
						<input type="button" class="btn-layout btn-brown " value="상품등록">
						<input type="button" class="btn-layout btn-brown " value="배너변경">
					</div>
					<div id="page">
						<div class="pageBar">
							<%=request.getAttribute("pageBar") %>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-----------   위에서 HTML 작업  ----------->
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
	<script src="<%= contextPath %>/js/script_common.js"></script>
	<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->

	<!-------------------------------------------->
</body>
</html>