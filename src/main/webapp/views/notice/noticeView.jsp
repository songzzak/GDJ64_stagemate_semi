<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.stagemate.notice.model.vo.Notice"%>
<%
	Notice n= (Notice)request.getAttribute("notice");
	%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=contextPath %>/css/nabin/notice_view.css">


<section class="min1280px">

	<div id="sectionContainer" class="max1280px">
		<div class="board_wrap">
		<p>스테이지메이트 공지사항</p>
		</div>
		<hr color=#000000>
		<div class="board_theme">
			<table>
				<tr>
					<th>제목</th>
					<td><%=n.getNoticeTitle() %></td>
				</tr>
				</div>
			</table>
			<div class="board_middle_theme">
			<hr style="color: #BDBDBD; border-style: dotted">
			<table>
				<tr>
					<th>작성자</th>
					<td><%=n.getNoticeWriter() %></td>
					<th>첨부파일</th>
					<td>
						<%if(n.getFiles()!=null){ %> 
						<div id="download-container" onclick="fileDownload('<%=n.getFiles()%>');">
						<img src="<%=request.getContextPath() %>/images/nabin/file.png"
						width="20"> <span><%=n.getFiles()%></span>
						</div>
						<% }%>
					</td>
					<th>작성일</th>
					<td><%=n.getNoticeInsertDt() %></td>
				</tr>
			</table>
			<hr>
				</div>
				<div class="board_main_content">
				<table>
						<tr>
						<th>내 용</th>
						<td><%=n.getNoticeContent() %></td>
				</tr>
			</table>
			</div>
			
				<hr color=#000000>
				<div class="bt_wrap">
				<%if(loginMember.getMemberId().equals("stageadmin")||
					loginMember.getMemberId().equals(n.getNoticeWriter())){%>
					<a href="<%=request.getContextPath()%>/notice/updateNotice.do?no=<%=n.getNoticeNo() %>" class="on">수정</a> 
					<a href="javascript:del();" class="on">삭제</a>
					<script type="text/javascript">
						function del() {
	 					 if (confirm("정말 삭제하시겠습니까?"))
	   						 location.replace('<%=request.getContextPath()%>/notice/deleteNotice.do?no=<%=n.getNoticeNo() %>');
	 					}
					</script> 
					<%} %>
				</div>
		
			<div class="bt_list">
					<a href="<%=request.getContextPath()%>/notice/noticeList.do"" class="on1">목록</a>
				</div>
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