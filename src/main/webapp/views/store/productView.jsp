<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<%@page import="java.util.List,com.stagemate.store.model.vo.Product,com.stagemate.store.model.vo.StoreUpfile"%>
<%
Product p = (Product)request.getAttribute("p");
List<StoreUpfile> files = (List) request.getAttribute("fileList");
StoreUpfile main=null;
StoreUpfile detail=null;
for(StoreUpfile f:files){
	if(f.getIsMainImg()=='Y'){
		main=f;
	}else{
		detail=f;
	}
};
%>
<link rel="stylesheet" href="<%= contextPath %>/css/jaehun/style_main.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/yoonjin/style_store_product_view.css">
<title>Product</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section class="min1280px">
	<div id="sectionContainer" class="max1280px min720px">
		<div id="product-container">
			<div id="productMainImage">
				<img
					src="<%=contextPath+"/upload/yoonjin/"+main.getImgFileRename()%>"
					alt="">
			</div>
			<div id="productInfo">
				<div id="infoDetail">
					<table>
						<tr>
							<td colspan="2"><h3><%=p.getProductTitle() %></h3></td>
						</tr>
						<tr>
							<td colspan="2"><%=p.getProductNm() %></td>
						</tr>
						<tr>
							<td>판매가</td>
							<td><span id="pricebyone"><%=p.getProductPrice()%></span></td>
						</tr>
						<tr>
							<td>수량 선택</td>
							<td id="product-select-count"><img
								src="<%=contextPath %>/images/yoonjin/button/minus.svg" alt="">
								<p class="fixed-width">1</p> <img
								src="<%=contextPath %>/images/yoonjin/button/plus.svg" alt="">
							</td>
						</tr>
					</table>
					<div id="likeAndShare">
						<div id="like">
							<img src="<%=contextPath %>/images/yoonjin/button/btn_wish.svg"
								alt="">
							<p id="like-cnt"><%=p.getProductLikeCnt() %></p>
						</div>
						<img src="<%=contextPath %>/images/yoonjin/button/share.jpg" alt=""
							id="shareSvg">
					</div>
				</div>
				<div id="product-order-ready">
					<hr class="linestyle01">
					<div id="product-total">
						<div id="product-totalPrice">
							<p>총 상품 금액</p>
						</div>
						<div id="product-totalspan">
							<p>(총 수량 1개)</p>
							<p></p>
						</div>
					</div>
					<hr class="linestyle01">
					<div id="product-view-btn">
						<button id="product-view-btn_pay">바로 구매</button>
						<button id="product-view-btn_cart">
							<img src="<%=contextPath %>/images/yoonjin/button/btn_cart.svg"
								alt="">
						</button>
						<button id="product-view-btn_wish">
							<img src="<%=contextPath %>/images/yoonjin/button/btn_wish.svg"
								alt="">
						</button>
					</div>
				</div>
			</div>
		</div>
		<div id="detail-container">
			<nav>
				<ul>
					<li id="li-detailInfo" class="active">상세정보</li>
					<li id="li-review" class="">리뷰(2)</li>
					<li id="li-cancleInfo" class="">반품/교환정보</li>
				</ul>
			</nav>
			<hr class="linestyle02">
			<div id="product-detailInfo">
				<img
					src="<%=contextPath+"/upload/yoonjin/"+detail.getImgFileRename()%>"
					alt="">
			</div>
			<div id="product-review">
				<div id="product-review-warning">
					<img src="<%=contextPath %>/images/yoonjin/information/warning.svg" alt="">
					<p>리뷰는 해당 상품을 구매한 MATE에 한해서만 작성할 수 있습니다.<br>
						매매, 욕설 등 운영 규정에 위반되는 글은 사전 통보없이 삭제될 수 있습니다.</p>
				</div>
				<div id="review-reacted">
					<p>반응</p>
					<ul>
						<li><img src="<%=contextPath %>/images/yoonjin/emoji/smile.png" alt=""><p>1</p></li>
						<li><img src="<%=contextPath %>/images/yoonjin/emoji/bad.png" alt=""><p>0</p></li>
						<li><img src="<%=contextPath %>/images/yoonjin/emoji/sad.png" alt=""><p>0</p></li>
						<li><img src="<%=contextPath %>/images/yoonjin/emoji/wow.png" alt=""><p>1</p></li>
						<li><img src="<%=contextPath %>/images/yoonjin/emoji/none.png" alt=""><p>0</p></li>
					</ul>
				</div>
				<div id="review-box-container">
					<div>
						<p id="store-review-writer">good*******</p>
						<p id="store-review-content">생각보다 크기가 작긴 하지만 자력도 세고 디자인은 마음에 들어요!</p>
						<div id="reactionAndDate">
							<img id="store-review-react" src="<%=contextPath %>/images/yoonjin/emoji/smile.png">
							<p id="store-review-date">작성일 2023.06.09</p>
						</div>
					</div>
					<div>
						<p id="store-review-writer">yoo*****</p>
						<p id="store-review-content">이쁜데 좀 비싼듯?</p>
						<div id="reactionAndDate">
							<img id="store-review-react" src="<%=contextPath %>/images/yoonjin/emoji/wow.png">
							<p id="store-review-date">작성일 2023.05.18</p>
						</div>
					</div>
				</div>
			</div>
			<div id="product-cancleInfo">
				<img src="<%=contextPath %>/images/yoonjin/information/교환반품안내서.jpg" alt="">
			</div>
		</div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp" %>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
<script src="<%= contextPath %>/js/jaehun/script_main.js"></script>
<script src="<%=contextPath%>/js/yoonjin/store_product_view.js"></script>
</body>
</html>