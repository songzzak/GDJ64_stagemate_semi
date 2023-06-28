package com.stagemate.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.board.service.BoardService;
import com.stagemate.store.service.StoreService;


@WebServlet("/mypage/deleteMyBoard.do")
public class DeleteBoardByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBoardByIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chkArrParam = request.getParameter("chk_arr");
		String id=request.getParameter("id");
		String[] chkArrStr = chkArrParam.split(",");
	    int[] chkArr = new int[chkArrStr.length];
	    for (int i = 0; i < chkArrStr.length; i++) {
	        chkArr[i] = Integer.parseInt(chkArrStr[i]);
	    }
	    for (int boardNo : chkArr) {
	        //System.out.println(boardNo);
	        int result=new BoardService().deleteBoard(boardNo);
	    }
	    request.getRequestDispatcher("/board/selectMyBoard.do?id="+id).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
