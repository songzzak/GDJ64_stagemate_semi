<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/store/style_shoppingBasket.css">
<link rel="stylesheet" href="<%=contextPath%>/css/yoonjin/style_mypage_nav.css">
<link rel="stylesheet" href="<%=contextPath%>/css/yoonjin/style_myInquiry.css">
<%@ page import="java.util.List,com.stagemate.qna.model.vo.Qna"%>
<%
List<Qna> list=(List)request.getAttribute("list");
%>
<title>My Page | 관심목록</title>
</head>
<body>
    <%@ include file="/views/common/header.jsp"%>
    <section class="min1280px">
        <div id="sectionContainer" class="max1280px" style="min-height: 720px;">
        	<div class=mypageContainer>
        	<div id="mypage_nav">
        		<div id="user_profile">
                    <img src="<%=contextPath%>/images/yoonjin/information/default_profile.png" alt="user_profile_img" id="img_profile">
        			<h5><%=loginMember.getMemberId() %> 님</h5>
        			<p><%=loginMember.getMemberEmail() %><p>
        			                <input type="hidden" id="userId" name="userId" value="<%=loginMember.getMemberId()%>">
        		</div>
        		<hr>
        		<div id="user_nav">
					<nav>   
						<ul id="mypage_nav_ul">
							<li class="li1"><a href="#">내 정보 관리</a></li>
							<li class="li1"><a href="<%= request.getContextPath() %>/mypage/wishList.do?userId=<%=loginMember.getMemberId()%>">관심목록</a></li>
							<li class="li1"><a href="<%=request.getContextPath()%>/store/selectCartList.do?id=<%=loginMember.getMemberId()%>">장바구니</a></li>
							<li class="li1">구매내역
								<ul>
									<li class="li2"><a href="#">구매상세내역</a></li>
									<li class="li2"><a href="#">리뷰 작성</a></li>
								</ul>
							</li>
							<li class="li1">내가 쓴 글
								<ul>
									<li class="li2"><a href="<%= request.getContextPath() %>/board/selectMyBoard.do?id=<%=loginMember.getMemberId()%>">커뮤니티</a></li>
									<li class="li2"><a href="<%= request.getContextPath() %>/views/mypage/myInquiry.jsp">1:1문의</a></li>
								</ul>
							</li>
							<li class="li1"><a href="<%= request.getContextPath() %>/views/member/member_withdraw.jsp">회원 탈퇴</a></li>
						</ul>
					</nav>
        		</div>
        		<div id="nav_btn_logout">
        			<a href="<%= request.getContextPath() %>/member/logout.do" id="logout_btn_mypage">로그아웃</a>
        		</div>
			</div>
            <div class="InquirtListContainer">
                <p class="ShoppingBasket_eng">My Page</p>
                <p class="ShoppingBasket_kor">내가 쓴 글</p>
                <hr class="hr-myInquiry-startLine">
                <!-- 목록리스트 -->
                <div id="quiryListContainer">
	                <table>
	                	<colgroup>
	                		<col style="width:100px">
	                		<col style="width:550px">
	                		<col style="width:200px">
	                		<col style="width:100px">
	                	</colgroup>
	                	<thead>
		                	<tr class="tr-underLine">
		                		<th scope="col" style="text-align: center;">카테고리</th>
		                		<th scope="col" style="text-align: center;">제목</th>
		                		<th scope="col" style="text-align: center;">작성일자</th>
		                		<th scope="col" style="text-align: center;">문의상태</th>
		                	</tr>
	                	</thead>
	                	<tbody>
	                	<%if(list.isEmpty()||list==null){ %>
	                		<tr><td colspan="4">작성된 게시글이 없습니다.</td></tr>
	                	<%}else{ 
	                			for(Qna q:list){%>
		                	<tr class="tr-underLine">
		                		<td style="text-align: center;"><%=q.getCtgNum() %></td>
		                		<td style="text-align: center;">
		                			<a href="<%=contextPath %>/qna/qnaView.do?no=<%=q.getInquiryNo()%>">
		                				<%=q.getInquiryTitle() %>
		                			</a>
		                		</td>
		                		<td style="text-align: center;"><%=q.getInquiryInsertDt() %></td>
		                		<td style="text-align: center;">답변대기</td>
		                	</tr>
		                <%}
	                			}%>

	                	</tbody>
	                </table>
                </div>
               <div class="page-bar">
               		<%-- <%=request.getAttribute("pageBar") %> --%>
               </div>
            </div>
        </div>
    </section>

   <%@ include file="/views/common/footer.jsp"%>
</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script>

</script>
</html>
