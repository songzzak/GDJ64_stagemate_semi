<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<body>
	<section class="min1280px">
		<div id="sectionContainer" class="max1280px">
			<div class="board_wrap">
				<h3>댓글 신고조회 및 처리</h3>
				<br>
				<hr>
				<div class="board_list_theme">
					<div class="board_list">
						<div class="top"></div>
						<div class="num b">글번호</div>
						<div class="title b">제목</div>
						<div class="writer b">작성자</div>
						<div class="date b">작성일자</div>
					</div>
				</div>
				<div class="board_list">
					<input type="checkbox" name="check" value="선택">
					<div class="admin_num">101</div>
					<div class="test10">
						<div class="admin_title">
							<a href="#">바보</a>
						</div>
					</div>
					<div class="com_test">
						<div class="com_writer">조장흠5</div>
					</div>
					<div class="com_date10">
						<div class="com_date">2022.05.08</div>
					</div>
					<br>
				</div>
				<hr>
				<div class="board_list">
					<input type="checkbox" name="check" value="선택"></label>
					<div class="admin_num">102</div>
					<div class="test11">
						<div class="admin_title">
							<a href="#">멍충이</a>
						</div>
					</div>
					<div class="com_test1">
						<div class="com_writer1">조장흠6</div>
					</div>
					<div class="com_date10">
						<div class="com_date">2022.05.08</div>
					</div>
					<br>
				</div>
				<hr>
				<div class="board_list">
					<input type="checkbox" name="check" value="선택"></label>
					<div class="admin_num">103</div>
					<div class="test10">
						<div class="admin_title">
							<a href="#">해삼</a>
						</div>
					</div>
					<div class="com_test3">
						<div class="com_writer2">조장흠7</div>
					</div>
					<div class="com_date10">
						<div class="com_date">2022.05.08</div>
					</div>
					<br>
				</div>
				<hr>
				<div class="board_list">
					<input type="checkbox" name="check" value="선택"></label>
					<div class="admin_num">104</div>
					<div class="test10">
						<div class="admin_title">
							<a href="#">멍게</a>
						</div>
					</div>
					<div class="com_test3">
						<div class="com_writer3">조장흠8</div>
					</div>
					<div class="com_date10">
						<div class="com_date">2022.05.08</div>
					</div>
					<br>
				</div>
				<hr>
				<div class="board_list">
					<input type="checkbox" name="check" value="선택"></label>
					<div class="admin_num">105</div>
					<div class="test10">
						<div class="admin_title">
							<a href="#">똥개</a>
						</div>
					</div>
					<div class="com_test3">
						<div class="com_writer4">조장흠9</div>
					</div>
					<div class="com_date10">
						<div class="com_date">2022.05.08</div>
					</div>
					<br>
				</div>
				<hr>
				<div class="board_list">
					<input type="checkbox" name="check" value="선택"></label>
					<div class="admin_num">106</div>
					<div class="test12">
						<div class="admin_title">
							<a href="#">나는 재훈씨보다 자바를 잘한다</a>
						</div>
					</div>
					<div class="com_test5">
						<div class="com_writer5">조장흠10</div>
					</div>
					<div class="com_date11">
						<div class="com_date">2022.05.08</div>
					</div>
					<br>
				</div>
				<hr>
				<div class="bt_wrap">
					<a href="#" class="on">삭제</a>
				</div>
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
							<input id="input_search_text" type="text" placeholder="Search...">
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
				<svg class="arrow-left" width="30" height="31" viewBox="0 0 30 31"
					fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
						d="M21.9873 23.4766L23.7498 21.7141L18.0248 15.9766L23.7498 10.2391L21.9873 8.47656L14.4873 15.9766L21.9873 23.4766Z"
						fill="black" />
                    <path
						d="M13.75 23.4766L15.5125 21.7141L9.7875 15.9766L15.5125 10.2391L13.75 8.47656L6.25 15.9766L13.75 23.4766Z"
						fill="black" />
                </svg>
				<svg class="double-arrow-left" width="30" height="31"
					viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
						d="M19.2625 21.7141L13.5375 15.9766L19.2625 10.2391L17.5 8.47656L10 15.9766L17.5 23.4766L19.2625 21.7141Z"
						fill="black" />
                </svg>
				<a class="page-num select">1</a> <a class="page-num">2</a> <a
					class="page-num">3</a>
				<svg class="arrow-right" width="30" height="31" viewBox="0 0 30 31"
					fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
						d="M10.7375 10.2391L16.4625 15.9766L10.7375 21.7141L12.5 23.4766L20 15.9766L12.5 8.47656L10.7375 10.2391Z"
						fill="black" />
                </svg>
				<svg class="double-arrow-right" width="30" height="31"
					viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
						d="M8.0127 8.47656L6.2502 10.2391L11.9752 15.9766L6.2502 21.7141L8.0127 23.4766L15.5127 15.9766L8.0127 8.47656Z"
						fill="black" />
                    <path
						d="M16.25 8.47656L14.4875 10.2391L20.2125 15.9766L14.4875 21.7141L16.25 23.4766L23.75 15.9766L16.25 8.47656Z"
						fill="black" />
                </svg>

			</div>

		</div>
	</section>
