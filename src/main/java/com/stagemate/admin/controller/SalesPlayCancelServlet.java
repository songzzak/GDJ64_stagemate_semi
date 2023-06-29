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

/**
 * Servlet implementation class SalesPlayCancelServlet
 */
@WebServlet("/admin/SalesPlayCancel.do")
public class SalesPlayCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesPlayCancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rsvNo=request.getParameter("rsvNo");
		
		List<EventOrder> eventOrders=new AdminService().selectCancelOrder(rsvNo);
		
		eventOrders.stream().forEach(System.out::println);

		request.setAttribute("eventOrders", eventOrders);
		
		
		
		
		request.getRequestDispatcher("/views/admin/admin_salesPlayCancel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
