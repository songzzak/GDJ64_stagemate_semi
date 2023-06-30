<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.stagemate.qna.model.vo.Qna,java.util.List,com.stagemate.qna.model.vo.QnaComment,com.stagemate.qna.model.vo.QnaListCtg"%>
<%
	Qna q= (Qna)request.getAttribute("qna");
	List<QnaComment> comments=(List)request.getAttribute("comments");
	List<QnaListCtg> qc =(List)request.getAttribute("qc");
%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=contextPath %>/css/nabin/qnaboard.css">

<section class="min1280px">
	<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->

	<!---------------------------------------->

	<!-- </head> -->
	
		<!-----------   아래에서 HTML 작업  ----------->
		<section class="min1280px">
			<div class="max1280px">
				<div class="board_main_theme">
					<p>1:1문의 게시판</p>
				</div>
				<hr color=#000000>
				<div class="board_theme">
					<th>제목</th>
					<td><%=q.getInquiryTitle() %></td>
					
				</div>
				<div class="board_middle_theme">
					<hr style="color: #BDBDBD; border-style: dotted">
					<table>
						<tr>
							<th>작성자</th>
							<td><%=q.getWriterId() %></td>
							<th>첨부파일</th>
							<td>
								<%if(q.getFiles()!=null) {%> 
									<div id="download-container" onclick="fileDownload('<%=q.getFiles()%>');">
									<img src="<%=request.getContextPath() %>/images/nabin/file.png"
									width="20"> <span><%=q.getFiles()%></span>
									</div>
								<% }else{%>
									<div id="download-container">
										<h4>[없음]</h4>
									</div>
								<%} %>
							</td>
							
						<%-- 	<th>카테고리 </th>
							<% for(QnaListCtg qlc:qc){%>
								<% if(qlc.getCtgNum()==q.getCtgNum()) {%>
							<td><%=q.getCtgNm() %> </td>
							<%} 
								}%> --%>
							
							<th>작성일</th>
							<td><%=q.getInquiryInsertDt()%></td>
							<!-- 	<th> 조회수</th> -->
							
						</tr>
					</table>

					<hr>
				</div>
				<div class="board_main_content">
					<table>
						<tr>
							<th>내용</th>
							<td><%=q.getInquiryContent()%></td>
						</tr>
					</table>
				</div>



				<hr color=#000000>
				<div class="bt_wrap">
					<!--  필요시 신고 -->
					<!-- <a href="#" class="on">신고</a>  -->
					<!-- 	글작성자 / 관리자인 경우 수정 삭제 가능 -->
					<%if(loginMember!=null&&(loginMember.getMemberId().equals("stageadmin")||
					loginMember.getMemberId().equals(q.getWriterId()))){%>
					<a href="<%=request.getContextPath()%>/qna/updateQna.do?no=<%=q.getInquiryNo() %>" class="on">수정</a> 
					<a href="javascript:del();" class="on">삭제</a> 
					<script type="text/javascript">
						function del() {
	 					 if (confirm("정말 삭제하시겠습니까?"))
	   						 location.replace('<%=request.getContextPath()%>/qna/deleteQna.do?no=<%=q.getInquiryNo() %>');
	 					}
					</script> 
					<%} %>
				
				</div>



				<!--댓글창 구현 공간 입니다  -->
				<div id="comment-container">
					<div class="comment-editor">
						<!-- 관리자만 작성할 수있도록 구현하기 -->
						<%if(loginMember!=null&&loginMember.getMemberId().equals("stageadmin")){%>
						<form action="<%=request.getContextPath()%>/qna/insertComment.do"
							method="post">
							<textarea name="content" cols="55" rows="3"></textarea>
							<input type="hidden" name="inquiryRef" value="<%=q.getInquiryNo()%>"> 
							<input type="hidden" name="level" value="1"> 
							<input type="hidden" name="inquiryCommentWriter" value="<%=loginMember!=null?loginMember.getMemberId():"" %>">
							<input type="hidden" name="inquiryCommentRef" value="0">
							<button type="submit" id="btn-insert">등록</button>
						</form>
						<%} %>
					</div>
				</div>
				<table id="tbl-comment">
				
					<%if(comments!=null){for(QnaComment qcm:comments) {%>
					<tr class="levlel1">
						<td>
							<sub class="comment-writer"><%=qcm.getQnaCommentWriter() %></sub> 
							<sub class="comment-date"><%=qcm.getQnaCommentDate() %></sub>
						<br> 
						<%=qcm.getQnaCommentContent() %>
						</td>
					</tr>
					<%} 
					}%>
				</table>

				<div class="bt_list">
					<a href="<%=request.getContextPath()%>/qna/qnaList.do" class="on1">목록</a>
				</div>
		
	</div>
</section>
<script>
		$("#comment-container textarea[name=content]").focus(e=>{
			if(<%=loginMember==null%>){
				alert("로그인 후 이용할 수있습니다.");
				$("#memberId").focus();
			}
		});
	
	</script>
	
		<script>
			const fileDownload=(filename)=>{
				location.assign("<%=request.getContextPath()%>/fileDownload.do?filename="+filename);
				
			}
			</script>

<%@ include file="/views/common/footer.jsp"%>
<script src="<%=contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%=contextPath %>/js/script_common.js"></script>
