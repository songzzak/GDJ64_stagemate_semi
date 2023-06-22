package com.stagemate.deliveryAddress.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.deliveryAddress.service.DlvAddressService;

/**
 * Servlet implementation class DeleteDlvAddressServlet
 */
@WebServlet("/dlv/deleteDlvAddress.do")
public class DeleteDlvAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDlvAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dlvId=request.getParameter("no");
		int result=new DlvAddressService().deleteDlvAddress(dlvId);

	    if (result > 0) {
            request.setAttribute("message", "배송지가 삭제되었습니다.");  // 성공 메시지 설정
            request.setAttribute("result", "success");
        } else {
            request.setAttribute("message", "배송지 삭제에 실패하였습니다.");  // 실패 메시지 설정
            request.setAttribute("result", "fail");
        }
        request.getRequestDispatcher("/views/store/resultMsg.jsp").forward(request, response);  // 주소 목록 페이지로 포워딩
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
