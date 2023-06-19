<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<link rel="stylesheet"
	href="<%=contextPath%>/css/joonho/style_event.css">
<!---------------------------------------->
<title>페이지 타이틀 입력</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<!-----------   아래에서 HTML 작업  ----------->
	<section class="min1280px">
		<div class="max1280px">
			<div id="seat_title">
				<h2>좌석 선택</h2>
				<h3>></h3>
				<h2>결제</h2>
				<h3>></h3>
				<h2>완료</h2>
			</div>
			<hr>
			<div id="seat_main">
				<div id="first_seat">
					<div>
						<h4>1F</h4>
						<h2>STAGE</h2>
						<div id="seatMap">
							<!-- 좌석 표시를 위한 공간 -->
						</div>
						<div id="wheelchair_seat">
							<div>
								<div>
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
								</div>
								<div>
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
									<img src="<%= contextPath %>/images/joonho/wheelchair.png">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div></div>
		</div>
	</section>
	<!-----------   위에서 HTML 작업  ----------->
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
	<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
	<script>
	 $(document).ready(function () {
         // 좌석 맵 배열
         var seatMap = [
             [1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
             [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
             [1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
             [1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1],
             [1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
             [1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1],
             [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1]
         ];

         // 선택한 좌석 변수
         var selectedSeat = null;

         // 좌석 맵 생성
         var seatMapElement = $("#seatMap");
            for (var i = 0; i < seatMap.length; i++) {
                var rowElement = $("<div>").addClass("row");
                for (var j = 0; j < seatMap[i].length; j++) {
                    var seatClass = seatMap[i][j] === 1 ? "seat" : "seat unavailable";
                    var seatElement = $("<div>").addClass(seatClass)
                    if((i==0||i==1)&&!seatElement.hasClass("unavailable")){
                    	if(i==0&&(j==2||j==14)){
                    		seatElement.css({"backgroundColor":"var(--sm-brown)","color":"white","fontSize":"120%"}).text("A")
                    		.addClass("unavailable");
                    	}else if(i==1&&(j==2||j==14)){
                    		seatElement.css({"backgroundColor":"var(--sm-brown)","color":"white","fontSize":"120%"}).text("B")
                    		.addClass("unavailable");
                    	}else{
                    		seatElement.css({"backgroundColor":"#CE3500"});
                    	}
                    }else if((i==2||i==3)&&!seatElement.hasClass("unavailable")){
                    	if(i==2&&(j==4||j==16)){
                    		seatElement.css({"backgroundColor":"var(--sm-brown)","color":"white","fontSize":"120%"}).text("C")
                    		.addClass("unavailable");
                    	}else if(i==3&&(j==4||j==16)){
                    		seatElement.css({"backgroundColor":"var(--sm-brown)","color":"white","fontSize":"120%"}).text("D")
                    		.addClass("unavailable");
                    	}else{
                    		seatElement.css({"backgroundColor":"#9900C9"});
                    	}
                    }else if((i==4||i==5||i==6)&&!seatElement.hasClass("unavailable")){
                    	if(i==4&&(j==4||j==16)){
                    		seatElement.css({"backgroundColor":"var(--sm-brown)","color":"white","fontSize":"120%"}).text("E")
                    		.addClass("unavailable");
                    	}else if(i==5&&(j==4||j==16)){
                    		seatElement.css({"backgroundColor":"var(--sm-brown)","color":"white","fontSize":"120%"}).text("F")
                    		.addClass("unavailable");
                    	}else if(i==6&&(j==4||j==16)){
                    		seatElement.css({"backgroundColor":"var(--sm-brown)","color":"white","fontSize":"120%"}).text("G")
                    		.addClass("unavailable");
                    	}else{
                    		seatElement.css({"backgroundColor":"#00CCCC"});
                    	}
                    }	
                    seatElement.on("click", function () {
                        selectSeat($(this));
                    });
                    rowElement.append(seatElement);
                }
                seatMapElement.append(rowElement);
            }


         // 좌석 선택 시 동작
         function selectSeat(seat) {
             if (seat.hasClass("seat")) {
                  if (seat.hasClass("selected")) {
                     seat.removeClass("selected");
                     seat.html("");
                 }else{
                 	seat.addClass("selected");
                 	seat.text("v");
                 }
                 selectedSeat = seat;
                 $("#selectedSeat").text(seat.text());
             }
         }
	 });
	</script>
	<style>
	#wheelchair_seat{
		display:flex;
		width:80%;
	}
	#seat_main{
		display:flex;
	    justify-content: center;
	    margin-top: 5%;
		
	}
#seat_title>h2:first-child, #seat_title>h3 {
	color: var(--sm-brown);
	font-weight: bold;
}

#seat_title>h2:not(:first-child) {
	color: var(--gray-light);
	font-weight: bold;
}

#first_seat>div>h4 {
	border-radius: 10px;
	background-color: black;
	color: white;
	width: 4%;
	padding: 1%;
}

#first_seat>div>h2 {
	display: flex;
	justify-content: center;
	font-size: 40px;
    margin-bottom: 2%;
    font-weight: bold;
    color: var(--gray)
}
div#seatMap {
    margin-bottom: 5%;
}
#first_seat {
	border-radius: 15px;
	border: 1px solid var(--gray);
    width: 80%;
}

#seat_title * {
	margin-right: 2%;
}

#seat_title {
	display: flex;
	align-items: center;
	font-size: 30px;
	margin-top: 5%;
	margin-bottom: 3%;
}



.row {
	display: flex;
	justify-content: center;
}
/* 좌석 스타일 */
.seat {
	display: flex;
	align-items: center;
	justify-content: center;
	width: 26px;
	height: 26px;
	margin: 5px;
	cursor: pointer;
	font-size: 80%;
	border-radius: 5px;
}

.selected {
	border: 3px solid black;
	color: white;
}
.unavailable {
	pointer-events: none;
	background-color: var(--gray)
}
</style>
	<!-------------------------------------------->
</body>
</html>