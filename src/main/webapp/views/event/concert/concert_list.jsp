<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page
	import="java.util.List,com.stagemate.event.model.vo.Event,com.stagemate.event.model.vo.EventUpfile"%>
<%
List<Event> concerts = (List) request.getAttribute("concert");
List<EventUpfile> files = (List) request.getAttribute("files");
%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<link rel="stylesheet"
	href="<%=contextPath%>/css/joonho/style_event_main.css">
<!---------------------------------------->
<title>STAGEMATE/콘서트</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<!-----------   아래에서 HTML 작업  ----------->
	<section class="min1280px">
		<div class="max1280px">
			<div id="maincontainer">
				<div id="musical">
					<h2>콘서트</h2>
					<div id="chioce_array">
						<a href="">최신등록순</a> | <a href="">인기도순</a> | <a href="">낮은가격순</a>
						| <a href="">높은가격순</a> | <a href="">리뷰많은순</a>
					</div>
					<br>
					<form id="event_search">
						<div id="event_search">
							<input id="input_search_text" type="text" placeholder="Search...">
							<div id="search_button">
								<svg width="24" height="24" viewBox="0 0 24 24" fill="none"
									xmlns="http://www.w3.org/2000/svg">
	                        <path
										d="M21.5 23.25L13.625 15.375C13 15.875 12.2812 16.2708 11.4688 16.5625C10.6562 16.8542 9.79167 17 8.875 17C6.60417 17 4.6825 16.2133 3.11 14.64C1.5375 13.0667 0.750833 11.145 0.75 8.875C0.75 6.60417 1.53667 4.6825 3.11 3.11C4.68333 1.5375 6.605 0.750833 8.875 0.75C11.1458 0.75 13.0675 1.53667 14.64 3.11C16.2125 4.68333 16.9992 6.605 17 8.875C17 9.79167 16.8542 10.6562 16.5625 11.4688C16.2708 12.2812 15.875 13 15.375 13.625L23.25 21.5L21.5 23.25ZM8.875 14.5C10.4375 14.5 11.7658 13.9529 12.86 12.8588C13.9542 11.7646 14.5008 10.4367 14.5 8.875C14.5 7.3125 13.9529 5.98417 12.8588 4.89C11.7646 3.79583 10.4367 3.24917 8.875 3.25C7.3125 3.25 5.98417 3.79708 4.89 4.89125C3.79583 5.98542 3.24917 7.31333 3.25 8.875C3.25 10.4375 3.79708 11.7658 4.89125 12.86C5.98542 13.9542 7.31333 14.5008 8.875 14.5Z"
										fill="white" />
	                    </svg>
							</div>
						</div>
					</form>
					<div id="choice">
						<div>
							<p>전체</p>
							<input type="radio" name="hobby" checked value="전체">
						</div>
						<div>
							<p>제목</p>
							<input type="radio" name="hobby" value="제목">
						</div>
						<div>
							<p>아티스트</p>
							<input type="radio" name="hobby" value="아티스트">
						</div>
						<div>
							<p>장소</p>
							<input type="radio" name="hobby" value="장소">
						</div>
					</div>
					<br> <br> <br>
					<div class="musical_content">
						<%
						if (concerts.isEmpty()) {
						%>
						<div>등록된 뮤지컬이 없습니다. 확인 후 등록 해주세요</div>
						<%
						} else {
						for (Event c : concerts) {
							for (EventUpfile u : files) {
						%>
						<%
						if ((c.getEventNo().equals(u.getEventNo())) && (u.getPurposeNo().equals("PUR1"))) {
						%> 
						<div class="musical_product">
							<img src="<%=contextPath%>/upload/joonho/<%=u.getEuRename()%>"
								width="250" height="350">
							<input type="hidden" value="<%=c.getEventNo()%>">
							<h4><%=c.getEventNm()%></h4>
							<h5><%=c.getLocation()%></h5>
							<div>
								<div class="like">
									<div>
										<object id="svgElement" type="image/svg+xml"
											data="<%=contextPath%>/images/joonho/heart.svg"></object>
									</div>
									<p>13</p>
								</div>
								<div class="like">
									<div>
										<img src="<%=contextPath%>/images/joonho/text.svg" alt="">
									</div>
									<p>21</p>
								</div>
							</div>
						</div>
						<%
						}
						%>
						<%
						}
						}
						}
						%>
					</div>
					<div id="page">
						<div class="pageBar">
							<%=request.getAttribute("pageBar")%>
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
	<script>
	$(".musical_product>img,.musical_product>h4").click(function(e) {
		  var eventNo = $(this).parent().find('input[type="hidden"]').val();
		  location.assign(getContextPath() + "/event/eventView.do?no=" + eventNo);
	});
	</script>
	<!-------------------------------------------->
</body>
</html>