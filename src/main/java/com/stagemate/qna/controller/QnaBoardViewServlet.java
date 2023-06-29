package com.stagemate.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.qna.model.service.QnaService;
import com.stagemate.qna.model.vo.Qna;
import com.stagemate.qna.model.vo.QnaComment;

/**
 * Servlet implementation class QnaBoardViewServlet
 */
@WebServlet("/qna/qnaView.do")
public class QnaBoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaBoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inquiryNo= Integer.parseInt(request.getParameter("no"));
		Qna q = new QnaService().selectInquiryByNo(inquiryNo);
					
		
		//댓글을 가져와 출력하기
		List<QnaComment> comments=new QnaService().selectQnaComment(inquiryNo);
		request.setAttribute("comments", comments);
		
		request.setAttribute("qna",q);
		System.out.println(comments);
		
		request.getRequestDispatcher("/views/qna/qnaBoardView.jsp")
		.forward(request, response);
		System.out.println(comments);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
