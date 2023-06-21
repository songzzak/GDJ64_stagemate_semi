<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<%@page import="java.util.List,com.stagemate.store.model.vo.Product,com.stagemate.store.model.vo.StoreUpfile,com.stagemate.deliveryAddress.model.vo.DlvAdress"%>
<%
Product p = (Product)request.getAttribute("p");
StoreUpfile main = (StoreUpfile)request.getAttribute("main");
int count = (int)request.getAttribute("count");
DlvAdress d=(DlvAdress)request.getAttribute("defaultAddress");
%>
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
                                <span><%=d.getDlvNm() %></span>
                                <button class="btn-layout2 btn-brown" onclick="openPopup('<%=contextPath%>/dlv/selectDlvAddress.do?userId=<%=loginMember.getMemberId()%>')">배송지변경</button>
                            </div>
                        </li>
                        <li>
                            <span>이름</span>
                            <div>
                                <span><%=d.getDlvPerson() %></span>
                            </div>
                        </li>
                        <li>
                            <span>연락처</span>
                            <div>
                                <span><%=d.getDlvPhone() %></span>
                            </div>
                        </li>
                        <li>
                            <span>주소</span>
                            <div><span><%=d.getDlvAddress() %></span></div>
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
                                        <img src="<%=contextPath+"/upload/yoonjin/"+main.getImgFileRename()%>" alt="" width="60px">
                                        <h3 class="orderform_product_name"><%=p.getProductNm() %></h3>
                                    </div>
                                </td>
                                <td><%=count %>개</td>
                                <td><%=p.getProductPrice() %></td>
                                <td>무료</td>
                                <td><%=(count*p.getProductPrice()) %></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <hr class="hr_margin_style01">
            <div id="btn_order_form">
                <button class="storeorder_btn_prev">이전단계</button>
                <button class="storeorder_btn_next" onclick="requestPay();">결제하기</button>
            </div>
        </div>
</section>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
	var IMP = window.IMP; 
	IMP.init("imp13225244"); 

	var today = new Date();   
	var hours = today.getHours(); // 시
	var minutes = today.getMinutes();  // 분
	var seconds = today.getSeconds();  // 초
	var milliseconds = today.getMilliseconds();
	var makeMerchantUid = hours +  minutes + seconds + milliseconds;
	
	function requestPay() {
	    IMP.request_pay({
	    	pg: "html5_inicis",
	        pay_method : 'card',
	        merchant_uid: "IMP"+makeMerchantUid, 
	        name : '<%=p.getProductTitle()+p.getProductNm() %>',
	        amount : 1,
	        buyer_email : 'Iamport@chai.finance',
	        buyer_name : '아임포트 기술지원팀',
	        buyer_tel : '010-1234-5678',
	        buyer_addr : '서울특별시 강남구 삼성동',
	    }, function (rsp) {
	        console.log(rsp);
	        if (rsp.success) {
	          var msg = '결제가 완료되었습니다.';
	          alert(msg);
	     	<%--   // 결제 완료 후 서블릿으로 데이터 전송
	            var xhr = new XMLHttpRequest();
	            xhr.open("POST", "<%=request.getContextPath()%>/store/orderComplete.do", true);
	            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	            xhr.onreadystatechange = function () {
	                if (xhr.readyState === 4 && xhr.status === 200) {
	                    console.log(xhr.responseText);
	                    // 서블릿에서 orderComplete.jsp로 이동
	                    location.href = "<%=request.getContextPath()%>/store/orderComplete.jsp";
	                }
	            };
	            // 전송할 데이터 설정 (주문자 정보, 배송지 정보 등)
	            var data = "paymentNo=" + encodeURIComponent(rsp.merchant_uid) +
	                "&paymentPrice=" + encodeURIComponent(rsp.paid_amount) +
	                "&paymentMeans=" + encodeURIComponent(rsp.pay_method) +
	                "&memberId=" + encodeURIComponent('<%=loginMember.getMemberId() %>') +
	                "&dlvId=" + encodeURIComponent('<%=dlvId %>') +
	                "&shipMsg=" + encodeURIComponent('<%=shipMsg %>') +
	                "&totalPrice=" + encodeURIComponent('<%=(count*p.getProductPrice()) %>');	            
	            xhr.send(data); --%>
	        } else {
	          var msg = '결제에 실패하였습니다.';
	          msg += '에러내용 : ' + rsp.error_msg;
	          alert(msg);
	        }
	      });
	}
</script>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%= contextPath %>/js/yoonjin/store_order_form.js"></script>
</body>
</html>