package com.stagemate.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagemate.member.model.vo.Member;

/**
 * Servlet implementation class updatePhone
 */
@WebServlet("/member/updatePhone.do")
public class updatePhone extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updatePhone() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute("loginMember");
		Member member = null;
		if (obj != null) {
			member = (Member)obj;
			userId = member.getMemberId();
		}
		request.setAttribute("MemberInfo", member);
		
		request.getRequestDispatcher("/views/member/updatePhone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
