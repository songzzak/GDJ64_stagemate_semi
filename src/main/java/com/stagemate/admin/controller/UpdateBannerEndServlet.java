package com.stagemate.admin.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/admin/updateBannerEnd.do")
public class UpdateBannerEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBannerEndServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String path = getServletContext().getRealPath("/upload/jaehun/main_banners.json");
		String data = request.getParameter("data");
		JsonObject jsonObject = JsonParser.parseString(data).getAsJsonObject(); 
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonWellPrinted = gson.toJson(jsonObject);
        
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path))) {
        	printWriter.write(jsonWellPrinted);
        	
        	response.setContentType("text/html; charset=utf-8");
    		response.getWriter().print("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
