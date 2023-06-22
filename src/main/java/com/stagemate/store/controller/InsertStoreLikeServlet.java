package com.stagemate.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.store.model.vo.StoreLike;
import com.stagemate.store.service.StoreService;

/**
 * Servlet implementation class InsertStoreLikeServlet
 */
@WebServlet("/store/insertLike.do")
public class InsertStoreLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStoreLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo=Integer.parseInt(request.getParameter("productNo"));
		String userId=request.getParameter("userId");
		StoreLike sl=StoreLike.builder()
				.strLikeCd(userId+"_"+productNo)
				.memberId(userId)
				.productNo(productNo)
				.build();

		int result=new StoreService().insertStoreLike(sl);
		if(result>0)request.getRequestDispatcher("/views/store/productList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
