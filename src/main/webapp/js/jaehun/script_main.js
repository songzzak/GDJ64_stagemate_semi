$(() => {
    const week = ["일", "월", "화", "수", "목", "금", "토"];
    const today = new Date();
    const rsvDays = $(".reservation-calandar-days");

    week.forEach((element, index) => {
        const $li = $("<li>").addClass("btn-layout");
        const day = $("<p>").text(index == 0 ? "오늘" : week[(today.getDay() + index) % 7]);
        const theDayAfter = new Date();
        theDayAfter.setDate((today.getDate() + index));
        const date = $("<p>").text(theDayAfter.getDate());
        const $hidden = $("<input>").attr("type", "hidden").val(formatDate(theDayAfter));

        $li.append(day)
            .append(date)
            .append($hidden);

        rsvDays.append($li);
        rsvDays.children().eq(0).addClass("btn-brown");
    });

    rsvDays.on("click", (event) => {
        let targetDate = "";
        if ($(event.target).prop("tagName") === "P") {
            rsvDays.children().removeClass("btn-brown");
            $(event.target).parent().addClass("btn-brown");
            targetDate = $(event.target).siblings("input[type=hidden]").val();
            getPosters(new Date(targetDate));
        }

        if ($(event.target).prop("tagName") === "LI") {
            rsvDays.children().removeClass("btn-brown");
            $(event.target).addClass("btn-brown");
            targetDate = $(event.target).find("input[type=hidden]").val();
            getPosters(new Date(targetDate));
        }
    });
});

$(window).on("load", () => {
    getPosters(new Date());
    getProducts();
});

//------------------------------ posters ------------------------------
function getPosters(date) {
    let currentIndex = 0;

    $.ajax({
        type: "post",
        url: getContextPath() + "/eventForMainPage.do",
        data: {
            targetDate: formatDate(date)
        },
        beforeSend: loadingForPoster,
        success: data => {
            data.sort((a, b) => {
                if (new Date(a.rsvOpenDt) < new Date(b.rsvOpenDt)) {
                    return -1;
                }

                if (new Date(a.rsvOpenDt) > new Date(b.rsvOpenDt)) {
                    return 1;
                }

                return 0;
            });

            const lineup = $(".reservation-calendar-lineup");
            lineup.html("");
            lineup.width($(".reservation-calendar-wrapper").width() * data.length);
            lineup.css('transform', 'translateX(0px)');
            
            data.forEach(event => {
                lineup.append(generatePoster(event));
            });

            const btnPrev = $(".calendar_btn_prev");
            const btnNext = $(".calendar_btn_next");
            const lineupPoster = $(".calendar-lineup_poster");

            lineupPoster.click((event) => {
                const eventNo = $(event.target).closest(".calendar-lineup_poster").find("input[type=hidden]").val();

                location.assign(getContextPath() + "/event/eventView.do?no=" + eventNo);
            })

            btnPrev.click(() => {
                if (data.length > 5) {
                    currentIndex = --currentIndex < 0 ? 0 : currentIndex;
                    lineup.css('transform', `translateX(-${currentIndex * lineupPoster.outerWidth(true)}px)`);
                }
            });

            btnNext.click(() => {
                if (data.length > 5) {
                    currentIndex = ++currentIndex > data.length - 5 ? data.length - 5 : currentIndex;
                    lineup.css('transform', `translateX(-${currentIndex * lineupPoster.outerWidth(true)}px)`);
                }
            });
        }
    });
}

function formatDate(date) {
    return date.getFullYear() 
            + "-" 
            + ((date.getMonth() + 1) < 9 ? "0" + (date.getMonth() + 1) : (date.getMonth() + 1)) 
            + "-" 
            + (date.getDate() < 9 ? "0" + date.getDate() : date.getDate());
}

function formatDateWithoutYear(date) {
    return (date.getMonth() + 1) + "/" + date.getDate();
}

function generatePoster(event) {
    const poster = $("<div>").addClass("calendar-lineup_poster");
    const rsvOpenDt = $("<p>").text(formatDateWithoutYear(new Date(event.rsvOpenDt))).css({
        border: "2px solid var(--sm-brown)",
        color: "white",
        backgroundColor: "var(--sm-brown)",
        borderTopLeftRadius: "10px",
        borderTopRightRadius: "10px",
        borderBottom: "none",
        width: "100%",
        textAlign: "center",
        padding: "10px 0"
    });
    const $hidden = $("<input>").attr("type", "hidden").val(event.eventNo);
    const relative = $("<div>").addClass("pos-relative");
    const $img = $("<img>").attr("src", getContextPath() + "/upload/joonho/" + event.euRename);
    const posterOverlay = $("<div>").addClass("lineup_poster_overlay");
    const eventNm = $("<h3>").text(event.eventNm);
    const eventStartDt = $("<p>").text(event.eventStartDt);
    const wave = $("<p>").text("~");
    const eventEndDt = $("<p>").text(event.eventEndDt);
    const location = $("<p>").text(event.location);

    posterOverlay.append(eventNm)
                .append(eventStartDt)
                .append(wave)
                .append(eventEndDt)
                .append(location);

    relative.append($img)
            .append(posterOverlay);

    return poster.append(rsvOpenDt)
                .append($hidden)
                .append(relative);
}

