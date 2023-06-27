<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stagemate.board.model.vo.Board"%>
<%
Board b = (Board) request.getAttribute("board");
%>
<%@ include file="/views/common/top.jsp"%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<style>
.board_main_theme p {
	text-align: center;
	font-size: 50px;
	margin-top: 10%;
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
	padding: 10px;
	text-align: center;
	border: 1px solid #000;
	border-radius: 15px;
	font-size: 1rem;
	margin-right: 8%;
}

a.on1 {
	font-size: 1.5rem;
	display: inline-block;
	min-width: 73px;
	padding: 10px;
	text-align: center;
	border: 1px solid #000;
	margin-bottom: 5%;
	background-color: black;
	color: white;
}

.bt_wrap {
	display: flex;
	justify-content: flex-end;
	margin-top: 1%;
	margin-right: -9%;
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
</style>

<!---------------------------------------->
<title>게시글</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<!-----------   아래에서 HTML 작업  ----------->
	<section class="min1280px">
		<div class="max1280px">
			<div class="board_main_theme">
				<p>게시글</p>
			</div>
			<hr color=#000000>
			<div class="board_theme">
				<p><%=b.getBoardTitle()%></p>
			</div>
			<div class="board_middle_theme">
				<hr style="color: #BDBDBD; border-style: dotted">
				<table>
					<tr>
						<th>작성자</th>
						<th><%=b.getBoardWriter()%></th>
						<th>작성일 </th>
						<th><%=b.getBoardDate()%></th>
						<th>조회수</th> 
						<th><%=b.getBoardViewCNT()%></th>
						<th>추천수</th> 
						<th><%=b.getBoardLikeCNT()%></th>
						<th><img id="thumbs"
							src="<%=request.getContextPath()%>/images/jangheum/thumbs.svg"></th>
					</tr>
				</table>
				<hr>
			</div>
			<div class="board_main_content">
				<p>
					서론 <br> □연구 대상이나 주제 설정의 배경이 드러나 있는가<br> □기존 연구와의 차별성이 드러나
					있는가<br> □글의 목표즉 이 글에서 답하고자 하는 연구 질문이 드러나 있는가<br> □연구의 의의가
					드러나 독자에게 글을 읽을 동기를 부여해주고있는가<br> 본론<br> □하위 주장들이 잘 구성되었는가<br>
					□각각을 뒷받침하는 근거들이 충분한가<br> □문단과 문단이 잘 연결되어 있어 독자가 그 흐름을 잘 따라갈 수
					있는가<br> 결론<br> □글의 내용을 적절하게 재진술하고 있는가<br> □연구 주제의
					의의나 시사점이 잘 드러나 있어 독자에게 중요성을 알리고 있는가<br> □연구 결과의 적용 가능성, 향후 논의의
					방향을 제안하고 있는가<br>
				</p>
			</div>
			<hr color=#000000>
			<div class="bt_wrap">
				<a href="#" class="on">신고</a> <a href="#" class="on">수정</a> <a
					href="#" class="on">삭제</a>
			</div>
			<div class="bt_list">
				<a href="http://localhost:8080/GDJ64_stagemate_semi/board/boardList.do" class="on1">목록</a>
			</div>
</body>
</section>
<!-----------   위에서 HTML 작업  ----------->
<%@ include file="/views/common/footer.jsp"%>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%=contextPath%>/js/script_common.js"></script>
<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
<script>
$("#thumbs").click(
		function(){
			$(this).attr("src","<%=request.getContextPath()%>/images/jangheum/thumbs.svg");
		},
		function(){
			$(this).attr("src","<%=request.getContextPath()%>/images/jangheum/done_thumbs.png");
					});
</script>
<!-------------------------------------------->
</body>
</html>