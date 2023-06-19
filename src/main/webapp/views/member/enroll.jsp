<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<link rel="stylesheet" href="<%= contextPath %>/css/jaehun/style_enroll.css">
<title>회원가입</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section class="enroll min1280px centering-children">
    <div class="enroll-container w-1280px">
        <div class="enroll-wrapper">
            <h2 class="enroll-form-title fw-bold">회원가입</h2>
            <p class="fw-bold fs-small"><span class="fw-bold fc-orange">*</span>표시는 꼭 입력해야 하는 항목입니다.</p>
            <form action="<%= contextPath %>/member/enrollEnd.do" method="post" class="centering-children-column">
                <div class="enroll-form-combo">
                    <div class="enroll-form-box enroll-check_mark w-70p">
	                    <div class="form-box_name">
	                        <p class="fw-bold">아이디<span class="fw-bold fc-orange">*</span></p>
	                    </div>
	                    <input type="text" name="userId" id="idToUse" isValid="false" 
	                    		onkeyup="validateIdRegex();"
	                    		placeholder="8 ~ 15자리 대소문자 및 숫자만 입력" 
	                    		onfocus="this.placeholder = ''" 
	                    		onblur="this.placeholder = '8 ~ 15자리 대소문자 및 숫자만 입력'">
                	</div>
                    <div class="enroll-wrapper-right">
                        <button type="button" id="btnIdDuplication" class="btn-layout-unchecked btn-api btn-brown" 
                        		onclick="validateIdDuplication();">중복 검사</button>
                    </div>
                </div>
                <div class="enroll-form-box enroll-check_mark">
                    <div class="form-box_name">
                        <p class="fw-bold">비밀번호<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="password" name="password" id="passwordToUse" isValid="false"
                    		onkeyup="validatePwRegex();" 
                    		placeholder="8 ~ 15자로 영문 대소문자, 숫자, 특수문자를 모두 사용해서 입력 | 예) abcd1234#" 
                    		onfocus="this.placeholder = ''" 
                    		onblur="this.placeholder = '8 ~ 15자로 영문 대소문자, 숫자, 특수문자를 모두 사용해서 입력 | 예) abcd1234#'">
                </div>
                <div class="enroll-form-box enroll-check_mark">
                    <div class="form-box_name">
                        <p class="fw-bold">비밀번호 재입력<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="password" id="passwordToConfirm" 
                    		onkeyup="validatePwCorrectness();">
                </div>
                <div class="enroll-form-box">
                    <div class="form-box_name">
                        <p class="fw-bold">이름<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="text" name="userName" id="userName">
                </div>
                <div class="enroll-form-box">
                    <div class="form-box_name">
                        <p class="fw-bold">생년월일<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="text" name="birthdate" id="birthdate" maxlength="8" 
                    	placeholder="8자리 숫자만 입력  | 예) 19990101" 
                    	onfocus="this.placeholder = ''" 
                    	onblur="this.placeholder = '8자리 숫자만 입력  | 예) 19990101'">
                </div>
                <div class="enroll-form-combo">
                    <div class="enroll-form-box w-70p">
                        <div class="form-box_name">
                            <p class="fw-bold">이메일<span class="fw-bold fc-orange">*</span></p>
                        </div>
                        <input type="email" name="email" id="email" 
                        	placeholder="stagemate@gmail.com" 
                        	onfocus="this.placeholder = ''" 
                        	onblur="this.placeholder = 'stagemate@gmail.com'">
                    </div>
                    <div class="enroll-wrapper-right">
                        <button onclick="startTimer(this);" class="btn-layout-unchecked btn-api btn-brown" type="button">인증번호 발송하기</button>
                    </div>
                </div>
                <div class="enroll-form-box">
                    <div class="form-box_name">
                        <p class="fw-bold">전화번호<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="text" name="phone" id="phone" maxlength="11" 
                    	placeholder="'-' 빼고 입력  | 예) 01012345678" 
                    	onfocus="this.placeholder = ''" 
                    	onblur="this.placeholder = `'-' 빼고 입력 | 예) 01012345678`">
                </div>
                <div class="enroll-form-combo address_white_space">
                    <div class="enroll-form-box w-70p">
                        <div class="form-box_name">
                            <p class="fw-bold">주소<span class="fw-bold fc-orange">*</span></p>
                        </div>
                        <input type="text" name="zipCode" id="zipCode" 
                        	placeholder="우편번호" 
                        	onfocus="this.placeholder = '우편번호'" 
                        	readonly>
                    </div>
                    <div class="enroll-wrapper-right">
                        <!-- 주소 api랑 연결하기 -->
                        <button onclick="" class="btn-layout-unchecked btn-api btn-brown" type="button">우편번호 찾기</button>
                    </div>
                </div>
                <div class="enroll-form-box">
                    <input type="text" name="address" id="address" 
                    	placeholder="상세 주소" 
                    	onfocus="this.placeholder = '상세 주소'" 
                    	readonly>
                </div>
                <div class="enroll-form-box form-box_agreement">
                    <p class="fw-bold">개인정보 수집 및 이용 동의<span class="fw-bold fc-orange">*</span></p>
                    <input type="checkbox" name="agreement" id="agreement" required readonly>
					<label for="agreement"></label>
                    <p style="cursor: pointer" class="fc-blue" onclick="toAgreement();">내용 보기</p>
                </div>
                <div class="enroll-form-box">
                    <input type="submit" class="btn-layout btn-brown" value="가입하기" onclick="return isAllValid();">
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
				<p>실행 중에 오류가 발생했습니다.</p>
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
<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
<script>
    const idToUse = $("#idToUse");
    const passwordToUse = $("#passwordToUse");
    const passwordToConfirm = $("#passwordToConfirm");

    const idRegex = /^[0-9a-zA-Z]{8,15}$/;
    const pwRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
    const bdRegex = /^(19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])$/;
    const phoneRegex = /^01([0|1|6|9])([0-9]{3,4})([0-9]{4})$/;

    $(() => {
        function generateCheckMark() {
            const $div = $("<div>").css({
                position: "absolute",
                top: "30%",
                right: "4%",
                width: "20px"
            });
            const checkMark = $("<img>").attr({
                src: "<%= contextPath %>/images/jaehun/page_enroll/unchecked.svg"
            });
    
            $(".enroll-check_mark").append($div.append(checkMark));
        }
        generateCheckMark();

        $("input[name=agreement]").prop("disabled", true);
        $("input[name=agreement] + label").click(() => {
            alert("개인정보 수집 및 이용 동의에 대한 내용을 읽어야 체크할 수 있습니다.");
        });
    });

    function isAllValid() {
        if (idToUse.attr("isValid") != "true") {
            alert('아이디 입력 조건을 통과하지 못 했습니다.');
            idToUse.focus();
			return false;
        }

        if (passwordToUse.attr("isValid") != "true") {
            alert('비밀번호 입력 조건을 통과하지 못 했습니다.');
            passwordToUse.focus();
			return false;
        }

        if ($("#userName").val().length === 0) {
            alert('이름을 입력하지 않았습니다.');
            $("#userName").focus();
			return false;
        }

        if (!bdRegex.test($("#birthdate").val())) {
            alert('올바른 생년월일 형식이 아닙니다.');
            $("#birthdate").focus();
            bdRegex.lastIndex = 0;
			return false;
        }

        // 이메일 인증 실패 시 return false

        if (!phoneRegex.test($("#phone").val())) {
            alert('올바른 전화번호 형식이 아닙니다.');
            $("#phone").focus();
            phoneRegex.lastIndex = 0;
			return false;
        }

        if ($("#address").val().length === 0) {
            alert('주소를 입력하지 않았습니다.');
            $("#address").focus();
			return false;
        }
    }
    
    function validateIdRegex() {
        idToUse.attr("isValid", "false");
    	$(".idInvalid, .idDuplicate").remove();
    	inactivateInput(idToUse);

        if (!idRegex.test(idToUse.val())) {
            idToUse.parent().append(addWarningSign("idInvalid", 
    									"아이디는 8자 이상 15자 이하에 영문 대소문자 및 숫자만 입력할 수 있습니다.",
    									"var(--jh-crimson)"));
                                        
    		alertInput(idToUse);
        } else {
            inactivateInput(idToUse);
        }   
        idRegex.lastIndex = 0;                   
    }
    
    function validateIdDuplication() {
    	if (!idRegex.test(idToUse.val())) {
            alert("조건에 부합하는 아이디를 만든 뒤 검사해주세요.");
			idToUse.focus();
            idRegex.lastIndex = 0;
			return;
		} 

        let warningSign = addWarningSign("idDuplicate", 
                                        "사용 가능한 아이디입니다.",
                                        "var(--green)");
    	
        $(".idDuplicate").remove();
    	$.ajax({
    		type: "get",
    		url: getContextPath() + "/member/idDuplication.do",
    		data: { idToUse: idToUse.val() },
    		dataType: "text",
    		beforeSend: () => {
    			$("#btnIdDuplication").text("검사 중");
    		},
    		success: (data) => {
    			if (data === "true") {
    				warningSign = addWarningSign("idDuplicate", 
    											"사용 중인 아이디입니다.",
    											"var(--jh-crimson)");
    				alertInput(idToUse);
    			} else {
                    idToUse.attr("isValid", "true");
    	    		activateInput(idToUse);
    			}
    		},
    		error:(request, status, error) => {
    			if (request.status === 500) {
    				showModalError();
    			}
    		},
    		complete: () => {
    			idToUse.parent().append(warningSign);
    			$("#btnIdDuplication").text("중복 검사");
    		}
    	});
    }
    
    function validatePwRegex() {
        passwordToUse.attr("isValid", "false");
        inactivateInput(passwordToUse);
        inactivateInput(passwordToConfirm);
        $(".pwInvalid, .confirmResult").remove();

    	if (!pwRegex.test(passwordToUse.val())) {
    		passwordToUse.parent().append(addWarningSign("pwInvalid", 
            "8 ~ 15자로 영문 대소문자, 숫자, 특수문자를 모두 사용해서 입력해주세요.",
            "var(--jh-crimson)"));
    		alertInput(passwordToUse);
    	} else {
    		$(".pwInvalid").remove();
    		activateInput(passwordToUse);
    	}
        pwRegex.lastIndex = 0;
    }
    
    function validatePwCorrectness() {
        $(".confirmResult").remove();
    	let warningSign = addWarningSign("confirmResult", 
    										"입력한 비밀번호와 일치하지 않습니다.",
    										"var(--jh-crimson)");
    	if (passwordToConfirm.val() != passwordToUse.val()) {
    		alertInput(passwordToConfirm);
    	} else {
            warningSign = addWarningSign("confirmResult", 
    										"입력한 비밀번호와 일치합니다.",
    										"var(--green)");
            activateInput(passwordToConfirm);
            passwordToUse.attr("isValid", "true");
    	}
        $(".confirmResult").remove();
        passwordToConfirm.parent().append(warningSign);
    }
    
    function toAgreement() {
    	const width = 400;
    	const height = 700;
    	const left = (window.screen.width / 2) + (width / 2);
    	const top = (window.screen.height / 2) + (height / 2);
    	
    	window.open('<%= contextPath %>/member/agreement.do', 
				'_blank',
				'width=' + width, 'height=' + height, 'left=' + left, 'top=' + top);
    }
    
    function addWarningSign(className, msg, colorName) {
    	const warningSign = $("<p>").text(msg)
							.css({
								position: "absolute",
								bottom: "-46%",
								right: "10px",
								fontSize: "0.6rem",
								color: colorName
							}).addClass(className);
    	
    	return warningSign;
    }
    
    function alertInput(element) {
    	element.css("border", "2px solid var(--jh-crimson)");
		element.parent().find("img")
						.attr("src", "<%= contextPath %>/images/jaehun/page_enroll/unchecked.svg")
    }
    
    function activateInput(element) {
    	element.css("border", "1px solid var(--gray)");
    	element.parent().find("img")
						.attr("src", "<%= contextPath %>/images/jaehun/page_enroll/checked.svg");
    }

    function inactivateInput(element) {
        element.css("border", "1px solid var(--gray)");
    	element.parent().find("img")
						.attr("src", "<%= contextPath %>/images/jaehun/page_enroll/unchecked.svg");
    }

    function startTimer(element) {
        $(element).addClass("fc-yellow");
        alert("입력한 이메일로 인증번호가 발송되었습니다.");
        $(element).text("인증번호 다시 발송하기");
        $(element).removeClass("fc-yellow");
        generateTimer(element);
    }

    function generateTimer(element) {
    	const formCombo = $("<div>").addClass("enroll-form-combo enroll-form-timer");
        const formBox = $("<div>").addClass("enroll-form-box w-70p");
        const authCode = $("<input>").attr({
                type: "text",
                id: "authCode",
                placeholder: "인증번호 입력",
                onfocus: "this.placeholder = ''",
                onblur: "this.placeholder = '인증번호 입력'"
        });
        const enrollWrapperRight = $("<div>").addClass("enroll-wrapper-right");
        
        const cssTime = {
        		width: "35%",
                textAlign: "center"
        };
        const timerTitle = $("<p>").text("남은 시간").css(cssTime).addClass("fs-small centering-children");
        const timerSeconds = $("<p>").text("01:00").css(cssTime).addClass("fc-red centering-children");

        formBox.append(authCode);
        enrollWrapperRight.append(timerTitle).append(timerSeconds);
        
        $(".enroll-form-timer").remove();
        formCombo.append(formBox)
                .append(enrollWrapperRight)
                .insertAfter($(element).parent().parent());
        
        setTimer(timerSeconds);
    }

    function setTimer(element) {
        let timer = undefined;
        let count = 59;

        timer = setInterval(() => {
            let minutes = parseInt(count / 60, 10);
            let seconds = parseInt(count % 60, 10);

            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;
        
            element.text(minutes + ":" + seconds);
        
            if (--count < 0) {
                // 회원가입 못하게 막기
                clearInterval(timer);
                element.text("00:00");
            }
        }, 1000);
    };
    
    function showModalError() {
    	$(".popup-error-bg").css("transition", "all 0.8s")
    							.addClass("popup-error-show");
    	$(".popup-error-content").css("transition", "all 0.8s")
    							.addClass("popup-error-slide");
    }

    function closeModalError() {
    	$("#accessFailed").html("");
    	$(".popup-error-bg").css("transition", "")
    						.removeClass("popup-error-show");
    	$(".popup-error-content").css("transition", "")
    							.removeClass("popup-error-slide");
    }
</script>
<!-------------------------------------------->
</body>
</html>