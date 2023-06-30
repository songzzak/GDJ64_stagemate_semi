<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/qna_insert.css">
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/qna.css">
<link rel = "stylesheet" href = "<%=contextPath %>/css/nabin/media.css">
	

<section class="min1280px">
	<div id="sectionContainer" class="max1280px">

		
			<div class="qna_wrap">
				<div class="qna_title">
					<span> 고객센터 </span>> <span>1:1 문의</span>
				</div>
				<div class="qna_insert_wrap">
					<div class="qna_insert">
						<form action="<%=request.getContextPath() %>/qna/insertQna.do" method="post" enctype="multipart/form-data">
							<table id="tbl-qna">
								<tr>
									<th>제 목</th>
									<td><input type="text" name="qnaTitle" required></td>
								</tr>
								<tr>
									<th>작성자</th>
									<td><input type="text" name="qnaWriter"
									value="<%=loginMember.getMemberId()%>" readonly></td>
								</tr>
								<tr>
								<th>비밀글</th>
								<td><input type="checkbox" name="qnaLock"
								value="Y" >
								</td>
								</tr>
								<tr>
								<th>카테고리</th>
								<td>
								<input type="radio" id="ctgList" name="category" value="1" checked="checked">
								예매
								<input type="radio" id="ctgList" name="category" value="2" checked="checked">
								상품
								<input type="radio" id="ctgList" name="category" value="3" checked="checked">
								배송
								<input type="radio" id="ctgList" name="category" value="4" checked="checked">
								반품/취소
								<input type="radio" id="ctgList" name="category" value="5" checked="checked">
								회원정보
								</td>
								<tr>
									<th>첨부파일</th>
									<td><input type="file" name="upFile"></td>
								</tr>
								<tr>
									<th>내 용</th>
									<td><textarea cols="100" rows="40" name="qnaContent"></textarea></td>
								</tr>
								<tr>
								<th colspan="2">
								<input type="submit" value="등록" onclick="if(!confirm('글이 등록됩니다.\ 글을 등록하시겠습니까?')){return false;}"/>
								
								</th>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
</section>

		<%@ include file="/views/common/footer.jsp"%>
		<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
		<script src="<%= contextPath %>/js/script_common.js"></script>