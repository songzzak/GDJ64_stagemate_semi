<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	final String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%= contextPath %>/images/common/favicon-32x32.png" type="image/x-icon">
<link rel="stylesheet" href="<%= contextPath %>/css/style_init.css">
<link rel="stylesheet" href="<%= contextPath %>/css/jaehun/style_agreement.css">
<title>개인정보 동의</title>
</head>
<body>
	<section class="agreement">
		<table>
			<thead>
				<tr>
					<th>수집 및 이용 목적</th>
					<th>수집 항목</th>
					<th>보유 기간</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>본인여부 확인 및 이용자 식별</td>
					<td>회원가입 시: 아이디, 비밀번호, 이름, 생년월일, 이메일, 전화번호, 주소</td>
					<td rowspan="3">내부방침에 따른 보존 기간 (회원탈퇴 후 30일)</td>
				</tr>
				<tr>
					<td>서비스 이용기록 분석, 부정이용 방지를 위한 이용기록 관리</td>
					<td>서비스 이용기록(IP주소, 브라우저 종류, 방문일시), 기기정보(OS, 모델명, 버전)</td>
				</tr>
				<tr>
					<td>재가입 및 부정이용 방지</td>
					<td>아이디, 이메일, 이름</td>
				</tr>
			</tbody>
		</table>
		<article class="agreement-content">
			<div class="centering-children">
				<p>본인은 개인정보 수집 및 이용 동의에 관한 설명을 모두 이해하였으며, 이에 동의합니다.</p>
				<div class="agreement-content_checkbox centering-children">
					<input type="checkbox" name="agreement" id="agreement">
					<label for="agreement"></label>
				</div>
			</div>
			<div class="agreement-content_btn">
				<div>
		            <button class="btn-layout btn-brown" 
		            		onclick="confirmAgreement();">확인</button>
		        </div>
		        <div>
		            <button class="btn-layout btn-white"
		            		onclick="closePage();">취소</button>
		        </div>	
			</div>
		</article>
	</section>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script>
	function confirmAgreement() {
		if ($("#agreement").is(":checked")) {
			$(opener.document).find("#agreement").prop("checked", true);
			closePage();
		} else {
			alert("개인정보 수집 및 이용 동의를 체크해야 확인 버튼을 누를 수 있습니다.");
		}
	}
</script>
</body>
</html>