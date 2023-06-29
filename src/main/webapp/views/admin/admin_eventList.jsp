<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page import="java.util.List, java.util.ArrayList, com.stagemate.event.model.vo.Event"%>
<%
	Object eventsUncast = request.getAttribute("event");

	String evcNo = (String) request.getAttribute("evcNo");
	String[] category = { "뮤지컬", "콘서트", "연극" };
	
	List<Event> events = new ArrayList<>();
	if (eventsUncast != null && eventsUncast instanceof ArrayList<?>) {
		for (Object eventUncast : (List<?>) eventsUncast) {
			events.add(Event.class.cast(eventUncast));
		}
	}
%>
<link rel="stylesheet"
	href="<%= contextPath %>/css/jaehun/style_admin_eventList.css">
<title>상품관리/행사</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="loading-bg">
		<article class="loading-container">
			<div class="loading-content">
				<img src="<%= contextPath %>/images/jaehun/main_page/loading_poster.gif">
			</div>
		</article>
	</section>
	<section class="min1280px">
		<div id="eventManagement">
			<nav class="eventManagement-sidebar">
				<ul class="eventManagement-sidebar_big">
					<li><a href="<%= contextPath %>/admin/membermanage">회원 관리</a></li>
					<li class="link_active"><a href="<%=contextPath%>/admin/eventlist">상품 관리</a>
						<ul class="eventManagement-sidebar_small">
							<li><a href="<%=contextPath%>/admin/eventlist">행사</a></li>
							<li><a
								href="<%= contextPath %>/admin/selectAllProduct.do">스토어</a></li>
						</ul>
					</li>
					<li><a href="<%=contextPath%>/admin/SalesDetail.do">판매 관리</a>
						<ul class="eventManagement-sidebar_small">
							<li><a href="<%= contextPath %>/admin/SalesDetail.do">판매내역관리</a></li>
							<li><a href="">결제 취소 요청</a></li>
							<li><a href="">반품/교환 관리</a></li>
						</ul>
					</li>
					<li><a href="">커뮤니티 관리</a>
						<ul class="eventManagement-sidebar_small">
							<li><a href="">게시판 관리</a></li>
							<li><a href="">신고 관리</a></li>
						</ul>
					</li>
					<li><a href="">고객센터</a>
						<ul class="eventManagement-sidebar_small">
							<li><a href="">공지사항 관리</a></li>
							<li><a href="">1:1문의 관리</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			<article class="eventManagement-content">
				<div class="eventManagement-title">
					<p>상품관리</p>
					<div>
						<img src="<%=contextPath %>/images/jaehun/page_insert_event/arrow.svg" alt="">
					</div>
					<p>행사</p>
				</div>
				<hr>
				<div class="event-category em-box">
					<fieldset>
						<label>
							<span>전체</span>
							<input type="radio" name="eventCategory" value="ALL"
							<%= (evcNo == null || (evcNo != null && evcNo.equals("ALL"))) ? "checked" : "" %>>
						</label>
						<label>
							<span>뮤지컬</span>
							<input type="radio" name="eventCategory" value="EVC1"
							<%= evcNo != null && evcNo.equals("EVC1") ? "checked" : "" %>>
						</label>
						<label>
							<span>콘서트</span>
							<input type="radio" name="eventCategory" value="EVC2"
							<%= evcNo != null && evcNo.equals("EVC2") ? "checked" : "" %>>
						</label>
						<label>
							<span>연극</span>
							<input type="radio" name="eventCategory" value="EVC3"
							<%= evcNo != null && evcNo.equals("EVC3") ? "checked" : "" %>>
						</label>
					</fieldset>
				</div>
				<table class="table-event" id="admin_membermanage_table">
					<thead>
						<tr>
							<th>공연명</th>
							<th>공연기간</th>
							<th>예매오픈일</th>
							<th>카테고리</th>
							<th>공연장소</th>
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
						for (Event event : events) {
					%>
						<tr>
							<td><%= event.getEventNm() %></td>
							<td><%= event.getEventStartDt() %> ~ <%= event.getEventEndDt() %></td>
							<td><%= event.getRsvOpenDt() %></td>
							<td>
								<%= category[Integer.parseInt(event.getEvcNo().substring(3)) - 1] %>
							</td>
							<td><%= event.getLocation() %></td>
							<td>
								<input type="hidden" value="<%= event.getEventNo() %>">
								<button class="btn-event_view">상세보기</button>
								<button class="btn-event_delete">삭제</button>
							</td>
						</tr>
						<%
						}
					} %>
					</tbody>
				</table>
				<div class="pageBar">
					<%=request.getAttribute("pageBar") %>
				</div>
				<div class="event-lower">
					<div>
						<input type="button" id="insertEvent" class="btn-layout btn-brown " value="행사등록"
								onclick='location.assign("<%= contextPath %>/admin/insertEvent.do")'>
					</div>
					<div>
						<input type="button" id="bannerLink" class="btn-layout btn-brown " value="배너변경">
					</div>
				</div>
			</article>
		</div>
	</section>
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
	<script src="<%= contextPath %>/js/script_common.js"></script>
	<script src="<%= contextPath %>/js/jaehun/script_eventList.js"></script>
</body>
</html>