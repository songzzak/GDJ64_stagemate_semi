<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<%@ include file="/views/common/header.jsp" %>
<link rel = "stylesheet" href = "<%=contextPath %>/css/style.css">
<section class="min1280px">
    <div id="sectionContainer" class="max1280px">
		<div class="board_wrap">
			<div class="board_title">
				<strong>1:1 문의</strong>
			</div>
	        <div class="title_list">
				<table>
					<tr><a href="notice_view.html">공지사항</a> </tr>
					<tr> | </tr>
					<tr><a href="list.html">1:1 문의사항</a></tr>
				</table>
	        </div>
			<div class="board_list_wrap">
				<table>
                        <tr>
                            <th>번호</th>
                            <th>카테고리</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th> 
                        </tr>   
                        <tr>
                            <td>5</td>
                            <td>[예매]</td>
                            <td><a href="view.html">예매한 좌석을 변경하고 싶어요.</a></td>
                            <td>이제똥</td>
                            <td>2023.06.06</td>

                        </tr>      
                        
                        <tr>
                            <td>4</td>
                            <td>[상품]</td>
                            <td><a href="view.html">주문한 상품색상 변경원합니다. </a></td>
                            <td>무민럽</td>
                            <td>2023.06.05</td>
                        </tr>

                        <tr>
                            <td>3</td>
                            <td>[반품/취소]</td>
                            <td><a href="view.html">상품에 하자가 있어요.</a></td>
                            <td>제똥이 </td>
                            <td>2023.06.03</td>
                        </tr>

                        <tr>
                            <td>2</td>
                            <td>[회원정보]</td>
                            <td><a href="view.html">회원정보 변경 원합니다.</a></td>
                            <td>말랑이</td>
                            <td>2023.06.02</td>

                        </tr>

                        <tr>
                            <td>1</td>
                            <td>[배송]</td>
                            <td><a href="view.html">배송시작일이 궁금해요</a></td>
                            <td>젠콩이</td>
                        </tr>
                </table>
			</div>
		</div>
    </div>
</section>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>