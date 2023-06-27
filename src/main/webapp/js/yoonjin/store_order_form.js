$(".storeorder_btn_prev").click(e=>{
    console.log(e);
    window.history.back();
})
  
function setSelectedAddress(dlvId,dlvName, name, phone, address) {
	console.log(dlvId);
	$("#dlvId").val(dlvId);
    $("#dlvName").text(dlvName);
    $("#dlvPerson").text(name);
    $("#dlvPhone").text(phone);
    $("#dlvAddress").text(address);
    
}