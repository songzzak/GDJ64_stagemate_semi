package com.stagemate.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.board.model.vo.Board;
import com.stagemate.board.model.vo.BoardComment;
import com.stagemate.board.service.BoardService;
import com.stagemate.qna.model.service.QnaService;
import com.stagemate.qna.model.vo.Qna;
import com.stagemate.qna.model.vo.QnaListCtg;

/**
 * Servlet implementation class SelectQnaOnMyPage
 */
@WebServlet("/qna/selectMyInquiry.do")
public class SelectQnaOnMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectQnaOnMyPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		List<Qna> list=new QnaService().selectQnaById(id);
		List<QnaListCtg> ctglist=new QnaService().selectQnaListCtg();
		request.setAttribute("list", list);
		request.setAttribute("ctglist", ctglist);
		request.getRequestDispatcher("/views/mypage/myInquiry.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
