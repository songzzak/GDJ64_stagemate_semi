<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.HttpServletRequest" %>
<%
   HttpServletRequest request2 = (HttpServletRequest) pageContext.getRequest();
   String contextPath = request2.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 변경 | StageMate</title>
<style>
    body{width:500px;height:970px;background-color:#f5f5f5;font-family:'Inter',sans-serif;margin:0;padding:0}
    .popup-address-list{position:relative;width:500px;height:970px;margin:0 auto;padding:20px;box-sizing:border-box;font-family:'Inter',sans-serif;background-color:#fff;border-radius:5px;box-shadow:0 2px 10px rgba(0,0,0,.1)}
    .popup-tit{margin:0;padding-bottom:20px;font-size:24px;font-weight:bold;color:#1C0808}
    .n-link{display:inline-block;font-size:14px;color:#1C0808;text-decoration:none;margin-top:10px;}
    .btn-insert-addr{margin-right:5px;color:#E9B910;}
    .list-dlv-address{margin-top:20px;border-bottom: 1px solid #666;}
    .addr-info{padding:10px;background-color:#f9f9f9;border-radius:5px;margin-bottom:10px}
    .addr-info span:first-child{font-size:18px;font-weight:bold;color:#1C0808}
    #default_addr{font-size:14px;font-weight:bold;color:#E9B910;margin-left:10px}
    .phone_no,.txt-addr{font-size:14px;color:#666;margin-top:5px}
    #addr-btns{display:flex;justify-content:space-between;align-items:center;margin-top:10px}
    .btn-left button{font-size:14px;color:#1C0808;background-color:transparent;border:none;cursor:pointer;margin-right:10px}
    .btn-right button{font-size:14px;color:#fff;background-color:#E9B910;border:none;cursor:pointer;padding:8px 16px;border-radius:5px}
    .list-dvl-paging{margin-top:20px;text-align:center}
</style>
</head>
<body>
    <div class="popup-address-list">
        <h1 class="popup-tit">배송지 변경</h1>
        <a href="" class="n-link" onclick="delivery_form(); return false;">
            <span class="btn-insert-addr">신규 배송지 등록</span>
            <span class="btn-insert-addr bigpont">+</span>
          </a>
        <div class="list-dlv-address">
            <div class="addr-info">
                <div>
                    <span>김팬텀(김팬텀님 배송지)</span>
                    <span id="default_addr">기본배송지</span>
                </div>
                <div class="phone_no">010-0000-0000</div>
                <div class="txt-addr">서울시 어쩌구 저쩌구</div>
                <div id="addr-btns">
                    <div class="btn-left">
                        <button>수정</button>
                        <button>삭제</button>
                    </div>
                    <div class="btn-right">
                        <button>선택</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="list-dvl-paging"></div>
    </div>
    <script>
        function delivery_form() {
        var url = "<%=contextPath %>/views/store/popupAddressInsert.jsp";
        window.open(url, '_blank', 'width=500, height=970');
        }
    </script>
</body>
</html>
