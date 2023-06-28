<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<link rel="stylesheet" href="<%= contextPath %>/css/yelin/play/Refund_play.css">
<%@ page import="java.util.List,com.stagemate.detail.model.vo.DetailInfo"%>
<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%=contextPath%>/js/yelin/Refund_play.js"></script>
<script src="<%=contextPath%>/js/yelin/detailList.js"></script>
<title>STAGEMATE</title>
</head>
<body>
	<%
	DetailInfo detailInfo = (DetailInfo)request.getAttribute("DetailInfo");
	%>
	<script>
		rsvNo = '<%= detailInfo.getRsvNo()%>';
		esNo = '<%= detailInfo.getEsNo()%>';
	</script>
<%@ include file="/views/common/header.jsp" %>

<section class="min1280px">
    <div id="sectionContainer" class="max1280px">
            

        <h1 id="RefundFin_play_title">취소완료</h1>
        <div class="division-line"></div>

        <div class="warning-msg2" >
            <img class="w_m_img" src="<%= contextPath %>/images/yelin/warning.png">
            <p id="warning-txt2">예매취소가 정상적으로 완료 되었습니다.
 
            </p>
        </div>

        <h4 class="refund-cnt">환불 내역</h4>
        <div class="refundbox">

            <p class="refundbox-text"><%=detailInfo.getEventName() %></p>
        </div>

        <h4 class="refundcnt-detail">환불 상세내역</h4>
        <table class="refundcnt-detail-chart">
            <tr>
                <th>환불 방법</th>
                <td>카드 취소</td>
            </tr>
            <tr>
                <th>환불 금액</th>
                <td><%=detailInfo.getRsvPirce() %>원</td>   
            </tr>
            <tr>
                <th>환불일정</th>
                <td>취소처리 완료 후, 영업일기준 3~4일 뒤에 카드사의 승인취소가 확인됩니다. </td>
            </tr>   

        </table>


      <div class="refundcnt-btn">
            <input type="button" class="re-btn4" value="예매내역목록" onclick="location.assign('<%=request.getContextPath()%>/Detail/DetailListServlet.do')">
            <input type="button" class="refund-btn2" value="취소내역 확인하기" onclick="detailListPage2('1');">
        </div>
    </div> 
        
   
        
    </section>


<%@ include file="/views/common/footer.jsp" %>
</body>

</html>