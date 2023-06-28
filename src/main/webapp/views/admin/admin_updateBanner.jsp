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
		<article class="banners-options">
			<h3 class="fw-bold">저장된 배너</h3>
			<div class="banners-wrapper">
				<ul class="banners-storage">
					<% if (banners.isEmpty()) { %>
						<li>저장된 배너가 없습니다.</li>
					<% } else { 
						for (Map.Entry<String, EventUpfile> banner : banners.entrySet()) { %>
						<li draggable="true">
		                    <div>
		                        <img src="<%= request.getContextPath() %>/upload/joonho/<%= banner.getValue().getEuRename() %>"
									rename="<%= banner.getValue().getEuRename() %>">
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
		<article class="banners-selected">
			<h3 class="fw-bold">메인 페이지용 배너</h3>
			<ul class="banners_main-container">
				<li>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
				<li>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
				<li>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
				<li>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
				<li>
					<img src='<%= contextPath %>/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
				</li>
			</ul>
		</article>
		<article class="banners-btn">
			<div>
				<input type="button" class="btn-layout btn-brown " value="저장"
						onclick="updateBanners()">
			</div>
			<div>
				<input type="button" class="btn-layout btn-white " value="닫기"
						onclick="closePage();">
			</div>
		</article>
	</section>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%= contextPath %>/js/jaehun/script_update_banners.js"></script>
</body>
</html>