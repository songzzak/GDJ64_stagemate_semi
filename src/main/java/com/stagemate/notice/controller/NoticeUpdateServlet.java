package com.stagemate.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.notice.model.service.NoticeService;
import com.stagemate.notice.model.vo.Notice;
import com.stagemate.qna.model.service.QnaService;
import com.stagemate.qna.model.vo.Qna;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/notice/updateNotice.do")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int no=Integer.parseInt(request.getParameter("no"));
		Notice n=new NoticeService().selectNoticeByNo(no);
		request.setAttribute("notice", n);
		request.getRequestDispatcher("/views/notice/updateNotice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
