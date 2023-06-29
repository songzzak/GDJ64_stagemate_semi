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
        padding: 5px 20px !important;
    }

    input[type="email"] {
        display: inline-block;
        width: 280px;
        margin-right: 15px;
        outline: none;
        padding: 5px;
        border: 1px solid var(--gray);
        border-radius: 10px;
        font-size: 1rem;
    }

    .find_id {
        padding: 10px;
        width: 100vw;
        height: 100vh;
    }

    .find_id-box>h3, .find_id-box>div {
        color: var(--sm-brown);
        margin-bottom: 30px;
    }
</style>
</head>
<body>
    <section class="find_id centering-children-column">
        <article class="find_id-box centering-children-column">
            <h3 class="fw-bold">가입 당시 사용한 이메일을 입력해주세요.</h3>
            <div class="centering-children">
                <input type="email">
                <button class="btn-layout btn-brown"
                        onclick="findId();">찾기</button>
            </div>
        </article>
    </section>
    <script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
    <script src="<%= contextPath %>/js/script_common.js"></script>
    <script>
        function findId() {
            $.get(getContextPath() + "/member/findIdEnd.do?email=" + $("input[type=email]").val(),
                data => {
                    if (data === "notFound") {
                        $("h3").text("입력한 이메일로 가입한 아이디를 찾지 못 했습니다.");
                        return;
                    }

                    $("h3").text("아이디: " + data);
                    $("div").remove();
                }
            );
        }
    </script>
</body>
</html>