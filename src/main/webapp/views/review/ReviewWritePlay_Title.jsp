<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%=contextPath%>/css/yelin/play/style_Detailed_play.css">
<title>STAGEMATE</title>
</head>
<body>



	<div class="Playtitle_title">
		<p>상품 검색</p>
	</div>
	<div class="Playtitle_bigchart">
		<div class="BP-searchtitle">
			<form action="<%=request.getContextPath()%>/Review/SearchTitle.do">
				<input type="text" id="PT-searchtxt" name="keyword">
				<button>검색</button>
			</form>
		</div>
		<table class="BookedPlay_List">
			<label for="">
				<tr>
					<td>뮤지컬<나르치스와 골드문트></td>
					<td>2023.06.19 18:00</td>
					<td><input type="radio""> S390292929</td>
				</tr>
				<tr>
					<td>뮤지컬<나르치스와 골드문트></td>
					<td>2023.06.19 18:00</td>
					<td><input type="radio""> S390292929</td>
				</tr>
				<tr>
					<td>뮤지컬<나르치스와 골드문트></td>
					<td>2023.06.19 18:00</td>
					<td><input type="radio""> S390292929</td>
				</tr>
				

			</label>
		</table>



	</div>
	<!-- 버튼 예매/스토어 -->
	<div class="Search-box">
		<button type="button" onclick="thisClose();">닫기</button>
		<button type="button" onclick="">선택</button>
	
	</div>

	<script>
		const thisClose=()=>{
			window.close();
		}
	</script>






	<style>
.Playtitle_bigchart {
	margin: auto;
	width: 650px;
	height: 180px;
	border: 0.5px solid lightgrey;
	flex-direction: row;
	margin-bottom: 0px;
}

.Playtitle_title {
	background-color: black;
	color: white;
	width: 650px;
		height: 40px;
	/*  */
	margin: 0 auto;
}

.Playtitle_title p {
	margin: auto;
	text-align: left;
	font-size: 18px;
	padding: 9px 0px 3px 0px;
	margin-left: 10px;
}

/* 검색창 */
.BP-searchtitle {
	width: 450px;
	height: 40px;
	margin: 0 auto;
/* 	text-align: center; */
	float:left;
	padding: 10px 0px 10px 55px;
	border-bottom: black;
}

#PT-searchtxt {
	border-radius: 5px;
}

.BP-searchtitle button {
	color: white;
	background-color: black;
	border: none;
	padding: 3px 10px;
	text-align: center;
	text-decoration: none;
	border-radius: 5px;
	font-weight: 20;
	cursor: pointer;
}

/* 검색결과창 */
.BookedPlay_List {
	width: 550px;
	margin: 0 auto;
	margin-top: 20px;
	border: 0.5px solid lightgray;
	border-left: none;
	border-right: none;
	border-collapse: collapse;
	/* 테두리 사이에 공백 없애줌 */
	text-align: center; /* 글씨 중앙정렬렬 */
}
.BookedPlay_List td{
	marin-left:10px;
}
/* 취소 버튼 */

/* 하단버튼 */

.Search-box{
  display: flex;
  justify-content: center;
    margin:0 auto;
    margin-top: 30px;

}
.Search-box button:first-child{

    background-color: lightgray;
    border: none;
    padding: 5px 25px;
    font-weight: bold;
    text-decoration: none;
    font-size: 20;
    border-radius: 5px;
    /* margin-left:590px; */
    cursor:pointer;
    margin-right:20px;

}

.Search-box button:last-child{
    margin-top: 0px;
    color: white;
    background-color:black;
    border: none;
    padding: 5px 25px;
    font-weight: bold;
    text-decoration: none;
    font-size: 20;
    border-radius: 5px;
    cursor:pointer;
    
   
}

.PT_btn {
	text-align: center;
}
</style>





</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>

</html>