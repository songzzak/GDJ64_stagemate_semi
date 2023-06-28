<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.stagemate.notice.model.vo.Notice"%>
<%
	Notice n= (Notice)request.getAttribute("notice");
	%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>


<section class="min1280px">
<h2> 스테이지 메이트 공지사항 </h2>
	<div id="sectionContainer" class="max1280px">
		<div class="board_wrap">
			<table>
				<tr>
					<th>제목</th>
					<td><%=n.getNoticeTitle() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=n.getNoticeWriter() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<%if(n.getFiles()!=null){ %> 
						<div id="download-container" onclick="fileDownload('<%=n.getFiles()%>');">
						<img src="<%=request.getContextPath() %>/images/nabin/file.png"
						width="20"> <span><%=n.getFiles()%></span>
						</div>
						<% }%>
					</td>
					</tr>
				<tr>
					<th>내 용</th>
					<td><%=n.getNoticeContent() %></td>
				</tr>
				<%if(loginMember.getMemberId().equals("stageadmin")||
					loginMember.getMemberId().equals(n.getNoticeWriter())){%>
				<tr>
					<th colspan="2">
					<button id="btn-update" class="btn btn-warning">수정</button>
					<button id="btn-delete" class="btn btn-danger">삭제</button>
					</th>
				</tr>
				<%} %>
			</table>
			
			 <!-- 버튼 기능 글 업데이트 딜릿 -->
		
			<script>
			const fileDownload=(filename)=>{
				location.assign("<%=request.getContextPath()%>/fileDownload.do?filename="+filename);
				
			}
			</script>
		</div>
	</div>
</section>

	<style>
	div.download-container
	{cursor:pointer;
	}</style>

		<%@ include file="/views/common/footer.jsp"%>
		<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
		<script src="<%= contextPath %>/js/script_common.js"></script>