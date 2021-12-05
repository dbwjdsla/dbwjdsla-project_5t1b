package com.otlb.semi.bulletin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.bulletin.model.service.BulletinService;
import com.otlb.semi.bulletin.model.vo.Board;
import com.otlb.semi.bulletin.model.vo.Bulletin;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/BoardUpdateServlet")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BulletinService bulletinService = new BulletinService();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		Board board = bulletinService.selectOneBoard(no);
		
		request.setAttribute("board", board);
		request
			.getRequestDispatcher("/WEB-INF/views/bulletin/bulletinUpdate.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			String category = request.getParameter("category");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			
			Board board = new Board();
			board.setNo(no);
			board.setCategory(category);
			board.setTitle(title);
			board.setContent(content);
			board.setEmpNo(empNo);

			int result = bulletinService.updateBoard(board);
			
			String msg = result > 0 ? "게시물 수정 성공" : "게시물 수정 실패";
			
			request.getSession().setAttribute("msg", msg);
			String location = request.getContextPath() + "/board/boardView?no=?" + board.getNo();
			response.sendRedirect(location);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
