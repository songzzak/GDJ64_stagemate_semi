package com.stagemate.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.common.AESEncryptor;
import com.stagemate.member.model.vo.Member;
import com.stagemate.member.service.MemberService;

@WebServlet("/member/findIdEnd.do")
public class FindIdEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindIdEndServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String email = "";
		try {
			email = AESEncryptor.encrypt(request.getParameter("email"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Member member = new MemberService().selectByEmail(email);
		String userId = "notFound";
		
		if (member != null) {
			userId = member.getMemberId();
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(userId);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
