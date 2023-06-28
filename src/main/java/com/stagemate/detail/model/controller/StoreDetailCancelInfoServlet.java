package com.stagemate.detail.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagemate.detail.model.service.PlayListService;
import com.stagemate.detail.model.service.StoreListService;
import com.stagemate.detail.model.vo.DetailInfo;
import com.stagemate.detail.model.vo.DetailTicketList;
import com.stagemate.detail.model.vo.StoreDetailInfo;
import com.stagemate.member.model.vo.Member;

import com.google.gson.Gson;

/**
 * Servlet implementation class PlayDetailInfoServlet
 */
@WebServlet("/Detail/StoreDetailCancelInfoServlet")
public class StoreDetailCancelInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_MEMBER = "loginMember";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreDetailCancelInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkNo = request.getParameter("orderNo");

		String userId = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute(LOGIN_MEMBER);
		if (obj != null) {
			Member member = (Member)obj;
			userId = member.getMemberId();
		}
		
		StoreDetailInfo storeDetailInfo = new StoreListService().selectStoreDetailInfo(userId, checkNo);
		request.setAttribute("StoreDetailInfo", storeDetailInfo);
		
		request.getRequestDispatcher("/views/detail/play_store_refund.jsp").forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



