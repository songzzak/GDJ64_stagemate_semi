package com.stagemate.member.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagemate.member.model.vo.Member;


@WebServlet("/member/MemberInfoServlet.do")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberInfoServlet() {
        super(); 
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		String userId = "";
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginMember");
		Member member = null;
		if (obj != null) {
			member = (Member)obj;
			userId = member.getMemberId();
		}
		
		if (userId.equals("")) {
			req.setAttribute("msg", "잘못된 접근입니다!");
			req.setAttribute("loc", "/");
			req.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
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
		request.getRequestDispatcher("/views/member/memberInfo.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
