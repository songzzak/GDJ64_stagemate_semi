package com.stagemate.deliveryAddress.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.deliveryAddress.model.vo.DlvAdress;
import com.stagemate.deliveryAddress.service.DlvAddressService;


@WebServlet("/dlv/selectDlvAddress.do")
public class SelectDlvAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectDlvAddressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		List<DlvAdress> dlvList = new DlvAddressService().selectDlvAddressById(userId);
        request.setAttribute("userId", userId);
		request.setAttribute("dlvList", dlvList);
		request.getRequestDispatcher("/views/store/popUpAddressSelect.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
