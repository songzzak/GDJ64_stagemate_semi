<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page import="java.util.List,com.stagemate.event.model.vo.Event"%>
<%
List<Event> events = (List) request.getAttribute("event");
String evcNo = (String) request.getAttribute("evcNo");
%>
<link rel="stylesheet"
	href="<%= contextPath %>/css/jaehun/style_admin_eventList.css">
<title>상품관리/행사</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="min1280px">
		<div id="eventManagement">
			<nav class="eventManagement-sidebar">
				<ul class="eventManagement-sidebar_big">
					<li><a href="<%=contextPath%>/admin/membermanage">회원 관리</a></li>
					<li class="link_active"><a href="">상품 관리</a>
						<ul class="eventManagement-sidebar_small">
							<li><a href="">행사</a></li>
							<li><a
								href="<%=contextPath%>/admin/selectAllProduct.do">스토어</a></li>
						</ul>
					</li>
					<li><a href="">판매 관리</a>
						<ul class="eventManagement-sidebar_small">
							<li><a href="">판매내역관리</a></li>
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
							<td><%=e.getEventStartDt() %> ~ <%=e.getEventEndDt() %></td>
							<td><%=e.getRsvOpenDt() %></td>
							<td>
								<%if(e.getEvcNo().equals("EVC1")){ %> 뮤지컬 <%}else if(e.getEvcNo().equals("EVC2")){%>
								콘서트 <%}else{ %> 연극 <%} %>
							</td>
							<td><%=e.getLocation() %></td>
							<td><%=e.getLocation()%></td>
							<td><button evn="<%= e.getEventNo() %>" class="btn-event_view">상세보기</button>
								<button>삭제</button></td>
						</tr>
						<%
					}
					}
					%>

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
						<input type="button" class="btn-layout btn-brown " value="배너변경"
								onclick="updateBanner();">
					</div>
				</div>
			</article>
		</div>
	</section>
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
	<script src="<%= contextPath %>/js/script_common.js"></script>
	<script>
		$(".btn-event_view").click(event => {
			location.assign("<%= contextPath %>/admin/updateEvent.do?no=" + $(event.target).attr("evn"));
		});

		$("input[name=eventCategory]").change(event => {
			console.log($(event.target).val());
			if ($(event.target).val() === "ALL") {
				location.replace("<%= contextPath %>/admin/eventlist");
			} else {
				location.replace("<%= contextPath %>/admin/selectEventByCategory.do?evcNo=" + $(event.target).val());
			}
		});

		function updateBanner() {
			const width = 800;
    		const height = 580;
    		const left = (window.screen.width / 2) - (width / 2);
    		const top = (window.screen.height / 2) - (height / 2);
			const url = getContextPath() + "/admin/updateBanner.do";

			window.open(url, "_blank",
						"width=" + width + ", " + 
						"height=" + height + ", " + 
						"left=" + left + ", " + 
						"top=" + top);
		}
	</script>
</body>
</html>