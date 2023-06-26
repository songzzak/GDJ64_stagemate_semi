package com.stagemate.store.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 
    	// 파라미터값 받아오기
        String[] productNos = request.getParameterValues("cart-checkbox");
        String[] quantities = request.getParameterValues("numBox");
        String memberId = request.getParameter("userId");
        //System.out.println("아이디:"+memberId);
        // 주문 정보 설정
        List<Product> productList = new ArrayList<>();
        List<Integer> quantityList=new ArrayList<>();
        for (int i = 0; i < productNos.length; i++) {
            int pNo = Integer.parseInt(productNos[i]);
            int count = Integer.parseInt(quantities[i]);
            Product p = new StoreService().selectProductByProductNo(pNo);
            int q=count;
            productList.add(p);
            quantityList.add(q);
        }
        
     // 기타 정보 설정
        List<StoreUpfile> filelist = new ArrayList<>();
        List<DlvAdress> dlvList = new DlvAddressService().selectDlvAddressById(memberId);
       // System.out.println("배송지리스트:"+dlvList);
        DlvAdress defaultAddress = null;

        for (Product p : productList) {
        	//첨부파일
            int pNo = p.getProductNo();
            List<StoreUpfile> files = new StoreService().selectFileByProductNo(pNo);
            filelist.addAll(files);
            //기본배송지
            for (DlvAdress d : dlvList) {
                if (d.getIsDefaultDlv() == 'Y') {
                    defaultAddress = d;
                    //System.out.println(defaultAddress);
                    break;
                }
            }
        }

        // 필요한 정보를 request에 attribute로 설정
        request.setAttribute("productList", productList);
        request.setAttribute("quantityList", quantityList);
        request.setAttribute("filelist", filelist);
        request.setAttribute("defaultAddress", defaultAddress);
        request.getRequestDispatcher("/views/store/order_form.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
