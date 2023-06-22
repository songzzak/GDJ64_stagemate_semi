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
			<div id="store_admin_nav">
				<nav>
					<ul id="store_admin_nav_ul">
						<li><a href="<%=contextPath%>/admin/membermanage" class="select_nav_admin">회원 관리</a></li>
						<li>
							<a href="<%=contextPath%>/admin/eventlist">상품 관리</a>
							<ul>
								<li><a href="<%=contextPath%>/admin/eventlist">예매</a></li>
								<li><a href="<%=contextPath%>/admin/selectAllProduct.do">스토어</a></li>
							</ul>
						</li>
						<li>
							<a href="">판매 관리</a>
							<ul>
								<li><a href="<%=contextPath%>/admin/SalesDetail.do">판매내역관리</a></li>
								<li><a href="">결제 취소 요청</a></li>
								<li><a href="">반품/교환 관리</a></li>
							</ul>
						</li>
						<li>
							<a href="">커뮤니티 관리</a>
							<ul>
								<li><a href="">게시판 관리</a></li>
								<li><a href="">신고 관리</a></li>
							</ul>
						</li>
						<li>
							<a href="">고객센터</a>
							<ul>
								<li><a href="">공지사항 관리</a></li>
								<li><a href="">1:1문의 관리</a></li>
							</ul>
						</li>
					</ul>
				</nav>
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
						if (members.isEmpty()) {%>
						<tr>
							<td colspan="6">등록된 회원이 없습니다.</td>
						</tr>
						<%} else {
							for (Member m : members) {
						%>
						<tr>
							<td><input type="checkbox" name="check"></td>
							<td><a href=""><%=m.getMemberId()%></a></td>
							<td><%=m.getMemberNm()%></td>
							<td><%=m.getMemberEmail()%></td>
							<td><%=m.getEnrollDate()%></td>
							<td><%=m.getWthdrDate() == null ? "-" : m.getWthdrDate()%></td>
						</tr>
						<%
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
<script src="<%= contextPath %>/js/joonho/script_admin_membermanage.js"></script>
<!-------------------------------------------->
</body>
</html>