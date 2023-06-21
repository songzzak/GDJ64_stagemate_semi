package com.stagemate.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.common.AuthMailSender;

@WebServlet("/member/sendAuthCode.do")
public class SendAuthCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_DIGIT = 6;
	private static final int MAX_NUMBER_EXCLUDED = 10;
       
    public SendAuthCodeServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		final String receiver = request.getParameter("receiver");
		System.out.println(receiver);
		final String authCode = generateAuthCode();
		System.out.println(authCode);
		
		AuthMailSender authMailSender = new AuthMailSender();
		authMailSender.send(receiver, authCode);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(authCode);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	private String generateAuthCode() {
		Random random = new Random();
		StringBuilder authCode = new StringBuilder();
		
		IntStream.range(0, MAX_DIGIT).forEach(digit -> {
			switch (random.nextInt(3)) {
				case 0:
					authCode.append((char) (random.nextInt(26) + 97));
					break;
				case 1:
					authCode.append((char) (random.nextInt(26) + 65));
					break;
				case 2:
					authCode.append(String.valueOf(random.nextInt(MAX_NUMBER_EXCLUDED)));
					break;
			}
		});
		return authCode.toString();
	}
}
