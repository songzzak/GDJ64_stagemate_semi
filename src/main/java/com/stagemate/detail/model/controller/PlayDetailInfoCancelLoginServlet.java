package com.stagemate.detail.model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
import com.stagemate.member.service.MemberService;
import com.google.gson.Gson;

/**
 * Servlet implementation class PlayListSearchServlet
 */
@WebServlet("/Detail/PlayDetailInfoCancelLoginServlet")
public class PlayDetailInfoCancelLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_MEMBER = "loginMember";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayDetailInfoCancelLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPw = request.getParameter("password");
		Boolean result = false;
		
		String userId = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute(LOGIN_MEMBER);
		if (obj != null) {
			Member member = (Member)obj;
			userId = member.getMemberId();
		}
		
		if (!userId.equals("")) {
			Member member = new MemberService().selectByIdAndPw(userId, userPw);
			if (member != null) {
				result = true;
			}
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



