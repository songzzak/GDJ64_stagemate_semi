package com.stagemate.deliveryAddress.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.deliveryAddress.model.vo.DlvAdress;
import com.stagemate.deliveryAddress.service.DlvAddressService;

/**
 * Servlet implementation class UpdateDlvAddressServlet
 */
@WebServlet("/dlv/updateDlvAddress.do")
public class UpdateDlvAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDlvAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dlvId=request.getParameter("no");
		DlvAdress d=new DlvAddressService().selectDlvAddressByDlvId(dlvId);
		String address=d.getDlvAddress();
		String[] addressParts = address.split("\\|");
		String addr1 = addressParts[0];
		String zipcode = addressParts[1];
		String addr2 = addressParts[2];
		request.setAttribute("d", d);
		request.setAttribute("addr1", addr1);
		request.setAttribute("zipcode", zipcode);
		request.setAttribute("addr2", addr2);
		request.getRequestDispatcher("/views/store/popupUpdateAddress.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
