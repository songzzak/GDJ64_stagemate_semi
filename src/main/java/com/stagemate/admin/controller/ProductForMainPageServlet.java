package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.stagemate.store.model.vo.Product;
import com.stagemate.store.service.StoreService;

@WebServlet("/productForMainPage.do")
public class ProductForMainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductForMainPageServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		Map<Product, String> products = new StoreService().selectProductAndFile();
		
		JSONArray jsonArray = new JSONArray();
		for (Map.Entry<Product, String> product : products.entrySet()) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("productNo", product.getKey().getProductNo());
			jsonObject.put("productTitle", product.getKey().getProductTitle());
			jsonObject.put("productNm", product.getKey().getProductNm());
			jsonObject.put("productPrice", product.getKey().getProductPrice());
			jsonObject.put("euRename", product.getValue());
			jsonArray.add(jsonObject);
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