//------------------------------ products ------------------------------
function getProducts() {
    $.ajax({
        type: "get",
        url: getContextPath() + "/productForMainPage.do",
        beforeSend: loadingForProduct,
        success: data => {
            const lineup = $(".goods-lineup");
            lineup.html("");
            
            data.forEach(product => {
                lineup.append(generateProduct(product));
            });
            resizeGoods();

            const unit = $(".goods-lineup_unit");
            unit.click((event) => {
                const productNo = $(event.target).closest(unit).find("input[type=hidden]").val();
                location.assign(getContextPath() + "/store/storeView.do?no=" + productNo);
            })
        },
        error: (request, status, error) => {
            console.log("실패");
            console.log(request.status);
            console.log(status);
        }
    });
}

function generateProduct(product) {
    const unit = $("<div>").addClass("goods-lineup_unit");
    const $divUpper = $("<div>");
    const $img = $("<img>").attr("src", getContextPath() + "/upload/yoonjin/" + product.euRename);
    const $hidden = $("<input>").attr("type", "hidden").val(product.productNo);
    const $divLower = $("<div>");
    const exhibitionTitle = $("<p>").text(product.productTitle);
    const productName = $("<h4>").text(product.productNm).addClass("fw-bold");
    const productPrice = $("<h4>").text(product.productPrice.toLocaleString('ko-KR') + "원")
                                .addClass("fw-bold");

    $divUpper.append($img)
            .append($hidden);

    $divLower.append(exhibitionTitle)
            .append(productName)
            .append(productPrice);

    return unit.append($divUpper)
                .append($divLower);
}

function loadingForPoster() {
    const loading = `
    <div class="calendar-lineup_poster" style="height: 298px; display: flex; justify-content: center; align-items: center;">
        <img src='${getContextPath()}/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
    </div>
    `;

    $(".reservation-calendar-lineup").html("");
    for (let i = 0; i < 5; i++) {
        $(".reservation-calendar-lineup").append(loading);
    }
}

function loadingForProduct() {
    const loading = `
    <div class="goods-lineup_unit" style="height: 219px; display: flex; justify-content: center; align-items: center;">
        <img src='${getContextPath()}/images/jaehun/main_page/loading_poster.gif' style='width: 64px;'>
    </div>
    `;

    $(".goods-lineup").html("");
    for (let i = 0; i < 3; i++) {
        $(".goods-lineup").append(loading);
    }
}

function changePosterOverlayStyle(element, num) {
    if ($(element).hasClass("lineup_poster_overlay")) {
        $(element).css("opacity", num);
    }

    if ($(element).prop("tagName") === "P" || $(element).prop("tagName") === "H3") {
        $(element).parent().css("opacity", num);
    }
}

$(document).on("mouseenter", ".pos-relative", event => {
    changePosterOverlayStyle(event.target, 1);
});

$(document).on("mouseleave", ".pos-relative", event => {
    changePosterOverlayStyle(event.target, 0);
});

const resizeGoods = () => {
    const goods = $('.goods-lineup_unit>div:first-child');

    goods.width("90%");
    goods.height(goods.width());
};
resizeGoods();

//------------------------------ banners ------------------------------
const slideBanners = (() => {
    const wrapper = $('.banners-wrapper');
    const container = $('.banners-container');
    const numOfbanners = container.children("li").length;
    const indicator = $(".banners-indicator");
    let currentIdx = 0;
    let timer = undefined;

    container.append(container.children().eq(0)
                                        .clone()
                                        .addClass("clone"));

    function initContainer() {
        container.width(wrapper.width() * (numOfbanners + 1))
                .css('transform', `translateX(-${currentIdx * wrapper.width()}px)`);
        
        generateIndicator();

        setTimeout(function () {
            container.addClass('animated-smooth');
        }, 100);
    };

    function generateIndicator() {
        indicator.html("");

        for (let index = 0; index < numOfbanners; index++) {
            const $li = $('<li>').css("width", "13%");
            const $img = $('<img>').attr("src", getContextPath() + "/images/jaehun/main_page/banners/indicator_empty.svg")
                                    .css({ display: "block",
                                            width: "100%"});

            if ((index == currentIdx) || (index == 0 && currentIdx == numOfbanners)) {
                $img.attr("src", getContextPath() + "/images/jaehun/main_page/banners/indicator_filled.svg");
            }

            $li.append($img);
            indicator.append($li);
        }
    }

    function autoSlide() {
        if (timer == undefined) {
            timer = setInterval(() => {
                moveContainer();
            }, 2000);
        }
    };

    function moveContainer() {
        container.css('transform', `translateX(-${++currentIdx * wrapper.width()}px)`);

        if (currentIdx == numOfbanners) {
            setTimeout(() => {
                container.removeClass("animated-smooth")
                        .css("transform", "translateX(0px)");
                currentIdx = 0;
            }, 500);

            setTimeout(() => {
                container.addClass("animated-smooth");
            }, 600);
        }
        generateIndicator();
    }

    function stopSlide() {
        clearInterval(timer);
        timer = undefined;
    }

    initContainer();
    autoSlide();

    container.on("mouseenter", function () {
        stopSlide();
    });

    container.on("mouseleave", function () {
        autoSlide();
    });

    $(window).resize(() => {
        stopSlide();
        initContainer();
        autoSlide();
    });

    indicator.click(event => {
        if ($(event.target).prop("tagName") === "IMG") {
            const targetIndex = $(event.target).parent().index();
            container.css('transform', `translateX(-${targetIndex * wrapper.width()}px)`);
            currentIdx = targetIndex;
            generateIndicator();
        }
    });
});
slideBanners();


