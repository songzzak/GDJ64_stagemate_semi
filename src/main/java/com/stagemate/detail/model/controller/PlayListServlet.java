package com.stagemate.detail.model.controller;

import java.io.IOException;
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
import com.stagemate.detail.model.vo.Detail;
import com.stagemate.detail.model.vo.StoreDetail;
import com.stagemate.member.model.vo.Member;

@WebServlet("/Detail/DetailListServlet.do")
public class PlayListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final String LOGIN_MEMBER = "loginMember";    

    public PlayListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
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
      
      List<Detail> detail = new PlayListService().selectPlayDetailCondition(userId, "1", "", "", "전체", 1, 10);
      request.setAttribute("DetailList", detail);
      List<StoreDetail> stores  = new StoreListService().selectStoreDetailCondition(userId, "1", "", "", "결제", 1, 10, "DESC");
      request.setAttribute("StoreList", stores );
      
      int totalCount = new PlayListService().selectPlayDetailCount(userId, "1", "", "", "1");
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
      
      request.getRequestDispatcher("/views/detail/detailList.jsp").forward(request, response);  
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}