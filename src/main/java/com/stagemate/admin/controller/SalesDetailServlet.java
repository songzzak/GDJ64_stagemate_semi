package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.admin.model.vo.PlayInfo;
import com.stagemate.admin.service.AdminService;


@WebServlet("/admin/SalesDetail.do")
public class SalesDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_MEMBER = "loginMember";    
       
  
    public SalesDetailServlet() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PlayInfo> p=new AdminService().listPlayInfo();
		request.setAttribute("playinfo", p);
		//출력할 화면 이동
		request.getRequestDispatcher("/views/admin/admin_salesDetail.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
