package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.store.model.vo.Product;
import com.stagemate.store.model.vo.StoreUpfile;
import com.stagemate.store.service.StoreService;

@WebServlet("/admin/updateProduct.do")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pNo=Integer.parseInt(request.getParameter("no"));
		Product p=new StoreService().selectProductByProductNo(pNo);
		List<StoreUpfile> fileList=new StoreService().selectFileByProductNo(pNo);
		request.setAttribute("p", p);
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/views/admin/admin_updateProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
