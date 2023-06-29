package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.admin.model.vo.PlayInfo;
import com.stagemate.admin.service.AdminService;


@WebServlet("/admin/SalesDetail.do")
public class SalesDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_MEMBER = "loginMember";    
       
  
    public SalesDetailServlet() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int cPage;
		int numPerpage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e){
			cPage=1;
		}
		try {
			numPerpage=Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e){
			numPerpage=10;
		}
		
		List<PlayInfo> p=new AdminService().listPlayInfo(cPage, numPerpage);
		request.setAttribute("playinfo", p);
		int totalData=new AdminService().selectSalesCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";
		String left_double_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/left_double_arrow.svg");
		String left_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/left_arrow.svg");
		String right_double_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/right_double_arrow.svg");
		String right_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/right_arrow.svg");
		if(pageNo==1) {
			pageBar+="<span>"+left_double_arrow+"</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURI()+"?cPage="+(pageNo-1)+"'>"+left_double_arrow+"</a>";
		}
		if(cPage==1) {
			pageBar+="<span>"+left_arrow+"</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURI()+"?cPage="+(cPage-1)+"'>"+left_arrow+"</a>";
		}
		pageBar+="<div>";
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getRequestURI()+"?cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		pageBar+="</div>";
		if(cPage==totalPage) {
			pageBar+="<span>"+right_arrow+"</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURI()+"?cPage="+(cPage+1)+"'>"+right_arrow+"</a>";
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>"+right_double_arrow+"</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURI()+"?cPage="+pageNo+"'>"+right_double_arrow+"</a>";
		}
		request.setAttribute("pageBar",pageBar);
		//출력할 화면 이동
		request.getRequestDispatcher("/views/admin/admin_salesDetail.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
