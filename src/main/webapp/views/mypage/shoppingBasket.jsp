<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/store/style_shoppingBasket.css">
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
            <div class="SB_bigchart">
                <p class="ShoppingBasket_eng">My Page</p>
                <p class="ShoppingBasket_kor">장바구니</p>
                <div class="deliv-group">
                    <p class="deliv-txt">업체 조건 배송 상품</p>
                    <p class="deliv-txt2">무료 배송</p>
                </div>
                <!-- 장바구니 내역 -->
                <div class="ShoppingBasket_List">
                    <table class="ShoppingBasket-table" style="margin: 3px auto; margin-right: auto;">
                        <colgroup>
                            <col style="width: 50px">
                            <col style="width: 170px">
                            <col style="width: 250px">
                            <col style="width: 135px">
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col"><input type="checkbox" value="전체선택" id="selectAll"></th>
                                <th scope="col">상품 정보</th>
                                <th scope="col">수량</th>
                                <th scope="col">상품 금액</th>
                                <th scope="col">주문</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            if (carts == null) {
                            %>
                            <tr>
                                <td colspan="5">조회된 장바구니 목록이 없습니다.</td>
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
                                <td class="shop-bk"><input type="checkbox" class="cart-checkbox" checked></td>
                                <td class="shop-bk" id="product-name"><a href=""><%=p.getProductNm()%></a></td>
                                <td class="shop-bk">
                                    <div class="haha">
                                        <button type="button" class="minus">-</button>
                                        <input type="number" class="numBox" min="1" max="" value="<%=c.getCartAmt()%>" readonly/>
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
                                <td colspan="5" class="SBT-txt">
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
                    <div class="SB-lowerbtn">
                        <input type="button" class="lowerbtn-basket" value="장바구니 삭제">
                        <input type="button" class="lowerbtn-purchase" value="구매하기">
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
    // 체크박스 변경 시 이벤트
    $(".cart-checkbox").on("change", function() {
        updateTotalPrice();
    });

    // 수량 변경 시 이벤트
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

    // 상품 금액 업데이트 함수
    function updateProductPrice(input) {
        var quantity = parseInt(input.val());
        var row = input.closest("tr");
        var priceByProduct = parseInt(row.find(".priceByProduct").text());
        var newPriceByProduct = priceByProduct * quantity;
        row.find(".priceByProduct").text(newPriceByProduct);
    }

    // 총 금액 업데이트 함수
    function updateTotalPrice() {
        var totalPrice = 0;
        $(".cart-checkbox:checked").each(function() {
            var row = $(this).closest("tr");
            var quantity = parseInt(row.find(".numBox").val());
            var priceByProduct = parseInt(row.find(".priceByProduct").text());
            totalPrice += priceByProduct * quantity;
        });
        $("#totalPrice").text(totalPrice);
        $("#productTotalPrice").text(totalPrice);
        $("#paymentTotalPrice").text(totalPrice);
    }
});
</script>
</html>
