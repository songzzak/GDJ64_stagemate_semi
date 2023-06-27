package com.stagemate.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.board.model.vo.Board;
import com.stagemate.board.service.BoardService;


@WebServlet(name = "SelectMyBoardListServlete", urlPatterns = { "/board/selectMyBoard.do" })
public class SelectBoardListOnMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SelectBoardListOnMyPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		List<Board> list=new BoardService().selectBoardById(id);
		
		request.setAttribute("boards", list);
		request.getRequestDispatcher("/views/mypage/myPosts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
