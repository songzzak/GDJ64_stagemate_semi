$(document).ready(function(){
	$('.ReviewList_play').show();
	$('.ReviewList_store').hide();	
	
});

$("#ps_play_btn").click(function(){
		$('.ReviewList_play').show();
	$('.ReviewList_store').hide();
	
});

$("#ps_store_btn").click(function(){
	$('.ReviewList_play').hide();
	$('.ReviewList_store').show();
});