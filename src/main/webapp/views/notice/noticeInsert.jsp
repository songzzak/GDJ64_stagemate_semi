<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<%@ include file="/views/common/header.jsp" %>
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/notice.css">
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/media.css">
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/notice_insert.css">

<section class="min1280px">
	<div id="sectionContainer" class="max1280px">
	<div id="notice-container">
    <form action="" method="post">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td>반드시 작성되야함.</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>반드시 있어야하고 로그인한 사용자 아이디가 들어가야함. 작성못하게!</td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>파일을 입력받아야함</td>
        </tr>
        <tr>
            <th>내 용</th>
            <td></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="등록하기" onclick="">
            </th>
        </tr>
    </table>
    </form>
    </div>

    
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>