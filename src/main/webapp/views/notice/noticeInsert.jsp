<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/notice_insert.css">
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/notice.css">
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/media.css">
	

<section class="min1280px">
	<div id="sectionContainer" class="max1280px">

		<body>
			<div class="notice_wrap">
				<div class="notice_title">
					<span> 고객센터 </span>>> <span>공지사항</span>
				</div>
				<div class="notice_insert_wrap">
					<div class="notice_insert">
						<form action="<%=request.getContextPath() %>/notice/insertNotice.do" method="post" enctype="multipart/form-data">
							<table id="tbl-notice">
								<tr>
									<th>제 목</th>
									<td><input type="text" name="noticeTitle" required></td>
								</tr>
								<tr>
									<th>작성자</th>
									<td><input type="text" name="noticeWriter"
									value="<%=loginMember.getMemberId()%>" readonly></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td><input type="file" name="upFile"></td>
								</tr>
								<tr>
									<th>내 용</th>
									<td><textarea cols="42" rows="5" name="noticeContent"></textarea></td>
								</tr>
								<tr>
									<th colspan="2"><input type="submit" value="등록하기"
										onclick=""></th>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</body>


		<%@ include file="/views/common/footer.jsp"%>
		<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
		<script src="<%= contextPath %>/js/script_common.js"></script>