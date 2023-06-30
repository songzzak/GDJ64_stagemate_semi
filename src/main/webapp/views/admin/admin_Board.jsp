<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page
	import="com.stagemate.board.model.vo.Board,
	java.util.List,com.stagemate.board.model.vo.BoardComment"%>
<%
Board b = (Board) request.getAttribute("board");
List<BoardComment> comments = (List) request.getAttribute("comments");
%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<style>

/* store_search */
#store_search {
	/* position: absolute; */
	width: 400px;
	height: 40px;
	left: 50%;
	top: 170px;
	transform: translateX(-50%);
	display: flex;
	align-items: center;
	margin-left: 265px;
	margin-top: -5%;
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

a.on {
	display: inline-block;
	min-width: 80px;
	padding: 10px;
	text-align: center;
	border: 1px solid #000;
	border-radius: 15px;
	color: red;
	margin-bottom: 5%;
}

table {
	width: 100%;
}

td {
	height: 50px;
	text-align: center;
}

#adminBoard_head_list>table tr:first-child {
	background-color: #e2e2e2;
	font-size: 25px;
}

div#adminBoard_head_list {
	margin-top: 3%;
}

.bt_wrap {
	margin-top: 15px;
	text-align: right;
	/* font-size: 0; */
	margin-right: 4%;
}

select {
	border-radius: 15px;
	height: 40px;
	border: 1px solid black;
}

.extracontainer {
	margin-left: 34.2%;
	margin-top: 1%;
}

a {
	text-decoration: none;
	color: black;
}

.page-bar {
	display: flex;
	flex-direction: row;
	/* align-items: center; */
	padding: 0px;
	gap: 50px;
	/* position: absolute; */
	width: 456px;
	/* height: 29px; */
	left: calc(50% - 456px/ 2);
	top: 1780.98px;
	margin-bottom: 5%;
	margin-left: 34%;
	margin-top: 3%;
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

table.adminBoard_head_list {
	margin-left: 5%;
}

.adminBoard_head_list th {
	border: 1px solid red;
	height: 130px;
	width: 30%;
}

table.adminBoard_head_list td {
	border: 1px solid blue;
	margin-bottom: 5%;
}

.admin_board {
	margin-top: 10%;
	margin-left: 7%;
}

div.admin_board>h3 {
	font-size: 30px;
	margin-left: 27%;
}

td#adminBoard_middle_theme {
	text-align: left;
}

input {
	height: 20px;
}
</style>

<!---------------------------------------->
<title>게시글 신고조회 및 처리</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<!-----------   아래에서 HTML 작업  ----------->
	<section class="min1280px">
		<div class="max1280px">

			<body>
				<div class="admin_board">
					<h3>게시글 신고조회 및 처리</h3>
				</div>
				<br>
				<hr>
				<div id="adminBoard_head_list">
					<table>
						<tr>
							<th></th>
							<th>글번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>작성날짜</th>
						</tr>
						<tr>
							<td><input type="checkbox" name="check" value="선택"></td>
							<td>59</td>
							<td id="adminBoard_middle_theme"> 토트백(화이트) 디자인 진짜 이쁘네요!!</td>
							<td>testuser51</td>
							<td>2023-06-26</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="check" value="선택"></td>
							<td>58</td>
							<td id="adminBoard_middle_theme"> 빈센트 반고흐 나노블럭은 신이다!!</td>
							<td>testuser56</td>
							<td>2023-06-26</td>
						</tr>
						
					</table>
					<hr>
				</div>
				<div class="bt_wrap">
  					<a href="#" class="on" onclick="deleteSelected()">삭제</a>
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
	function deleteSelected() {
		  // 체크된 체크박스 가져오기
		  var checkboxes = document.getElementsByName("check");
		  var selectedItems = [];

		  for (var i = 0; i < checkboxes.length; i++) {
		    if (checkboxes[i].checked) {
		      // 선택된 체크박스의 값을 배열에 추가
		      selectedItems.push(checkboxes[i].value);
		    }
		  }

		  // 선택된 게시물 삭제
		  for (var j = 0; j < selectedItems.length; j++) {
		    var itemValue = selectedItems[j];
		    // 여기서 삭제할 로직을 작성하세요. 예를 들어, AJAX 요청을 보내거나 서버로부터 해당 게시물을 삭제하는 등의 로직을 구현합니다.
		    // 이 예시에서는 단순히 선택된 항목을 제거합니다.
		    var itemRow = document.querySelector("td[value='" + itemValue + "']").parentNode;
		    itemRow.parentNode.removeChild(itemRow);
		  }
		}

	</script>
	<!-------------------------------------------->
</body>
</html>