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
    console.log(e.target);
  	console.log($heartIcon);
  	console.log($countElement);
  	console.log(count);
    if ($heartIcon.css("fill") === "none") {
      $heartIcon.css("fill", "#BC0000");
      count=(count+1);
      //$(this).off("click");
    } else {
      $heartIcon.css("fill", "none");
      count=(count-1)
    }
    console.log(count);
	  $.post(getContextPath() + "/store/updateProductLikeCnt.do", {
	    productId: $("#productNo").val(),
	    newLikeCount: count
	  });
	
  });
  
$(".imageContainer").click(e=>{
    console.log(getContextPath());
	location.assign(getContextPath()+"/store/storeView.do");
});