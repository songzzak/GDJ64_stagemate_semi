package com.stagemate.detail.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagemate.admin.service.AdminService;
import com.stagemate.detail.model.service.PlayListService;
import com.stagemate.detail.model.service.StoreListService;
import com.stagemate.detail.model.vo.ResponseSearch;
import com.stagemate.detail.model.vo.Detail;
import com.stagemate.detail.model.vo.StoreDetail;
import com.stagemate.member.model.vo.Member;

import com.google.gson.Gson;

/**
 * Servlet implementation class PlayListSearchServlet
 */
@WebServlet("/StoreListSearchServlet")
public class StoreListSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_MEMBER = "loginMember";   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreListSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String day = request.getParameter("day");
		String yyyy = request.getParameter("yyyy");
		String mm = request.getParameter("mm");
		String status = request.getParameter("status");
		String order = request.getParameter("order");
		
		int cPage;
		int numPerpage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e){
			cPage = 1;
		}
		try {
			numPerpage = Integer.parseInt(request.getParameter("numPerpage"));
		} catch (NumberFormatException e){
			numPerpage = 10;
		}
		
		String userId = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute(LOGIN_MEMBER);
		if (obj != null) {
			Member member = (Member)obj;
			userId = member.getMemberId();
		}
		
		int totalCount = new StoreListService().selectStoreDetailCount(userId, day, yyyy, mm, status);
		List<StoreDetail> stores = new ArrayList<>();
		String pageBar="";
		if (totalCount > 0) {
			int totalPage=(int)Math.ceil((double)totalCount/numPerpage);
			int pageBarSize=5;
			int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
			int pageEnd=pageNo+pageBarSize-1;
			int startRow = cPage == 1 ? 1 : 1 + ((cPage-1) * numPerpage);
			int endRow = cPage == 1 ? numPerpage : ((cPage) * numPerpage);
			stores = new StoreListService().selectStoreDetailCondition(userId, day, yyyy, mm, status, startRow, endRow, order);
			
			String left_double_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/left_double_arrow.svg");
			String left_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/left_arrow.svg");
			String right_double_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/right_double_arrow.svg");
			String right_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/right_arrow.svg");
			if(pageNo==1) {
				pageBar+="<span>"+left_double_arrow+"</span>";
			}else {
				pageBar+="<a class='page-link' onclick=\"searchList('2', 1, 10)\">"+left_double_arrow+"</a>";
			}
			if(cPage==1) {
				pageBar+="<span>"+left_arrow+"</span>";
			}else {
				pageBar+="<a class='page-link' onclick=\"searchList('2', " + (cPage-1) + ", 10)\">"+left_arrow+"</a>";
			}
			pageBar+="<div>";
			while(!(pageNo>pageEnd||pageNo>totalPage)) {
				if(pageNo==cPage) {
					pageBar+="<span>"+pageNo+"</span>";
				}else {
					pageBar+="<a class='page-link' onclick=\"searchList('2', " + pageNo + ", 10)\">"+pageNo+"</a>";
				}
				pageNo++;
			}
			pageBar+="</div>";
			if(cPage==totalPage) {
				pageBar+="<span>"+right_arrow+"</span>";
			}else {
				pageBar+="<a class='page-link' onclick=\"searchList('2', " + (cPage+1) + ", 10)\">"+right_arrow+"</a>";
			}
			
			if(pageNo>totalPage) {
				pageBar+="<span>"+right_double_arrow+"</span>";
			}else {
				pageBar+="<a class='page-link' onclick=\"searchList('2', " + pageNo + ", 10)\">"+right_double_arrow+"</a>";
			}
		}
		
		ResponseSearch data = new ResponseSearch(totalCount, null, stores, pageBar);
		Gson gson = new Gson();
		String json = gson.toJson(data);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



