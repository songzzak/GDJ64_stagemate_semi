package com.stagemate.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.store.model.vo.Cart;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.service.StoreService;

/**
 * Servlet implementation class SelectCartLisServlet
 */
@WebServlet("/store/selectCartList.do")
public class SelectCartLisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCartLisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		List<Cart> carts=new StoreService().selectCartByUserId(id);
		//System.out.println(carts);
		List<Product> products=new ArrayList<>();
		for(Cart c : carts) {
			Product p=new StoreService().selectProductByProductNo(c.getProductNo());
			products.add(p);
		}
		//System.out.println(products);
		request.setAttribute("carts", carts);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/views/mypage/shoppingBasket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
