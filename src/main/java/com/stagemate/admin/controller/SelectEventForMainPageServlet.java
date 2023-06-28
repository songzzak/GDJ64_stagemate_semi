package com.stagemate.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.stagemate.event.model.vo.Event;
import com.stagemate.event.service.EventService;

@WebServlet("/eventForMainPage.do")
public class SelectEventForMainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectEventForMainPageServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String date = request.getParameter("targetDate");
		System.out.println("프론트에서 받은 날짜: " + date);
		Map<Event, String> events = new EventService().selectEventAndFileByDate(date);
		
		JSONArray jsonArray = new JSONArray();
		for (Map.Entry<Event, String> event : events.entrySet()) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("eventNo", event.getKey().getEventNo());
			jsonObject.put("eventNm", event.getKey().getEventNm());
			jsonObject.put("eventStartDt", convert(event.getKey().getEventStartDt()));
			jsonObject.put("eventEndDt", convert(event.getKey().getEventEndDt()));
			jsonObject.put("rsvOpenDt", convert(event.getKey().getRsvOpenDt()));
			jsonObject.put("location", event.getKey().getLocation());
			jsonObject.put("euRename", event.getValue());
			jsonArray.add(jsonObject);
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	private String convert(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
