package com.stagemate.store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stagemate.store.model.vo.Cart;
import com.stagemate.store.service.StoreService;

/**
 * Servlet implementation class InsertCartServlet
 */
@WebServlet("/store/insertCart.do")
public class InsertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		int productNo=Integer.parseInt(request.getParameter("productNo"));
		int amt=Integer.parseInt(request.getParameter("count"));
		Cart c=Cart.builder()
				.cartCd(userId+"_"+productNo)
				.memberId(userId)
				.productNo(productNo)
				.cartAmt(amt)
				.build();
		int result=new StoreService().insertCart(c);
		System.out.println("결과"+result);
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
