<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<style>
.board_title {
	margin-top: 5%;
	margin-bottom: 10%;
}

.board_title strong {
	margin-left: 5%;
	font-size: 30px;
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

.board_title hr {
	margin-top: 2%;
}

#board_view hr {
	margin-bottom: 5%;
}

hr {
	width: 100%;
}

#board_view hr {
	margin-top: -8%;
}

#board_view {
	margin-bottom: 17%;
	margin-top: -7%;
	margin-left: 3%;
	font-size: 20px;
}

#board_view_theme {
	margin-left: 3%;
}

#board_view table {
	width: 100%;
}

td#board_view_posistion {
	text-align: right;
}

th#board_view_posistion1{
	text-align: left;
}
th#board_view_
</style>

<!---------------------------------------->
<title>게시글</title>
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
					<p>게시글</p>
					<hr>
				</div>
				<div id="board_view">
					<table>
						<tr>
							<th>제목</th>
							<td>많은 분들이 저를 도와줬어요</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>user01</td>
							<td id="board_view_posistion">2023.05.08</td>
							<td id="board_view_posistion">조회수 98</td>
							<td id="board_view_posistion">추천수98</td>
						</tr>
						<tr>
							<th>내용</th>
							<th id="board_view_posistion1">안녕하세요!! 많은 분들이 저를 도와줬어요!!</th>
						</tr>
					</table>
				</div>
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