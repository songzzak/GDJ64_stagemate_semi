package com.stagemate.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagemate.member.model.vo.Member;
import com.stagemate.review.model.vo.PlaySearch;
import com.stagemate.review.model.vo.ReviewPlay;
import com.stagemate.review.model.vo.ReviewStore;
import com.stagemate.review.model.vo.StoreSearch;
import com.stagemate.review.service.ReviewService;


@WebServlet("/Review/ReviewWritePlay_Title")
public class ReviewWritePlayTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewWritePlayTitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String userId = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute("loginMember");
		if (obj != null) {
			Member member = (Member)obj;
			userId = member.getMemberId();
		}
		
		List<PlaySearch> playSearch = new ArrayList<>(); 
		List<StoreSearch> storeSearch = new ArrayList<>();
		if (type.equals("1")) {
			playSearch = new ReviewService().selectPlaySearch(userId);
		} else {
			storeSearch = new ReviewService().selectStoreSearch(userId);
		}	
		request.setAttribute("PlaySearch", playSearch);
		request.setAttribute("StoreSearch", storeSearch );
		
		request.getRequestDispatcher("/views/review/ReviewWritePlay_Title.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
