<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
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
	margin-top: 2%;
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
	margin-right: 2%;
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
	margin-top: 1%;
}

input {
	border-radius: 15px;
	height: 35px;
	width: 400px;
}

select {
	border-radius: 15px;
	height: 40px;
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
	margin-left: 30%;
	margin-top: 4%;
	margin-bottom: 7%;
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
</style>
<!---------------------------------------->
<title>게시글 목록</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
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
						<hr>
						<div class="board_list">
							<div class="num">
								<button>인기글</button>
							</div>
							<div class="title">
								<a href="#">많은 분들이 저를 도와줬어요</a>
							</div>
							<div class="count">40</div>
							<div class="rec_num">98</div>
							<div class="writer">user01</div>
							<div class="date">2022.05.08</div>
						</div>
						<div class="board_list">
							<div class="num">
								<button>인기글</button>
							</div>
							<div class="title">
								<a href="#">재훈씨랑 준호가 옆에서 많이 알려줬어요</a>
							</div>
							<div class="count">34</div>
							<div class="rec_num">87</div>
							<div class="writer">조장흠1</div>
							<div class="date">2022.05.08</div>
						</div>
						<div class="board_list">
							<div class="num">
								<button>인기글</button>
							</div>
							<div class="title">
								<a href="#">바로 옆에 있으니까 즉각적인 피드백이 좋네요</a>
							</div>
							<div class="count">33</div>
							<div class="rec_num">84</div>
							<div class="writer">조장흠2</div>
							<div class="date">2022.05.08</div>
						</div>
						<div class="board_list">
							<div class="num">
								<button>인기글</button>
							</div>
							<div class="title">
								<a href="#">예린씨, 윤진씨, 나빈씨가 하신 것들도 많이 참고했어요</a>
							</div>
							<div class="count">29</div>
							<div class="rec_num">80</div>
							<div class="writer">조장흠3</div>
							<div class="date">2022.05.08</div>
						</div>
						<div class="board_list">
							<div class="num">
								<button>인기글</button>
							</div>
							<div class="title">
								<a href="#">특히 윤진씨가 하신 것에서 도움이 많이!!!!</a>
							</div>
							<div class="count">28</div>
							<div class="rec_num">64</div>
							<div class="writer">조장흠4</div>
							<div class="date">2022.05.08</div>
						</div>
						<div class="board_middle_list">
							<div class="board_list">
								<div class="num">2301</div>
								<div class="title">
									<a href="#">현영이도 엄청난 팁들과 도움을 많이 줬어요</a>
								</div>
								<div class="count">24</div>
								<div class="rec_num">62</div>
								<div class="writer">조장흠5</div>
								<div class="date">2022.05.08</div>
							</div>
							<div class="board_list">
								<div class="num">2302</div>
								<div class="title">
									<a href="#">더 이상 쓸 말이 없네요</a>
								</div>
								<div class="count">23</div>
								<div class="rec_num">59</div>
								<div class="writer">조장흠6</div>
								<div class="date">2022.05.08</div>
							</div>
							<div class="board_list">
								<div class="num">2303</div>
								<div class="title">
									<a href="#">jquery</a>
								</div>
								<div class="count">21</div>
								<div class="rec_num">53</div>
								<div class="writer">조장흠7</div>
								<div class="date">2022.05.08</div>
							</div>
							<div class="board_list">
								<div class="num">2304</div>
								<div class="title">
									<a href="#">java</a>
								</div>
								<div class="count">18</div>
								<div class="rec_num">18</div>
								<div class="writer">조장흠8</div>
								<div class="date">2022.05.08</div>
							</div>
							<div class="board_list">
								<div class="num">2305</div>
								<div class="title">
									<a href="#">oracle</a>
								</div>
								<div class="count">17</div>
								<div class="rec_num">17</div>
								<div class="writer">조장흠9</div>
								<div class="date">2022.05.08</div>
							</div>
							<div class="board_list">
								<div class="num">2306</div>
								<div class="title">
									<a href="#">javascript</a>
								</div>
								<div class="count">14</div>
								<div class="rec_num">16</div>
								<div class="writer">조장흠10</div>
								<div class="date">2022.05.08</div>
							</div>
							<div class="board_list">
								<div class="num">2307</div>
								<div class="title">
									<a href="#">servlet</a>
								</div>
								<div class="count">10</div>
								<div class="rec_num">14</div>
								<div class="writer">조장흠11</div>
								<div class="date">2022.05.08</div>
							</div>
							<div class="board_list">
								<div class="num">2308</div>
								<div class="title">
									<a href="#">HTML</a>
								</div>
								<div class="count">1</div>
								<div class="rec_num">10</div>
								<div class="writer">조장흠12</div>
								<div class="date">2022.05.08</div>
							</div>
							<hr>
						</div>
					</div>
					<div class="bt_wrap">
						<a href="#" class="on">작성</a>
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
							viewBox="0 0 30 31" fill="none"
							xmlns="http://www.w3.org/2000/svg">
                    <path
								d="M19.2625 21.7141L13.5375 15.9766L19.2625 10.2391L17.5 8.47656L10 15.9766L17.5 23.4766L19.2625 21.7141Z"
								fill="black" />
                </svg>
						<a class="page-num select">1</a> <a class="page-num">2</a> <a
							class="page-num">3</a>
						<svg class="arrow-right" width="30" height="31"
							viewBox="0 0 30 31" fill="none"
							xmlns="http://www.w3.org/2000/svg">
                    <path
								d="M10.7375 10.2391L16.4625 15.9766L10.7375 21.7141L12.5 23.4766L20 15.9766L12.5 8.47656L10.7375 10.2391Z"
								fill="black" />
                </svg>
						<svg class="double-arrow-right" width="30" height="31"
							viewBox="0 0 30 31" fill="none"
							xmlns="http://www.w3.org/2000/svg">
                    <path
								d="M8.0127 8.47656L6.2502 10.2391L11.9752 15.9766L6.2502 21.7141L8.0127 23.4766L15.5127 15.9766L8.0127 8.47656Z"
								fill="black" />
                    <path
								d="M16.25 8.47656L14.4875 10.2391L20.2125 15.9766L14.4875 21.7141L16.25 23.4766L23.75 15.9766L16.25 8.47656Z"
								fill="black" />
                </svg>

					</div>
				</div>
			</body>
    </div>
</section>
<!-----------   위에서 HTML 작업  ----------->
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
<script>

</script>
<!-------------------------------------------->
</body>
</html>