<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	final String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 찾기</title>
<link rel="stylesheet" href="<%= contextPath %>/css/style_init.css">
<style>
    button {
        display: inline-block;
        height: 100%;
        padding: 5px 20px !important;
    }

    input {
        display: inline-block;
        width: 260px;
        margin-right: 15px;
        outline: none;
        padding: 5px;
        border: 1px solid var(--gray);
        border-radius: 10px;
        font-size: 1rem;
    }

    .find_pw {
        padding: 15px;
        width: 100vw;
        height: 100vh;
    }

    .find_pw-box>h3 {
        color: var(--sm-brown);
        margin-bottom: 30px;
    }

    .content-input:first-child {
        margin-bottom: 15px;
    }

    .content-input>p {
        margin-right: 10px;
    }
</style>
</head>
<body>
    <section class="find_pw centering-children-column">
        <article class="find_pw-box centering-children-column">
            <h3 class="fw-bold">가입 당시 사용한 이메일과 아이디를 입력해주세요.</h3>
            <div class="centering-children">
                <div class="centering-children-column">
                    <div class="content-input centering-children">
                        <p>아이디</p>
                        <input type="text">
                    </div>
                    <div class="content-input centering-children">
                        <p>이메일</p>
                        <input type="email">
                    </div>
                </div>
                <button class="btn-layout btn-brown"
                            onclick="findPw();">찾기</button>
            </div>
        </article>
    </section>
    <script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
    <script src="<%= contextPath %>/js/script_common.js"></script>
    <script>
        function findPw() {
            $.post(getContextPath() + "/member/findPwEnd.do",
                {
                    userId: $("input[type=text]").val(),
                    email: $("input[type=email]").val()
                },
                data => {
                    $(".find_pw-box").children("div").remove();
                    
                    if (data === "1") {
                        $("h3").text("입력한 이메일로 새 비밀번호를 발송했습니다.");
                        return;
                    }

                    $("h3").text("입력한 정보에 해당하는 계정이 없습니다.");
                }
            );
        }
    </script>
</body>
</html>