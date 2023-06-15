package com.stagemate.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.member.model.vo.Member;

@WebServlet("/loginEnd.do")
public class LogInEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogInEndServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("password");
		String saveId = request.getParameter("saveId");
		System.out.println(userId);
		System.out.println(userPw);
		System.out.println(saveId);
		Boolean isIdentified = false;
		
		if (saveId.equals("true")) {
			Cookie cookie = new Cookie("saveId", userId);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("saveId", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

//		Member member = new MemberService().selectByAccount(userId, userPw);
		Member member = null;
		
		
		if (member != null) {
			request.getSession().setAttribute("loginMember", member);
			isIdentified = true;
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(isIdentified);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
