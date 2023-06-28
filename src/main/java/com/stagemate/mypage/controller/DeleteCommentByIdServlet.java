package com.stagemate.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.board.service.BoardService;

/**
 * Servlet implementation class DeleteCommentByIdServlet
 */
@WebServlet("/mypage/deleteMyComment.do")
public class DeleteCommentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chkArrParam = request.getParameter("chk_arr");
		String id=request.getParameter("id");
		String[] chkArrStr = chkArrParam.split(",");
	    int[] chkArr = new int[chkArrStr.length];
	    for (int i = 0; i < chkArrStr.length; i++) {
	        chkArr[i] = Integer.parseInt(chkArrStr[i]);
	    }
	    for (int commentNo : chkArr) {
	        //System.out.println(commentNo);
	        int result=new BoardService().deleteComment(commentNo);
	    }
	    request.getRequestDispatcher("/board/selectMyBoard.do?id="+id).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
