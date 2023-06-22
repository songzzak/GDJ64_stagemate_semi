package com.stagemate.deliveryAddress.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.deliveryAddress.model.vo.DlvAdress;
import com.stagemate.deliveryAddress.service.DlvAddressService;


@WebServlet("/dlv/insertDlvAddress.do")
public class InsertDlvAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertDlvAddressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
	    String name = request.getParameter("name");
	    String title = request.getParameter("title");
	    String phone = request.getParameter("phone");
	    String address = String.format("%s|%s|%s", 
				request.getParameter("addr1"),
				request.getParameter("zipcode"),
				request.getParameter("addr2"));	
	    DlvAdress newAddress=DlvAdress.builder()
	    		.memberId(userId)
	    		.dlvPerson(name)
	    		.dlvNm(title)
	    		.dlvPhone(phone)
	    		.dlvAddress(address)
	    		.isDefaultDlv('N')
	    		.build();
	    int result=new DlvAddressService().insertDlvAddress(newAddress);

	    if (result > 0) {
            request.setAttribute("message", "배송지가 성공적으로 등록되었습니다.");  // 성공 메시지 설정
            request.setAttribute("result", "success");
        } else {
            request.setAttribute("message", "배송지 등록에 실패하였습니다.");  // 실패 메시지 설정
            request.setAttribute("result", "fail");
        }
        request.getRequestDispatcher("/views/store/resultMsg.jsp").forward(request, response);  // 주소 목록 페이지로 포워딩
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
