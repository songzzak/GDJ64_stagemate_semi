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
		String totalprice=request.getParameter("totalprice");
		Payment p=Payment.builder()
				.paymentNo(request.getParameter("merchant_uid"))
				.paymentPrice(Integer.parseInt(totalprice))
				.build();
		
		int paymentResult=new PaymentService().insertPayment(p);
		String paymentNo=request.getParameter("merchant_uid");
		String eventNo=request.getParameter("eventNo");
		String esNo=request.getParameter("esNo");
		EventOrder eo=EventOrder.builder()
				.esNo(esNo)
				.rsvPrice(Integer.parseInt(totalprice))
				.memberId(request.getParameter("memberId"))
				.paymentNo(paymentNo)
				.build();
		
		int eventOrderResult=new PaymentService().insertEventOrder(eo);
		String evcNo=request.getParameter("evcNo");
		String row=request.getParameter("row");
		String column=request.getParameter("column");
		String choiceday=request.getParameter("choiceday");
		String choicedays=choiceday.replace(".", "");
		String[] rows=row.split(",");
		List<Integer> col = new ArrayList<>();
        String[] columns = column.split(",");
		for(int i=0;i<rows.length;i++) {
			 if(evcNo.equals("EVC1")) {
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
		if(evcNo.equals("EVC1")) {
			for(int i=0;i<rows.length;i++) {
				int updateSeatResult=new PaymentService().updateMusicalSeatRes(rows[i],col.get(i),eventNo,choicedays);
				Seat SeatNo=new PaymentService().selectMusicalSeatNo(rows[i],col.get(i),eventNo,esNo);
				int eventOrderDetailResult=new PaymentService().insertEventOrderDetail(eventOrder.getRsvNo(),SeatNo.getSeatNo());
			}
		}else if(evcNo.equals("EVC2")) {
			for(int i=0;i<rows.length;i++) {
				int updateSeatResult=new PaymentService().updateConcertSeatRes(rows[i],col.get(i),eventNo,choicedays);
				Seat SeatNo=new PaymentService().selectConcertSeatNo(rows[i],col.get(i),eventNo,esNo);
				int eventOrderDetailResult=new PaymentService().insertEventOrderDetail(eventOrder.getRsvNo(),SeatNo.getSeatNo());
			}
		}else {
			for(int i=0;i<rows.length;i++) {
				int updateSeatResult=new PaymentService().updateActSeatRes(rows[i],col.get(i),eventNo,choicedays);
				Seat SeatNo=new PaymentService().selectActSeatNo(rows[i],col.get(i),eventNo,esNo);
				int eventOrderDetailResult=new PaymentService().insertEventOrderDetail(eventOrder.getRsvNo(),SeatNo.getSeatNo());
			}
		}
		Event event=new EventService().selectEventByEventNo(eventNo);
		List<EventUpfile> files=new EventService().selectFileByEventNo(eventNo);
		String name=request.getParameter("name");
		String chkDate=request.getParameter("chkDate");
		String round=request.getParameter("round");
		String seats=request.getParameter("seats");
		request.setAttribute("event", event);
		request.setAttribute("seats", seats);
		request.setAttribute("choiceday", choiceday);
		request.setAttribute("round", round);
		request.setAttribute("totalprice", totalprice);
		request.setAttribute("files", files);
		request.setAttribute("eventOrder", eventOrder);
		request.setAttribute("chkDate", chkDate);
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
