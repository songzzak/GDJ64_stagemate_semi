$("#insert_product_btn").mouseover(() => {
    $("#insert_product_btn").removeClass("btn-white")
    $("#insert_product_btn").addClass("btn-brown");
});

$("#insert_product_btn").mouseout(() => {
    $("#insert_product_btn").removeClass("btn-brown");
    $("#insert_product_btn").addClass("btn-white");
});
