package com.stagemate.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.common.AESEncryptor;
import com.stagemate.member.model.vo.Member;
import com.stagemate.member.service.MemberService;

@WebServlet("/member/enrollEnd.do")
public class EnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final SimpleDateFormat firstFormat;
	private final SimpleDateFormat finalFormat;
       
    public EnrollEndServlet() {
    	firstFormat = new SimpleDateFormat("yyyyMMdd");
    	finalFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		final String address = String.format("%s %s", 
											request.getParameter("address"),
											request.getParameter("addressDetail"));	
		
		Member member = Member.builder()
							.memberId(request.getParameter("userId"))
							.memberPw(request.getParameter("password"))
							.memberNm(request.getParameter("userName"))
							.memberBdate(formatDate(request.getParameter("birthdate")))
							.memberEmail(request.getParameter("email"))
							.memberPhone(request.getParameter("phone"))
							.memberAddress(address)
							.build();

		try {
			member.setMemberEmail(AESEncryptor.encrypt(member.getMemberEmail()));
		} catch (Exception e) {
			System.out.println("이메일 암호화 실패");
		}

		try {
			member.setMemberPhone(AESEncryptor.encrypt(member.getMemberPhone()));
		} catch (Exception e) {
			System.out.println("전화번호 암호화 실패");
		}
		
		int result = new MemberService().insertMember(member);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	private Date formatDate(String date) {
		java.util.Date tempDate = null;
		
		try {
			tempDate = firstFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String transDate = finalFormat.format(tempDate);
		return Date.valueOf(transDate);
	}

}
