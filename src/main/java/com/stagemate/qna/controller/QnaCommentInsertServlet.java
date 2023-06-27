package com.stagemate.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.qna.model.service.QnaService;
import com.stagemate.qna.model.vo.QnaComment;

/**
 * Servlet implementation class BoardCommentInsertServlet
 */
@WebServlet("/qna/insertComment.do")
public class QnaCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnaComment qc=QnaComment.builder()
				.qnaRef(Integer.parseInt(request.getParameter("inquiryRef")))
				.level(Integer.parseInt(request.getParameter("level")))
				.qnaCommentWriter(request.getParameter("inquiryCommentWriter"))
				.qnaCommentContent(request.getParameter("content"))
				.qnaCommentRef(Integer.parseInt(request.getParameter("inquiryCommentRef")))
				.build();
					
		int result=new QnaService().insertQnaComment(qc);
		
		String view;
		if(result>0) {
			view=request.getContextPath()+"/qna/qnaView.do?no="+qc.getQnaRef();
			response.sendRedirect(view);
		}else {
			request.setAttribute("msg", "댓글등록 실패!");
			request.setAttribute("loc", "/qna/qnaView.do?no="+qc.getQnaRef());
			view="/views/common/msg.jsp";
			
		}
		request.getRequestDispatcher(view).forward(request,response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
