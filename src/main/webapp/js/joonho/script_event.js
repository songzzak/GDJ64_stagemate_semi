const urlcopy = () => {
	var url = '';
	var textarea = document.createElement("textarea");
	document.body.appendChild(textarea);
	textarea.value = pagecopy;
	textarea.select();
	document.execCommand("copy");
	document.body.removeChild(textarea);
	alert("링크가 복사되었습니다. 필요하신 곳에 붙여넣기 하세요!")
}
const openmap = () => {
	open("<%=contextPath%>/map.do", "_blank", 'top=' + (window.innerHeight / 2 - 250) + ', left=' + (window.innerWidth / 2 - 250) + ', width=500, height=500')
}


$("#detail_information").click(e => {
	$("#detail_information").css({ "borderBottom": "14px solid black" })
	$("#detail_information").children().css({ "fontWeight": "bolder" })
	$("#reservation_cancel").css({ "borderBottom": "" })
	$("#reservation_cancel").children().css({ "fontWeight": "" })
	$("#gold_review").css({ "borderBottom": "" })
	$("#gold_review").children().css({ "fontWeight": "" })
	$("#gold_location").css({ "borderBottom": "" })
	$("#gold_location").children().css({ "fontWeight": "" })
	$("#detail_information_img").css({ "display": "inline-flex", "flex-direction": "column", "align-items": "center" })
	$("#reservation_cancel_info").css({ "display": "none" })
	$("#gold_details_map").css({ "display": "none" })

})

$("#reservation_cancel").click(e => {
	$("#detail_information").css({ "borderBottom": "" })
	$("#detail_information").children().css({ "fontWeight": "" })
	$("#reservation_cancel").css({ "borderBottom": "14px solid black" })
	$("#reservation_cancel").children().css({ "fontWeight": "bolder" })
	$("#gold_review").css({ "borderBottom": "" })
	$("#gold_review").children().css({ "fontWeight": "" })
	$("#gold_location").css({ "borderBottom": "" })
	$("#gold_location").children().css({ "fontWeight": "" })
	$("#detail_information_img").css({ "display": "none" })
	$("#reservation_cancel_info").css({ "display": "inline-flex", "flex-direction": "column" })
	$("#gold_details_map").css({ "display": "none" })


})
$("#gold_review").click(e => {
	$("#detail_information").css({ "borderBottom": "" })
	$("#detail_information").children().css({ "fontWeight": "" })
	$("#reservation_cancel").css({ "borderBottom": "" })
	$("#reservation_cancel").children().css({ "fontWeight": "" })
	$("#gold_review").css({ "borderBottom": "14px solid black" })
	$("#gold_review").children().css({ "fontWeight": "bolder" })
	$("#gold_location").css({ "borderBottom": "" })
	$("#gold_location").children().css({ "fontWeight": "" })
	$("#detail_information_img").css({ "display": "none" })
	$("#reservation_cancel_info").css({ "display": "none" })
	$("#gold_details_map").css({ "display": "none" })
})

$("#movemap").click(e=>{
	var location = document.querySelector("#gold_location").offsetTop;
	window.scrollTo({top:location, behavior:'smooth'});
	$("#detail_information").css({"borderBottom":""})
	$("#detail_information").children().css({"fontWeight":""})
	$("#reservation_cancel").css({"borderBottom":""})
	$("#reservation_cancel").children().css({"fontWeight":""})
	$("#gold_review").css({"borderBottom":""})
	$("#gold_review").children().css({"fontWeight":""})
	$("#gold_location").css({"borderBottom":"14px solid black"})
	$("#gold_location").children().css({"fontWeight":"bolder"})
	$("#detail_information_img").css({"display":"none"})
	$("#reservation_cancel_info").css({"display":"none"})
	$("#gold_details_map").css({"display":"inline-flex","flex-direction":"column","align-items": "center"})
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(GPSX, GPSY), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
       
    
});
});



