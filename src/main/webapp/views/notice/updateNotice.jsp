<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.stagemate.notice.model.vo.Notice, java.util.List"%>
<%
Notice n = (Notice) request.getAttribute("notice");
%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=contextPath %>/css/nabin/notice_view.css">


<section class="min1280px">
	<form action="<%=request.getContextPath()%>/notice/updateNoticeEnd.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
		<div class="max1280px">
			<div class="board_main_theme">
				<p>공지사항 수정</p>
			</div>
			<hr color=#000000>
				<div class="board_theme">

				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="noticeTitle"
							value="<%=n.getNoticeTitle()%>"></td>
					</tr>
					</table>
					</div>
					<div class="board_middle_theme">
					<hr style="color: #BDBDBD; border-style: dotted">
					<table>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="noticeWriter"
							value="<%=n.getNoticeWriter()%>"></td>
							<tr>
						<th>첨부파일</th>
						<td><input type="file" name="upfile"></td>
					</tr>
					</table>
					<hr>
					</div>
					<div class="board_main_content">
					<table>
					<tr>
						<th>내 용</th>
						<td><textarea cols="42" rows="5" name="noticeContent"><%=n.getNoticeContent()%></textarea></td>
					</tr>
					</table>
					</div>
					<hr color=#000000>
					<div class="bt_wrap">
						<button type="submit">저장하기</button>
					</div>
			</div>
	</form>
</section>


<%@ include file="/views/common/footer.jsp"%>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%=contextPath%>/js/script_common.js"></script>