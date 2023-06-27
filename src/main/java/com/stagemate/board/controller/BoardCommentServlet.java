package com.stagemate.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.board.model.vo.BoardComment;
import com.stagemate.board.service.BoardService;

/**
 * Servlet implementation class BoardCommentServlet
 */
@WebServlet("/board/insertComment.do")
public class BoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardComment bc=BoardComment.builder()
				.boardRef(Integer.parseInt(request.getParameter("boardRef")))
				.level(Integer.parseInt(request.getParameter("level")))
				.cmtWriter(request.getParameter("cmtWriter"))
				.cmtContent(request.getParameter("cmtContent"))
				.cmtRef(Integer.parseInt(request.getParameter("cmtRef")))
				.build();
		
		int result=new BoardService().insertBoardComment(bc);
		
		String view;
		if(result>0) {
			view=request.getContextPath()+"/board/boardView.do?no="+bc.getBoardRef();
			response.sendRedirect(view);
		}else {
			request.setAttribute("msg", "댓글등록 실패하셨습니다!");
			request.setAttribute("loc", "/board/boardView.do?no="+bc.getBoardRef());
			view="/views/common/msg.jsp";
			response.sendRedirect(request.getContextPath()+"/board/boardView.do?no="+bc.getBoardRef());
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
