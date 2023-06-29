package com.stagemate.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.common.AESEncryptor;
import com.stagemate.member.service.MemberService;

@WebServlet("/member/emailDuplication.do")
public class EmailDuplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailDuplication() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String emailToUse = request.getParameter("receiver");
		
		try {
			emailToUse = AESEncryptor.encrypt(emailToUse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String result = "unique";
		
		if (new MemberService().selectByEmail(emailToUse) != null) {
			result = "duplicate";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
