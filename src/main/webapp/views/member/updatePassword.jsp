<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
 <%@ page import="java.util.List,com.stagemate.review.model.vo.EventReview" %>  
  <%@ page import="java.util.List,com.stagemate.member.model.vo.Member" %> 
<title>패스워드 변경</title>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<% 
	Member memberInfo = (Member)request.getAttribute("MemberInfo");
%>
<script>
	function cancelDetailLogin(type) {
		let reqData = {};
		let url = '';
		const password_new = $('#password_new').val().trim();
		const password_chk = $('#password_chk').val().trim();
		
		if (password_new === '' || password_chk === '') {
			alert('비밀번호를 입력해주세요.');
			return;
		}
		
		if (password_new !== password_chk) {
			alert('비밀번번호 확인이 맞지 않습니다.');
			return;
		}

		reqData['memberId'] = $('#memberId').val().trim();
	    reqData['password'] = password_new;
	    
		url = getContextPath() + "/member/UpdatePasswordServiceServlet";	
		$.ajax({
			type: "post",
			url: url,
			data: reqData,
			dataType: "text",
			success: (data) => {
				if (data === "1") {
					alert("비밀번호가 변경됐습니다.");
				} else {
					alert("비밀번호가 변경되지 않습니다.");
				}
				window.close();
			},
			error:(response, status, error) => {
				if (response.status === 500) {
					alert("code:" + response.status + "\n" + "message:" + response.responseText + "\n" + "error:" + error);
				}
			}
		});
	}
</script>
</head>
<body>

	<div class="bigchart">
	
	<div class="updatePassword">
		<p>STAGEMATE</p>
		<p id="notice">비밀번호는 8~15자리 영문 대/소문자,<br>숫자, 특수문자를 조합해서 입력해주세요.</p>
		<form name="updatePwdFrom" action="" method="post">
			<tr>
				<td><input type="text" name="id" id="memberId" value="<%=memberInfo.getMemberId() %>" readonly></td>
			</tr>
			<tr>
				<td><input type="password" name="password_new" id="password_new" 
					placeholder="새 비밀번호" required></td>
			</tr>
			<tr>
				<td>
					<input type="password" id="password_chk" 
					placeholder="새 비밀번호 재입력" required><br>
				</td>
			</tr>
		
		<input type="button" class="update-btn" onclick="cancelDetailLogin();" value="변경하기">
		
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