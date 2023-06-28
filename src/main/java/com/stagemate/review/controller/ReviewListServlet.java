package com.stagemate.review.controller;

import static com.stagemate.common.JDBCTemplate.getConnection; //새로 추가해줘야 하는 임포트. 

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagemate.detail.model.service.PlayListService;
import com.stagemate.detail.model.service.StoreListService;
import com.stagemate.detail.model.vo.Detail;
import com.stagemate.detail.model.vo.StoreDetail;
import com.stagemate.member.model.vo.Member;
import com.stagemate.review.model.vo.ReviewPlay;
import com.stagemate.review.model.vo.ReviewStore;
import com.stagemate.review.service.ReviewService;
import com.stagemate.review.model.vo.EventReview;


@WebServlet("/Review/ReviewListServlet.do")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_MEMBER = "loginMember"; 
       
 
    public ReviewListServlet() {
        super();

    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage = 1;
		int numPerpage = 10;
		String userId = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute(LOGIN_MEMBER);
		if (obj != null) {
			Member member = (Member)obj;
			userId = member.getMemberId();
		}
		
		List<ReviewPlay> reviewPlay = new ReviewService().selectPlayReviewCondition(userId, 1, 10);
		request.setAttribute("ReviewPlay", reviewPlay);
		List<ReviewStore> reviewStore  = new ReviewService().selectStoreReviewCondition(userId, 1, 10);
		request.setAttribute("ReviewStore", reviewStore );
		
		int totalCount = new ReviewService().selectPlayReviewCount(userId);
		request.setAttribute("TotalCount", totalCount );
		String pageBar="";
		if (totalCount > 0) {
			int totalPage=(int)Math.ceil((double)totalCount/numPerpage);
			int pageBarSize=5;
			int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
			int pageEnd=pageNo+pageBarSize-1;
			String left_double_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/left_double_arrow.svg");
			String left_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/left_arrow.svg");
			String right_double_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/right_double_arrow.svg");
			String right_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/right_arrow.svg");
			if(pageNo==1) {
				pageBar+="<span>"+left_double_arrow+"</span>";
			}else {
				pageBar+="<a class='page-link' onclick=\"searchList('1', 1, 10)\">"+left_double_arrow+"</a>";
			}
			if(cPage==1) {
				pageBar+="<span>"+left_arrow+"</span>";
			}else {
				pageBar+="<a class='page-link' onclick=\"searchList('1', " + (cPage-1) + "1, 10)\">"+left_arrow+"</a>";
			}
			pageBar+="<div>";
			while(!(pageNo>pageEnd||pageNo>totalPage)) {
				if(pageNo==cPage) {
					pageBar+="<span>"+pageNo+"</span>";
				}else {
					pageBar+="<a class='page-link' onclick=\"searchList('1', " + pageNo + "1, 10)\">"+pageNo+"</a>";
				}
				pageNo++;
			}
			pageBar+="</div>";
			if(cPage==totalPage) {
				pageBar+="<span>"+right_arrow+"</span>";
			}else {
				pageBar+="<a class='page-link' onclick=\"searchList('1', " + (cPage+1) + "1, 10)\">"+right_arrow+"</a>";
			}
			
			if(pageNo>totalPage) {
				pageBar+="<span>"+right_double_arrow+"</span>";
			}else {
				pageBar+="<a class='page-link' onclick=\"searchList('1', " + pageNo + "1, 10)\">"+right_double_arrow+"</a>";
			}
		}
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/views/review/ReviewList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	

	private EventReview getReviewList(ResultSet rs) throws SQLException{
		return EventReview.builder()
				.eventName(rs.getString("EVENT_NAME"))
				.rpNo(rs.getInt("RP_NO"))
				.rpContent(rs.getString("RP_CONTENT"))
				.rpDate(rs.getDate("RP_DATE"))
				.rsvNo(rs.getString("RSV_NO"))
				.imojiCd(rs.getInt("IMOJI_CD"))
				.memberId(rs.getString("MEMBER_ID"))
				.watchDt(rs.getDate("WATCH_DT"))
				.build(); 
				
	}
}
