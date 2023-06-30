<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ page import="java.util.List,com.stagemate.review.model.vo.EventReview" %>  
<%@ page import="java.util.List,com.stagemate.member.model.vo.Member" %> 
<title>전화번호 변경</title>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<% 
	Member memberInfo = (Member)request.getAttribute("MemberInfo");
%>
<script>
	function cancelDetailLogin(type) {
		let reqData = {};
		let url = '';
		const phone = $('#phone').val().trim();
		
		if (phone === '') {
			alert('전화번호를 입력해주세요.');
			return;
		}

		reqData['memberId'] = '<%=memberInfo.getMemberId()%>';
		reqData['phone'] = phone;
			
		url = getContextPath() + "/member/UpdatePhoneServiceServlet";	
		$.ajax({
			type: "post",
			url: url,
			data: reqData,
			dataType: "text",
			success: (data) => {
				if (data === "1") {
					alert("전화번호가 변경됐습니다.");
				} else {
					alert("전화번호가 변경되지 않습니다.");
				}
				window.close();
				reload();
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

	<div class="bigchart_phone">
	
	<div class="updatePhone">
		<p>STAGEMATE</p>
		<p id="notice">전화번호 변경</p>
		<form name="updatePhoneFrom" action="" method="post" >
			<tr>
				<td><input type="text" name="phone" id="phone"
				placeholder="변경 전화번호(-) 없이 입력" value="" ></td>
			</tr>
			
		
		<input type="button" class="update-btn" onclick="cancelDetailLogin();" value="변경하기">
		
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
	padding: 8px 8px;
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