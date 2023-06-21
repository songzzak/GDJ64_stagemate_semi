<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/play/style_ReviewWrite_play.css">
<title>STAGEMATE</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>

	<section class="min1280px">
		<div id="sectionContainer" class="max1280px">
			<div class="ReviewWritePlay_bigchart">
				<h1 id="ReviewWritePlay_title">리뷰 작성>예매</h1>
				<div class="division-line"></div>
				<p class="review-txt2">관람 후기</p>
				<p class="review-txt">게시판 운영규정에 맞지 않는 글은 사전 통보없이 삭제될 수 있습니다.</p>
<%-- 				<form action="<%=request.getContextPath()%>/notice/WriteReviewPlay.do"
					method="post" enctype="multipart/form-data"></form> --%>



					<div class="RB-biggroup">
						<div class="book_txtbox">
							<div class="book_txtbox2">
								<p>상품명</p>
								<p style="margin-top: 20px;">관람일시</p>
								<p style="margin-top: 20px;">반응</p>
							</div>
						</div>

						<div class="RB_btngroup">
							<div class="RB_searchbtn">
								<input type="text" id="RD_txt">
								<button onclick="SearchPlayTitle();">검색</button>
							</div>
							<div class="RB_info" style="margin-top: 20px">
								<div>
									<p id='result'>
									</p>
								</div>

							</div>
							<div class="RB-reac-rate">
								<input type="radio" name="emoticon" id="smile-emo"
									class="emo-radio" value=""> <label for="smile-emo">
									<img src="<%=contextPath%>/images/yelin/smile.png"
									style="width: 25px; height: 25px;" alt="">
								</label> <input type="radio" name="emoticon" id="wow-emo"
									class="emo-radio" value=""> <label for="wow-emo">
									<img src="<%=contextPath%>/images/yelin/wow.png"
									style="width: 25px; height: 25px;" alt="">
								</label> <input type="radio" name="emoticon" id="sad-emo"
									class="emo-radio" value=""> <label for="sad-emo">
									<img src="<%=contextPath%>/images/yelin/sad.png"
									style="width: 25px; height: 25px;" alt="">
								</label><input type="radio" name="emoticon" id="bad-emo"
									class="emo-radio" value=""> <label for="bad-emo">
									<img src="<%=contextPath%>/images/yelin/bad.png"
									style="width: 25px; height: 25px;" alt="">
								</label><input type="radio" name="emoticon" id="none-emo"
									class="emo-radio" value=""> <label for="none-emo">
									<img src="<%=contextPath%>/images/yelin/none.png"
									style="width: 25px; height: 25px;" alt="">
								</label>
							</div>
						</div>
					</div>
					<textarea class="RB-textarea" cols="100" rows="9" maxlength="300"
						placeholder="관람후기를 남겨보세요!" style="resize: none;"></textarea>

					<div class="RD_util_right">
						<div class="RD-txtgroup">
							<span class="current_length" style="font-weight: 500">0</span> <span
								class="limit_length" style="font-weight: 350;">/300</span>
						</div>
					</div>
					<div class="RD-list-box">
						<button type="button" class="RD-list-btn" onclick="location.assign('<%=request.getContextPath()%>/Review/ReviewListServlet.do')">목록</button>
						<button type="submit" class="RD-comment-btn">등록</button>
					</div>
			</div>
		</div>
	


		<script>
        //상품명 검색창 
   		const SearchPlayTitle=()=>{
	   		const childWindow=open("<%=request.getContextPath()%>/Review/SearchTitle.do","_blank","width=650,height=300");
   		}
	   
   
    </script>



	</section>
	<%@ include file="/views/common/footer.jsp"%>
</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%=contextPath%>/js/yelin/play/ReviewWrite_play.js"></script>
</html>