<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<link rel="stylesheet" href="<%= contextPath %>/css/jaehun/style_login.css">
<title>로그인</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section class="login min1280px centering-children">
    <div class="login-container max1280px centering-children">
    	<div class="login-form" style="background-image: url('<%= contextPath %>/images/jaehun/login_page/login_container.svg');">
    		<div class="login-form-left">
    			<div class="form-left_upper">
    				<div class="left_upper_bar"></div>
		    		<div class="left_upper_words fw-bold">
			    		<h2>ADMIT</h2>
			    		<h2>ONE</h2>
		    		</div>
    			</div>
    			<div class="form-left_lower">
    				<div class="left_lower_img">
    					<img src="<%= contextPath %>/images/jaehun/login_page/login_container_drawing.svg" alt="로그인창_이미지">
    				</div>
    				<div class="left_lower_enroll">
    					<h3>아직 <span class="fw-bold">MATE</span>가 아니신가요?</h3>
    					<div>
    						<img src="<%= contextPath %>/images/jaehun/login_page/enroll.svg" alt="회원가입_아이콘">
    						<h3><a class="fw-bold" href="<%= contextPath %>/member/enroll.do">회원가입 하기</a></h3>
    					</div>
    				</div>
    			</div>
    		</div>
    		<form class="login-form-right centering-children" id="loginForm">
    			<div class="form-right_content">
    				<h3 class="fw-bold" style="letter-spacing :0.1rem;">LOGIN</h3>
    				<div id="accessFailed"></div>
    				<div class="right_content_account">
    					<div>
							<input type="text" id="userId" name="userId" placeholder="아이디" 
									onfocus="this.placeholder = ''"
                    				onblur="this.placeholder = '아이디'"
                    				onkeyup="loginByEnter();">
						</div>
						<div>
							<input type="password" id="password" name="password" placeholder="비밀번호" 
									onfocus="this.placeholder = ''"
                    				onblur="this.placeholder = '비밀번호'" 
                    				onkeyup="loginByEnter();">
						</div>
    				</div>
    				<div class="right_content_options">
    					<div>
    						<input type="checkbox" name="saveId" id="saveId">
							<label for="saveId"></label>
							<label for="saveId">ID 저장</label>
    					</div>
    					<div>
							<p><a href="">ID 찾기</a></p>
							<p><a href="">PW 찾기</a></p>
						</div>
    				</div>
    				<div class="right_content_login">
    					<button type="button" class="btn-layout btn-login" 
    							onclick="validateAccount();">입장하기</button>
    				</div>
    			</div>
    		</form>
    	</div>
    </div>
</section>
<div class="popup-error-bg">
	<div class="popup-error-container">
		<div class="popup-error-content centering-children">
			<div class="error-content_icon">
				<img src="<%= contextPath %>/images/jaehun/login_page/warning.svg">
			</div>
			<div class="error-content_msg">
				<h2 class="fw-bold">죄송합니다.</h2>
				<p>로그인 실행 중에 오류가 발생했습니다.</p>
				<p>나중에 다시 시도해주세요.</p>
			</div>
			<div>
				<button type="button" class="btn-layout btn-brown" onclick="closeModalError();">확인</button>
			</div>
		</div>
	</div>
</div>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%= contextPath %>/js/jaehun/script_login.js"></script>
<script>
$(document).ready(() => {
	function checkSaveId() {
		if ("<%= saveId %>" !== "") {
			$("#saveId").prop("checked", true);
			$("#userId").val("<%= saveId %>");
		}
	}
	checkSaveId();
});
</script>
</body>
</html>