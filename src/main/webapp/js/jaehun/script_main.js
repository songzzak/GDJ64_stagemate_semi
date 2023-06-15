$('.header-container-icons input').hover(event => {
    if (event.target == event.currentTarget) {
        $(event.target).next().fadeToggle(500);
    }
});

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

$('.calandar-lineup_poster').each((index, selector) => {
    $(selector).hover(() => {
        $(selector).children('div').children().first().css('opacity', 1);
    }, () => {
        $(selector).children('div').children().first().css('opacity', 0);
    });
});

$('.lineup_btn_prev').click(() => {
    alert('개발 중');
})

$('.lineup_btn_next').click(() => {
    alert('개발 중');
})

const days = $('.reservation-calandar-days>li');
days.each(function() {
    $(this).click(() => {
        days.removeClass("btn-brown");
        $(this).addClass("btn-brown");
    });
});

const resizeGoods = () => {
    const goods = $('.goods-lineup_item>div:first-child');

    goods.width("95%");
    goods.height(goods.width());
};
resizeGoods();