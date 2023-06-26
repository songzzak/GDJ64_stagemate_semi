package com.stagemate.payment.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.event.model.vo.Seat;
import com.stagemate.event.service.EventService;
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
		
		int paymentResult=new PaymentService().insertPayment(p);
		String paymentNo=request.getParameter("merchant_uid");
		String eventNo=request.getParameter("eventNo");
		String esNo=request.getParameter("esNo");
		EventOrder eo=EventOrder.builder()
				.esNo(esNo)
				.rsvPrice(Integer.parseInt(request.getParameter("totalprice")))
				.memberId(request.getParameter("memberId"))
				.paymentNo(paymentNo)
				.build();
		
		int eventOrderResult=new PaymentService().insertEventOrder(eo);
		String evnNo=request.getParameter("evnNo");
		String row=request.getParameter("row");
		String column=request.getParameter("column");
		String choiceday=request.getParameter("choiceday");
		String choicedays=choiceday.replace(".", "");
		String[] rows=row.split(",");
		List<Integer> col = new ArrayList<>();
        String[] columns = column.split(",");
		for(int i=0;i<rows.length;i++) {
			 if(evnNo.equals("EVC1")) {
				 int number = Integer.parseInt(columns[i]);
				 if((rows[i].equals("A")||rows[i].equals("B"))&&number>2) {
					 number += 1;
				 }else if(number>4) {
					 number += 1;
				 }
				 if((rows[i].equals("A")||rows[i].equals("B"))&&number>14) {
					 number += 1;
				 }else if(number>16) {
					 number += 1;
				 }
				 col.add(number);
			 }else {
				 int number = Integer.parseInt(columns[i]);
				 if(number>5) {
					 number += 1;
				 }
				 if(number>13) {
					 number += 1;
				 }
				 col.add(number);
			 }
		}
		
		EventOrder eventOrder=new PaymentService().selectEventOrder(paymentNo);
		for(int i=0;i<rows.length;i++) {
			int updateSeatResult=new PaymentService().updateSeatRes(rows[i],col.get(i),eventNo,choicedays);
			Seat SeatNo=new PaymentService().selectSeatNo(rows[i],col.get(i),eventNo,esNo);
			int eventOrderDetailResult=new PaymentService().insertEventOrderDetail(eventOrder.getRsvNo(),SeatNo.getSeatNo());
		}
		Event event=new EventService().selectEventByEventNo(eventNo);
		List<EventUpfile> files=new EventService().selectFileByEventNo(eventNo);
		request.setAttribute("event", event);
		request.setAttribute("files", files);
		request.setAttribute("eventOrder", eventOrder);
		String name=request.getParameter("name");
		String chkDate=request.getParameter("chkDate");
		request.getRequestDispatcher("/views/event/event_payment_final.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
