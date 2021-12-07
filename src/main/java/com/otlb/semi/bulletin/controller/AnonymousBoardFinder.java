package com.otlb.semi.bulletin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.bulletin.model.service.BulletinService;
import com.otlb.semi.bulletin.model.vo.Board;

/**
 * Servlet implementation class AnonymousBoardFinder
 */
@WebServlet("/board/anonymousBoardFinder")
public class AnonymousBoardFinder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BulletinService bulletinService = new BulletinService();

	/**
	 * select * from board where title like ?
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		System.out.println("param@servlet = " + param);
		
		List<Board> list = bulletinService.searchAnonymousBoard(param);
		System.out.println("list : " + list);
		
		request.setAttribute("list", list);
		request
			.getRequestDispatcher("/WEB-INF/views/board/anonymousBoardList.jsp")
			.forward(request, response);
	}

}
