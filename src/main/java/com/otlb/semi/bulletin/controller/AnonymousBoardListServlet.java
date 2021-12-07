package com.otlb.semi.bulletin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.bulletin.model.service.BulletinService;
import com.otlb.semi.bulletin.model.vo.Board;

/**
 * Servlet implementation class AnonymousBoardList
 */
@WebServlet("/anonymousBoard/anonymousBoardList")
public class AnonymousBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BulletinService bulletinService = new BulletinService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Board> list = bulletinService.selectAllAnonymousBoard();
		
		request.setAttribute("list", list);
		request
			.getRequestDispatcher("/WEB-INF/views/anonymousBoard/anonymousBoardList.jsp")
			.forward(request, response);
	}

}