<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<%@page import="java.util.List,com.stagemate.store.model.vo.Product,com.stagemate.store.model.vo.StoreUpfile,com.stagemate.deliveryAddress.model.vo.DlvAdress"%>
<%
List<Product>productList=(List)request.getAttribute("productList");
List<Integer> quantityList=(List)request.getAttribute("quantityList");
List<StoreUpfile>filelist=(List)request.getAttribute("filelist");
DlvAdress d=(DlvAdress)request.getAttribute("defaultAddress");
int productCount=productList.size();
String firstProductNm=productList.get(0).getProductNm();
%>
<link rel="stylesheet" href="<%=contextPath %>/css/yoonjin/style_store_order_form.css">
<title>StageMate | 배송정보입력</title>
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
            <form id="store_payment_form" method="post" action="<%= contextPath %>/payment/storeOrderEnd.do">
	            <input type="hidden" name="userId" value="<%=loginMember.getMemberId()%>">
	            <div id="section_orderform">
	                <div id="store-delivery-info">
	                    <h3>배송 정보</h3>
	                    <ul>
	                        <li>
	                            <span>배송지</span>
	                            <input type="hidden" name="dlvId" value="<%=d.getDlvId()%>">
	                            <div>
	                                <span id="dlvName"><%=d.getDlvNm() %></span>
	                                <button class="btn-layout2 btn-brown" onclick="openPopup('<%=contextPath%>/dlv/selectDlvAddress.do?userId=<%=loginMember.getMemberId()%>')">배송지변경</button>
	                            </div>
	                        </li>
	                        <li>
	                            <span>이름</span>
	                            <div>
	                                <span id="dlvPerson"><%=d.getDlvPerson() %></span>
	                            </div>
	                        </li>
	                        <li>
	                            <span>연락처</span>
	                            <div>
	                                <span id="dlvPhone"><%=d.getDlvPhone() %></span>
	                            </div>
	                        </li>
	                        <li>
	                            <span>주소</span>
	                            <div><span id="dlvAddress"><%=d.getDlvAddress() %></span></div>
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
	                                <% for (int i = 0; i < productCount; i++) { %>
								        <input type="hidden" name="quantityList" value="<%= quantityList.get(i) %>">
								        <input type="hidden" name="productNoList" value="<%= productList.get(i).getProductNo() %>">
								         <input type="hidden" name="productPriceList" value="<%= productList.get(i).getProductPrice() %>">
	    							<% } %>
	                                <input type="hidden" id="selectedOption" name="selectedOption">
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
	                              <%
	                            if (productList == null || productList.isEmpty()) {
	                            %>
	                            <tr>
	                                <td colspan="6">조회된 주문 목록이 없습니다.</td>
	                            </tr>
						      <% } else {
						        for (int i = 0; i < productList.size(); i++) {
						            Product product = productList.get(i);
						            StoreUpfile file = filelist.get(i);
						            for(StoreUpfile f:filelist){
						            	if(f.getProductNo()==product.getProductNo()&&f.getIsMainImg()=='Y'){
						            		file=f;
						            	}
						            }
						            int quantity = quantityList.get(i);
						    %>
						        <tr>
						            <td>
						                <div class="horizontal-list">
						                    <img src="<%= contextPath + "/upload/yoonjin/" + file.getImgFileRename() %>" alt="" width="60px">
						                    <h3 class="orderform_product_name"><%= product.getProductNm() %></h3>
						                </div>
						            </td>
						            <td><%= quantity %>개</td>
						            <td><%= product.getProductPrice() %></td>
						            <td>무료</td>
						            <td><%= (quantity * product.getProductPrice()) %></td>
						            <input type="hidden" id="totalprice" name="totalprice" value="">
						        </tr>
						    <% }
						    } %>
						</tbody>
	                    </table>
	                </div>
	            </div>
            </form>
            <hr class="hr_margin_style01">
            <div id="btn_order_form">
                <button class="storeorder_btn_prev">이전단계</button>
                <button class="storeorder_btn_next" onclick="requestPay()">결제하기</button>
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
		//배송요청사항
		var selectedOption = $("#dlv_selectbox").val();
	    $("#selectedOption").val(selectedOption);
	    //결제금액
	    var totalAmount = 0;
	    var quantityList = $("input[name='quantityList']");
        var productPriceList = $("input[name='productPriceList']");
	    for (var i = 0; i < productPriceList.length; i++) {
	        totalAmount += parseInt(quantityList[i].value) * parseInt(productPriceList[i].value);
	    }
		$("#totalprice").val(totalAmount);
	    IMP.request_pay({
	    	pg: "html5_inicis",
	        pay_method : 'card',
	        merchant_uid: "STR"+makeMerchantUid, 
	        name : '<%=firstProductNm%>',
	        amount : 100,
	        buyer_email : '<%=loginMember.getMemberEmail() %>',
	        buyer_name : '<%=d.getDlvPerson() %>',
	        buyer_tel :'<%=d.getDlvPhone()%>',
	        buyer_addr : '<%=d.getDlvAddress() %>',
	    }, function (rsp) {
	        console.log(rsp);
	        if (rsp.success) {
	          var msg = '결제가 완료되었습니다.';
	          alert(msg);
	          var inputElement = $("<input>")
	            .attr("type", "hidden")
	            .attr("name", "merchant_uid")
	            .val(rsp.merchant_uid);
	        $("#store_payment_form").append(inputElement);
	     	$("#store_payment_form").submit();
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