$("#gold_location").click(e=>{
	$("#detail_information").css({"borderBottom":""})
	$("#detail_information").children().css({"fontWeight":""})
	$("#reservation_cancel").css({"borderBottom":""})
	$("#reservation_cancel").children().css({"fontWeight":""})
	$("#gold_review").css({"borderBottom":""})
	$("#gold_review").children().css({"fontWeight":""})
	$("#gold_location").css({"borderBottom":"14px solid black"})
	$("#gold_location").children().css({"fontWeight":"bolder"})
	$("#detail_information_img").css({"display":"none"})
	$("#reservation_cancel_info").css({"display":"none"})
	$("#gold_details_map").css({"display":"inline-flex","flex-direction":"column","align-items": "center"})
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(GPSX, GPSY), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
       
    
});
})
window.onload = function() { buildCalendar(); }    // 웹 페이지가 로드되면 buildCalendar 실행

let nowMonth = new Date();  // 현재 달을 페이지를 로드한 날의 달로 초기화
let today = new Date();     // 페이지를 로드한 날짜를 저장
today.setHours(0, 0, 0, 0);    // 비교 편의를 위해 today의 시간을 초기화

// 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
function buildCalendar() {

	let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1);     // 이번달 1일
	let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0);  // 이번달 마지막날

	let tbody_Calendar = document.querySelector(".Calendar > tbody");
	document.getElementById("calYear").innerText = nowMonth.getFullYear();             // 연도 숫자 갱신
	document.getElementById("calMonth").innerText = leftPad(nowMonth.getMonth() + 1);  // 월 숫자 갱신

	while (tbody_Calendar.rows.length > 0) {                        // 이전 출력결과가 남아있는 경우 초기화
		tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
	}

	let nowRow = tbody_Calendar.insertRow();        // 첫번째 행 추가           

	for (let j = 0; j < firstDate.getDay(); j++) {  // 이번달 1일의 요일만큼
		let nowColumn = nowRow.insertCell();        // 열 추가
	}

	for (let nowDay = firstDate; nowDay <= lastDate; nowDay.setDate(nowDay.getDate() + 1)) {   // day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복  

		let nowColumn = nowRow.insertCell();        // 새 열을 추가하고


		let newDIV = document.createElement("p");
		newDIV.innerHTML = leftPad(nowDay.getDate());        // 추가한 열에 날짜 입력
		nowColumn.appendChild(newDIV);

		if (nowDay.getDay() == 6) {                 // 토요일인 경우
			nowRow = tbody_Calendar.insertRow();    // 새로운 행 추가
		}
		
		if (nowDay<startDay || nowDay < today) {                       // 지난날인 경우
			newDIV.className = "pastDay";
		}
		else if (nowDay.getFullYear() == today.getFullYear() && nowDay.getMonth() == today.getMonth() && nowDay.getDate() == today.getDate()) { // 오늘인 경우           
			newDIV.className = "today";
			newDIV.onclick = function() { choiceDate(this); }
		}else if(nowDay>endDay){
			newDIV.className = "pastDay";
		}else {                                      // 미래인 경우
			daysgo.forEach((val)=>{
				switch(val){
					case "월" : $(".Calendar>tbody>tr>td:nth-child(2)>p:not(.pastDay,.today)").addClass("futureDay");break;
					case "화" : $(".Calendar>tbody>tr>td:nth-child(3)>p:not(.pastDay,.today)").addClass("futureDay");break;
					case "수" : $(".Calendar>tbody>tr>td:nth-child(4)>p:not(.pastDay,.today)").addClass("futureDay");break;
					case "목" : $(".Calendar>tbody>tr>td:nth-child(5)>p:not(.pastDay,.today)").addClass("futureDay");break;
					case "금" : $(".Calendar>tbody>tr>td:nth-child(6)>p:not(.pastDay,.today)").addClass("futureDay");break;
					case "토" : $(".Calendar>tbody>tr>td:nth-child(7)>p:not(.pastDay,.today)").addClass("futureDay");break;
					case "일" : $(".Calendar>tbody>tr>td:nth-child(1)>p:not(.pastDay,.today)").addClass("futureDay");break;
				}
			
			})
			$(".Calendar>tbody>tr>td>p:not(.pastDay,.today,.futureDay)").addClass("pastDay").css({"pointer-events":"none"});
			newDIV.onclick = function() { choiceDate(this); }
		}
	}
}

