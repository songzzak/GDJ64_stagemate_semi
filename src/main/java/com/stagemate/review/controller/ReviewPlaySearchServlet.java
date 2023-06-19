package com.stagemate.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.admin.service.AdminService;
import com.stagemate.member.model.vo.Member;

/**
 * Servlet implementation class SearchPlayTitleServlet
 */
@WebServlet("/Review/SearchTitle.do")
public class ReviewPlaySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ReviewPlaySearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 파라미터로 keyword에 입력한 값 받아오기. 그리고 그 값이 DB에 있는 값과 일치한지 확인하기.
		String keyword = request.getParameter("keyword");
		// 확인된 값을 service로 넘겨주기

//		List<Member> members=new AdminService()
//				.selectEventByKeyword(keyword);
//		
//		request.setAttribute("members", members);
		
		
		
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
