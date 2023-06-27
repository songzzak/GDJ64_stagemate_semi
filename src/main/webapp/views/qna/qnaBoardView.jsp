<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.stagemate.qna.model.vo.Qna"%>
<%
	Qna q= (Qna)request.getAttribute("qna");
%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>


<section class="min1280px">
	<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
	<style>
.board_main_theme p {
	text-align: center;
	font-size: 50px;
	margin-top: 8%;
	margin-bottom: 6%;
}

hr {
	margin-top: 2%;
}

.board_theme p {
	margin-top: 2%;
	font-size: 35px;
}

table {
	width: 60%;
	text-align: left;
	margin-top: 2%;
}

p {
	margin-top: 3%;
}

button#btn-list {
	margin-top: 3%;
	background-color: brown;
	color: white;
	width: 85px;
	height: 42px;
}

.bt_wrap a.on {
	display: inline-block;
	min-width: 60px;
	padding: 5px;
	text-align: center;
	border: 1px solid #B5B5B5;
	border-radius: 10px;
	font-size: 1rem;
	margin-right: 3%;
}

a.on1 {
	font-size: 1.5rem;
	display: inline-block;
	min-width: 73px;
	padding: 10px;
	text-align: center;
	border: 1px solid #B5B5B5;
	margin-bottom: 5%;
	background-color: black;
	color: white;
}

.board_middle_theme tr th {
	font-color: #5151;
}

.board_middle_theme tr th {
	font-color: #5151;
}

.bt_wrap {
	display: flex;
	justify-content: flex-end;
	margin-top: 1.5%;
	margin-right: -3%;
}

.bt_list {
	display: flex;
	justify-content: center;
	margin-top: 4%;
}

a {
	text-decoration: none;
	color: black;
}

.bt_wrap a.on1 {
	color: white;
}

.bt_list a.on1 {
	margin-top: 8%
}
</style>

	<!---------------------------------------->
	<title><strong>게시글</strong></title>
	</head>
	<body>

		<!-----------   아래에서 HTML 작업  ----------->
		<section class="min1280px">
			<div class="max1280px">
				<div class="board_main_theme">
					<p>1:1문의 게시판</p>
				</div>
				<hr color=#000000>
				<div class="board_theme">
					<th>제목</th>
					<td><%=q.getInquiryTitle() %>
						</table>
				</div>
				<div class="board_middle_theme">
					<hr style="color: #BDBDBD; border-style: dotted">
					<table>
						<tr>
							<th>작성자</th>
							<td><%=q.getWriterId() %></td>
							<th>작성일</th>
							<td><%=q.getInquiryInsertDt()%></td>
							<!-- 	<th> 조회수</th> -->
							<td><%= %>
						</tr>
					</table>

					<hr>
				</div>
				<div class="board_main_content">
					<table>
						<tr>
							<th>내용</th>
							<td><%=q.getInquiryContent()%></td>
						</tr>
					</table>
				</div>
				


				<hr color=#000000>
				<div class="bt_wrap">
					<!--  필요시 신고 -->
					<a href="#" class="on">신고</a> <a href="#" class="on">수정</a> <a
						href="#" class="on">삭제</a>
				</div>


				<
				<!--댓글창 구현 공간 입니다  -->

				<div class="bt_list">
					<a href="#" class="on1">목록</a>
				</div>
	</body>
</section>

<%@ include file="/views/common/footer.jsp"%>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>


</body>
</html>