// 날짜 선택
function choiceDate(newDIV) {
	/*if(openday>todays){
		alert(opendays+" 이후에 예매 가능합니다");
	}else{*/
		if (document.getElementsByClassName("choiceDay")[0]) {                              // 기존에 선택한 날짜가 있으면
			document.getElementsByClassName("choiceDay")[0].classList.remove("choiceDay");  // 해당 날짜의 "choiceDay" class 제거
		}
		var choiceButton=$("#gold_button").html("");
		for(let i=0;i<6;i++){
			if(newDIV==$(".Calendar>tbody>tr>td:nth-child(2)>p:not(.pastDay)")[i]){
				monday.length>0?choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+monday[0])):"";
			}else if(newDIV==$(".Calendar>tbody>tr>td:nth-child(3)>p:not(.pastDay)")[i]){
				tuesday.length>0?choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+tuesday[0])):"";
			}else if(newDIV==$(".Calendar>tbody>tr>td:nth-child(4)>p:not(.pastDay)")[i]){
				wednesday.length>0?choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+wednesday[0])):"";
			}else if(newDIV==$(".Calendar>tbody>tr>td:nth-child(5)>p:not(.pastDay)")[i]){
				thursday.length>0?choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+thursday[0])):"";
			}else if(newDIV==$(".Calendar>tbody>tr>td:nth-child(6)>p:not(.pastDay)")[i]){
				friday.length>0?choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+friday[0])):"";
			}else if(newDIV==$(".Calendar>tbody>tr>td:nth-child(7)>p:not(.pastDay)")[i]){
				if(saturday.length==2){
					choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+saturday[0]));
					choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("2회 "+saturday[1]))
				}else if(saturday.length==1){
					choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+saturday[0]));
				}else{
					choiceButton=""
				}
			}else if(newDIV==$(".Calendar>tbody>tr>td:nth-child(1)>p:not(.pastDay)")[i]){
				if(sunday.length==2){
					choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+sunday[0]));
					choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("2회 "+sunday[1]))
				}else if(saturday.length==1){
					choiceButton=$("#gold_button").append($("<button id='schedule'>").addClass('schedule').css({"cursor":"pointer"}).text("1회 "+sunday[0]));
				}else{
					choiceButton=""
				}
			}
		}
		newDIV.classList.add("choiceDay");           // 선택된 날짜에 "choiceDay" class 추가
		$("#schedule").css({ "backgroundColor": "white", "color": "black" })
		$("#pointmark").css({"visibility":"visible"});
		$("#gold_seat").css({"color":"rgb(0,0,0,0.3)"});
		$("#res_cho").css({"border":"1px solid rgb(0,0,0,0.3)","backgroundColor":"white","color":"rgb(0,0,0,0.3)","pointer-events":"none"});
		$("#seat_money>div>h3:odd").css({"color":"rgb(0,0,0,0.3)"});
		$("#seat_money>div:first-child>h3:last-child").html('')
		$("#seat_money>div:nth-child(2)>h3:last-child").html('')
		$("#seat_money>div:nth-child(3)>h3:last-child").html('')
		$("#seat_money>div:last-child>h3:last-child").html('')
		flag=true;
	/*}*/
}


// 이전달 버튼 클릭
function prevCalendar() {
	nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() - 1, nowMonth.getDate());   // 현재 달을 1 감소
	buildCalendar();    // 달력 다시 생성
}
// 다음달 버튼 클릭
function nextCalendar() {
	nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, nowMonth.getDate());   // 현재 달을 1 증가
	buildCalendar();    // 달력 다시 생성
}

// input값이 한자리 숫자인 경우 앞에 '0' 붙혀주는 함수
function leftPad(value) {
	if (value < 10) {
		value = "0" + value;
		return value;
	}
	return value;
}

function toReservationMusical(evcNo,eventNo){
	const roundup=$("#schedule").text();
	const round=roundup.replaceAll(' ','');
	const choiceday=$("#calYear").text()+"."+$("#calMonth").text()+"."+$(".choiceDay").text();
	location.assign(getContextPath() + "/event/reservation.do?evc="+evcNo+"&event="+eventNo+"&round="+round+"&choiceday="+choiceday+"&esNo="+esNo+"&vip="+vip+"&r="+r+"&s="+s+"&a="+a+"&f1="+f1+"&f2="+f2+"&allseat="+allseat);
}