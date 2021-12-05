package com.otlb.semi.bulletin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.bulletin.model.service.BulletinService;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BulletinService bulletinService = new BulletinService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt((String) request.getAttribute("no"));
		int result = bulletinService.deleteBoard(no);
		
		String msg = result > 0 ? "게시물 삭제 성공" : "게시물 삭제 실패";
		
		request.getSession().setAttribute("msg", msg);
		String location = request.getContextPath() + "/";
		response.sendRedirect(location);
	}

}