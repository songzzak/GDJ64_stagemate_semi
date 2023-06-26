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

        rsvDays.append($li.append(day).append(date));
        rsvDays.children().eq(0).addClass("btn-brown");
    });

    rsvDays.on("click", (event) => {
        rsvDays.children().removeClass("btn-brown");
        if ($(event.target).prop("tagName") === "P") {
            $(event.target).parent().addClass("btn-brown");
        } else {
            $(event.target).addClass("btn-brown");
        }
    });
});

window.onload = () => {
    $.post(getContextPath() + "/eventForMainPage.do", 
            {
                date: formatDate(new Date())
            }, 
            data => {
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
                
                data.forEach(event => {
                    lineup.append(generatePoster(event));
                });
            }
    );
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
        padding: "13px 0"
    });
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

    relative.append($img).append(posterOverlay);
    return poster.append(rsvOpenDt).append(relative);
}

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
            }, 3000);
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
});
slideBanners();

$(document).on("mouseenter", ".pos-relative", event => {
    console.log($(event.target));
    if ($(event.target).hasClass("lineup_poster_overlay")) {
        $(event.target).css("opacity", 1);
    }
});

$(document).on("mouseleave", ".pos-relative", event => {
    if ($(event.target).hasClass("lineup_poster_overlay")) {
        $(event.target).css("opacity", 0);
    }
});


$('.lineup_btn_prev').click(() => {
    alert('개발 중');
})

$('.lineup_btn_next').click(() => {
    alert('개발 중');
})

const resizeGoods = () => {
    const goods = $('.goods-lineup_item>div:first-child');

    goods.width("95%");
    goods.height(goods.width());
};
resizeGoods();

