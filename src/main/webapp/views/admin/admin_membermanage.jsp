<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<%@ page import="java.util.List,com.stagemate.member.model.vo.Member"%>
<%
List<Member> members = (List) request.getAttribute("member");
%>
<!-- 본인이 따로 적용할 CSS 파일 및 style 태그 -->
<link rel="stylesheet" href="<%= contextPath %>/css/joonho/style_admin_membermanage.css">
<!---------------------------------------->
<title>STAGEMATE/회원관리</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<!-----------   아래에서 HTML 작업  ----------->
<section class="min1280px">
    <div class="max1280px">
        <div id="maincontainer">
			<!-- 관리자 사이드메뉴 -->
			<div id="admin_menu">
				<div>
					<a href="">회원관리</a>
				</div>
				<div>
					<a href="">상품관리</a>
					<ul>
						<li><a href="">예매</a></li>
						<li><a href="">스토어</a></li>
					</ul>
				</div>
				<div>
					<a href="">판매관리</a>
					<ul>
						<li><a href="">판매내역 관리</a></li>
						<li><a href="">결제 취소요청</a></li>
						<li><a href="">반품/교환관리</a></li>
					</ul>
				</div>
				<div>
					<a href="">커뮤니티관리</a>
					<ul>
						<li><a href="">게시판 관리</a></li>
						<li><a href="">신고 관리</a></li>
					</ul>
				</div>
				<div>
					<a href="">고객센터</a>
					<ul>
						<li><a href="">공지사항 관리</a></li>
						<li><a href="">1:1문의 관리</a></li>
					</ul>
				</div>
			</div>
			<!-- 회원검색창 -->
			<div id="memberManage">
				<h2>회원관리</h2>
				<br>
				<hr>
				<div id="search-container">
					<select id="searchType">
						<option value="userId">아이디</option>
						<option value="userName">회원이름</option>
					</select>
					<div id="search-userId">
						<form action="<%= contextPath %>/admin/searchMember">
							<input type="hidden" name="searchType" value="userId"> <input
								type="text" name="searchKeyword" size="25"
								placeholder="검색할 아이디를 입력하세요"> <input type="button"
								class="btn-layout btn-brown" value="조회">
						</form>
					</div>
					<div id="search-userName">
						<form action="<%= contextPath %>/admin/searchMember">
							<input type="hidden" name="searchType" value="userName">
							<input type="text" name="searchKeyword" size="25"
								placeholder="검색할 이름을 입력하세요"> <input type="button"
								class="btn-layout btn-brown" value="조회">
						</form>
					</div>
				</div>
				<!-- 회원테이블 -->
				<table id="admin_membermanage_table">
					<thead>
						<tr>
							<th><input type="checkbox" class="checkall"
								onclick="checkAll();"></th>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>가입일자</th>
							<th>탈퇴일자</th>
						</tr>
					</thead>
					<tbody>
						<%
						int i = 1;
						if (members.isEmpty()) {
						} else {
							for (Member m : members) {
						%>
						<tr class=<%=i % 2 == 0 ? "member_table_a" : "member_table_b"%>>
							<td><input type="checkbox" name="check"></td>
							<td><a href=""><%=m.getMemberId()%></a></td>
							<td><%=m.getMemberNm()%></td>
							<td><%=m.getMemberEmail()%></td>
							<td><%=m.getEnrollDate()%></td>
							<td><%=m.getWthdrDate() == null ? "-" : m.getWthdrDate()%></td>
						</tr>
						<%
						i++;
						}
						}
						%>

					</tbody>
				</table>
				<br> <br>
				<!-- 강제탈퇴 버튼 -->
				<div id="withdrawal">
					<a href="#layer1" class="btn-example"><input type="button"
						class="btn-layout btn-brown " value="강제탈퇴"></a>
					<div id="layer1" class="pop-layer">
						<div class="pop-container">
							<div class="pop-conts">
								<!--content //-->
								<div id="inner_pop">
									<div>
										<img src="<%= contextPath %>/images/joonho/question.png">
									</div>
									<div>
										<p class="ctxt mb20">qwerty님을 탈퇴하시겠습니까?</p>
									</div>
									<div>
										<div class="btn-r">
											<a href="#" class="btn-layerClose" id="yes">확인</a>
										</div>
										<div class="btn-r">
											<a href="#" class="btn-layerClose" id="no">취소</a>
										</div>
									</div>
								</div>
								<!--// content-->
							</div>
						</div>
					</div>
				</div>
				<div id="page">
					<div class="pageBar">
						<%=request.getAttribute("pageBar") %>
					</div>
				</div>
			</div>
		</div>
    </div>
</section>
<!-----------   위에서 HTML 작업  ----------->
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
<script src="<%= contextPath %>/js/joonho/admin_membermanage.js"></script>
<!-------------------------------------------->
</body>
</html>