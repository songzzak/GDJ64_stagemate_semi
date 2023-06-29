$(".btn-event_view").click(event => {
    location.assign(getContextPath() + "/admin/updateEvent.do?no=" 
                    + $(event.target).siblings("input[type=hidden]").val());
});

$(".btn-event_delete").click(event => {
    if(confirm("해당 공연을 정말로 삭제하시겠습니까?")) {
        $.ajax({
            type: "post",
            url: getContextPath() + "/admin/deleteEvent.do",
            data: {
                "eventNo": $(event.target).siblings("input[type=hidden]").val()
            },
            dataType: "text",
            beforeSend: showLoadingForDeletion,
            success: (data) => {
                closeLoadingForDeletion();

                if (data === "1") {
                    alert("데이터가 성공적으로 삭제되었습니다.");
                    window.location.reload(true);
                } else {
                    alert("데이터 삭제에 실패했습니다.")
                }
            },
            error:(request, status, error) => {
                if (request.status === 500) {
                    alert("에러 발생! 관리자에게 문의하세요.");
                }
            },
            complete: closeLoadingForDeletion
        });
    }
})

function showLoadingForDeletion() {
    $(".loading-bg").css("transition", "all 0.8s")
                    .addClass("loading-show");
}

function closeLoadingForDeletion() {
    $(".loading-bg").css("transition", "")
                    .removeClass("loading-show");
}

$("input[name=eventCategory]").change(event => {
    console.log($(event.target).val());
    if ($(event.target).val() === "ALL") {
        location.replace(getContextPath() + "/admin/eventlist");
    } else {
        location.replace(getContextPath() + "/admin/selectEventByCategory.do?evcNo=" + $(event.target).val());
    }
});

$("#bannerLink").click(event => {
    openPage(800, 580, getContextPath() + "/admin/updateBanner.do");
});