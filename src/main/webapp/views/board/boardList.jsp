<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page import="java.util.List,com.stagemate.board.model.vo.Board"%>
<%
List<Board> boards = (List<Board>) request.getAttribute("board");
%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<style>

.board_head_list {
	margin-left: -0.2%;
}

.board_middle_list {
	margin-left: 0.8%;
}

* {
	margin: 0;
	padding: 0;
}

html {
	font-size: 10px;
}

ui, li {
	list-style: none;
}

a {
	text-decoration: none;
	color: inherit;
}

.board_wrap {
	width: 1000px;
	margin: 100px auto;
}

.board_title {
	margin-bottom: 30px;
}

.board_title strong {
	font-size: 2rem;
}

.board_title p {
	font-size: 3rem;
	margin-top: 40px;
}

.bt_wrap {
	margin-top: -6%;
	text-align: right;
	font-size: 0;
}

.bt_wrap a.on {
	display: inline-block;
	min-width: 80px;
	padding: 10px;
	text-align: center;
	border: 1px solid #000;
	border-radius: 15px;
	font-size: 1.5rem;
	margin-right: 8%;
}

.board_list {
	margin-top: 1%;
	margin-bottom: 2%;
	width: 100%;
}

.board_list>div {
	display: inline-block;
	font-size: 1.5rem;
}

hr {
	border-top: 2px solid #000;
}

.a {
	color: gray;
	font-size: 20px !important;
}

div.num>button {
	border-radius: 15px;
	height: 20px;
	min-width: 53px;
	background-color: white;
}

div.num {
	margin-left: 1%;
}

.board_list .num {
	width: 10%;
	margin-left: 2%;
}

.board_list .title {
	width: 43%;
}

.board_list .top .title {
	text-align: center;
}

.board_list .count {
	text-align: center;
	width: 10%;
}

.board_list .rec_num {
	text-align: center;
	width: 10%;
}

.board_list .writer {
	text-align: center;
	width: 10%;
	margin-left: 2%;
}

.board_list .date {
	text-align: center;
	width: 10%;
	margin-right: 5px;
}

.board_page {
	text-align: center;
	margin-top: 30px;
	font-size: 0;
}

.board_page a {
	display: inline-block;
	width: 32px;
	height: 32px;
	box-sizing: border-box;
	vertical-align: middle;
	border: 1px solid #ddd;
	border-left: 0;
	line-height: 100%;
}

.board_page a.bt {
	padding-top: 10px;
	font-size: 1.2rem;
	letter-spacing: -1px;
}

.board_page a.num {
	padding-top: 9px;
	font-size: 1.4rem;
}

.board_page a.num.on {
	/*  border-color: #000;*/
	background-color: #000;
	color: #fff
}

.board_page a:first-child {
	border-left: 1px solid #ddd;
}

.extracontainer {
	display: flex;
	justify-content: center;
	margin-top: 2%;
	margin-right: 8%;
}

input {
	border-radius: 15px;
	height: 35px;
	width: 400px;
}

select {
	border-radius: 15px;
	height: 40px;
	border: 1px solid black;
}

.search {
	width: 100%;
	height: 25px;
}

#store_search {
	width: 400px;
	height: 40px;
	left: 50%;
	top: 170px;
	transform: translateX(-50%);
	display: flex;
	align-items: center;
	margin-left: 66%;
	margin-top: -9.7%;
}

/* input_search_text */
#input_search_text {
	box-sizing: border-box;
	flex: 1;
	height: 40px;
	background: #FFFFFF;
	border: 1px solid #1C0808;
	border-radius: 20px 0 0 20px;
	padding: 0 10px;
	font-family: 'Inter';
	font-style: normal;
	font-weight: 300;
	font-size: 20px;
	line-height: 24px;
	color: #828282;
	position: relative;
	z-index: -1;
}

/* search_button */
#search_button {
	width: 40px;
	height: 40px;
	background: #1C0808;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 50%;
	cursor: pointer;
	margin-left: -20px;
}

