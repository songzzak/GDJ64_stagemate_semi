<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/store/style_shoppingBasket.css">
<link rel="stylesheet" href="<%=contextPath%>/css/yoonjin/style_mypage_nav.css">
<link rel="stylesheet" href="<%=contextPath%>/css/yoonjin/style_myWishList.css">
<%@ page import="java.util.List,com.stagemate.store.model.vo.StoreUpfile,
com.stagemate.store.model.vo.Product,com.stagemate.store.model.vo.StoreLike,
com.stagemate.event.model.vo.EventUpfile,com.stagemate.event.model.vo.EventWish,
com.stagemate.event.model.vo.Event"%>
<%
    List<Product> products = (List) request.getAttribute("products");
	List<Event> tickets = (List) request.getAttribute("eventList");
	List<StoreUpfile> files = (List) request.getAttribute("files");
	List<StoreLike> likes=(List) request.getAttribute("likes");
	List<EventUpfile> efiles = (List) request.getAttribute("efiles");
	List<EventWish> events=(List) request.getAttribute("events");
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
									<li class="li2"><a href="<%= request.getContextPath() %>/qna/selectMyInquiry.do?id=<%=loginMember.getMemberId()%>">1:1문의</a></li>
								</ul>
							</li class="li1">
							<li class="li1"><a href="<%= request.getContextPath() %>/views/member/member_withdraw.jsp">회원 탈퇴</a></li>
						</ul>
					</nav>
        		</div>
        		<div id="nav_btn_logout">
        			<a href="<%= request.getContextPath() %>/member/logout.do" id="logout_btn_mypage">로그아웃</a>
        		</div>
			</div>
            <div class="wishListContainer">
                <p class="ShoppingBasket_eng">My Page</p>
                <p class="ShoppingBasket_kor">관심목록</p>
                <!-- 리스트 선택 -->
                <div class="wish_btn_container">
                    <button id="wish_event_btn" class="btn_selected">공연</button>
                    <button id="wish_store_btn" class="">스토어</button>
                </div>
                <!-- 목록리스트 -->
                <div id="eventWishList-container">
                 <table>
					<%
					if (tickets == null || tickets.isEmpty()) {
					%>
					<tr>
						<td colspan="3">
							<p class="wish-none-msg">
							관심목록 상품이 없습니다.<br>
							하트 아이콘을 클릭하여 관심목록에 추가해주세요.
							</p>
						</td>
					</tr>
					<%
                    } else {
                    int size = tickets.size();
                    for (int i = 0; i < size; i++) {
                    %>
                    <tr class="prod_tr">
                        <%
                        for (int j = 0; j < 3; j++) {
                            int index = i * 3 + j;
                            if (index < size) {
                                Event t = tickets.get(index);
                                String eventNo = t.getEventNo();
                                EventUpfile mainFile = null;
                                for (EventUpfile file : efiles) {
                                    if (file.getEventNo().equals(eventNo) && file.getPurposeNo().equals("PUR1")) {
                                        mainFile = file;
                                        break;
                                    }
                                }
                                EventWish ew=null;
                                for(EventWish ews : events) {
                                	if(ews.getEventNo().equals(eventNo)) {
                                		ew=ews;
                                	}
                                }
                                String heartColor="";
                                if(ew!=null){
                                	heartColor="#BC0000";
                                }else{
                                	heartColor="none";
                                }
                                
                        %>
						<td class="prod_td1">
							<div class="product">
								<div class="imageContainer">
								<%
								String path=null;
								if(mainFile != null){
									path=contextPath+"/upload/joonho/"+mainFile.getEuRename();
								}else{
									path=contextPath +"/images/yoonjin/information/default_img.gif";
								}
								%>
									<img src="<%= path %>" alt="Product Image">
								</div>
								<div class="productDetails">
									<input type="hidden" value="<%=t.getEventNo()%>">
									<%-- <span class="brand"><%=%></span> --%>
									<span class="name"><%=t.getEventNm()%></span>
									<div class="wishAndPrice">
										<span class="price"><%=t.getLocation()%></span>
										<span class="eventwish">
											<svg width="44" height="39" viewBox="0 0 44 39" fill="<%=heartColor%>" xmlns="http://www.w3.org/2000/svg">
                                        		<path d="M12.9329 1.67188C6.67923 1.67188 1.60938 6.80209 1.60938 13.1302C1.60938 24.5885 14.9917 35.0052 22.1976 37.4281C29.4035 35.0052 42.7859 24.5885 42.7859 13.1302C42.7859 6.80209 37.716 1.67188 31.4623 1.67188C27.6329 1.67188 24.2461 3.59584 22.1976 6.54063C21.1535 5.03563 19.7663 3.80739 18.1536 2.95988C16.5409 2.11238 14.7501 1.67058 12.9329 1.67188Z"
												stroke="#BC0000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                                    	</svg>
										</span>
									</div>
								</div>
							</div>
						</td>
						<%
						}
						}
						%>
					</tr>
					<%
					}
					}
					%>
				</table>
                </div>
                <div id="storeWishList-container">
                <table>
					<%
					if (products == null || products.isEmpty()) {
					%>
					<tr>
						<td colspan="3">
							<p class="wish-none-msg">
							관심목록 상품이 없습니다.<br>
							하트 아이콘을 클릭하여 관심목록에 추가해주세요.
							</p>
						</td>
					</tr>
					<%
                    } else {
                    int size = products.size();
                    for (int i = 0; i < 2; i++) {
                    %>
                    <tr class="prod_tr">
                        <%
                        for (int j = 0; j < 3; j++) {
                            int index = i * 3 + j;
                            if (index < size) {
                                Product p = products.get(index);
                                int productNo = p.getProductNo();
                                StoreUpfile mainFile = null;
                                for (StoreUpfile file : files) {
                                    if (file.getProductNo()==(productNo) && file.getIsMainImg()=='Y') {
                                        mainFile = file;
                                        break;
                                    }
                                }
                                StoreLike sl=null;
                                for(StoreLike ul : likes) {
                                	if(ul.getProductNo()==(productNo)) {
                                		sl=ul;
                                	}
                                }
                                String heartColor="";
                                if(sl!=null){
                                	heartColor="#BC0000";
                                }else{
                                	heartColor="none";
                                }
                                
                        %>
						<td class="prod_td1">
							<div class="product">
								<div class="imageContainer">
								<%
								String path=null;
								if(mainFile != null){
									path=contextPath+"/upload/yoonjin/"+mainFile.getImgFileRename();
								}else{
									path=contextPath +"/images/yoonjin/information/default_img.gif";
								}
								%>
									<img src="<%= path %>" alt="Product Image">
								</div>
								<div class="productDetails">
									<input type="hidden" value="<%=p.getProductNo()%>">
									<span class="brand"><%=p.getProductTitle()%></span>
									<span class="name"><%=p.getProductNm()%></span>
									<div class="wishAndPrice">
										<span class="price"><%=p.getProductPrice()%></span>
										<span class="wish">
											<svg width="44" height="39" viewBox="0 0 44 39" fill="<%=heartColor%>" xmlns="http://www.w3.org/2000/svg">
                                        		<path d="M12.9329 1.67188C6.67923 1.67188 1.60938 6.80209 1.60938 13.1302C1.60938 24.5885 14.9917 35.0052 22.1976 37.4281C29.4035 35.0052 42.7859 24.5885 42.7859 13.1302C42.7859 6.80209 37.716 1.67188 31.4623 1.67188C27.6329 1.67188 24.2461 3.59584 22.1976 6.54063C21.1535 5.03563 19.7663 3.80739 18.1536 2.95988C16.5409 2.11238 14.7501 1.67058 12.9329 1.67188Z"
												stroke="#BC0000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                                    	</svg>
										</span>
									</div>
								</div>
							</div>
						</td>
						<%
						}
						}
						%>
					</tr>
					<%
					}
					}
					%>
				</table>
                </div>
            </div>
        </div>
    </section>

   <%@ include file="/views/common/footer.jsp"%>
