<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>

<link rel="stylesheet" href="<%=contextPath %>/css/yoonjin/style_store_order_form.css">
<title>Order Form</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section class="min1280px">
        <div id="sectionContainer" class="max1280px container_style01">
            <div id="nav_orderform">
                <span>상품선택</span>
                <span><img src="<%=contextPath %>/images/yoonjin/button/arrow.svg" alt=""></span>
                <span style="color: #1C0808">배송정보입력</span>
                <span><img src="<%=contextPath %>/images/yoonjin/button/arrow.svg" alt=""></span>
                <span>결제완료</span>
            </div>
            <hr class="hr_margin_style01">
            <div id="section_orderform">
                <div id="store-delivery-info">
                    <h3>배송 정보</h3>
                    <ul>
                        <li>
                            <span>배송지</span>
                            <div>
                                <span>기본배송지</span>
                                <button class="btn-layout2 btn-brown" onclick="openPopup('<%=contextPath%>/views/store/popUpAddressSelect.jsp')">배송지변경</button>
                            </div>
                        </li>
                        <li>
                            <span>이름</span>
                            <div>
                                <span>김팬텀</span>
                            </div>
                        </li>
                        <li>
                            <span>연락처</span>
                            <div>
                                <span>010-1234-5678</span>
                            </div>
                        </li>
                        <li>
                            <span>주소</span>
                            <div><span>서울시 어쩌구 저쩌동 59-8 403</span></div>
                        </li>
                        <li>
                            <span>배송 요청사항</span>
                            <div>
                                <select name="dlv_selectbox" id="dlv_selectbox">
                                    <option value selected="selected">배송 요청사항을 선택해주세요</option>
                                    <option value="부재 시 경비실에 맡겨주세요">부재 시 경비실에 맡겨주세요</option>
                                    <option value="부재 시 택배함에 넣어주세요">부재 시 택배함에 넣어주세요</option>
                                    <option value="부재 시 집 앞에 놔주세요">부재 시 집 앞에 놔주세요</option>
                                    <option value="배송 전 연락바랍니다">배송 전 연락바랍니다</option>
                                </select>
                            </div>
                        </li>
                    </ul>
                </div>
                <hr class="hr_margin_style01">
                <div id="store-product-info">
                    <h3>상품 정보</h3>
                    <table>
                        <thead>
                            <th>상품정보</th>
                            <th>수량</th>
                            <th>가격</th>
                            <th>배송비</th>
                            <th>주문금액</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <div class="horizontal-list">
                                        <img src="<%=contextPath%>/images/yoonjin/store/셰퍼드페어리 아크릴마그넷 S.F. 대표이미지jpg.jpg" alt="" width="60px">
                                        <h3 class="orderform_product_name">아크릴 마그넷</h3>
                                    </div>
                                </td>
                                <td>2개</td>
                                <td>7,000</td>
                                <td>무료</td>
                                <td>14,000</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <hr class="hr_margin_style01">
            <div id="btn_order_form">
                <button class="storeorder_btn_prev">이전단계</button>
                <button class="storeorder_btn_next">결제하기</button>
            </div>
        </div>
</section>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%= contextPath %>/js/yoonjin/store_order_form.js"></script>
</body>
</html>