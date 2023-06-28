package com.stagemate.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.admin.service.AdminService;
import com.stagemate.member.service.MemberService;


@WebServlet("/member/withdrawMember.do")
public class WithdrawMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WithdrawMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int result=new AdminService().outmember(id);
		String msg = "";
		String loc = "/";
		 if (result > 0) {
             // 성공
			 msg="탈퇴가 완료되었습니다. 그 동안 StageMate를 사랑해주셔서 감사합니다.";
         } else {
             // 실패
        	 msg="회원탈퇴에 실패하였습니다. 관리자에게 문의해주세요.";
         }
		 request.setAttribute("msg", msg);
		 request.setAttribute("loc", loc);
		 request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
