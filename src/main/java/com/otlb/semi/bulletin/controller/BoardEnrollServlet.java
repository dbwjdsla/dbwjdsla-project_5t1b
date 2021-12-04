package com.otlb.semi.bulletin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.bulletin.model.service.BulletinService;
import com.otlb.semi.bulletin.model.vo.Board;

/**
 * Servlet implementation class BoardEnrollServlet
 */
@WebServlet("/board/boardEnroll")
public class BoardEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BulletinService bulletinService = new BulletinService();

	/**
	 * insert into board(no, category, title, content) values(?, ?, ?, ?)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값 처리
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		
		Board board = new Board();
		board.setCategory(category);
		board.setTitle(title);
		board.setContent(content);
		board.setEmpNo(empNo);
		
		// 2. 업무로직
		int result = bulletinService.insertBoard(board);
		String msg = result > 0 ? "게시물 등록 성공" : "게시물 등록 실패";
		
		// 3. 응답요청
		request.getSession().setAttribute("msg", msg);
		String location = request.getContextPath() + "/board/boardForm";
		response.sendRedirect(location);
	}

}
