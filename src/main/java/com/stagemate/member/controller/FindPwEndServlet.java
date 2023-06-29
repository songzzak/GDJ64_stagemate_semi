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

import com.stagemate.common.AESEncryptor;
import com.stagemate.common.AuthMailSender;
import com.stagemate.common.filter.PasswordEncryptionWrapper;
import com.stagemate.member.service.MemberService;

@WebServlet("/member/findPwEnd.do")
public class FindPwEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_DIGIT = 8;
	private static final int MAX_NUMBER_EXCLUDED = 10;
       
    public FindPwEndServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		final String newPassword = generateAuthCode();
		final String userId = request.getParameter("userId");
		final String email = request.getParameter("email");
		String emailEncrypted = "";
		try {
			emailEncrypted = AESEncryptor.encrypt(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int result = new MemberService().updatePassword(PasswordEncryptionWrapper.getSHA512(newPassword), userId, emailEncrypted);
		if (result != 0) {
			AuthMailSender authMailSender = new AuthMailSender();
			authMailSender.send(email, newPassword);
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
	
	private String generateAuthCode() {
		Random random = new Random();
		StringBuilder authCode = new StringBuilder();
		
		IntStream.range(0, MAX_DIGIT).forEach(digit -> {
			if (random.nextInt(2) == 0) {
				authCode.append((char) (random.nextInt(26) + 97));
				return;
			}
			authCode.append(String.valueOf(random.nextInt(MAX_NUMBER_EXCLUDED)));
		});
		return authCode.toString() + "@";
	}
}