</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script>
$(document).ready(function() {
	  // 초기 설정은 공연 버튼이 선택되어 있음
	  $("#eventWishList-container").show();
	  $("#storeWishList-container").hide();
	  $("#wish_event_btn").addClass("btn_selected");

	  // 공연 버튼 클릭 시
	  $("#wish_event_btn").click(function() {
	    $(this).addClass("btn_selected");
	    $("#wish_store_btn").removeClass("btn_selected");

	    $("#eventWishList-container").show();
	    $("#storeWishList-container").hide();
	  });

	  // 스토어 버튼 클릭 시
	  $("#wish_store_btn").click(function() {
	    $(this).addClass("btn_selected");
	    $("#wish_event_btn").removeClass("btn_selected");

	    $("#eventWishList-container").hide();
	    $("#storeWishList-container").show();
	  });
	  
	  
	  $(".wish").on("click", function(e) {
		    let $heartIcon = $(this).find("svg");
			let productNo = $(this).closest(".product").find(".productDetails input[type='hidden']").val();
			const userId=$("#userId").val();
			console.log(productNo);
			console.log(userId);
		      $heartIcon.css("fill", "none");
		      $.post("<%=request.getContextPath()%>/store/deleteLike.do", 
				  {
				    productNo: productNo,
				    userId: userId
				  })
				  .done(function(response) {
			            alert("관심목록에서 삭제되었습니다.");
			            location.reload();
			        })
			        .fail(function(error) {
			            alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
			            location.reload();
			        });
		  });
	  $(".eventwish").on("click", function(e) {
		    let $heartIcon = $(this).find("svg");
			let eventNo = $(this).closest(".product").find(".productDetails input[type='hidden']").val();
			const userId=$("#userId").val();
		      $heartIcon.css("fill", "none");
		      $.post("<%=request.getContextPath()%>/event/removeHeart.do", 
				  {
		    	  eventNo: eventNo,
		    	  memberId: userId
				  })
				  .done(function(response) {
			            alert("관심목록에서 삭제되었습니다.");
			            location.reload();
			        })
			        .fail(function(error) {
			            alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
			            location.reload();
			        });
		  });
	});

</script>
</html>
