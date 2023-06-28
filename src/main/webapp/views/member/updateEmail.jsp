<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
 <%@ page import="java.util.List,com.stagemate.review.model.vo.EventReview" %>  
<title>패스워드 변경</title>
</head>
<body>

	<div class="bigchart_phone">
	
	<div class="updatePhone">
		<p>STAGEMATE</p>
		<p id="notice">이메일 변경</p>
		<form name="updatePhoneFrom" action="" method="post" >
			<tr>
				<td><input type="text" name="phone" id="phone"
				placeholder="변경 비밀번호(-) 없이 입력" value=" ">
				</td>
			</tr>
			
		
		<input type="button" class="update-btn" value="변경하기">
		
		</form>
	
	</div>
</div>

<style>
	@import url("../style_init.css");

.bigchart_phone{
	display: flex;
	 align-items: center;
	  justify-content: center; 
	  text-align: center; 
}
	.updatePhone{
		width: 350px;
		height: 250px;
	}
	
	.updatePhone p:first-child{
		font-size: 25px;
		text-align: left;
		margin-left: 20px;
		font-weight: bold;
		margin-top: 30px;
	}
	#notice{
		font-size: 15px;
		margin-top: 5px;
		text-align: left;
		margin-left: 25px;
		
	}

	input{
	border: none;
	font-weight: bold;
	padding: 8px 4px;
 	text-align: center; 
	border-radius: 8px;
	border: 1px solid var(--sm-brown);
	margin: 0 auto;

	}
	.update-btn{
	border: none;
	font-weight: bold;
	padding: 8px 80px;
 	text-align: center; 
	border-radius: 8px;
	border: 1px solid var(--sm-brown);
	background-color: var(--sm-brown);
	color: white;
	cursor:pointer;
	margin-top: 30px;
	 
	}
	#phone{
		margin-top: 30px;
	}


</style>
</body>
</html>