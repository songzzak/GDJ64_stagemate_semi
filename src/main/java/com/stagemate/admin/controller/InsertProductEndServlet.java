package com.stagemate.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.model.vo.StoreUpfile;
import com.stagemate.store.service.StoreService;


@WebServlet("/admin/insertProductEnd.do")
public class InsertProductEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertProductEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // MultipartRequest 객체를 사용하여 파일 업로드 처리
	    String path = getServletContext().getRealPath("/upload/yoonjin");
	    int maxSize = 1024 * 1024 * 100; // 100MB
	    String encode = "UTF-8";
	    DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
	    MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, dfr);

	    // 제품 정보 저장
	    String productTitle = mr.getParameter("productTitle");
	    String productNm = mr.getParameter("productNm");
	    int productPrice = Integer.parseInt(mr.getParameter("productPrice"));
	    int productAmt = Integer.parseInt(mr.getParameter("productAmt"));
	    String productComment = mr.getParameter("productComment");
	    Product product = Product.builder()
	            .productTitle(productTitle)
	            .productNm(productNm)
	            .productPrice(productPrice)
	            .productAmt(productAmt)
	            .productComment(productComment)
	            .build();
	    int productInsertResult = new StoreService().insertProduct(product);

	    // 파일 정보 저장
	    String orifilenameMain = mr.getOriginalFileName("upFileMain");
	    String refilenameMain = mr.getFilesystemName("upFileMain");
	    String orifilenameDetail = mr.getOriginalFileName("upFileDetail");
	    String refilenameDetail = mr.getFilesystemName("upFileDetail");
	    StoreUpfile mainImg = StoreUpfile.builder()
	    		.imgFilenameOri(orifilenameMain)
	    		.imgFileRename(refilenameMain)
	    		.isMainImg('Y')
	    		.build();
	    StoreUpfile DetailImg = StoreUpfile.builder()
	    		.imgFilenameOri(orifilenameDetail)
	    		.imgFileRename(refilenameDetail)
	    		.isMainImg('N')
	    		.build();
	    int fileInsertResult1 = new StoreService().insertFileData(mainImg, product);
	    int fileInsertResult2 = new StoreService().insertFileData(DetailImg, product);

	    if (productInsertResult > 0 && fileInsertResult1 > 0 && fileInsertResult2 > 0) {
	        // 성공적으로 삽입된 경우
	        String msg = "새 상품 등록 완료!";
	        String loc = "/admin/selectAllProduct.do";
	        request.setAttribute("msg", msg);
	        request.setAttribute("loc", loc);
	        request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	    } else {
	        // 삽입 실패
	        String msg = "새 상품 등록 실패";
	        String loc = "/admin/insertProduct.do";
	        request.setAttribute("msg", msg);
	        request.setAttribute("loc", loc);
	        request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);   
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
