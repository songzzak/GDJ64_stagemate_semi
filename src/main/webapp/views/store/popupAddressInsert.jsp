<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 추가 | StageMate</title>
<style>
    body{width:500px;height:440px;background-color:#f5f5f5;font-family:'Inter',sans-serif;margin:0;padding:0}
    form{margin:0 auto;padding:20px;box-sizing:border-box;background-color:#fff;border-radius:5px;box-shadow:0 2px 10px rgba(0,0,0,.1)}
    h1{margin:0;padding-bottom:20px;font-size:24px;font-weight:bold;color:#1C0808}
    table{width:100%;margin-bottom:20px;border-collapse:collapse}
    th{vertical-align:top;padding:10px 0;text-align:left;font-size:14px;color:#1C0808}
    td{vertical-align:top;padding:5px 10px;text-align:left;padding-left:10px}
    .n-input{width:100%;max-width:320px;padding:8px;border:1px solid #ccc;border-radius:3px;font-size:14px;color:#1C0808}
    .search{display:flex;align-items:center;flex-wrap:wrap}
    .search input[type="text"]{margin-bottom:5px}
    .search button{margin-bottom:5px;margin-left:5px}
    .n-btn{display:inline-block;font-size:14px;padding:8px 16px;border-radius:5px;cursor:pointer;border:none}
    .n-btn.btn-sm{padding:5px 10px;font-size:12px}
    .btn-accent{background-color:#E9B910;color:#fff}
    .btn-lighter{background-color:#f5f5f5;color:#1C0808;border:1px solid #ccc}
    .n-check-block{margin-top:10px}.n-check{vertical-align:middle;margin-right:5px}
    label{font-size:14px;color:#1C0808}
    .popup-btn{display:flex;justify-content:center;margin-top:20px}
    #search-input{display:flex;flex-direction:row;align-items:center;width:340px}
    #btn-search{width:50px;height:33px;z-index:10;padding:0;margin-left:-40px;border-top-left-radius:none;border-bottom-left-radius:none}
</style>

</head>
<body>
    <form action="<%=request.getContextPath()%>/dlv/insertDlvAddress.do" method="post" id="delivery_form">
    <input type="hidden" name="userId" value="<%=request.getParameter("userId") %>">
        <div>
            <h1>신규 배송지</h1>
            <table>
                <colgroup>
                    <col style="width:122px">
                    <col style="width:all">
                </colgroup>
                <tbody>
                    <tr>
                        <th>수령인</th>
                        <td><input name="name" type="text" class="n-input" value="" required></td>
                    </tr>
                    <tr>
                        <th>배송지명</th>
                        <td><input name="title" type="text" class="n-input" value="" required></td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td><input name="phone" type="text" class="n-input" value="" required></td>
                    </tr>
                    <tr>
                        <th>배송지 주소</th>
                        <td>
                            <div class="search">
                                <div id="search-input">
                                    <input id="zipcode" name="zipcode" data-name="data-zipcode" type="text" class="n-input" value="" readonly="" required>
                                    <button type="button" id="btn-search" class="n-btn btn-sm btn-accent" onclick="openPostCode('#zipcode', '#addr1', '#addr2');">검색</button>
                                </div>
                                <input id="addr1" name="addr1" data-name="data-addr1" type="text" class="n-input" value="" readonly="" required>
                                <input id="addr2" name="addr2" data-name="data-addr2" type="text" class="n-input" value="">
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="popup-btn">
                <button type="reset" class="n-btn btn-lighter" onclick="self.close();">취소</button>
                <button type="submit" class="n-btn btn-accent">등록</button>
            </div>
        </div>
    </form>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="<%= request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/script_common.js"></script>
</body>
</html>
