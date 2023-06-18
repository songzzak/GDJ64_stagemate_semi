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
            <p class="fw-bold"><span class="fw-bold fc-orange">*</span>표시는 꼭 입력해야 하는 항목입니다.</p>
            <form action="<%= contextPath %>/member/enrollEnd.do" method="post" class="centering-children-column">
                <div class="enroll-form-box enroll-check_mark">
                    <div class="form-box_name">
                        <p class="fw-bold">아이디<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="text" name="userId" id="idToUse" duplicate="true" placeholder="8 ~ 15자리 대소문자 및 숫자만 입력" onfocus="this.placeholder = ''" onblur="this.placeholder = '8 ~ 15자리 대소문자 및 숫자만 입력'">
                </div>
                <div class="enroll-form-box enroll-check_mark">
                    <div class="form-box_name">
                        <p class="fw-bold">비밀번호<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="password" name="password" id="passwordToUse" onkeyup="" placeholder="8~15자리 영문 대/소문자, 숫자, 특수문자를 조합해서 입력" onfocus="this.placeholder = ''" onblur="this.placeholder = '8~15자리 영문 대/소문자, 숫자, 특수문자를 조합해서 입력'">
                </div>
                <div class="enroll-form-box">
                    <div class="form-box_name">
                        <p class="fw-bold">비밀번호 재입력<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="password" id="passwordToConfirm" onkeyup="">
                </div>
                <div class="enroll-form-box">
                    <div class="form-box_name">
                        <p class="fw-bold">이름<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="text" name="userName" id="userName">
                </div>
                <div class="enroll-form-combo">
                    <div class="enroll-form-box enroll-check_mark w-70p">
                        <div class="form-box_name">
                            <p class="fw-bold">생년월일<span class="fw-bold fc-orange">*</span></p>
                        </div>
                        <input type="text" name="birthdate" id="birthdate" maxlength="11" placeholder="8자리 숫자만 입력  | 예) 19990101" onfocus="this.placeholder = ''" onblur="this.placeholder = '8자리 숫자만 입력  | 예) 19990101'">
                    </div>
                    <div class="enroll-wrapper-right">
                        <div class="enroll-btn_radio">
                            <input type="radio" name="gender" id="genderM" value="M">
                            <label for="genderM" class="btn-layout-unchecked btn-color-unchecked centering-children"><span>남</span></label>
                        </div>
                        <div class="enroll-btn_radio">
                            <input type="radio" name="gender" id="genderF" value="F">
                            <label for="genderF" class="btn-layout-unchecked btn-color-unchecked centering-children"><span>여</span></label>
                        </div>
                    </div>
                </div>
                <div class="enroll-form-combo">
                    <div class="enroll-form-box w-70p">
                        <div class="form-box_name">
                            <p class="fw-bold">이메일<span class="fw-bold fc-orange">*</span></p>
                        </div>
                        <input type="email" name="email" id="email" placeholder="stagemate@gmail.com" onfocus="this.placeholder = ''" onblur="this.placeholder = 'stagemate@gmail.com'">
                    </div>
                    <div class="enroll-wrapper-right">
                        <button onclick="startTimer(this);" class="btn-layout-unchecked btn-api btn-brown" type="button">인증번호 발송하기</button>
                    </div>
                </div>
                <div class="enroll-form-box">
                    <div class="form-box_name">
                        <p class="fw-bold">전화번호<span class="fw-bold fc-orange">*</span></p>
                    </div>
                    <input type="text" name="phone" id="phone" maxlength="11" placeholder="'-' 빼고 입력  | 예) 01012345678" onfocus="this.placeholder = ''" onblur="this.placeholder = `'-' 빼고 입력 | 예) 01012345678`">
                </div>
                <div class="enroll-form-combo address_white_space">
                    <div class="enroll-form-box w-70p">
                        <div class="form-box_name">
                            <p class="fw-bold">주소<span class="fw-bold fc-orange">*</span></p>
                        </div>
                        <input type="text" name="zipCode" id="zipCode" placeholder="우편번호" onfocus="this.placeholder = ''" onblur="this.placeholder = '우편번호'">
                    </div>
                    <div class="enroll-wrapper-right">
                        <!-- 주소 api랑 연결하기 -->
                        <button onclick="" class="btn-layout-unchecked btn-api btn-brown" type="button">우편번호 찾기</button>
                    </div>
                </div>
                <div class="enroll-form-box">
                    <input type="text" name="address" id="address" placeholder="상세 주소" onfocus="this.placeholder = ''" onblur="this.placeholder = '상세 주소'" readonly>
                </div>
                <div class="enroll-form-box form-box_agreement">
                    <p class="fw-bold">개인정보 수집 및 이용 동의<span class="fw-bold fc-orange">*</span></p>
                    <input type="checkbox" name="agreement" id="agreement">
					<label for="agreement"></label>
                    <p style="cursor: pointer" class="fc-blue" onclick="">내용 보기</p>
                </div>
                <div class="enroll-form-box">
                    <input type="submit" class="btn-layout btn-brown" value="가입하기" onclick="return isAllValid();">
                </div>
            </form>
        </div>
    </div>
</section>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
<script>
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
</script>
<!-------------------------------------------->
</body>
</html>