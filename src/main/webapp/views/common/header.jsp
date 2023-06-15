<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="min1280px">
    <div class="header-container max1280px">
        <div>
            <img src="<%= request.getContextPath() %>/images/common/logo_header.svg" alt="로고_헤더">
        </div>
        <nav>
            <ul>
                <li><a href="#" class="sample">홈</a></li>
                <li><a href="#">뮤지컬</a></li>
                <li><a href="#">연극</a></li>
                <li><a href="#">콘서트</a></li>
                <li><a href="#">스토어</a></li>
                <li><a href="#">커뮤니티</a></li>
            </ul>
        </nav>
        <form class="header-container-search">
            <div>
                <input type="text" class="fw-light" placeholder="이거 누르면 지워짐" onfocus="this.placeholder = ''"
                    onblur="this.placeholder = '이거 누르면 지워짐'">
            </div>
            <div class="search_submit">
                <input type="submit" value="" 
                	style="background-image: url('<%= request.getContextPath() %>/images/common/icon_search.svg')">
            </div>
        </form>
        <div class="header-container-icons">
            <div>
                <input type="button" value="" 
                	style="background-image: url('<%= request.getContextPath() %>/images/common/icon_login.svg')">
                <p class="fw-bold">로그인</p>
            </div>
            <div>
                <input type="button" value="" 
                	style="background-image: url('<%= request.getContextPath() %>/images/common/icon_cart.svg')">
                <p class="fw-bold">장바구니</p>
            </div>
            <div>
                <input type="button" value="" 
                	style="background-image: url('<%= request.getContextPath() %>/images/common/icon_notice.svg')">
                <p class="fw-bold">공지사항</p>
            </div>
        </div>
    </div>
</header>