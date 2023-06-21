

$("#store_nav_menu span").on("click",function(e){
    $("#store_nav_menu").find("span").removeClass("select-store-menu");
    $(e.target).addClass("select-store-menu");
})
$(".bar-num").on("click",function(e){
  $(".bar-num").find("span").removeClass("select-store-menu");
  $(e.target).addClass("select-store-menu");
})

  $(".wish").on("click", function(e) {
    let $heartIcon = $(this).find("svg");
    let $countElement = $(this).find(".wish-count");
    let count = parseInt($countElement.text());
	let productNo = $(this).closest(".product").find(".productDetails input[type='hidden']").val();
  
  	console.log(count);
  	console.log(productNo);
  	const userId=$("#userId").val();
    console.log(userId);
   if(userId!=""){
	    if ($heartIcon.css("fill") === "none") {
	      $heartIcon.css("fill", "#BC0000");
	      count=(count+1);
	      //$(this).off("click");
	    } else {
	      $heartIcon.css("fill", "none");
	      count=(count-1)
	    }
	    //console.log(count);
	    //console.log(getContextPath());
	    $countElement.text(count); // 좋아요 수 업데이트
		  $.post(getContextPath() + "/store/updateProductLikeCnt.do", 
		  {
		    productNo: productNo,
		    newLikeCount: count
		  });
	}else{
		alert("로그인 후 이용 가능합니다.");
	}
  });
  
$(".imageContainer").click(function(e) {
  var pNo = $(this).siblings('.productDetails').find('input[type="hidden"]').val();
  console.log(pNo);
  location.assign(getContextPath() + "/store/storeView.do?no=" + pNo);
});

$("#search_button").click(() => {
    const keyword = $("#input_search_text").val();
   	location.href = getContextPath() + "/store/productSearch.do?search=" + keyword;
});

