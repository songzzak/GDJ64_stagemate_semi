<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.stagemate.qna.model.vo.Qna, 
java.util.List,com.stagemate.qna.model.vo.QnaComment"%>
<%
	Qna q= (Qna)request.getAttribute("qna");
%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=contextPath %>/css/nabin/qnaboard.css">

<section class="min1280px">
	<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
		<!-----------   아래에서 HTML 작업  ----------->
		<form action="<%=request.getContextPath() %>/qna/updateQnaEnd.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="qnaNo" value="<%=q.getInquiryNo() %>">
			<div class="max1280px">
				<div class="board_main_theme">
					<p>1:1문의 게시판 수정</p>
				</div>
				<hr color=#000000>
				<div class="board_theme">
				<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="qnaTitle" value="<%=q.getInquiryTitle() %>"></td>
					</tr>
				</table>
				</div>
				<div class="board_middle_theme">
					<hr style="color: #BDBDBD; border-style: dotted">
					<table>
						<tr>
							<th>작성자</th>
							<td><input type="text" name="qnaWriter" value="<%=q.getWriterId() %>" readonly></td>
							<th>첨부파일</th>
							<td>
								<input type="file" name="upfile">
							</td>
							
						</tr>
					</table>

					<hr>
				</div>
				<div class="board_main_content">
					<table>
						<tr>
							<th>내용</th>
							<td><textarea cols="42" rows="5" name="qnaContent"><%=q.getInquiryContent()%></textarea></td>
						</tr>
					</table>
				</div>



				<hr color=#000000>
				<div class="bt_wrap">
					<button type="submit">저장하기</button> 
				</div>
			</div>
		</form>
</section>


<%@ include file="/views/common/footer.jsp"%>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%=contextPath %>/js/script_common.js"></script>

