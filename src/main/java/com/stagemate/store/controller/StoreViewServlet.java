package com.stagemate.store.controller;

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


@WebServlet("/store/storeView.do")
public class StoreViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StoreViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pNo=Integer.parseInt(request.getParameter("no"));
		Product p=new StoreService().selectProductByProductNo(pNo);
		List<StoreUpfile> fileList=new StoreService().selectFileByProductNo(pNo);
		request.setAttribute("p", p);
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/views/store/productView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
