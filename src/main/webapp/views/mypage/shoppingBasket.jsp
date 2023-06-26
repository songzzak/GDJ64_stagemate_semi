<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/store/style_shoppingBasket.css">
<link rel="stylesheet" href="<%=contextPath%>/css/yoonjin/style_mypage_nav.css">
<%@ page import="java.util.List,com.stagemate.store.model.vo.Cart,com.stagemate.store.model.vo.Product"%>
<%
    List<Cart> carts = (List) request.getAttribute("carts");
    List<Product> products = (List) request.getAttribute("products");
    int totalPrice = 0;
%>
<title>My Page | 장바구니</title>
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
							<li class="li1"><a href="#">장바구니</a></li>
							<li class="li1">구매내역
								<ul>
									<li class="li2"><a href="#">구매상세내역</a></li>
									<li class="li2"><a href="#">리뷰 작성</a></li>
								</ul>
							</li>
							<li class="li1">내가 쓴 글
								<ul>
									<li class="li2"><a href="#">커뮤니티</a></li>
									<li class="li2"><a href="#">1:1문의</a></li>
								</ul>
							</li class="li1">
							<li class="li1"><a href="#">회원 탈퇴</a></li>
						</ul>
					</nav>
        		</div>
        		<div id="nav_btn_logout">
        			<a href="<%= request.getContextPath() %>/member/logout.do" id="logout_btn_mypage">로그아웃</a>
        		</div>
			</div>
            <div class="SB_bigchart">
                <p class="ShoppingBasket_eng">My Page</p>
                <p class="ShoppingBasket_kor">장바구니</p>
                <div class="deliv-group">
                    <p class="deliv-txt">업체 조건 배송 상품</p>
                    <p class="deliv-txt2">무료 배송</p>
                </div>
                <!-- 장바구니 내역 -->
                <div class="ShoppingBasket_List">
                 <form id="orderForm" method="post" action="<%=request.getContextPath()%>/store/storeOrder.do">
                    <table class="ShoppingBasket-table" style="margin: 3px auto; margin-right: auto;">
                        <colgroup>
                            <col style="width: 50px">
                            <col style="width: 170px">
                            <col style="width: 130px">
                            <col style="width: 200px">
                            <col style="width: 135px">
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col"><input type="checkbox" value="전체선택" id="selectAll"></th>
                                <th scope="col">상품 정보</th>
                                 <th scope="col">판매가</th>
                                <th scope="col">수량</th>
                                <th scope="col">주문 금액</th>
                                <th scope="col">주문</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            if (carts == null) {
                            %>
                            <tr>
                                <td colspan="6">조회된 장바구니 목록이 없습니다.</td>
                            </tr>
                            <%
                            } else {
                                for (Cart c : carts) {
                                    for (Product p : products) {
                                        if (p.getProductNo() == c.getProductNo()) {
                                        	int price=p.getProductPrice();
                                            int priceByProduct = p.getProductPrice() * c.getCartAmt();
                                            totalPrice += priceByProduct; // 총 금액 누적
                            %>
                            <tr>
                                <td class="shop-bk"><input type="checkbox" class="cart-checkbox" name="cart-checkbox" value="<%=p.getProductNo() %>" checked></td>
                                <td class="shop-bk product_name_container">
                                	<input type="hidden" value="<%=p.getProductNm()%>" class="product_name_input">
                                	<input type="hidden" value="<%=p.getProductNo()%>" class="product_no_input">
                                </td>
                                <td class="shop-bk" ><%=p.getProductPrice()%></td>
                                <td class="shop-bk">
                                    <div class="haha">
                                        <button type="button" class="minus">-</button>
                                        <input type="number" name="numBox" class="numBox" min="1" max="" value="<%=c.getCartAmt()%>" readonly/>
                                        <button type="button" class="plus">+</button>
                                    </div>
                                </td>
                                <td class="shop-bk priceByProduct"><%=priceByProduct%></td>
                                <td class="shop-bk"><input type="button" class="SBOrder-btn" value="주문하기"></td>
                            </tr>
                            <%
                                            }
                                        }
                                    }
                                }
                            %>
                            <tr>
                                <td colspan="6" class="SBT-txt">
                                    <p>
                                        총 합계 : <span id="totalPrice"><%=totalPrice%></span>원
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="total-prc" style="margin: 8px auto; margin-right: auto;">
                        <p class="tt-txt" style="margin: 8px 0px 0px 10px;">총 주문 금액</p>
                        <div class="total-prc2">
                            <div class="count-prc">
                                <p style="margin-right: 80px;">상품 총 금액</p>
                                <p style="float: right; margin-right: 10px;"><span id="productTotalPrice"><%=totalPrice%></span>원</p>
                            </div>
                            <div class="total-line"></div>
                            <div class="count-prc2">
                                <p style="margin-right: 80px;">배송비</p>
                                <p style="float: right; margin-right: 10px">0원</p>
                            </div>
                            <div class="total-line"></div>
                        </div>
                        <div class="dash-line"></div>
                        <div class="payment-price">
                            <p style="margin-right: 10px; font-size: 12px;">결제 예정 금액</p>
                            <p style="margin-right: 10px"><span id="paymentTotalPrice"><%=totalPrice%></span>원</p>
                        </div>
                    </div>
	                    <div class="SB-lowerbtn" id="btn-result">
	                        <input type="button" class="lowerbtn-basket" id="deleteCartBtn" value="장바구니 삭제">
	                        <input type="button" class="lowerbtn-purchase"  id="orderCartBtn" value="구매하기">
	                    </div>
	                 </form>
                </div>
            </div>
            </div>
        </div>
    </section>

   <%@ include file="/views/common/footer.jsp"%>
