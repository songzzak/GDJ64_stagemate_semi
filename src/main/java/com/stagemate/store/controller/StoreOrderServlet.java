package com.stagemate.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.deliveryAddress.model.vo.DlvAdress;
import com.stagemate.deliveryAddress.service.DlvAddressService;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.model.vo.StoreUpfile;
import com.stagemate.store.service.StoreService;

@WebServlet("/store/storeOrder.do")
public class StoreOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StoreOrderServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//파라미터값받아오기
//    	System.out.println("no: " + request.getParameter("no"));
//    	System.out.println("count: " + request.getParameter("count"));
    	int pNo=Integer.parseInt(request.getParameter("no"));
    	int count=Integer.parseInt(request.getParameter("count"));
    	String memberId=request.getParameter("userId");
        // 주문 정보 설정
        Product p = new StoreService().selectProductByProductNo(pNo);
        List<StoreUpfile> files = new StoreService().selectFileByProductNo(pNo);
        StoreUpfile main = null;
        for (StoreUpfile f : files) {
            if (f.getIsMainImg() == 'Y') {
                main = f;
            } 
        }
        List<DlvAdress> dlvList = new DlvAddressService().selectDlvAddressById(memberId);
        DlvAdress defaultAddress = null;
        for (DlvAdress d : dlvList) {
            if (d.getIsDefaultDlv() == 'Y') {
            	defaultAddress = d;
            } 
        }
        
        // 필요한 정보를 request에 attribute로 설정
        request.setAttribute("p", p);
        request.setAttribute("main", main);
        request.setAttribute("count", count);
        request.setAttribute("defaultAddress", defaultAddress);
        request.getRequestDispatcher("/views/store/order_form.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
