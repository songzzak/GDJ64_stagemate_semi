<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.stagemate.notice.model.vo.Notice"%>
<%
	List<Notice> notices=(List)request.getAttribute("notices");
%>
<%@ include file="/views/common/top.jsp"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=contextPath %>/css/nabin/notice.css">
<link rel="stylesheet" href="<%=contextPath %>/css/nabin/media.css">
<section class="min1280px">
	<div id="sectionContainer" class="max1280px">

		<div class="board_wrap">
			<div class="board_title">
				<strong>공지사항</strong>
			</div>

			<div class="title_list">
				<table>
					<tr>
						<a href="<%=request.getContextPath()%>/notice/noticeList.do">공지사항</a>
					</tr>
					<tr>|
					</tr>
					<tr>
						<a href="<%=request.getContextPath()%>/qna/qnaList.do">1:1
							문의사항</a>
					</tr>
				</table>
			</div>
			<div class="board_list_wrap">
				<div class="board_list">
					<table>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>작성일</th>
						</tr>
						<%if(notices.isEmpty()){ %>
						<tr>
							<td colspan="4">조회된 공지사항이 없습니다.</td>
						<tr>
							<%}else{ 
			 for(Notice n : notices){%>
						
						<tr>
							<td><%=n.getNoticeNo() %></td>
							<td><a
								href="<%=request.getContextPath()%>/notice/noticeView.do?no=<%=n.getNoticeNo()%>">
									<%=n.getNoticeTitle() %>
							</a>
							<td><%=n.getNoticeInsertDt() %></td>
							<td><%=n.getNoticeWriter() %></td>
						</tr>
						<%} 
		}%>
					</table>
					<div id="pageBar">
						<%=request.getAttribute("pageBar") %>
					</div>


				</div>
				<div class="board_page">
					<a href="#" class="bt first"><<</a> <a href="#" class="bt prev"><</a>
					<a href="#" class="num on">1</a> <a href="#" class="bt next">></a>
					<a href="#" class="bt last">>></a>
				</div>
				<div class="bt_wrap">
					<%if(loginMember!=null&&loginMember.getMemberId().equals("stageadmin")){ %>
					<button class="on"
						onclick="location.assign('<%=request.getContextPath()%>/notice/insertForm.do')">글쓰기</button>
					<%} %>
				</div>

				<!-- <a href="write.html" class="on">등록</a>
                            <a href="#">수정</a> -->
			</div>
		</div>

		
</section>




<%@ include file="/views/common/footer.jsp"%>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>