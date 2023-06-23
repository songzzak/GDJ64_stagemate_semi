<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp"%>
<link rel="stylesheet"
	href="<%= contextPath %>/css/jaehun/style_insertEvent.css">
<style>
input[type="checkbox"]:checked {
	background-image: url("<%= contextPath %>/images/jaehun/page_insert_event/checkbox_checked.svg");
	background-color: var(--sm-brown);
	background-position: center;
	background-repeat: no-repeat;
	background-size: 60%;
}
</style>
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
							<div class="input-fx-center">
								<input type="text" name="eventTitle" id="eventTitle" required>
							</div>
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
								<div class="input-fx-center w-60p">
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
								<div class="input-fx-center w-60p">
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
								<div class="input-fx-center w-60p">
									<input type="date" name="eventStartDt" id="eventStartDt" inorder="false" required>
								</div>
							</div>
						</div>
						<div class="event_end_dt insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">종료 일자</p>
							</div>
							<div class="insert-box-right">
								<div class="input-fx-center w-60p">
									<input type="date" name="eventEndDt" id="eventEndDt" required>
								</div>
							</div>
						</div>
					</div>
					<div class="event-period2 insert-combo">
						<div class="event-rsv_open insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">예매 오픈</p>
							</div>
							<div class="insert-box-right">
								<div class="input-fx-center w-60p">
									<input type="date" name="eventRsvDt" id="eventRsvDt" required>
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
										<input type="time" name="startTimeSat" id="startTimeSat" disabled>
									</div>
								</div>
								<div class="event-time_table">
									<div class="event-time_day">
										<span>일</span>
										<input type="checkbox" name="eventTime" value="일">
									</div>
									<div class="event-time_row">
										<input type="time" name="startTimeSun" id="startTimeSun" disabled>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
					<div class="event-location insert-combo">
						<div class="event-title insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">장소</p>
							</div>
							<div class="insert-box-right">
								<div class="input-fx-center w-90p">
									<input type="search" name="eventLocation" id="eventLocation" list="locations" required>
								<datalist id="locations"></datalist>
								</div>
							</div>
						</div>
						<div class="event-title insert-box">
							<div class="insert-box-left">
								<p class="fw-bold">캐스팅</p>
							</div>
							<div class="insert-box-right">
								<div class="input-fx-center w-90p">
									<input type="text" name="eventCasting" id="eventCasting" placeholder="쉼표(,)로 구분해서 입력" 
								onfocus="this.placeholder = ''" 
								onblur="this.placeholder = '쉼표(,)로 구분해서 입력'" required>
								</div>
							</div>
						</div>
					</div>
					<div class="event-images insert-combo position-relative">
						<div class="images-main_poster insert-box">
							<div class="event-info">
								<div>
									<img src="<%= contextPath %>/images/jaehun/page_insert_event/event_info.svg">
								</div>
								<h4>이미지 파일은 jpg, jpeg, png 파일만 업로드할 수 있습니다.</h4>
							</div>
							<div class="insert-box-left">
								<p class="fw-bold">메인 포스터</p>
							</div>
							<div class="insert-box-right">
								<input type="file" name="eventMainPoster" id="eventMainPoster" required>
								<div class="box-right_preview">
									<img src="<%= contextPath %>/images/jaehun/page_insert_event/preview.svg">
								</div>
							</div>
						</div>
						<div class="images-main_poster insert-box position-relative">
							<div class="insert-box-left">
								<p class="fw-bold">상세 이미지</p>
							</div>
							<div class="insert-box-right">
								<input type="file" name="eventMainPoster" id="eventMainPoster" required>
							</div>
						</div>
					</div>
					<div class="insert-combo">
						<div class="event-banner insert-box">
							<div class="insert-box-left input-fx-center">
								<p class="fw-bold">배너</p>
								<input type="checkbox" name="bannerCheckBox">
							</div>
							<div class="insert-box-right display-none">
								<input type="file" name="eventBanner" id="eventBanner" disabled>
							</div>
						</div>
					</div>
					<div class="event-insert insert-box">
						<div>
							<input type="button" class="btn-layout btn-brown" value="등록">
						</div>
						<div>
							<input type="reset" class="btn-layout btn-white" value="리셋">
						</div>
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
				const theDayBefore = $(element).prop("valueAsDate");
				theDayBefore.setDate(theDayBefore.getDate() - 1);
				$("input[name=eventRsvDt]").prop("max", theDayBefore.toISOString().split("T")[0]);
			}
		}

		function isNotANumber(startDate, endDate) {
			return Date.parse(startDate.val()) === NaN || Date.parse(endDate.val()) === NaN
		}

		function isDateInOrder(startDate, endDate) {
			return Date.parse(startDate.val()) > Date.parse(endDate.val());
		}

		$("#eventStartDt, #eventEndDt").blur(event => {
			setRsvDt("#eventStartDt");

			const startDate = $("#eventStartDt");
			const endDate = $("#eventEndDt");

			if (isNotANumber(startDate, endDate)) {
				startDate.attr("inorder", "false");
				return;
			}

			if (isDateInOrder(startDate, endDate)) {
				alert("종료 일자는 시작 일자보다 뒤에 와야 합니다.");
				startDate.attr("inorder", "false");
				return;
			}

			startDate.attr("inorder", "true");
		});

		$("input[name=eventTime]").change(event => {
			const timeRow = $(event.target).parent().next().find("input[type=time]");

			if ($(event.target).is(":checked")) {
				timeRow.attr("disabled", false);
			} else {
				timeRow.attr("disabled", true);
			}
		});

		$("#eventLocation").keyup(event => {
			$.get("<%= contextPath %>/admin/searchLocation.do?location=" + $(event.target).val(),
					data => {
						$("#locations").html("");
						data.split(",").forEach(location => {
							const option = $("<option>").val(location).text(location);
							$("#locations").append(option);
						});
					}
				);
		});

		$("input[name=bannerCheckBox]").change(event => {
			if ($(event.target).is(":checked")) {
				$("input[name=eventBanner]").parent().toggleClass("display-none");
				$("input[name=eventBanner]").attr("disabled", false);
			} else {
				$("input[name=eventBanner]").parent().toggleClass("display-none");
				$("input[name=eventBanner]").attr("disabled", true);
			}
		});
	</script>
</body>
</html>