package com.stagemate.payment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.payment.model.vo.Payment;
import com.stagemate.payment.model.vo.PrdOrder;
import com.stagemate.payment.model.vo.PrdOrderDetail;
import com.stagemate.payment.service.PaymentService;

@WebServlet("/payment/storeOrderEnd.do")
public class StorePaymentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StorePaymentResultServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Payment객체 생성
		Payment p=Payment.builder()
				.paymentNo(request.getParameter("merchant_uid"))
				.paymentPrice(Integer.parseInt(request.getParameter("totalprice")))
				.build();
		int paymentResult=new PaymentService().insertPayment(p);
		
		//PrdOrder객체생성
		PrdOrder po=PrdOrder.builder()
				.dlvId(request.getParameter("dlvId"))
				.paymentNo(p.getPaymentNo())
				.memberId(request.getParameter("userId"))
				.shipMsg(request.getParameter("selectedOption"))
				.totalPrice(Integer.parseInt(request.getParameter("totalprice")))
				.build();
		
		PaymentService paymentService = new PaymentService();
		int prdOrderResult  = paymentService.insertPrdOrder(po);
		String orderNo = paymentService.selectOrderNo();
		System.out.println("prdOrderNo:"+orderNo);
		//PrdOrderDetail객체 생성
		String[] productNoList=request.getParameterValues("productNoList");
		List<Integer>pNoList=new ArrayList<>();
		for (String productNo : productNoList) {
		    Integer pNo = Integer.parseInt(productNo);
		    pNoList.add(pNo);
		};
		//System.out.println("pNoList:"+pNoList);
		String[] quantityList=request.getParameterValues("quantityList");
		List<Integer>qList=new ArrayList<>();
		for (String q : quantityList) {
		    Integer quantity = Integer.parseInt(q);
		    qList.add(quantity);
		};
		//System.out.println("qList:"+qList);
		List<PrdOrderDetail> podList = new ArrayList<>();
		int index = 0;
		for (Integer pNo : pNoList) {
		    Integer quantity = qList.get(index);
		    index++;
		    PrdOrderDetail pod = PrdOrderDetail.builder()
		            .orderNo(orderNo)
		            .productNo(pNo)
		            .orderAmt(quantity)
		            .build();
		    podList.add(pod);
		    int prdOrderDetailresult=new PaymentService().insertPrdOrderDetail(pod);
		}
		//System.out.println("podList:"+podList);
		//데이터 저장
		request.setAttribute("po", po);
		//완료페이지로 포워딩
		request.getRequestDispatcher("/views/store/store_order_complete.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}