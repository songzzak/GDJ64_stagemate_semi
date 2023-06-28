package com.stagemate.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.admin.service.AdminService;
import com.stagemate.detail.model.vo.EventOrder;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/member/UpdateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateMemberServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//이거 
		String userId=request.getParameter("userId");
		
		List<EventOrder> eventOrders=new AdminService().selectSalesInfo(userId);

		eventOrders.stream().forEach(System.out::println);

		
		request.setAttribute("eventOrders", eventOrders);
		//
		request.getRequestDispatcher("/views/member/updateMember.jsp").forward(request, response);
		
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
