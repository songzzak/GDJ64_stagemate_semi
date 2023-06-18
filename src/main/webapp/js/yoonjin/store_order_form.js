$(".storeorder_btn_prev").click(e=>{
    console.log(e);
    window.history.back();
})
function openPopup(url) {
    window.open(url, '_blank', 'width=500, height=970');
  }