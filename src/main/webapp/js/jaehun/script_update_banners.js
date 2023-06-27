$(window).on("load", () => {
    getMainBanners();
});

function getMainBanners() {
    $.get(getContextPath() + "/upload/jaehun/main_banners.json")
    .then(data => {
        $(".banners_update-lineup_main").html("");

        data.banners.forEach((banner, index) => {
            const path = getContextPath() + "/upload/joonho/" + banner.euNameRename;
            $(".banners_update-lineup_main").append(`
                <li>
                    <div class="number-order"><span>${index + 1}</span></div>
                    <div>
                        <img src="${path}">
                    </div>
                    <h5 class="fw-bold">${banner.eventNm}</h5>
                    <input type="button" class="btn-layout btn-brown" value="제외하기"
                                onclick="alert('테스트')">
                    <input name="euNo" type="hidden" value="${banner.euNo}">
                    <input name="eventNo" type="hidden" value="${banner.eventNo}">
                </li>
            `);
        })
    });
}

function closePopupBanners() {
    window.close();
}