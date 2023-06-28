<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/style_updateMember.css">
 <%@ page import="java.util.List,com.stagemate.review.model.vo.EventReview" %>  
<title>STAGEMATE</title>
</head>
<body>
<%@ include file="/views/common/header.jsp"%>
<section class="min1280px">
        <div id="updateMember_chart" class="max1280px" style="min-height:720px;" >
            
		<div class="bigchart">
			<div class="SB_bigchart">
                <p class="updateMember_eng">My Page</p>
                <p class="updateMember_kor">내 정보 관리</p>
			</div>
			<div class="">
			<table class="updateTable">
				<tr>
					<th>이름</th>
					<td>	
						<input type="text" name="userName" value="김뚜껑" readonly>
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
					<input type="text" name="userId" value="qwerty" readonly>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<button onclick="UpdatePwd();">비밀번호 수정</button>
					</td>
				</tr>
					<th>전화번호</th>
					<td>
					<input type="text" name="" value="010-1111-1111">	
					</td>
					<td>
						<button onclick="UpdatePhone();">수정</button>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>	
						<input type="text" name="gender" value="여" readonly >	
					</td>
				</tr> 
				<tr>
					<th>주소</th>
					<td>	
					<input type="text" name="address" value="경기도 시흥">	
					</td>
					<td>
						<button onclick="openPostCode();">수정</button>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>	
					<input type="text" name="email" value="qwerty@naver.com">	
					</td>
					<td>
						<button onclick="UpdateEmail();">수정</button>
					</td>
				</tr>			
			</table>
			<div class="infoUpdate_btn">
						<button onclick=""  class="cancel_btn">취소</button>
						<button onclick="updateClearButton();"  class="update_btn">변경하기</button>
			</div>
			</div>

		</form>
			</div>

        </div>
</section>

<script>
	const UpdatePwd=()=>{
		const childWindow=open("<%=request.getContextPath()%>/member/UpdatePassword.do","_blank","width=600,height=450");
		
	}
	const UpdatePhone=()=>{
		const childWindow=open("<%=request.getContextPath()%>/member/updatePhone.do","_blank","width=600,height=260");
	}
	const UpdateEmail=()=>{
		const chilWindow=open("<%=request.getContextPath()%>/member/updateEmail.do","_blank","width=600,height=260");
	}
	const updateClearButton=()=>{
		alert('변경 완료되었습니다.');
	}
</script>

<%@ include file="/views/common/footer.jsp"%>
</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="<%=contextPath%>/js/script_common.js"></script>
</html>