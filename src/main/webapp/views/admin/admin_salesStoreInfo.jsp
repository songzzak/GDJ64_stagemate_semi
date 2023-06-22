<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/store/style_sales_store_info.css"> 
<title>STAGEMATE</title>
</head>
<body>

	 <div class="MDStore_bigchart">
        <button type="button" class="btn_close" onclick="closeWin();"></button>

        <div class="OrderInfo_txt">  
        <p>회원정보</p>
        <div class="MDS_underline"></div>
        </div> 
        <div class="Order-group2">
            <img src="<%=contextPath%>/images/yelin/profile.png" alt="">
            <!-- 주문자정보 테이블 -->
            <table class="OrderInfo-table">
                <tr>
                    <td>이름</td>
                    <td>김뚜껑</td>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td>qwerty</td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td>1998년 09월 30일</td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>qwerty@naver.com</td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td>010-1234-1234</td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td>경기도 시흥시 주소주소주소소소</td>
                </tr>
            </table>
        </div>
       

    <div class="OrderInfo_txt">  
        <p>구매정보</p>
        <div class="MDS_underline"></div>
    </div> 
        
<!-- 예매내역 -->
<div class="PurchaseList-store">
    <table class="PurchaseList-table" style="margin: 30px auto; margin-right: auto;">
        <colgroup>
            <col style="width:100px">
            <col style="width:100px">
            <col style="width:270px">
            <col style="width:100px">
            <col style="width:80px">
            <col style="width:70px">
        </colgroup>
        <thead>
            <tr>
                <th scope="col">주문일자</th>
                <th scope="col">주문번호</th>
                <th scope="col">상품명</th>
                <th scope="col">결제금액</th>
                <th scope="col">상태</th>
                <th scope="col">취소하기</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="book_no">2023-06-04</td>
                <td class="book_no"><a href=""  style="text-decoration-line: none;">S120329133</a></td>
                <td class="book_no">[셰퍼드 페어리 행동하라!] 아크릴마그넷_S.F</a></td>
                <td class="book_no">14,000원</td>
                <td class="book_no">배송 중</td>
                <td class="book_no"><a href="" onclick="CancelStorepage();" 
                		style="text-decoration-line: none; color:black; font-weight:bold;">취소</a>
                </td>
            </tr>
                        <tr>
                <td class="book_no">2023-06-04</td>
                <td class="book_no"><a href=""  style="text-decoration-line: none;">S120329133</a></td>
                <td class="book_no">[셰퍼드 페어리 행동하라!] 아크릴마그넷_S.F</a></td>
                <td class="book_no">14,000원</td>
                <td class="book_no">배송 중</td>
                <td class="book_no">
                	<a href="" style="text-decoration-line: none; color:black;">취소</a>
                </td>
            </tr>
        </tbody>
    </table>


<!-- 페이징바 -->
<div class="page-bar">
    <svg class="arrow-left" width="30" height="31" viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M21.9873 23.4766L23.7498 21.7141L18.0248 15.9766L23.7498 10.2391L21.9873 8.47656L14.4873 15.9766L21.9873 23.4766Z" fill="black"/>
        <path d="M13.75 23.4766L15.5125 21.7141L9.7875 15.9766L15.5125 10.2391L13.75 8.47656L6.25 15.9766L13.75 23.4766Z" fill="black"/>
    </svg>
    <svg class="double-arrow-left" width="30" height="31" viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M19.2625 21.7141L13.5375 15.9766L19.2625 10.2391L17.5 8.47656L10 15.9766L17.5 23.4766L19.2625 21.7141Z" fill="black"/>
    </svg>
    <a class="page-num select">1</a>
    <a class="page-num">2</a>
    <a class="page-num">3</a>
    <svg class="arrow-right" width="30" height="31" viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M10.7375 10.2391L16.4625 15.9766L10.7375 21.7141L12.5 23.4766L20 15.9766L12.5 8.47656L10.7375 10.2391Z" fill="black"/>
    </svg>
    <svg class="double-arrow-right" width="30" height="31" viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M8.0127 8.47656L6.2502 10.2391L11.9752 15.9766L6.2502 21.7141L8.0127 23.4766L15.5127 15.9766L8.0127 8.47656Z" fill="black"/>
        <path d="M16.25 8.47656L14.4875 10.2391L20.2125 15.9766L14.4875 21.7141L16.25 23.4766L23.75 15.9766L16.25 8.47656Z" fill="black"/>
    </svg>  
</div>
    </div>
</body>
	
	<script>
		const closeWin=()=>{
			window.close();
		}
		const CancelStorepage=()=>{
			const childWindow=open("<%=contextPath%>/admin/SalesStoreCancel.do","_blank","width=650,height=450");
		}
	</script>



</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
</html>