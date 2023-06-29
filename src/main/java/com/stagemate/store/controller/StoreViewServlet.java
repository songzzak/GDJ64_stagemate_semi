package com.stagemate.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.review.model.vo.Imoji;
import com.stagemate.review.model.vo.StoreReview;
import com.stagemate.review.service.ReviewService;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.model.vo.Review;
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
		List<Review> reviews=new StoreService().selectStoreReviewByNo(pNo);
		//System.out.println("리뷰리스트"+reviews);
		List<Imoji> imojiList=new StoreService().selectImojiAll();
		//System.out.println("이모지리스트"+imojiList);
		request.setAttribute("imojiList", imojiList);
		request.setAttribute("reviews", reviews);
		request.setAttribute("p", p);
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/views/store/productView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
