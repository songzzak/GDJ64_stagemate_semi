package com.stagemate.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.admin.service.AdminService;

@WebServlet("/admin/salesCancelServlet.do")
public class SalesCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalesCancelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//취소 버튼을 눌렀을 때.(js)  
		String rsvNo=request.getParameter("rsvNo");
		//담긴 정보 가져오기 (service
		int result=new AdminService().updateCancelByNo(rsvNo);
		if(result>0) {
		String msg = "성공적으로 취소 완료되었습니다.";
		String loc = "/admin/SalesDetail.do";
            request.setAttribute("msg", msg);
            request.setAttribute("loc", loc);
            request.setAttribute("rsvNo", result);
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
