package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.event.model.vo.EventUpfile;
import com.stagemate.event.service.EventService;

@WebServlet("/admin/updateBanner.do")
public class UpdateBannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBannerServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		Map<String, EventUpfile> banners = new EventService().selectBanner();
		
		request.setAttribute("banners", banners);
		request.getRequestDispatcher("/views/admin/admin_updateBanner.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
