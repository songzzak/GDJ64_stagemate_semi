var outname;
var outid;
$('.btn-example').click(function(){
	outid=($("input[type='checkbox']:checked")).parent().next().children().text()
	outname=($("input[type='checkbox']:checked")).parent().next().next().text()
	if(outname==""){
		alert("탈퇴하시려는 회원을 선택해주세요")
	}else{
		$(".realout").text(outname+'님을 탈퇴하시겠습니까?')
	    var $href = $(this).attr('href');
	    layer_popup($href);
    }
});

$('.btn-layerCloseNew').click(function(){
    var $href = $(this).attr('href');
    $(".realoutend").text(outname+'님을 탈퇴하였습니다.')
    layer_popup($href);
});
function layer_popup(el){

    var $el = $(el);    //레이어의 id를 $el 변수에 저장
	$el.fadeIn();
    

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
          	marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    $el.find('a.btn-layerClose').click(function(){
        $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        return false;
    });


}
