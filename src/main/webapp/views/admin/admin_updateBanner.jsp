<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.stagemate.event.model.vo.EventUpfile" %>
<%
	final String contextPath = request.getContextPath();
	
	Object bannersUncast = request.getAttribute("banners");
	Map<String, EventUpfile> banners = new HashMap<>();
	
	if (bannersUncast != null && bannersUncast instanceof HashMap<?, ?>) {
		for (Map.Entry<?, ?> banner : ((Map<?, ?>) bannersUncast).entrySet()) {
			banners.put(String.valueOf(banner.getKey()), EventUpfile.class.cast(banner.getValue()));
		}
	}		
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%= contextPath %>/images/common/favicon-32x32.png" type="image/x-icon">
<link rel="stylesheet" href="<%= contextPath %>/css/style_init.css">
<link rel="stylesheet" href="<%= contextPath %>/css/jaehun/style_update_banners.css">
<title>배너변경</title>
</head>
<body>
	<section class="banners_update">
		<article class="banners_update-options">
			<h2 class="fw-bold">저장된 배너</h2>
			<div class="banners_update-wrapper">
				<ul class="banners_update-lineup">
					<% if (banners.isEmpty()) { %>
						<li>저장된 배너가 없습니다.</li>
					<% } else { 
						for (Map.Entry<String, EventUpfile> banner : banners.entrySet()) { %>
						<li>
		                    <div>
		                        <img src="<%= request.getContextPath() %>/upload/joonho/<%= banner.getValue().getEuRename() %>">
		                    </div>
		                    <h5 class="fw-bold"><%= banner.getKey() %></h5>
		                    <input name="euNo" type="hidden" value="<%= banner.getValue().getEuNo() %>">
		                    <input name="eventNo" type="hidden" value="<%= banner.getValue().getEventNo() %>"></input>
                		</li>
					<% }
					} %>
				</ul>
			</div>
		</article>
		<article class="banners_update-selected">
			<h2 class="fw-bold">메인 페이지용 배너</h2>
			<ul class="banners_update-lineup_main">
				<li>
					<div class="number-order"><span>1</span></div>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
				<li>
					<div class="number-order"><span>2</span></div>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
				<li>
					<div class="number-order"><span>3</span></div>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
				<li>
					<div class="number-order"><span>4</span></div>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
				<li>
					<div class="number-order"><span>5</span></div>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
			</ul>
		</article>
		<article class="banners_update-btn">
			<div>
				<input type="button" class="btn-layout btn-brown " value="저장"
						onclick="alert('테스트')">
			</div>
			<div>
				<input type="button" class="btn-layout btn-white " value="닫기"
						onclick="closePopupBanners();">
			</div>
		</article>
	</section>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%= contextPath %>/js/jaehun/script_update_banners.js"></script>
</body>
</html>