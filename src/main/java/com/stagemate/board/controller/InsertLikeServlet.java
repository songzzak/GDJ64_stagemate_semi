package com.stagemate.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stagemate.board.service.BoardService;

/**
 * Servlet implementation class InsertLikeServlet
 */
@WebServlet("/board/insertLike.do")
public class InsertLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		int boardNo=Integer.parseInt(request.getParameter("no"));
//		String memberId=request.getParameter("id");
//		int insertThumbs=new BoardService().insertLike(boardNo,memberId);
//		response.setContentType("application/json;utf-8");
//		
//		if(insertThumbs>0) {
//			int count=new BoardService().likeCount(boardNo);
//			new Gson().toJson(true,response.getWriter());
//		}else {
//			new Gson().toJson(false,response.getWriter());
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