.page-bar {
	display: flex;
	flex-direction: row;
	align-items: flex-start;
	padding: 0px;
	gap: 50px;
	width: 456px;
	height: 29px;
	/* left: calc(50% - 456px/2); */
	/* top: 1760.98px; */
	margin-left: 35%;
	margin-top: 4%;
	margin-bottom: 10%;
}

.page-num {
	width: 13px;
	height: 29px;
	font-family: 'Inter';
	font-style: normal;
	font-weight: 400;
	font-size: 20px;
	line-height: 24px;
	display: flex;
	align-items: center;
	text-align: center;
	color: #828282;
}
span {
    font-size: 25px;
}
</style>
<!---------------------------------------->
<title>게시글 목록</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<!-----------   아래에서 HTML 작업  ----------->
	<section class="min1280px">
		<div class="max1280px">
			<body>
				<div class="board_wrap">
					<div class="board_title">
						<strong>STAGEMATE</strong>
						<hr>

						<p>게시글목록</p>
					</div>
					<div class="board_list_wrap">
						<div class="board_head_list">
							<div class="board_list">
								<div class="top"></div>
								<div class="num a">글번호</div>
								<div class="title a">제목</div>
								<div class="count a">조회수</div>
								<div class="rec_num a">추천수</div>
								<div class="writer a">작성자</div>
								<div class="date a">작성일자</div>
							</div>
						</div>
						<%
						if (boards.isEmpty()) {
						%>
						<tr>
							<td colspan="6">조회된 데이터가 없습니다</td>
						</tr>
						<%
						} else {%>
						<hr>
						<% for (Board b : boards) {
						%>
						<div class="board_list">
							<div class="num">
								<button>인기글</button>
							</div>
							<div class="title">
								<a href="#"><%=b.getBoardTitle()%></a>
							</div>
							<div class="count"><%=b.getBoardViewCNT()%></div>
							<div class="rec_num"><%=b.getBoardLikeCNT()%></div>
							<div class="writer"><%=b.getBoardWriter()%></div>
							<div class="date"><%=b.getBoardDate()%></div>
						</div>
						<%
						}%>
						<hr>
					</div>
					<% }
						%>


				</div>
				<div class="bt_wrap">
					<a href="#" onclick="window.open('boardWrite.jsp')" class="on">작성</a>
				</div>
				<div class="extracontainer">
					<form action="">
						<select name="searchKeyword" id="">
							<option value="title">제목</option>
							<option value="writer">작성자</option>
							<option value="content">내용</option>
						</select>
						<div>
							<div id="store_search">
								<input id="input_search_text" type="text"
									placeholder="Search...">
								<div id="search_button">
									<svg width="24" height="24" viewBox="0 0 24 24" fill="none"
										xmlns="http://www.w3.org/2000/svg">
                        <path
											d="M21.5 23.25L13.625 15.375C13 15.875 12.2812 16.2708 11.4688 16.5625C10.6562 16.8542 9.79167 17 8.875 17C6.60417 17 4.6825 16.2133 3.11 14.64C1.5375 13.0667 0.750833 11.145 0.75 8.875C0.75 6.60417 1.53667 4.6825 3.11 3.11C4.68333 1.5375 6.605 0.750833 8.875 0.75C11.1458 0.75 13.0675 1.53667 14.64 3.11C16.2125 4.68333 16.9992 6.605 17 8.875C17 9.79167 16.8542 10.6562 16.5625 11.4688C16.2708 12.2812 15.875 13 15.375 13.625L23.25 21.5L21.5 23.25ZM8.875 14.5C10.4375 14.5 11.7658 13.9529 12.86 12.8588C13.9542 11.7646 14.5008 10.4367 14.5 8.875C14.5 7.3125 13.9529 5.98417 12.8588 4.89C11.7646 3.79583 10.4367 3.24917 8.875 3.25C7.3125 3.25 5.98417 3.79708 4.89 4.89125C3.79583 5.98542 3.24917 7.31333 3.25 8.875C3.25 10.4375 3.79708 11.7658 4.89125 12.86C5.98542 13.9542 7.31333 14.5008 8.875 14.5Z"
											fill="white" />
                    </svg>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="page-bar">
					<%=request.getAttribute("pageBar")%>
					
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
<script>
	
</script>
<!-------------------------------------------->
</body>
</html>