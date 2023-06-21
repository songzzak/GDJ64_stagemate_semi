$(document).ready(function() {
        $("#updateBtn").click(function() {
            if (confirm("수정하시겠습니까?")) {
                $("form").submit();
            }
        });

        $("#resetBtn").click(function() {
            if (confirm("수정을 취소하시겠습니까? 입력한 정보는 저장되지 않습니다.")) {
                location.assign(getContextPath()+"/admin/selectAllProduct.do");
            }
        });
    });