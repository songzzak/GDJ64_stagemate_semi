<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<%@ include file="/views/common/header.jsp" %>
<link rel = "stylesheet" href = "<%=contextPath %>/css/style.css">

<section class="min1280px">
  <div id="sectionContainer" class="max1280px">
    <div class="board_wrap">
        <div class="board_title">
            <strong>공지사항</strong>
            <p>예매 가이드를 안내해드립니다.</p>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                    스테이지 메이트 예매 가이드
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd>1</dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd>관리자</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>2023.6.16</dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>38</dd>
                    </dl>
                </div>
                <div class="cont">
                    <span class="step_num">STEP.1</span>
                    <span class="step_title">날짜/회차</span>
                    <p>관람하실 공연의 날짜, 회차를 선택하고, [예매하기]를 누릅니다.</p>
                    <em class="first_notice">예매창이 뜨지 않나요?? 
                     <span class="color_point">팝업을 허용</span>해주세요.</em>
                <ul class="dsc_list">
                     <li>Internet Explorer : 도구(Alt+X) &gt; 인터넷 옵션 &gt; 개인정보 &gt; 팝업차단 - ‘팝업 차단 사용’ 체크해제</li>
                     <li>Chrome : 메뉴 &gt; 설정 &gt; 고급 설정 표시 &gt; 개인정보 &gt; 콘텐츠 설정 &gt; 팝업 - ‘모든 사이트에서 팝업 표시 허용’ 체크</li>
                </ul>
                <br>
                    <span class="step_num second">STEP.2</span>
                    <span class="step_title second">등급/좌석</span>
                    <p> 원하는 좌석을 선택합니다.</p>
                <ul class="dsc_list">
                    <li>좌석선택 후 [다음단계]를 클릭하면 해당좌석이 <span class="color_point">8분 동안 선점</span>됩니다. (결제를 완료하셔야 예매가 완료됩니다.)</li>
                </ul>
               <br>
               <li>
                    <span class="step_num third">STEP.3</span>
                    <span class="step_title third">매수/배송방법</span>
                <div class="bx_right">
                    <p> 티켓의 가격을 확인하고, 예매할 티켓 매수를 선택해주세요<br>
                    <span class="color_point"> 배송방법(현장수령/배송)</span>선택하고, 배송으로 받을 경우 배송지를 입력해주세요</p>
                </div>
              </li>
             <br>
            <li>
                    <span class="step_num fourth">STEP.4</span>
                    <span class="step_title fourth">결제</span>
          <div class="bx_right">
                <p>결제 창이 뜨면, 결제 수단을 선택하고 결제합니다.</p>
            <ul class="dsc_list">
                <li> <span class="color_point">(필수) </span>결제 동의가 필요합니다.</li>
                <li>[예매확인] 또는 , 마이페이지 &gt; 예매확인/취소에서 예매된 내역을 확인해주세요.</li>
            </ul>k
          </div>
           </li>
        </div>
           </div>
            </div>
            <div class="bt_wrap">
                <a href="main.html" class="on">목록</a>
            </div>



<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>