<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<body>
	<section class="min1280px">
		<div id="sectionContainer" class="max1280px">
			<div class="board_title">
				<strong>STAGEMATE</strong>
				<hr>
				<p>게시글 작성</p>
			</div>
			<div class="board_write">
				<table>
					<tr>
						<th>제목</th>
						<th>작성중...</th>
					</tr>
					<tr>
						<td>파일첨부</td>
						<td><button>내 PC</button></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>작성</td>
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>

<style>
table{
	border-collapse: collapse;
}
table tr th, td{
	border:1px solid gray;
	text-align: center;
	text-align: center;
	padding: 5px;
	font-size: 100px;
	
	
}
.board_title {
	margin-top: 5%;
	margin-bottom: 10%;
}

.board_title hr {
	width: 96%;
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
</style>
<%@ include file="/views/common/footer.jsp"%>