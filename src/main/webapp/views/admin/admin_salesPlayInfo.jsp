<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/play/style_sales_play_info.css"> 
<title>STAGEMATE</title>
</head>
<body>

	 <div class="MDPlay_bigchart">
        <button type="button" class="btn_close" onclick="closeWin();"></button>

        <div class="OrderInfo_txt">  
        <p>회원정보</p>
        <div class="MDP_underline"></div>
        </div> 
        <div class="Order-group">
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
        <p>예매정보</p>
        <div class="MDP_underline"></div>
    </div> 
        
<!-- 예매내역 -->
<div class="BookingList-play">
    <table class="BookingList-table" style="margin: 30px auto; margin-right: auto;">
        <colgroup>
            <col style="width:120px">
            <col style="width:185px">
            <col style="width:105px">
            <col style="width:70px">
            <col style="width:80px">
            <col style="width:80px">
        </colgroup>
        <thead>
            <tr>
                <th scope="col">예매번호</th>
                <th scope="col">티켓명</th>
                <th scope="col">관람일시</th>
                <th scope="col">매수</th>
                <th scope="col">상태</th>
                <th scope="col">취소하기</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="book_no"><a href=""  style="text-decoration-line: none;">S120329133</a></td>
                <td class="book_no">뮤지컬<아르토고흐></a></td>
                <td class="book_no">2023-08-02</td>
                <td class="book_no">1매</td>
                <td class="book_no">예매</td>
                <td class="book_no">
                	<a href="" onclick="CancelPlaypage();"
                			style="text-decoration-line: none; color:black; font-weight:bold;">취소</a>
               	</td>
            </tr>
            <tr>
                <td class="book_no"><a href=""  style="text-decoration-line: none;">S120329133</a></td>
                <td class="book_no">뮤지컬<나르치스와 골드문트></a></td>
                <td class="book_no">2023-07-24</td>
                <td class="book_no">1매</td>
                <td class="book_no">예매</td>
                <td class="book_no"><a href="" style="text-decoration-line: none; color:black;">취소</a></td>
            </tr> 
          
        
        </tbody>
    </table>
    </div>


<script>
	const closeWin=()=>{
		window.close();
	}
	
	const CancelPlaypage=()=>{
		const childWindow=open("<%=contextPath%>/admin/SalesPlayCancel.do","_blank","width=650,height=450");
	}
		
</script>








</body>
	
		



</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<%-- <script src="<%=contextPath%>/js/yelin/play/ReviewWrite_play.js"></script> --%>
</html>