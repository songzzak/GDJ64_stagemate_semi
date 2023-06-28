package com.stagemate.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.stagemate.qna.model.service.QnaService;
import com.stagemate.qna.model.vo.Qna;
import com.stagemate.qna.model.vo.QnaFileData;

/**
 * Servlet implementation class UpdateQnaEndServlet
 */
@WebServlet("/qna/updateQnaEnd.do")
public class UpdateQnaEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQnaEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "시스템 에러 혹은 잘못된 접근입낟. XD");
			request.setAttribute("loc", "/qna/qnaList.do");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}else {
			String path=getServletContext().getRealPath("/upload/nabin");
			MultipartRequest mer=new MultipartRequest(request, path,1024*1024*100,"UTF-8",new DefaultFileRenamePolicy());
			Qna q=Qna.builder().inquiryNo(Integer.parseInt(mer.getParameter("qnaNo")))
					.inquiryTitle(mer.getParameter("qnaTitle"))
					.inquiryContent(mer.getParameter("qnaContent"))
					.writerId(mer.getParameter("qnaWriter"))
					.files(QnaFileData.builder().imgFileRename(mer.getFilesystemName("upfile"))
							.imgFilenameOri(mer.getOriginalFileName("upfile")).build())
					.build();
			
			
			int result=new QnaService().updateQna(q);
			if(result>0) {
				request.setAttribute("msg", "정상적으로 등록되었습니다.");
				request.setAttribute("loc", "/qna/qnaList.do");
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				
			}else {
				
				q=Qna.builder().inquiryNo(Integer.parseInt(mer.getParameter("qnaNo")))
						.inquiryTitle(mer.getParameter("qnaTitle"))
						.inquiryContent(mer.getParameter("qnaContent"))
						.writerId(mer.getParameter("qnaWriter"))
						.inquiryLockFlg(mer.getParameter("qnaLock"))
						.files(QnaFileData.builder().imgFileRename(mer.getFilesystemName("upfile"))
								.imgFilenameOri(mer.getOriginalFileName("upfile")).build())
						.build();
				
			}
		}
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
