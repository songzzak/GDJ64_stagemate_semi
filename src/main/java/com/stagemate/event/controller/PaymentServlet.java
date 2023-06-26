package com.stagemate.event.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.event.service.EventService;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/event/payment.do")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventNo=request.getParameter("no");
		String round=request.getParameter("round");
		String choiceday=request.getParameter("choiceday");
		String seats=request.getParameter("seat");
		String esNo=request.getParameter("esNo");
		String[] seat=seats.split("\\)");
		Event event=new EventService().selectEventByEventNo(eventNo);
		List<EventUpfile> files=new EventService().selectFileByEventNo(eventNo);
		request.setAttribute("event", event);
		request.setAttribute("files", files);
		request.setAttribute("round", round);
		request.setAttribute("choiceday", choiceday);
		request.setAttribute("seat", seat);
		request.setAttribute("seats", seats);
		request.setAttribute("seat", seat);
		request.setAttribute("esNo", esNo);
		String a=choiceday.replace(".", "");
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMdd");  //dt와 형식을 맞추어 준다.
		SimpleDateFormat output = new SimpleDateFormat("yyyy년MM월dd일"); //변환할 형식
		Date newdt=null;
		try{
			newdt = input.parse(a);			//date 자료형으로 변환
		}catch (Exception e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newdt);
		calendar.add(Calendar.DATE, -1);
		String chkDate = output.format(calendar.getTime());
		request.setAttribute("chkDate", chkDate);
		request.getRequestDispatcher("/views/event/event_payment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
