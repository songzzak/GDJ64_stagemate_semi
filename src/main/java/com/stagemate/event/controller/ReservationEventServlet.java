package com.stagemate.event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.event.model.vo.Seat;
import com.stagemate.event.service.EventService;

/**
 * Servlet implementation class ReservationMusical
 */
@WebServlet("/event/reservation.do")
public class ReservationEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String esNo=request.getParameter("esNo");
		String evcNo=request.getParameter("evc");
		String eventNo=request.getParameter("event");
		String round=request.getParameter("round");
		String choiceday=request.getParameter("choiceday");
		request.setAttribute("esNo", esNo);
		request.setAttribute("eventNo", eventNo);
		request.setAttribute("round", round);
		request.setAttribute("choiceday", choiceday);
		if(evcNo.equals("EVC1")) {
			List<Seat> seats=new EventService().selectSeatByEvnNoMusical(eventNo);
			request.setAttribute("seats", seats);
			request.getRequestDispatcher("/views/event/musical/musical_reservation.jsp").forward(request, response);
		}else if(evcNo.equals("EVC2")) {
			List<Seat> seats=new EventService().selectSeatByEvnNoConcert(eventNo);
			request.setAttribute("seats", seats);
			request.getRequestDispatcher("/views/event/concert/concert_reservation.jsp").forward(request, response);
		}else{
			List<Seat> seats=new EventService().selectSeatByEvnNoAct(eventNo);
			request.setAttribute("seats", seats);
			request.getRequestDispatcher("/views/event/act/act_reservation.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
