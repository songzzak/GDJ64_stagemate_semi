package com.stagemate.admin.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.stagemate.event.model.vo.Casting;
import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.event.service.EventService;

@WebServlet("/admin/updateEventEnd.do")
public class UpdateEventEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateEventEndServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		if (!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("진입 실패");
			return;
		}

		String path = getServletContext().getRealPath("/upload/joonho");
		int maxSize = 1024 * 1024 * 10;
		String encode = "UTF-8";
		DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, dfrp);
		
		System.out.println(mr.getParameter("bannerCheckBox"));
		System.out.println(mr.getOriginalFileName("eventBanner"));

		Event eventInfo = Event.builder()
							.eventNo(mr.getParameter("eventNo"))
							.eventNm(mr.getParameter("eventTitle"))
							.eventStartDt(Date.valueOf(mr.getParameter("eventStartDt")))
							.eventEndDt(Date.valueOf(mr.getParameter("eventEndDt")))
							.rsvOpenDt(Date.valueOf(mr.getParameter("eventRsvDt")))
							.evcNo(mr.getParameter("eventCategory"))
							.location(mr.getParameter("eventLocation"))
							.eventAge(Integer.parseInt(mr.getParameter("eventAge")))
							.eventDuration(Integer.parseInt(mr.getParameter("eventDuration")))
							.eventInter(Integer.parseInt(mr.getParameter("eventInter")))
							.build();
		
		List<Casting> castings = Arrays.asList(mr.getParameter("eventCasting").split(","))
									.stream().map(castingNm -> getCastingBy(castingNm, mr.getParameter("eventNo")))
									.collect(Collectors.toList());
		
		List<EventUpfile> upfiles = new ArrayList<>();
		upfiles.add(getUpFileBy(mr.getOriginalFileName("eventMainPoster") == null ? mr.getParameter("eventMainPosterOriginal") : mr.getOriginalFileName("eventMainPoster"),
								mr.getFilesystemName("eventMainPoster") == null ? mr.getParameter("eventMainPosterOriginal") : mr.getFilesystemName("eventMainPoster"),
								"PUR1",
								mr.getParameter("eventNo")));
		upfiles.add(getUpFileBy(mr.getOriginalFileName("eventImageDetail") == null ? mr.getParameter("eventImageDetailOriginal") : mr.getOriginalFileName("eventImageDetail"),
								mr.getFilesystemName("eventImageDetail") == null ? mr.getParameter("eventImageDetailOriginal") : mr.getFilesystemName("eventImageDetail"),
								"PUR2",
								mr.getParameter("eventNo")));
		if (mr.getParameter("bannerCheckBox") != null) {
			System.out.println("PUR3 진입");
			upfiles.add(getUpFileBy(mr.getOriginalFileName("eventBanner") == null ? mr.getParameter("eventBannerOriginal") : mr.getOriginalFileName("eventBanner"),
									mr.getFilesystemName("eventBanner") == null ? mr.getParameter("eventBannerOriginal") : mr.getFilesystemName("eventBanner"),
									"PUR3",
									mr.getParameter("eventNo")));
		}
		
		// 스케쥴 업데이트는 추후 반영
		
		int result = new EventService().updateEvent(eventInfo, castings, upfiles);
		
		String msg = "행사가 성공적으로 수정되었습니다.";
		String loc = "/admin/eventlist";
		
		if (result == 0) {
			msg = "행사 수정에 실패했습니다.";
			loc = "/admin/updateEvent.do?no=" + mr.getParameter("eventNo");
			
			System.out.println("수정 실패! 새로 등록된 파일을 삭제합니다.");
			upfiles.forEach(upfile -> {
				deleteFile(upfile.getEuRename());
			});
		} else {
			System.out.println("수정 성공! 이전 파일을 삭제합니다.");
			deleteFile(mr.getParameter("eventMainPosterOriginal"));
			deleteFile(mr.getParameter("eventImageDetailOriginal"));
			
			if (mr.getParameter("bannerCheckBox") != null) {
				deleteFile(mr.getParameter("eventBannerOriginal"));
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

	private EventUpfile getUpFileBy(String originalFileName, String fileRename, String purposeNo, String eventNo) {
		return EventUpfile.builder()
						.euNameOriginal(originalFileName)
						.euRename(fileRename)
						.purposeNo(purposeNo)
						.eventNo(eventNo)
						.build();
	}
	
	private Casting getCastingBy(String castingNm, String eventNo) {
		return Casting.builder()
					.castingNm(castingNm)
					.eventNo(eventNo)
					.build();
	}
	
	private void deleteFile(String fileRename) {
		String filePath = getServletContext().getRealPath("/upload/joonho") + "/" + fileRename;
		File fileToDelete = new File(filePath);
		
		if (fileToDelete.exists()) {
			fileToDelete.delete();
			System.out.println(String.format("%s을 삭제했습니다.", fileRename));
			return;
		}
		System.out.println(String.format("%s은 존재하지 않습니다.", fileRename));
	}
}
