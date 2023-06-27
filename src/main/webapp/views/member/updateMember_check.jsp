<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/ReviewList.css">
<title>STAGEMATE</title>
<
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
<section class="min1280px">
        <div id="totalchart" class="max1280px" style="min-height:720px;" >
		<div class="bigchart">
			<p>STAGEMATE</p>
			<p>정보를 안전하게 보호하기 위해 <br> 비밀번호를 다시 한 번 확인합니다.</p>
			<input type="password" id="check_pw" placeholder="비밀번호 입력">    
			<div class="passwordck_btn">
						<input type="button" class="check_btn" value="확인"> 
						<input type="button" class="cancel_btn" value="취소">
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
	.bigchart p:last-child{
		font-size: 15px;
		margin-top: 13px;
	}
	
	#check_pw{
		margin-top: 50px;
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
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<%-- <script src="<%=contextPath%>/js/yelin/ReviewList.js"></script> --%>
</html>