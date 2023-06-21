$(".storeorder_btn_prev").click(e=>{
    console.log(e);
    window.history.back();
})
function openPopup(url) {
    window.open(url, '_blank', 'width=500, height=700');
  }
  
function setSelectedAddress(dlvName, name, phone, address) {
    $("#dlvName").text(dlvName);
    $("#dlvPerson").text(name);
    $("#dlvPhone").text(phone);
    $("#dlvAddress").text(address);
    
}