package com.stagemate.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.stagemate.notice.model.service.NoticeService;
import com.stagemate.notice.model.vo.Notice;
import com.stagemate.notice.model.vo.NoticeFileData;

/**
 * Servlet implementation class NoticeInsertEndServlet
 */
@WebServlet("/notice/insertNotice.do")
public class NoticeInsertEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//파일 업로드 처리하기 ->cos.jar 
	//1. mutipart/form-data 형식의 요청인지 확인 
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "잘못된 접근입니다. 관리자에게 문의하세요!");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
			return;
		}
		
//		파일 경로
		String path= getServletContext().getRealPath("/upload/nabin");
		System.out.print(path);
		//최대 파일 크기 
		int maxSize =1024*1024*10;
		String encode="UTF-8";
		//리네임 클래스 생성 
		DefaultFileRenamePolicy dfr= new DefaultFileRenamePolicy();
		
		//MutipartRequest 클래스 샹성하기 
		MultipartRequest mr= new MultipartRequest (request,path,maxSize,encode,dfr);
		
		String noticeTitle= mr.getParameter("noticeTitle");
		String noticeWriter=mr.getParameter("noticeWriter");
		String noticeContent=mr.getParameter("noticeContent");
		//저장된 파일에 대한 정보도 가져올 수있음 
		//원본파일명, 재정의 파일명, 파일 사이즈 등의 정보를 가져올 수있다.
		String orifilename=mr.getOriginalFileName("upFile");
		String renamefilename=mr.getFilesystemName("upFile");
		
		Notice n = Notice.builder()
				  .noticeTitle(noticeTitle)
				  .noticeWriter(noticeWriter)
				  .noticeContent(noticeContent)
				  .files(NoticeFileData.builder().imgFilenameOri(orifilename).imgFileRename(renamefilename).build())
				  .build();
				
	int result = new NoticeService().insertNotice(n);
	String msg="공지사항 등록 완료", loc="/notice/noticeList.do";
	if(result==0) {
		msg="공지사항 등록 실패";
		loc="/notice/insertForm.do";
	}
	request.setAttribute("msg", msg);
	request.setAttribute("loc", loc);
		
	request.getRequestDispatcher("/views/common/msg.jsp")
	.forward(request, response);
	}
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
