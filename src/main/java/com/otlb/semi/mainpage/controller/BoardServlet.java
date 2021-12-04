package com.otlb.semi.mainpage.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.mainpage.model.service.SelectService;
import com.otlb.semi.mainpage.model.vo.Board;



/**
 * Servlet implementation class Board
 */
@WebServlet("/mainpage/Board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();
//	List<Board> board = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) 자유게시판 글 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Board board = selectService.selectBoardContent();
		System.out.println("boar =" + board);

		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
