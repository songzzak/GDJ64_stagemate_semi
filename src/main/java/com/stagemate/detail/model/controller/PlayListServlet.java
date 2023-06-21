package com.stagemate.detail.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.detail.model.service.PlayListService;
import com.stagemate.detail.model.vo.Detail;

@WebServlet("/Detail/DetailListServlet.do")
public class PlayListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PlayListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Detail> detail=new PlayListService().selectPlayDetail();
		request.setAttribute("DetailList", detail);
		
		request.getRequestDispatcher("/views/detail/detailList.jsp").forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
