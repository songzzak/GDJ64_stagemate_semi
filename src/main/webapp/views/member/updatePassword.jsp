<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
 <%@ page import="java.util.List,com.stagemate.review.model.vo.EventReview" %>  
<title>패스워드 변경</title>
</head>
<body>

	<div class="bigchart">
	
	<div class="updatePassword">
		<p>STAGEMATE</p>
		<p id="notice">비밀번호는 8~15자리 영문 대/소문자,<br>숫자, 특수문자를 조합해서 입력해주세요.</p>
		<form name="updatePwdFrom" action="" method="post">
			<tr>
				<td><input type="text" name="password" id="password" value="qwerty1110" readonly></td>
			</tr>
			<tr>
				<td><input type="text" name="password_new" id="password_new" 
					placeholder="새 비밀번호" required></td>
			</tr>
			<tr>
				<td>
					<input type="password" id="password_chk" 
					placeholder="새 비밀번호 재입력" required><br>
				</td>
			</tr>
		
		<input type="button" class="update-btn" value="변경하기">
		
		</form>
	
	</div>
</div>
<style>
@import url("../style_init.css");

.bigchart{
	display: flex;
	 align-items: center;
	  justify-content: center; 
	  text-align: center; 
}
	.updatePassword{
		width: 350px;
		height: 400px;
	}
	
	.updatePassword p:first-child{
		font-size: 25px;
		text-align: left;
		margin-left: 20px;
		font-weight: bold;
		margin-top: 30px;
	}
	.notice{
		font-size: 15px;
		margin-top: 5px;
		text-align: left;
		margin-left: 25px;
		
	}

	.updatePassword input{
	border: none;
	font-weight: bold;
	padding: 8px 30px;
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
	 
	}
	#password{
		margin-top: 30px;
	}

	#password_new{
		margin-top: 30px;
		}
	#password_chk{
	margin-top: 15px;
	margin-bottom: 45px;
	}	
</style>
</body>
</html>