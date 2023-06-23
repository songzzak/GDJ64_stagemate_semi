package com.stagemate.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.service.StoreService;

/**
 * Servlet implementation class DeleteStoreLikeServlet
 */
@WebServlet("/store/deleteLike.do")
public class DeleteStoreLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStoreLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo=Integer.parseInt(request.getParameter("productNo"));
		String userId=request.getParameter("userId");

		int result=new StoreService().deleteStoreLike(productNo,userId);
		Product p=new StoreService().selectProductByProductNo(productNo);
		int likeCnt=p.getProductLikeCnt()-1;
		int result2=new StoreService().updateProductLikeCnt(productNo,likeCnt);
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(result,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
