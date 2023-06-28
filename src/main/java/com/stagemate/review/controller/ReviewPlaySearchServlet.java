package com.stagemate.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.review.model.vo.PlaySearch;
import com.stagemate.review.service.ReviewService;

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
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
