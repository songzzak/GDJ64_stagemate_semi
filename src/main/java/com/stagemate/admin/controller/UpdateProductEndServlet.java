package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/admin/updateProductEnd.do")
public class UpdateProductEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateProductEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/upload/yoonjin");
        int maxSize = 1024 * 1024 * 100; // 100MB
        String encode = "UTF-8";
        DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
        MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, dfr);

        int productNo = Integer.parseInt(mr.getParameter("productNo"));
        //System.out.println(productNo);
        String productTitle = mr.getParameter("productTitle");
        String productNm = mr.getParameter("productNm");
        int productPrice = Integer.parseInt(mr.getParameter("productPrice"));
        int productAmt = Integer.parseInt(mr.getParameter("productAmt"));
        String productComment = mr.getParameter("productComment");
        StoreService storeService = new StoreService();
        Product product = storeService.selectProductByProductNo(productNo);
        //System.out.println(product);
        // 제품 정보 업데이트
        product.setProductTitle(productTitle);
        product.setProductNm(productNm);
        product.setProductPrice(productPrice);
        product.setProductAmt(productAmt);
        product.setProductComment(productComment);

        int updateResult = storeService.updateProduct(product);
       // System.out.println(updateResult);
        if (updateResult > 0) {
        	List<StoreUpfile> files=storeService.selectFileByProductNo(productNo);
        	//files.forEach(e->System.out.print(e));
        	StoreUpfile mainImg = null;
        	StoreUpfile detailImg = null;
        	for(StoreUpfile f:files) {
        		if(f.getIsMainImg()=='Y'){
        			mainImg=f;
        		}else {
        			detailImg=f;
        		}
        	}
        	System.out.println(mainImg);
        	System.out.println(detailImg);
            // 대표 이미지 업데이트
            String orifilenameMain = mr.getOriginalFileName("upFileMain");
            String refilenameMain = mr.getFilesystemName("upFileMain");
            mainImg.setImgFilenameOri(orifilenameMain);
            mainImg.setImgFileRename(refilenameMain);
            int fileUpdateResult1 = storeService.updateFileData(mainImg, productNo);

            // 상세 이미지 업데이트
            String orifilenameDetail = mr.getOriginalFileName("upFileDetail");
            String refilenameDetail = mr.getFilesystemName("upFileDetail");
            detailImg.setImgFilenameOri(orifilenameDetail);
            detailImg.setImgFileRename(refilenameDetail);
            int fileUpdateResult2 = storeService.updateFileData(detailImg, productNo);

            if (fileUpdateResult1 > 0 && fileUpdateResult2 > 0) {
                String msg = "성공적으로 수정이 완료되었습니다.";
                String loc = "/admin/selectAllProduct.do";
                request.setAttribute("msg", msg);
                request.setAttribute("loc", loc);
                request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
            } else {
                String msg = "수정에 실패하였습니다.";
                String loc = "/admin/updateProduct.do";
                request.setAttribute("msg", msg);
                request.setAttribute("loc", loc);
                request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
            }
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