</body>
</html>
<style>
.extracontainer {
	margin-left: 34.2%;
	margin-top: 2%;
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
	margin-top: 5%;
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
	margin-left: 32.1%;
	margin-top: -4.5%;
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
	margin-bottom: 1%;
}

select {
	border-radius: 15px;
	height: 40px;
}
/*comment */
.board_list {
	margin-bottom: 0;
}

.board_list .title {
	width: 43%;
	margin-top: 0.3%;
	font-size: 20px;
}

.board_list .writer {
	text-align: center;
	width: 10%;
	margin-left: 3.2%;
	margin-top: 0.3%;
	font-size: 20px;
}

.board_list .date {
	text-align: center;
	width: 10%;
	margin-right: 5px;
	margin-top: 0.3%;
	font-size: 20px;
}

h3 {
	font-size: 30px;
	margin-top: 8%;
	margin-left: 7%;
}

.board_list_theme {
	background-color: #e2e2e2;
	height: 35px;
}

div.bt_wrap a {
	color: red;
	text-decoration: none;
}

.main_line>hr {
	color: black;
}

hr {
	border-top: 2px solid #e2e2e2;
}

.com_date10 {
	text-align: end;
	margin-left: 5.9%;
}

.com_date11 {
	text-align: end;
	margin-left: 5.2%;
}

.com_test {
	text-align: end;
	margin-left: 57.9%;
}

.com_test1 {
	text-align: end;
	margin-left: 56.8%;
}

.com_test2 {
	text-align: end;
	margin-left: 57.9%;
}

.com_test3 {
	text-align: end;
	margin-left: 57.9%;
}

.com_test5 {
	text-align: end;
	margin-left: 42.8%;
}

.test10 {
	text-align: end;
	margin-left: 5.2%;
}

.test11 {
	text-align: end;
	margin-left: 5%;
}

.test12 {
	text-align: end;
	margin-left: 5.1%;
}

div.board_list {
	display: flex;
	margin-top: 2%;
}

div.num.b {
	margin-left: 5.5%;
	margin-top: 0.3%;
	font-size: 20px;
}

div.title.b {
	margin-left: 15%;
}

div.date.b {
	margin-left: 20px;
}

div.admin_num {
	margin-left: 3.3%;
}

input {
	border-radius: 15px;
	height: 20px;
	width: 40px;
	margin-bottom: 1%;
}

.bt_wrap a.on {
	display: inline-block;
	min-width: 80px;
	padding: 10px;
	text-align: center;
	border: 1px solid #000;
	border-radius: 15px;
}

.bt_wrap {
	margin-top: 15px;
	text-align: right;
	/* font-size: 0; */
	margin-right: 4%;
}
</style>
<%@ include file="/views/common/footer.jsp"%>