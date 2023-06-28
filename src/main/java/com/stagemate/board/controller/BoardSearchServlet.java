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
@WebServlet("/board/searchBoard.do")
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
				System.out.println(type);
				System.out.println(keyword);
				int cPage,numPerpage;
				try {
					cPage=Integer.parseInt(request.getParameter("cPage"));
				}catch(NumberFormatException e) {
					cPage=1;
				}
				try {
					numPerpage=Integer.parseInt(request.getParameter("numPerpage"));
				}catch(NumberFormatException e) {
					numPerpage=10;
				}
				
				List<Board> boards=new BoardService()
						.selectBoardByKeyword(type,keyword,cPage,numPerpage);
				System.out.println(boards);
				request.setAttribute("board", boards);
				
				String pageBar="";
				int totalData=new BoardService()
						.selectBoardByKeywordCount(type,keyword);
				int totalPage=(int)Math.ceil((double)totalData/numPerpage);
				int pageBarSize=3;
				int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
				int pageEnd=pageNo+pageBarSize-1;
				
				String pageBar1 = "";
				String left_double_arrow = String.format("<img src='%s'>",
						request.getContextPath() + "/images/joonho/left_double_arrow.svg");
				String left_arrow = String.format("<img src='%s'>", request.getContextPath() + "/images/joonho/left_arrow.svg");
				String right_double_arrow = String.format("<img src='%s'>",
						request.getContextPath() + "/images/joonho/right_double_arrow.svg");
				String right_arrow = String.format("<img src='%s'>",
						request.getContextPath() + "/images/joonho/right_arrow.svg");
				if (pageNo == 1) {
					pageBar1 += "<span>" + left_double_arrow + "</span>";
				} else {
					pageBar1 += "<a href='" + request.getRequestURI() + "?cPage=" + (pageNo - 1) + "'>" + left_double_arrow
							+ "</a>";
				}
				if (cPage == 1) {
					pageBar1 += "<span>" + left_arrow + "</span>";
				} else {
					pageBar1 += "<a href='" + request.getRequestURI() + "?cPage=" + (cPage - 1) + "'>" + left_arrow + "</a>";
				}
				pageBar1 += "<div>";
				while (!(pageNo > pageEnd || pageNo > totalPage)) {
					if (pageNo == cPage) {
						pageBar1 += "<span>" + pageNo + "</span>";
					} else {
						pageBar1 += "<a href='" + request.getRequestURI() + "?cPage=" + pageNo + "'>" + pageNo + "</a>";
					}
					pageNo++;
				}
				pageBar1 += "</div>";
				if (cPage == totalPage) {
					pageBar1 += "<span>" + right_arrow + "</span>";
				} else {
					pageBar1 += "<a href='" + request.getRequestURI() + "?cPage=" + (cPage + 1) + "'>" + right_arrow + "</a>";
				}

				if (pageNo > totalPage) {
					pageBar1 += "<span>" + right_double_arrow + "</span>";
				} else {
					pageBar1 += "<a href='" + request.getRequestURI() + "?cPage=" + pageNo + "'>" + right_double_arrow + "</a>";
				}
				request.setAttribute("pageBar", pageBar1);
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
