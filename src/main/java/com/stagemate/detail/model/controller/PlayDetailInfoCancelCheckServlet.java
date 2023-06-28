package com.stagemate.detail.model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagemate.admin.service.AdminService;
import com.stagemate.detail.model.service.PlayListService;
import com.stagemate.detail.model.service.StoreListService;
import com.stagemate.detail.model.vo.ResponseSearch;
import com.stagemate.detail.model.vo.Detail;
import com.stagemate.detail.model.vo.StoreDetail;
import com.stagemate.member.model.vo.Member;

import com.google.gson.Gson;

/**
 * Servlet implementation class PlayListSearchServlet
 */
@WebServlet("/Detail/PlayDetailInfoCancelCheckServlet")
public class PlayDetailInfoCancelCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_MEMBER = "loginMember";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayDetailInfoCancelCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rsvNo = request.getParameter("rsvNo");
		if (rsvNo == null) {
			rsvNo = "";
		}
		String esNo = request.getParameter("esNo");
		if (esNo == null) {
			esNo = "";
		}
		String orderNo = request.getParameter("orderNo");
		if (orderNo == null) {
			orderNo = "";
		}
		
		request.setAttribute("RsvNo", rsvNo);
		request.setAttribute("EsNo", esNo);
		request.setAttribute("OrderNo", orderNo);
		request.getRequestDispatcher("/views/detail/play_detail_check.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



