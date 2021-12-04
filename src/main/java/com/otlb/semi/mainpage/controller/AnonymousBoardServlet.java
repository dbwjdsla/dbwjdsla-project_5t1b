package com.otlb.semi.mainpage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.mainpage.model.service.SelectService;
import com.otlb.semi.mainpage.model.vo.AnonymousBoard;





/**
 * Servlet implementation class Anonymous_board
 */
@WebServlet("/mainpage/AnonymousBoard")
public class AnonymousBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 익명게시판 조회
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnonymousBoard anonymousBoard = selectService.selectAnonymousBoardContent();
		
		request.setAttribute("anonymousBoard", anonymousBoard);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
