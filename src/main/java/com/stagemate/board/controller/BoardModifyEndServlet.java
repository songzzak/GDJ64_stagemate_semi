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
 * Servlet implementation class BoardModifyEndServlet
 */
@WebServlet(name="boardModifyEnd", urlPatterns="/board/boardModify.do")
public class BoardModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModifyEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Board b = Board.builder()
				.boardWriter(request.getParameter("writer"))
				.boardTitle(request.getParameter("title"))
				.boardContent(request.getParameter("content"))
				.boardNo(Integer.parseInt(request.getParameter("no")))
				.build();
		
		int result = new BoardService().boardModify(b);

		response.sendRedirect(request.getContextPath()+"/board/boardList.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
