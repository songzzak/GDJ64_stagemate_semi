package com.stagemate.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.board.model.vo.Board;
import com.stagemate.board.service.BoardService;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/board/boardList")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				String type=request.getParameter("searchType");
				String keyword=request.getParameter("searchKeyword");
				
				int cPage,numPerpage;
				try {
					cPage=Integer.parseInt(request.getParameter("cPage"));
				}catch(NumberFormatException e) {
					cPage=1;
				}
				try {
					numPerpage=Integer.parseInt(request.getParameter("numPerpage"));
				}catch(NumberFormatException e) {
					numPerpage=3;
				}
				
				List<Board> boards=new BoardService()
						.selectBoardByKeyword(type,keyword,cPage,numPerpage);
				
				request.setAttribute("boards", boards);
				
				String pageBar="";
				int totalData=new BoardService()
						.selectBoardByKeywordCount(type,keyword);
				int totalPage=(int)Math.ceil((double)totalData/numPerpage);
				int pageBarSize=3;
				int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
				int pageEnd=pageNo+pageBarSize-1;
				
				if(pageNo==1) {
					pageBar+="<span>[이전]</span>";
				}else {
					pageBar+="<a href='"+request.getRequestURI()
					+"?searchType="+type
					+"&searchKeyword="+keyword
					+"&cPage="+(pageNo-1)
					+"&numPerpage="+numPerpage+"'>[이전]</a>";
				}
				
				while(!(pageNo>pageEnd||pageNo>totalPage)) {
					if(pageNo==cPage) {
						pageBar+="<span>"+pageNo+"</span>";
					}else {
						pageBar+="<a href='"+request.getRequestURI()
						+"?searchType="+type
						+"&searchKeyword="+keyword
						+"&cPage="+pageNo
						+"&numPerpage="+numPerpage+"'>"+pageNo+"</a>";
					}
					pageNo++;
				}
				if(pageNo>totalPage) {
					pageBar+="<span>[다음]</span>";
				}else {
					pageBar+="<a href='"+request.getRequestURI()
					+"?searchType="+type
					+"&searchKeyword="+keyword
					+"&cPage="+pageNo
					+"&numPerpage="+numPerpage+"'>[다음]</a>";
				}
				request.setAttribute("pageBar", pageBar);
				request.getRequestDispatcher("/views/board/boardList.jsp")
				.forward(request, response);
				
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
