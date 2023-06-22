package com.stagemate.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class NoticeInsertEndServlet
 */
@WebServlet("/notice/InsertNotice.do")
public class NoticeInsertEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//파일 업로드 처리하기 ->cos.jar 라이브러리가 제공하는 클래스를 이용한다.
	//1. mutipart/form-data 형식의 요청인지 확인 
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "잘못된 접근입니다. 관리자에게 문의하세요!");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
			return;
		}
		
		//2.데이터 업로드 처리하기 
		String path= getServletContext().getRealPath("/upload/nabin");
		System.out.print(path);
		//최대 파일 크기 
		int maxSize =1024*1024*10;
		String encode="UTF-8";
		//리네임 클래스 생성 
		DefaultFileRenamePolicy dfr= new DefaultFileRenamePolicy();
		
		//MutipartRequest 클래스 샹성하기 
		MultipartRequest mr= new MultipartRequest (request,path,maxSize,encode,dfr);
		
		 
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
