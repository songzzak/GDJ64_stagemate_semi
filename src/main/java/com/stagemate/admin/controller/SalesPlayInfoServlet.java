package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.admin.service.AdminService;
import com.stagemate.detail.model.vo.EventOrder;

@WebServlet("/admin/SalesPlayInfo.do")
public class SalesPlayInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SalesPlayInfoServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId=request.getParameter("userId");
		
		List<EventOrder> eventOrders=new AdminService().selectSalesInfo(userId);
		
		eventOrders.stream().forEach(System.out::println);
//		System.out.println(eventOrders);
		
		request.setAttribute("eventOrders", eventOrders);
		//화면 요청
		request.getRequestDispatcher("/views/admin/admin_salesPlayInfo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
