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

$(".btn_product_update").click(e => {
    const pNo = $(e.target).closest("tr").find("td:first-child").text();
    console.log(pNo);
    location.assign(getContextPath() + '/admin/updateProduct.do?no=' + pNo);
  });

  $(".btn_product_delete").click(e => {
    const pNo = $(e.target).closest("tr").find("td:first-child").text();
    if (confirm("정말로 삭제하시겠습니까?")) {
      location.assign(getContextPath() + '/admin/deleteProduct.do?no=' + pNo);
    }
  });
  