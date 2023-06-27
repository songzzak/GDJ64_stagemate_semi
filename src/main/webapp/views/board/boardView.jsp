<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.stagemate.board.model.vo.Board,
java.util.List,com.stagemate.board.model.vo.BoardComment"%>
<%
Board b = (Board) request.getAttribute("board");
List<BoardComment> comments = (List) request.getAttribute("comments");
%>
<%@ include file="/views/common/top.jsp"%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<style>
div#comment-container button#btn-insert {
	width: 60px;
	height: 50px;
	color: white;
	background-color: #3300FF;
	position: relative;
	top: -20px;
}

section#board_container {
	width: 600px;
	margin: 0 auto;
	text-align: center;
}

section#board_container h2 {
	margin: 10px 0;
}

table#tbl_board {
	width: 500px;
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
	clear: both;
}

table#tbl_board th {
	width: 125px;
	border: 1px solid;
	padding: 5px 0;
	text-align: center;
}

table#tbl_board td {
	border: 1px solid;
	padding: 5px 0 5px 10px;
	text-align: left;
}

div#comment_container button#btn_insert {
	width: 60px;
	height: 50px;
	color: white;
	background-color: brown;
	position: relative;
	top: -20px;
}
/*댓글테이블*/
table#tbl_comment {
	width: 580px;
	margin: 0 auto;
	border-collapse: collapse;
	clear: both;
}

table#tbl_comment tr td {
	border-bottom: 1px solid;
	border-top: 1px solid;
	padding: 5px;
	text-align: left;
	line-height: 120%;
}

table#tbl_comment tr td:first-of-type {
	padding: 5px 5px 5px 50px;
}

table#tbl_comment tr td:last-of-type {
	text-align: right;
	width: 100px;
}

table#tbl_comment button.btn_reply {
	display: none;
}

table#tbl_comment button.btn_delete {
	display: none;
}

table#tbl_comment button.btn_update {
	display: none;
}

table#tbl_comment tr:hover {
	background: lightgray;
}

table#tbl_comment tr:hover button.btn_reply {
	display: inline;
}

table#tbl_comment tr:hover button.btn_delete {
	display: inline;
}

table#tbl_comment tr:hover button.btn_update {
	display: inline;
}

table#tbl_comment tr.level2 {
	color: gray;
	font-size: 14px;
}

table#tbl_comment sub.comment_writer {
	color: orange;
	font-size: 14px;
}

table#tbl_comment sub.comment_date {
	color: blue;
	font-size: 10px
}

table#tbl_comment tr.level2 td:first-of-type {
	padding-left: 100px;
}

table#tbl_comment tr.level2 sub.comment_writer {
	color: #8e8eff;
	font-size: 14px
}

table#tbl-comment tr.level2 sub.comment_date {
	color: #ff9c8a;
	font-size: 10px
}
/*답글관련*/
table#tbl_comment textarea {
	margin: 4px 0 0 0;
}

table#tbl_comment button.btn_insert2 {
	width: 60px;
	height: 23px;
	color: white;
	background: #3300ff;
	position: relative;
	top: -5px;
	left: 10px;
}

textarea {
	margin-left: 30%;
}

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
						<th>작성일</th>
						<th><%=b.getBoardDate()%></th>
						<th>조회수</th>
						<th><%=b.getBoardViewCNT()%></th>
						<th>추천수</th>
						<th><%=b.getBoardLikeCNT()%></th>
						<th><img style="width: 20; height: 20px;" id="thumbs"
							src="<%=request.getContextPath()%>/images/jangheum/thumbs.svg"></th>
					</tr>
				</table>
				<hr>
			</div>
			<div class="board_main_content">
				<p><%=b.getBoardContent()%></p>
			</div>
			<div>
				<hr color=#000000>
				<div class="bt_wrap">
					<a href="#" class="on">신고</a> <a href="#" class="on">수정</a> <a
						href="<%=request.getContextPath()%>/board/boardDelete.do"
						class="on">삭제</a>
				</div>
				<div class="bt_list">
					<a href="<%=request.getContextPath()%>/board/boardList.do"
						class="on1">목록</a>
				</div>
				<div id="comment_container">
					<div class="comment_editor">
						<form
							action="<%=request.getContextPath()%>/board/insertComment.do?boardRef=<%=b.getBoardNo()%>"
							method="post">
							<textarea name="cmtContent" cols="55" rows="3"></textarea>
							<input type="hidden" name="boardRef" value="<%=b.getBoardNo()%>">
							<input type="hidden" name="level" value="1"> <input
								type="hidden" name="cmtWriter"
								value="<%=loginMember != null ? loginMember.getMemberId() : ""%>">
							<input type="hidden" name="cmtRef" value="0">
							<button type="submit" id="btn_insert">등록</button>
						</form>
					</div>
				</div>
				<table id="tbl_comment">
					<%
					if (comments != null) {
						for (BoardComment bc : comments) {
							if (bc.getLevel() == 1) {
					%>
					<tr class="level1">
						<td><sub class="comment_writer"><%=bc.getCmtWriter()%></sub>
							<sub class="comment_date"><%=bc.getCmtDate()%></sub> <br> <%=bc.getCmtContent()%>
						</td>
						<td>
							<%
							if (loginMember != null) {
							%>
							<button class="btn_reply" value="<%=bc.getCmtNo()%>">답글</button>
							<button class="btn_delete">삭제</button> 
							<%
 							}
							 %>
						</td>
					</tr>
					<%
					} else {
					%>
					<tr class="level2">
						<td><sub class="comment_writer"><%=bc.getCmtWriter()%></sub>
							<sub class="comment_date"><%=bc.getCmtDate()%></sub> <br> <%=bc.getCmtContent()%>
						</td>
						<td></td>
					</tr>
					<%
					}
					}
					%>
					<%
					}
					%>
				</table>
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
					
	$("#comment_container textarea[name=cmtContent]").click(e=>{
		if(<%=loginMember == null%>){
			alert("로그인 후 이용할 수 있습니다.");
			$("#memberId").focus();
			e.preventDefault();
		}
	});
	$(".btn_reply").click(e=>{
        const tr=$("<tr>");
        const td=$("<td>").attr("colspan","2");
        const cmtRef=$(e.target).val();
        const form=$(".comment_editor>form").clone();
        form.find("textarea").attr("rows","1");
        form.find("input[name=level]").val("2");
        form.find("input[name=cmtRef]").val(cmtRef);
        td.css("display","none");
        td.append(form);
        tr.append(td);
        
     });
</script>
<!-------------------------------------------->
</body>
</html>