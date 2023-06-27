         // 초기 상태에서는 #product-detailInfo만 표시!!
            $(document).ready(() => {
				const price=parseInt($("#pricebyone").text());
				$("#product-totalspan p:last-child").text((price).toLocaleString());
				
                $("#product-review, #product-cancleInfo").hide();

                $("#li-detailInfo").click(() => toggleActiveMenu($("#li-detailInfo"), "#product-detailInfo"));

                $("#li-review").click(() => toggleActiveMenu($("#li-review"), "#product-review"));

                $("#li-cancleInfo").click(() => toggleActiveMenu($("#li-cancleInfo"), "#product-cancleInfo"));

                const toggleActiveMenu = (clickedMenu, targetSection) => {
                    $(".active").removeClass("active");
                    clickedMenu.addClass("active");
                    $("div#detail-container > div").hide();
                    $(targetSection).show();
                };

                $("#product-select-count img:last-child").click(function() {
                    var count = parseInt($("#product-select-count p").text());
                    count++;
                    $("#product-select-count p").text(count);
                });
    
                $("#product-select-count img:first-child").click(function() {
                    var count = parseInt($("#product-select-count p").text());
                    if (count > 1) {
                    count--;
                    $("#product-select-count p").text(count);
                    }
                });

                var count = parseInt($("#ordercount").text());

                // 수량 변경 시 이벤트 핸들러
                $("#product-select-count img").click(function() {
                    if ($(this).is(":first-child")) {
                    // 마이너스 버튼 클릭 시
                    if (count > 1) {
                        count--;
                    }
                    } else {
                    // 플러스 버튼 클릭 시
                    count++;
                    }
                    // 수량 업데이트
                    // $("product-totalspan p").text(count);
                    $("#product-totalspan p:first-child").text("(총 수량 " + count + "개)");
					//금액 업데이트
					
					$("#product-totalspan p:last-child").text((count*price).toLocaleString());
                });
            });
            
$("#product-view-btn_pay").click(e => {
	const userId=$("#userId").val();
   if(userId!=""){
        const pNo = $("#pNo").val();
    	const count = parseInt($("#product-select-count p").text());
    	const userId=$("#userId").val();
        var form = $('<form action="' + getContextPath() + '/store/storeOrder.do" method="post"></form>');
        form.append('<input type="hidden" name="cart-checkbox" value="' + pNo + '">');
        form.append('<input type="hidden" name="numBox" value="' + count + '">');
        form.append('<input type="hidden" name="userId" value="' + userId + '">');
        $('body').append(form);
        form.submit();
	}else{
		alert("로그인 후 이용 가능합니다.");
	}
});
	
	$("#product-view-btn_cart").click(e => {
    const pNo = $("#pNo").val();
    const count = parseInt($("#product-select-count p").text());
    const userId=$("#userId").val();
   if(userId!=""){
	    $.post(getContextPath() + "/store/insertCart.do", {
	      productNo: pNo,
	      userId: userId,
	      count:count
	    })
	    .done(function(response) {
			//성공
			if(response>0){
				if (confirm("장바구니 목록에 추가하였습니다. 장바구니로 이동하시겠습니까?")) {
		                location.assign(getContextPath()+"/store/selectCartList.do?id=" + userId);
		            }
			 }else{//실패
					alert("이미 장바구니에 담겨있는 상품입니다. 장바구니에서 수량을 수정해주세요.");
			}
	    }).fail(function(jqXHR, textStatus, errorThrown) {
	      // 실패한 경우
	      alert("전송실패 관리자에게 문의하세요 :(");
	    });
	}else{
		alert("로그인 후 이용 가능합니다.");
	}
});

	$("#product-view-btn_wish").click(e => {
    const pNo = $("#pNo").val();
    const userId=$("#userId").val();
   if (userId !== "") {
	    $.post(getContextPath() + "/store/insertLike.do", {
	      productNo: pNo,
	      userId: userId
	    })
	    .done(function(response) {
				if(response>0){
					alert("관심상품 목록에 추가하였습니다.");
				 }else{
						 $.post(getContextPath() + "/store/deleteLike.do", {
				      			productNo: pNo,
				      			userId: userId
			    		})
			    		.done(function(response) {
								if(response>0){
									alert("관심상품 목록에서 삭제하였습니다.");
								 }
						})
				 }
	    })
	    .fail(function(jqXHR, textStatus, errorThrown) {
	      // 실패한 경우
	      alert("전송실패 관리자에게 문의하세요 :(");
	    });
  } else {
    alert("로그인 후 이용 가능합니다.");
  }
});
