<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%= contextPath %>/css/jaehun/style_insertEvent.css">
<title>행사 등록</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="min1280px">
		<div id="insertEvent">
			<nav class="insertEvent-sidebar">
				<ul class="insertEvent-sidebar_big">
					<li><a href="">회원 관리</a></li>
					<li class="link_active"><a href="">상품 관리</a>
						<ul class="insertEvent-sidebar_small">
							<li><a href="">예매</a></li>
							<li><a
								href="<%=contextPath%>/admin/selectAllProduct.do">스토어</a></li>
						</ul>
					</li>
					<li><a href="">판매 관리</a>
						<ul class="insertEvent-sidebar_small">
							<li><a href="">판매내역관리</a></li>
							<li><a href="">결제 취소 요청</a></li>
							<li><a href="">반품/교환 관리</a></li>
						</ul>
					</li>
					<li><a href="">커뮤니티 관리</a>
						<ul class="insertEvent-sidebar_small">
							<li><a href="">게시판 관리</a></li>
							<li><a href="">신고 관리</a></li>
						</ul>
					</li>
					<li><a href="">고객센터</a>
						<ul class="insertEvent-sidebar_small">
							<li><a href="">공지사항 관리</a></li>
							<li><a href="">1:1문의 관리</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			<article class="insertEvent-content">
				<nav class="insertEvent-title">
					<p>상품관리</p>
					<div>
						<img src="<%=contextPath %>/images/jaehun/page_insert_event/arrow.svg" alt="">
					</div>
					<p>행사</p>
					<div>
						<img src="<%=contextPath %>/images/jaehun/page_insert_event/arrow.svg" alt="">
					</div>
					<p>등록</p>
				</nav>
				<hr>
				<form name="insertEventForm">
					<div class="event-title insert-box">
						<div class="insert-box-left">
	                        <p class="fw-bold">행사명</p>
	                    </div>
						<div class="insert-box-right">
							<input type="text" name="eventTitle" id="eventTitle" required>
						</div>
					</div>
					<div class="event-category insert-box">
						<div class="insert-box-left">
	                        <p class="fw-bold">카테고리</p>
	                    </div>
						<fieldset class="insert-box-right">
							<label>
								<span>뮤지컬</span>
								<input type="radio" name="eventCategory" value="EVC1" checked>
							</label>
							<label>
								<span>콘서트</span>
								<input type="radio" name="eventCategory" value="EVC2">
							</label>
							<label>
								<span>연극</span>
								<input type="radio" name="eventCategory" value="EVC3">
							</label>
						</fieldset>
					</div>
					<div class="event-age insert-box">
						<div class="insert-box-left">
	                        <p class="fw-bold">관람 연령</p>
	                    </div>
						<fieldset class="insert-box-right">
							<label>
								<span>8세 이상</span>
								<input type="radio" name="eventAge" value="8" checked>
							</label>
							<label>
								<span>12세 이상</span>
								<input type="radio" name="eventAge" value="12">
							</label>
							<label>
								<span>15세 이상</span>
								<input type="radio" name="eventAge" value="15">
							</label>
						</fieldset>
					</div>
					<div class="event-runningtime insert-combo">
						<div class="event-info">
							<div>
								<img src="<%= contextPath %>/images/jaehun/page_insert_event/event_info.svg">
							</div>
							<h4>상영시간 입력 시 인터미션을 포함해서 입력해주세요.</h4>
						</div>
						<div class="event-duration insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">상영 시간</p>
							</div>
							<div class="insert-box-right">
								<div class="input_resized">
									<input type="number" name="eventDuration" id="eventDuration" required>
									<span>분</span>
								</div>
							</div>
						</div>
						<div class="event-inter insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">인터미션</p>
							</div>
							<div class="insert-box-right">
								<div class="input_resized">
									<input type="number" name="eventPeriod" id="eventPeriod" required>
									<span>분</span>
								</div>
							</div>
						</div>
					</div>
					<div class="event-period insert-combo">
						<div class="event_start_dt insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">시작 일자</p>
							</div>
							<div class="insert-box-right">
								<div class="input_resized">
									<input type="date" name="eventStartDt" id="eventStartDt" 
											onblur="setRsvDt(this);" required>
								</div>
							</div>
						</div>
						<div class="event_end_dt insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">종료 일자</p>
							</div>
							<div class="insert-box-right">
								<div class="input_resized">
									<input type="date" name="eventEndDt" id="eventEndDt" required>
								</div>
							</div>
						</div>
						<div class="event-rsv_open insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">예매 오픈일</p>
							</div>
							<div class="insert-box-right">
								<div class="input_resized">
									<input type="date" name="eventRsvDt" id="eventRsvDt" required>
								</div>
							</div>
						</div>
					</div>
					<div class="event-time insert-box">
						<div class="insert-box-left">
	                        <p class="fw-bold">회차</p>
	                    </div>
						<fieldset class="insert-box-right">
							<div class="event-time_table">
								<div class="event-time_day">
									<span>월</span>
									<input type="checkbox" name="eventTime" value="월">
								</div>
								<div class="event-time_row">
									<input type="time" name="startTimeMon" id="startTimeMon" disabled>
								</div>
							</div>
							<div class="event-time_table">
								<div class="event-time_day">
									<span>화</span>
									<input type="checkbox" name="eventTime" value="화">
								</div>
								<div class="event-time_row">
									<input type="time" name="startTimeTue" id="startTimeTue" disabled>
								</div>
							</div>
							<div class="event-time_table">
								<div class="event-time_day">
									<span>수</span>
									<input type="checkbox" name="eventTime" value="수">
								</div>
								<div class="event-time_row">
									<input type="time" name="startTimeWed" id="startTimeWed" disabled>
								</div>
							</div>
							<div class="event-time_table">
								<div class="event-time_day">
									<span>목</span>
									<input type="checkbox" name="eventTime" value="목">
								</div>
								<div class="event-time_row">
									<input type="time" name="startTimeThu" id="startTimeThu" disabled>
								</div>
							</div>
							<div class="event-time_table">
								<div class="event-time_day">
									<span>금</span>
									<input type="checkbox" name="eventTime" value="금">
								</div>
								<div class="event-time_row">
									<input type="time" name="startTimeFri" id="startTimeFri" disabled>
								</div>
							</div>
							<div class="event-time_table">
								<div class="event-time_day">
									<span>토</span>
									<input type="checkbox" name="eventTime" value="토">
								</div>
								<div class="event-time_row">
									<input type="time" name="startTimeSat1" id="startTimeSat1" disabled>
									<input type="time" name="startTimeSat2" id="startTimeSat2" disabled>
									<p>추가하기</p>
								</div>
							</div>
							<div class="event-time_table">
								<div class="event-time_day">
									<span>일</span>
									<input type="checkbox" name="eventTime" value="일">
								</div>
								<div class="event-time_row">
									<input type="time" name="startTimeSun1" id="startTimeSun1" disabled>
									<input type="time" name="startTimeSun2" id="startTimeSun2" disabled>
									<p>추가하기</p>
								</div>
							</div>
						</fieldset>
					</div>
				</form>
			</article>
		</div>
	</section>
	<%@ include file="/views/common/footer.jsp"%>
	<script src="<%=contextPath%>/js/jquery-3.7.0.min.js"></script>
	<script src="<%=contextPath%>/js/script_common.js"></script>
	<script>
		$(() => {
			const startDate = new Date();
			$("input[type=date]").prop("min", startDate.toISOString().split('T')[0]);
		});

		function setRsvDt(element) {
			if ($(element).val() != '') {
				$("input[name=eventRsvDt]").prop("max", $(element).val());
			}
		}

	</script>
</body>
</html>