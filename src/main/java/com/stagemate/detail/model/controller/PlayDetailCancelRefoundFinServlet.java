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
import com.stagemate.detail.model.vo.DetailInfo;
import com.stagemate.detail.model.vo.DetailTicketList;
import com.stagemate.member.model.vo.Member;

import com.google.gson.Gson;

/**
 * Servlet implementation class PlayDetailInfoServlet
 */
@WebServlet("/Detail/PlayDetailCancelRefoundFinServlet")
public class PlayDetailCancelRefoundFinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_MEMBER = "loginMember";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayDetailCancelRefoundFinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkNo = request.getParameter("rsvNo");

		String userId = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute(LOGIN_MEMBER);
		if (obj != null) {
			Member member = (Member)obj;
			userId = member.getMemberId();
		}
		
		DetailInfo detailInfo = new PlayListService().selectPlayDetailInfo(userId, checkNo);
		request.setAttribute("DetailInfo", detailInfo);
		
		request.getRequestDispatcher("/views/detail/play_refund_fin.jsp").forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



