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
import com.stagemate.qna.model.service.QnaService;
import com.stagemate.qna.model.vo.Qna;
import com.stagemate.qna.model.vo.QnaFileData;

/**
 * Servlet implementation class UpdateNoticeEndServlet
 */
@WebServlet("/notice/updateNoticeEnd.do")
public class UpdateNoticeEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "시스템 에러 혹은 잘못된 접근입니다. XD");
			request.setAttribute("loc", "/notice/noticeList.do");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}else {
			String path=getServletContext().getRealPath("/upload/nabin");
			MultipartRequest mr=new MultipartRequest(request, path,1024*1024*100,"UTF-8",new DefaultFileRenamePolicy());
			Notice n=Notice.builder().noticeNo(Integer.parseInt(mr.getParameter("noticeNo")))
					.noticeTitle(mr.getParameter("noticeTitle"))
					.noticeContent(mr.getParameter("noticeContent"))
					.noticeWriter(mr.getParameter("noticeWriter"))
					.files(NoticeFileData.builder().imgFileRename(mr.getFilesystemName("upfile"))
							.imgFilenameOri(mr.getOriginalFileName("upfile")).build())
					.build();
			
			
			int result=new NoticeService().updateNotice(n);
			if(result>0) {
				request.setAttribute("msg", "정상적으로 등록되었습니다.");
				request.setAttribute("loc", "/qna/qnaList.do");
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				
			}else {
				
				n=Notice.builder().noticeNo(Integer.parseInt(mr.getParameter("noticeNo")))
						.noticeTitle(mr.getParameter("noticeTitle"))
						.noticeContent(mr.getParameter("noticeContent"))
						.noticeWriter(mr.getParameter("noticeWriter"))
						.files(NoticeFileData.builder().imgFileRename(mr.getFilesystemName("upfile"))
								.imgFilenameOri(mr.getOriginalFileName("upfile")).build())
						.build();
				
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
