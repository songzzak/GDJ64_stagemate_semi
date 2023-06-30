<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet" href="<%=contextPath%>/css/yelin/play/style_sales_play_info.css"> 
<%@ page import="java.util.List,com.stagemate.detail.model.vo.EventOrder,com.stagemate.member.model.vo.Member"%>
<title>STAGEMATE</title>
</head>
<body>
 <%
   //PlayDetail 정보 가져와야 한다. 
   	List<EventOrder> eventOrders = (List) request.getAttribute("eventOrders");
 	Member m=eventOrders.size()>0?eventOrders.get(0).getMember():null;
   %>

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
            <%if(m!=null){ %>
                <tr>
                    <td>이름</td>
                    <td><%=m.getMemberNm() %></td>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td><%=m.getMemberId() %></td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td><%=m.getMemberBdate() %></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><%=m.getMemberEmail() %></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><%=m.getMemberPhone() %></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><%=m.getMemberAddress() %></td>
                </tr>
              <%}else{%>
              	<tr>
              		<td>존재하지않는 사용자입니다.</td>
              	</tr>
              <%} %>
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
        	<%if(eventOrders.size()>0){ 
	        	 for(EventOrder eo:eventOrders){ %>
		            <tr>
		                <td class="book_no"><a href=""  style="text-decoration-line: none; color:black;"><%=eo.getRsvNo() %></a></td>
		                <td class="book_no"><%=eo.getEvent().getEventNm() %></td>
		                <td class="book_no"><%=eo.getEsDate() %></td>
		                <td class="book_no"><%=eo.getTcnt() %></td>
		                <td class="book_no"><%=eo.getOrderStatus() %></td>
		                <td class="book_no">
		                	<a href="javascript:CancelPlaypage('<%=eo.getRsvNo() %>')"
		                			style="text-decoration-line: none; color:black; font-weight:bold;">취소</a>
		               	</td>
		            </tr>
	           <%}
        	}else{ %>
          		<tr colspan="6">
              		<td>예매내역이 없습니다.</td>
              	</tr>
        	<%} %>
        </tbody>
    </table>
    </div>


<script>
	const closeWin=()=>{
		window.close();
	}
	
	const CancelPlaypage=(rsvNo)=>{
		const childWindow=open("<%=contextPath%>/admin/SalesPlayCancel.do?rsvNo="+rsvNo," blank","width=650,height=450");
	}
		
</script>


</body>


</body>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<%-- <script src="<%=contextPath%>/js/yelin/play/ReviewWrite_play.js"></script> --%>
</html>