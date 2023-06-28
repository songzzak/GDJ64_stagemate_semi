package com.stagemate.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.notice.model.service.NoticeService;
import com.stagemate.qna.model.service.QnaService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/notice/deleteNotice.do")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		System.out.println(request.getParameter("no"));
		int noticeNo = Integer.parseInt(request.getParameter("no"));
		System.out.println(noticeNo);
		int result = new NoticeService().deleteNotice(noticeNo);
	
		response.sendRedirect(request.getContextPath()+"/notice/noticeList.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
