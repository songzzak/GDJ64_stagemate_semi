<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/store/style_ReviewWrite_store.css">
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%=contextPath%>/js/yelin/ReviewList.js"></script>
<script src="<%=contextPath%>/js/yelin/play/ReviewWrite_play.js"></script>
<title>STAGEMATE</title>
</head>
<script>
var productNo = '';
$(document).ready(function() {
	  $('#fileInput').click(function() {
         $(this).prop("value", "");
         $(this).one(
            'change',
            function () {
               console.log("fnImportFile");
               selectFile = null;
               selectFile = document.getElementById("fileInput");

               if (selectFile.files == undefined) {
                   alert("파일 확인 바랍니다.");
                     return true;
               } else if (selectFile.files != undefined && selectFile.files != null && selectFile.files != "") {
            	   $('#RS_filename').val(selectFile.files[0].name);
               }
             }
         ); 
	  });
});

function sendData(arr){
	orderNo = arr[0];
	$('#RS_txt').val(arr[1]);
}
</script>
<body>
<%@ include file="/views/common/header.jsp"%>
<section class="min1280px">
	<div class="ReviewWriteStore_bigchart">
		<h1 id="ReviewWriteStore_title">리뷰 작성>스토어</h1>
		<div class="division-line"></div>
		<p class="review-txt2">상품 후기</p>
		<p class="review-txt">게시판 운영규정에 맞지 않는 글은 사전 통보없이 삭제될 수 있습니다.</p>
			<div class="RS-biggroup">
				<div class="parchase_txtbox">
					<div class="parchase_txtbox2">
						<p>상품명</p>
						<p style="margin-top: 20px;">첨부파일</p>
						<p style="margin-top: 20px;">반응</p>
					</div>
				</div>

				<div class="RS_btngroup">
					<div class="RS_searchbtn">
						<input type="text" id="RS_txt">
						<button onclick="searchPlayTitle();">검색</button>
					</div>
					<div class="RS_attach">
						<input type="file" id="fileInput" style="display:none">
						<input type="text" id="RS_filename" readonly>
						<input type="button" id="RS-attachbtn" onclick='$("#fileInput").click()' value="파일 등록">
					</div>
					<div class="RB-reac-rate">
							<input type="radio" name="emoticon" id="smile-emo"
								class="emo-radio" value="1"> <label for="smile-emo">
								<img src="<%= contextPath %>/images/yelin/smile.png"
								style="width: 25px; height: 25px;" alt="">
							</label> <input type="radio" name="emoticon" id="wow-emo"
								class="emo-radio" value="2"> <label for="wow-emo">
								<img src="<%=contextPath %>/images/yelin/wow.png"
								style="width: 25px; height: 25px;" alt="">
							</label> <input type="radio" name="emoticon" id="sad-emo"
								class="emo-radio" value="3"> <label for="sad-emo">
								<img src="<%=contextPath %>/images/yelin/sad.png"
								style="width: 25px; height: 25px;" alt="">
							</label><input type="radio" name="emoticon" id="bad-emo"
								class="emo-radio" value="4"> <label for="bad-emo">
								<img src="<%=contextPath %>/images/yelin/bad.png"
								style="width: 25px; height: 25px;" alt="">
							</label><input type="radio" name="emoticon" id="none-emo"
								class="emo-radio" value="5"> <label for="none-emo">
								<img src="<%=contextPath %>/images/yelin/none.png"
								style="width: 25px; height: 25px;" alt="">
							</label> 
						</div>
				</div>
			</div>
			<textarea class="RS-textarea" cols="100" rows="9" maxlength="300"
				style="resize: none;"></textarea>
			<!-- 
			<div class="RS_util_right">
				<div class="RS-txtgroup">
					<span class="current_length" style="font-weight: 500">0</span> <span
						class="limit_length" style="font-weight: 350;">/300</span>
				</div>
			</div>
			-->
			<div class="RS-list-box">
				<button type="button" class="RS-list-btn">목록</button>
				<button type="button" class="RS-comment-btn" onclick="revieWriteStore();">등록</button>
			</div>
		</div>
	</div>
	</section>
		<script>
        //상품명 검색 팝업 
   		const searchPlayTitle=()=>{
	   		const childWindow=open("<%=request.getContextPath()%>/Review/ReviewWritePlay_Title?type=2","_blank","width=650,height=600");
	   		/*$(childWindow).on('popupValueSelected', function(event, value) {
	   			if (value.length > 0) {
	   				$('#result').text('상품명: ' + value[1]);
	   				productNo = value[3];
	   			}
          	});*/
   		}
	   
    	</script>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>