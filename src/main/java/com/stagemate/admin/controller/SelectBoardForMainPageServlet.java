package com.stagemate.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.stagemate.board.model.vo.Board;
import com.stagemate.board.service.BoardService;

@WebServlet("/boardForMainPage.do")
public class SelectBoardForMainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectBoardForMainPageServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		List<Board> boards = new BoardService().selectBoardAll();
		List<Integer> randomNumbers = generateRandomNumbers(boards.size());
		
		JSONArray jsonArray = new JSONArray();
		randomNumbers.forEach(number -> {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("boardNo", boards.get(number).getBoardNo());
			jsonObject.put("boardTitle", boards.get(number).getBoardTitle());
			jsonObject.put("boardLikeCnt", boards.get(number).getBoardLikeCNT());
			jsonObject.put("boardViewCnt", boards.get(number).getBoardViewCNT());
			jsonArray.add(jsonObject);
		});
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	private List<Integer> generateRandomNumbers(int size) {
		Set<Integer> randomNumbers = new HashSet<>();
		while (randomNumbers.size() < 5) {
			randomNumbers.add((int) (Math.random() * size));
		}
		
		return new ArrayList<>(randomNumbers);
	}

}
