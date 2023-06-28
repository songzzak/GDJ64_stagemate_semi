<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%=contextPath%>/js/yelin/detailList.js"></script>
<script>
let rsvNo = '';
let esNo = '';
$(document).ready(function() {
	rsvNo = '<%= request.getAttribute("RsvNo").toString()%>';
	esNo = '<%= request.getAttribute("EsNo").toString()%>';
	orderNo = '<%= request.getAttribute("OrderNo").toString()%>';
});

function checkCancelDetailLogin() {
	if (rsvNo.trim() != '') { 
		cancelDetailLogin('1');
	} else {
		cancelDetailLogin('2');
	}
}
</script>
<title>STAGEMATE</title>
</head>
<body>

	<%@ include file="/views/common/header.jsp"%>
<section class="min1280px">
	<div id="totalchart" class="max1280px" style="min-height:720px;" >
	<div class="bigchart">
			<p>STAGEMATE</p>
			<p id="relogin">재로그인</p>
			<p id="notice">예매 취소 진행을 위해 재로그인합니다.</p>
			
			<input type="password" id="check_pw" placeholder=" 비밀번호 입력">
			<div class="password_btn">
						<input type="button" class="cancel_btn" onclick="history.back()" value="돌아가기">
						<input type="button" class="check_btn" onclick="checkCancelDetailLogin()" value="확인"> 
						
	</div>
			
	</div>
	
	</div>
</section>
	
	
<style>


	#totalchart{
	 display: flex;
	 align-items: center;
	  justify-content: center; 
	  text-align: center; 
	  height: 720px;
	}
	.bigchart{
		width: 600px;
		height: 400px;
/* 		border: 1px solid black; */
		text-align: center; 
		margin: 0 auto;
	}
	.bigchart p:first-child{
		font-size: 30px;
	}
	#notice{
		font-size: 15px;
		margin-top: 10px;
	}
	#relogin{
	font-size: 20px;
	font-weight: bold;
		}
	
	#check_pw{
		margin-top: 30px;
		margin-bottom: 30px;
		width: 280px;
		height: 40px;
		 border-radius: 8px;
	}
	
	.cancel_btn{
		 border: none;
	    font-weight: bold;
	    background-color: var(--gray-light);
	    border: 2px solid var(--gray-light);
	    color: var(--sm-brown);
	    padding: 8px 40px;
	    text-align: center;
	    text-decoration: none;
	    border-radius: 5px;
	    cursor:pointer;
	}
	.check_btn{
		 border: none;
	    font-weight: bold;
	    background-color: var(--sm-brown);
	    border: 2px solid var(--sm-brown);
	    color: white;
	    padding: 8px 40px;
	    text-align: center;
	    text-decoration: none;
	    border-radius: 5px;
	    cursor:pointer;
	}
    

	
</style>


	<%@ include file="/views/common/footer.jsp"%>
</body>

</html>