package com.stagemate.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.store.service.StoreService;

@WebServlet("/admin/deleteProduct.do")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pNo=Integer.parseInt(request.getParameter("no"));
		
		int result=new StoreService().deleteProductByNo(pNo);
		
		String msg = "성공적으로 삭제 완료되었습니다.";
		String loc = "/admin/selectAllProduct.do";
		if (result> 0) {
            request.setAttribute("msg", msg);
            request.setAttribute("loc", loc);
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
        } else {
            msg = "삭제에 실패하였습니다. 개발자에게 문의해주세요.	";
            request.setAttribute("msg", msg);
            request.setAttribute("loc", loc);
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
