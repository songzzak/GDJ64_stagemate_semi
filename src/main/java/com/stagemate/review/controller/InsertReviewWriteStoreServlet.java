package com.stagemate.review.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.stagemate.member.model.vo.Member;
import com.stagemate.review.service.ReviewService;
import com.google.gson.Gson;

/**
 * Servlet implementation class PlayDetailInfoServlet
 */
@WebServlet("/Review/InsertReviewWriteStoreServlet")
@MultipartConfig
public class InsertReviewWriteStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewWriteStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute("loginMember");
		if (obj != null) {
			Member member = (Member)obj;
			userId = member.getMemberId();
		}
		
		String orderNo = request.getParameter("orderNo");
        String content = request.getParameter("content");
        String emotion = request.getParameter("emotion");
        Part filePart = request.getPart("file");

        String path = getServletContext().getRealPath("/upload/yelin");
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        String fileName =  "";
        if (filePart != null) {
        	filePart.getSubmittedFileName();
        	String filePath = path + File.separator + fileName;
            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
		int result = new ReviewService().insertStoreReview(userId, orderNo, fileName, content, emotion);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



