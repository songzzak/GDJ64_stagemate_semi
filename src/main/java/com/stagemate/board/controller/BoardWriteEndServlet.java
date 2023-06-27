package com.stagemate.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.board.model.vo.Board;
import com.stagemate.board.service.BoardService;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet(name="boardWriteEnd",urlPatterns = "/board/boardWrite.do")
public class BoardWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardWriteEndServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Board b = Board.builder()
				.boardWriter(request.getParameter("writer"))
				.boardTitle(request.getParameter("title"))
				.boardContent(request.getParameter("content"))
				.build();
		System.out.println(b.getBoardWriter());
		System.out.println(b.getBoardTitle());
		System.out.println(b.getBoardContent());
		int result = new BoardService().boardWrite(b.getBoardWriter(),b.getBoardTitle(), b.getBoardContent());

		response.sendRedirect(request.getContextPath()+"/board/boardList.do");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
