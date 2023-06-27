package com.stagemate.event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.event.model.vo.Event;
import com.stagemate.event.model.vo.EventSchedule;
import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.event.model.vo.EventWish;
import com.stagemate.event.model.vo.Seat;
import com.stagemate.event.service.EventService;

/**
 * Servlet implementation class MusicalNum1
 */
@WebServlet("/event/eventView.do")
public class EventViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventNo=request.getParameter("no");
		Event event=new EventService().selectEventByEventNo(eventNo);
		List<EventUpfile> files=new EventService().selectFileByEventNo(eventNo);
		List<EventSchedule> es=new EventService().selectTimeByEvent(eventNo);
		if(event.getEvcNo().equals("EVC1")) {
			List<Seat> seats=new EventService().selectSeatByEvnNoMusical(eventNo);
			request.setAttribute("seats", seats);
		}else if(event.getEvcNo().equals("EVC2")) {
			List<Seat> seats=new EventService().selectSeatByEvnNoConcert(eventNo);
			request.setAttribute("seats", seats);
		}else{
			List<Seat> seats=new EventService().selectSeatByEvnNoAct(eventNo);
			request.setAttribute("seats", seats);
		}
		List<EventWish> ew=new EventService().selectAllEventWish();
		request.setAttribute("ew", ew);
		request.setAttribute("event", event);
		request.setAttribute("files", files);
		request.setAttribute("es", es);
		request.getRequestDispatcher("/views/event/event_view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
