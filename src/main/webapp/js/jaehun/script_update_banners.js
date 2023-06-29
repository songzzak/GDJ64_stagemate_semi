const storage = $(".banners-storage");
const bannersInStorage = storage.children("li");
const container = $(".banners_main-container");

$(window).on("load", () => {
    updateStorage();
    updateContainer();
});

function updateStorage() {
    bannersInStorage.width("200px");
    bannersInStorage.height("30%");
    bannersInStorage.css("margin", "0 20px");

    storage.width(bannersInStorage.first().outerWidth(true) * bannersInStorage.length);
    storage.height("100%");
    storage.css({
        display: "flex",
        alignItems: "center"
    });
}

function updateContainer() {
    $.get(getContextPath() + "/upload/jaehun/main_banners.json")
    .then(data => {
        container.html("");

        data.banners.forEach((banner, index) => {
            const path = getContextPath() + "/upload/joonho/" + banner.euRename;
            container.append(generateMainBanner(path, 
                                                banner.euRename,
                                                banner.eventNm, 
                                                banner.euNo, 
                                                banner.eventNo));
        });
    });
}

function generateMainBanner(filePath, fileName, eventName, eventFileName, eventNo) {
    return `<li>
                <div>
                    <img src="${filePath}" rename="${fileName}">
                </div>
                <h5 class="fw-bold">${eventName}</h5>
                <input type="button" class="btn-remove btn-layout btn-brown" value="제외하기">
                <input name="euNo" type="hidden" value="${eventFileName}">
                <input name="eventNo" type="hidden" value="${eventNo}">
            </li>`;
}

$(document).on("click", container.children("input[type=button]"), event => {
    const button = $(event.target);
    if (button.hasClass("btn-remove")) {
        if (confirm(`${button.siblings("h5").text()}의 배너를 메인 페이지에서 제외하시겠습니까?`)) {
            button.parent("li").remove();
        }
    }
});

$(document).on("dragstart", bannersInStorage, event => {
    let picked;
    
    if ($(event.target).prop("tagName") === "LI") {
        picked = $(event.target);
    }

    if ($(event.target).prop("tagName") === "IMG") {
        picked = $(event.target).parents("li");
    }

    event.originalEvent.dataTransfer.setData("path", picked.find("img").attr("src"));
    event.originalEvent.dataTransfer.setData("rename", picked.find("img").attr("rename"));
    event.originalEvent.dataTransfer.setData("eventNm", picked.find("h5").text());
    event.originalEvent.dataTransfer.setData("euNo", picked.find("input[name=euNo]").val());
    event.originalEvent.dataTransfer.setData("eventNo", picked.find("input[name=eventNo]").val());
});

$(document).on("dragover", container, event => {
    event.preventDefault();
});

$(document).on("drop", container, event => {
    const corX = event.pageX;
    const mainBanners = container.children("li");
    const divisions = [];
    const newMainBanner = generateMainBanner(event.originalEvent.dataTransfer.getData("path"), 
                                            event.originalEvent.dataTransfer.getData("rename"), 
                                            event.originalEvent.dataTransfer.getData("eventNm"), 
                                            event.originalEvent.dataTransfer.getData("euNo"), 
                                            event.originalEvent.dataTransfer.getData("eventNo"));
    let isIncluded = false;

    mainBanners.each((index, mainBanner) => {
        if (isBannerIncluded($(mainBanner).find("input[name=eventNo]").val(),
                            event.originalEvent.dataTransfer.getData("eventNo"))
        ) {
            alert("이미 포함된 배너입니다.");
            isIncluded = true;
            return;
        }
        divisions.push(mainBanners.eq(index).offset().left + (mainBanners.eq(index).width() / 2));
    });

    if (isIncluded) {
        return;
    }

    if (mainBanners.length === 0) {
        container.prepend(newMainBanner);
        return;
    }

    if (mainBanners.length === 1) {
        if (corX < divisions[0]) {
            container.prepend(newMainBanner);
        } else {
            container.children("li").eq(0).after(newMainBanner);
        }
        return;
    }

    if (mainBanners.length === 2) {
        if (corX < divisions[0]) {
            container.prepend(newMainBanner);
        } else if (corX < divisions[1]) {
            putAfter(mainBanners, 0, newMainBanner);
        } else {
            container.append(newMainBanner);
        }
        return;
    }

    if (mainBanners.length === 3) {
        if (corX < divisions[0]) {
            container.prepend(newMainBanner);
        } else if (corX < divisions[1]) {
            putAfter(mainBanners, 0, newMainBanner);
        } else if (corX < divisions[2]) {
            putAfter(mainBanners, 1, newMainBanner);
        } else {
            container.append(newMainBanner);
        }
        return;
    }

    if (mainBanners.length === 4) {
        if (corX < divisions[0]) {
            container.prepend(newMainBanner);
        } else if (corX < divisions[1]) {
            putAfter(mainBanners, 0, newMainBanner);
        } else if (corX < divisions[2]) {
            putAfter(mainBanners, 1, newMainBanner);
        } else if (corX < divisions[3]) {
            putAfter(mainBanners, 2, newMainBanner);
        } else {
            container.append(newMainBanner);
        }
        return;
    }

    if (mainBanners.length === 5) {
        alert("메인 페이지에는 최대 5개까지 배너를 게시할 수 있습니다.");
        return;
    }
});

function isBannerIncluded(eventNo, anotherEventNo) {
    return eventNo === anotherEventNo;
}

function putAfter(targets, index, element) {
    targets.eq(index).after(element);
}

function updateBanners() {
    if (confirm("변경 사항을 저장하시겠습니까?")) {
        const mainBanners = container.children("li");
        $.post(getContextPath() + "/admin/updateBannerEnd.do",
            {
                data : JSON.stringify({ "banners": toArray(mainBanners) })
            },
            data => {
                if (data === "success") {
                	window.opener.location.reload(true);
                    alert("배너가 성공적으로 변경되었습니다.");
                } else {
                    alert("배너 변경에 실패했습니다.");
                }
            }
        ).fail(() => {
            alert("에러 발생! 관리자에게 문의하세요.")
        });
    }
}

function toArray(banners) {
    const bannersArray = []; 
    banners.each((index, banner) => {
        bannersArray.push(
            {
                "eventNm": $(banner).find("h5").text(),
                "euNo": $(banner).find("input[name=euNo]").val(),
                "euRename": $(banner).find("img").attr("rename"),
                "eventNo": $(banner).find("input[name=eventNo]").val()
            }
        );
    });

    return bannersArray;
}