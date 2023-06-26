package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.event.model.vo.Event;
import com.stagemate.event.service.EventService;

@WebServlet("/admin/updateEvent.do")
public class UpdatetEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatetEventServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String eventNo = request.getParameter("no");
		
		Event eventInfo = new EventService().selectEventByEventNo(eventNo);
		String casting = String.join(",", new EventService().selectCastingByEventNo(eventNo));
		
		List<String> fileRenames = new EventService().selectFileByEventNo(eventNo)
													.stream()
													.map(eventFile -> eventFile.getEuRename())
													.collect(Collectors.toList());
		
		Map<String, String> eventDays = new EventService().selectDaysByEventNo(eventNo);
		
		request.setAttribute("eventNo", eventNo);
		request.setAttribute("eventInfo", eventInfo);
		request.setAttribute("casting", casting);
		request.setAttribute("fileRenames", fileRenames);
		request.setAttribute("eventDays", eventDays);
		request.getRequestDispatcher("/views/admin/admin_updateEvent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}