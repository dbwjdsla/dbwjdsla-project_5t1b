package com.otlb.semi.bulletin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.bulletin.model.service.BulletinService;
import com.otlb.semi.mainpage.controller.BoardServlet;

/**
 * Servlet implementation class BoardLikeCountServlet
 */
@WebServlet("/board/boardLikeCount")
public class BoardLikeCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BulletinService bulletinService = new BulletinService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.valueOf(request.getParameter("no"));
		String board = request.getParameter("board");
		System.out.println(board);
		int result = 0;
		//일반게시판 좋아요 요청이면
		if(board.equals("board")) {
			result = bulletinService.updateBoardLikeCount(no);
			
			String msg = result > 0 ? "추천하셨습니다!" : "추천에 오류가 있습니다...";
			
			request.getSession().setAttribute("msg", msg);
			
			String location = request.getContextPath() + "/board/boardView?no=" + no;
			response.sendRedirect(location);
		}else if(board.equals("anonyBoard")) {
			result = bulletinService.updateAnonyBoardLikeCount(no);

			String msg = result > 0 ? "추천하셨습니다!" : "추천에 오류가 있습니다...";
			
			request.getSession().setAttribute("msg", msg);
			
			String location = request.getContextPath() + "/board/anonymousBoardView?no=" + no;
			response.sendRedirect(location);
		}
		
		
	}
	
}
