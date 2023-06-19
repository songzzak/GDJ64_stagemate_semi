$("#insert_product_btn").mouseover((e) => {
    $(e.target).removeClass("btn-white")
    $(e.target).addClass("btn-brown");
});

$("#insert_product_btn").mouseout((e) => {
    $(e.target).removeClass("btn-brown");
    $(e.target).addClass("btn-white");
});

$("#insert_product_btn").click(e=>{e
	location.assign(getContextPath()+'/admin/insertProduct.do');
});