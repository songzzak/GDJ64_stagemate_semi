package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.admin.service.AdminService;

@WebServlet("/admin/searchLocation.do")
public class SearchLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchLocationServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String location = request.getParameter("location");
		List<String> locations = new AdminService().selectLocation(location);
		
		StringBuilder data = new StringBuilder();
		IntStream.range(0, locations.size()).forEach(index -> {
			if (index != 0) {
				data.append(",");
			}
			data.append(locations.get(index));
		});
		
		response.setContentType("text/csv; charset=utf-8");
		response.getWriter().print(data.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