</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script>
$(document).ready(function() {

	// 전체선택 체크박스 클릭 시
    $("#selectAll").on("change", function() {
        var isChecked = $(this).prop("checked");
        $(".cart-checkbox").prop("checked", isChecked);
        updateTotalPrice();
    });

    // 개별 체크박스 클릭 시
    $(".cart-checkbox").on("change", function() {
        if ($(".cart-checkbox:checked").length === $(".cart-checkbox").length) {
        	$("#selectAll").prop("checked", true);
        } else {
        	$("#selectAll").prop("checked", false);
        }
        updateTotalPrice();
    });
    
    // 페이지 로드 시 주문 금액 및 판매가 초기화
    updateProductPrices();
    updateTotalPrice();
    
 	// 상품 이름 출력
    $(".product_name_container").each(function() {
        var productName = $(this).find(".product_name_input").val();
        var productNo=$(this).find(".product_no_input").val();
        const $a=$("<a>");
        $a.attr("href", "<%=request.getContextPath()%>/store/storeView.do?no="+productNo);
        $a.text(productName);
        $a.css("fontSize", "12px");
        $(this).append($a);
    });
 
    $(".cart-checkbox").on("change", function() {
        updateTotalPrice();
    });

    // 수량 변경
    $(".minus").on("click", function() {
        var input = $(this).siblings(".numBox");
        var quantity = parseInt(input.val());
        if (quantity > 1) {
            quantity--;
            input.val(quantity);
            updateProductPrice(input);
            updateTotalPrice();
        }
    });
    $(".plus").on("click", function() {
        var input = $(this).siblings(".numBox");
        var quantity = parseInt(input.val());
        quantity++;
        input.val(quantity);
        updateProductPrice(input);
        updateTotalPrice();
    });

    // 주문 금액 및 판매가 초기화
    function updateProductPrices() {
        $(".priceByProduct, .shop-bk").each(function() {
            var priceText = $(this).text();
            var price = parseInt(priceText.replace(/,/g, ""));
            if (!isNaN(price)) {
                $(this).text(price.toLocaleString());
            }
        });
    }

    // 주문 금액 업데이트
    function updateProductPrice(input) {
        var quantity = parseInt(input.val());
        var row = input.closest("tr");
        var priceText = row.find(".shop-bk").eq(2).text();
        var price = parseInt(priceText.replace(/,/g, ""));
        if (!isNaN(price)) {
            var priceByProduct = price * quantity;
            row.find(".priceByProduct").text(priceByProduct.toLocaleString());
        }
    }

    // 총 금액
    function updateTotalPrice() {
        var totalPrice = 0;
        $(".cart-checkbox:checked").each(function() {
            var row = $(this).closest("tr");
            var quantity = parseInt(row.find(".numBox").val());
            var priceText = row.find(".shop-bk").eq(2).text();
            var price = parseInt(priceText.replace(/,/g, ""));
            if (!isNaN(price)) {
                var priceByProduct = price * quantity;
                row.find(".priceByProduct").text(priceByProduct.toLocaleString());
                totalPrice += priceByProduct;
            }
        });
        $("#totalPrice").text(totalPrice.toLocaleString());
        $("#productTotalPrice").text(totalPrice.toLocaleString());
        $("#paymentTotalPrice").text(totalPrice.toLocaleString());
    }
 // 단일 상품 주문하기 클릭
    $(".SBOrder-btn").click(function() {
        var row = $(this).closest("tr");
        var pNo = row.find(".product_no_input").val();
        var count = parseInt(row.find(".numBox").val());
        var userId = $("#userId").val();
        
        // 폼 생성
        var form = $('<form action="<%=request.getContextPath()%>/store/storeOrder.do" method="post"></form>');
        form.append('<input type="hidden" name="cart-checkbox" value="' + pNo + '">');
        form.append('<input type="hidden" name="numBox" value="' + count + '">');
        form.append('<input type="hidden" name="userId" value="' + userId + '">');
        
        // 폼을 body에 추가하고 submit
        $('body').append(form);
        form.submit();
    });
    
    $("#deleteCartBtn").click(function () {
		let chk_arr=[];
		$(".cart-checkbox:checked").each(function(){
			chk_arr.push($(this).val()); 
		});
		if(confirm("선택 상품 모두 장바구니에서 삭제하시겠습니까?")){
		location.assign("<%=request.getContextPath()%>/store/deleteCart.do?chk_arr="+chk_arr+"&id=<%=loginMember.getMemberId()%>");
		}else{
			alert("삭제하기 취소");
		}
		reload();
	});
    
    $("#orderCartBtn").click(function() {
        if (!checkSelectedProducts()) {
          return;
        }
        $("#orderForm").submit();
      });

      // 선택된 상품 체크 여부 확인
      function checkSelectedProducts() {
        var checkedProducts = $(".cart-checkbox:checked");
        if (checkedProducts.length === 0) {
          alert("주문할 상품을 선택해주세요.");
          return false;
        }
        return true;
      }
 
});

</script>
</html>
