package com.stagemate.payment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.event.model.vo.Seat;
import com.stagemate.payment.model.vo.EventOrder;
import com.stagemate.payment.model.vo.Payment;
import com.stagemate.payment.service.PaymentService;

/**
 * Servlet implementation class PaymentResultServlet
 */
@WebServlet("/event/paymentresult.do")
public class EventPaymentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventPaymentResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Payment p=Payment.builder()
				.paymentNo(request.getParameter("merchant_uid"))
				.paymentPrice(Integer.parseInt(request.getParameter("totalprice")))
				.build();
		
		int eventPayment=new PaymentService().insertPayment(p);
		EventOrder eo=EventOrder.builder()
				.eventNo(request.getParameter("eventNo"))
				.whatchDt(request.getParameter("choiceday"))
				.rsvPrice(Integer.parseInt(request.getParameter("totalprice")))
				.memberId(request.getParameter("memberId"))
				.paymentNo(request.getParameter("merchant_uid"))
				.build();
		String row=request.getParameter("row");
		String column=request.getParameter("column");
//		String[] rows=row.split(",");
//		int[] columns=column.split(",");
//		for(int i=0;i<rows.length;i++) {
//			if(rows[i].equals("A")) {
//				column[i]
//			}
//		}
//		
//		for(int i=0;i<rows.length;i++) {
//			Seat s=Seat.builder()
//				.seatRow(rows[i].charAt(0))
//				.seatCol(Integer.parseInt(columns[i]))
//				.eventNo(request.getParameter("eventNo"))
//				.build();
//		}
				
				
		String name=request.getParameter("name");
		String chkDate=request.getParameter("chkDate");
		
		
		
		//request.getRequestDispatcher("/views/event/event_payment_final.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
