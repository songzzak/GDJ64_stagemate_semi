package com.stagemate.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagemate.member.model.vo.Member;
import com.stagemate.review.model.vo.StoreReview;
import com.stagemate.review.service.ReviewService;

/**
 * Servlet implementation class StoreReviewListServlet
 */
@WebServlet("/review/storeReviewlist.do")
public class StoreReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int cPage;
        try {
            cPage = Integer.parseInt(request.getParameter("cPage"));
        } catch (NumberFormatException e) {
            cPage = 1;
        }
        int numPerPage;
        try {
            numPerPage = Integer.parseInt(request.getParameter("numPerpage"));
        } catch (NumberFormatException e) {
            numPerPage = 6;
        }
        HttpSession session=request.getSession();
        Member loginMember=(Member)session.getAttribute("loginMember");
        
        List<StoreReview> list=new ReviewService().selectStoreReviewList(cPage,numPerPage,
        		loginMember.getMemberId());
        
        request.setAttribute("storeReview", list);
        
        int totalData = new ReviewService().selectStoreReviewCount(loginMember.getMemberId());
        int totalPage = (int) Math.ceil((double) totalData / numPerPage);
        int pageBarSize = 3;
        int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
        int pageEnd = pageNo + pageBarSize - 1;

        String contextPath = request.getContextPath();
        String pageBar = "";
        // 맨처음 페이지표시
        if (pageNo == 1) {
            pageBar += "<span><img src='" + contextPath + "/images/yoonjin/button/double-arrow-left.svg' alt='arrow-left'></span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + 1 +"'><img src='" + contextPath + "/images/yoonjin/button/double-arrow-left.svg' alt='arrow-left'></a>";
        }
        // 이전표시
        if (pageNo == 1) {
            pageBar += "<span><img src='" + contextPath + "/images/yoonjin/button/arrow-left.svg' alt='arrow-left'></span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + (pageNo - 1)
                    + "'><img src='" + contextPath + "/images/yoonjin/button/arrow-left.svg' alt='arrow-left'></a>";
        }
        // 선택할 페이지 번호 출력
        while (!(pageNo > pageEnd || pageNo > totalPage)) {
            if (pageNo == cPage) {
                pageBar += "<span>" + pageNo + "</span>";
            } else {
                pageBar += "<a class='bar-num' href='" + request.getRequestURI() + "?cPage=" + pageNo 
                        + "'>" + pageNo + "</a>";
            }
            pageNo++;
        }
        // 다음표시
        if (pageNo > totalPage) {
            pageBar += "<span><img src='" + contextPath + "/images/yoonjin/button/arrow-right.svg' alt='arrow-right'></span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + (pageNo + 1)
                    + "'><img src='" + contextPath + "/images/yoonjin/button/arrow-right.svg' alt='arrow-right'></a>";
        }
        // 마지막 페이지표시
        if (pageNo > totalPage) {
            pageBar += "<span><img src='" + contextPath + "/images/yoonjin/button/double-arrow-right.svg' alt='arrow-right'></span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + totalPage
                    + "'><img src='" + contextPath + "/images/yoonjin/button/double-arrow-right.svg' alt='arrow-right'></a>";
        }

        request.setAttribute("pageBar", pageBar);
		
        request.getRequestDispatcher("/views/review/ReviewList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
