<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<style>
.board_title {
	margin-top: 5%;
	margin-bottom: 10%;
}

.board_title hr {
	width: 100%;
	/* text-align: right; */
	margin-left: 5%;
}

.board_title strong {
	margin-left: 5%;
	font-size: 30px;
}
/* text-align: right; */
margin-left
:
5%;
}
.board_title strong {
	margin-left: 5%;
	font-size: 35px;
}

p {
	margin-top: 2%;
	margin-left: 5%;
	font-size: 35px;
}
hr{
	margin-top: 2%;
}
table{
	width: 100%;
	border: 1px black;
}
</style>

<!---------------------------------------->
<title>게시글 작성</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<!-----------   아래에서 HTML 작업  ----------->
	<section class="min1280px">
		<div class="max1280px">
			<body>
				<div class="board_title">
					<strong>STAGEMATE</strong>
					<hr>
					<p>게시글 작성</p>
				</div>
				<div id="boardwrite">
					<table>
						<tr>
							<th>제목</th>
							<th>작성중...</th>
						</tr>
						<tr>
							<th>파일첨부</th>
							<th></th>
						</tr>
						<tr>
							<th>내용</th>
							<th>작성작성</th>
						</tr>
					</table>
				</div>
			</body>
		</div>
	</section>
	<!-----------   위에서 HTML 작업  ----------->
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
	<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->

	<!-------------------------------------------->
</body>
</html>