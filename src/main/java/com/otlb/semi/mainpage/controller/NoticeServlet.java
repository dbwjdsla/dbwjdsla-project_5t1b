package com.otlb.semi.mainpage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.mainpage.model.service.SelectService;
import com.otlb.semi.mainpage.model.vo.AnonymousBoard;
import com.otlb.semi.mainpage.model.vo.Board;
import com.otlb.semi.mainpage.model.vo.FoodMenu;
import com.otlb.semi.mainpage.model.vo.LikeContent;
import com.otlb.semi.mainpage.model.vo.Notice;

/**
 * Servlet implementation class Notice
 */

@WebServlet("/indexbyebye")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) 공지사항 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-------------servlet test ---------------");
		
		
		Notice notice = selectService.selectNoticeContent();
		System.out.println("notice Servlet" + notice);

		LikeContent likeContent = selectService.selectLikeContent();
		System.out.println("likeContent Servlet" + likeContent);

		FoodMenu foodMenu = selectService.selectFoodMenu();
		System.out.println("foodMenu Servlet" + foodMenu);

		Board board = selectService.selectBoardContent();
		System.out.println("board  Servlet" + board);

		AnonymousBoard anonymousBoard = selectService.selectAnonymousBoardContent();
		System.out.println("AnonymousBoard Servlet" + anonymousBoard);

		request.setAttribute("noticeSelvlet", notice);
		request.setAttribute("likeContent", likeContent);
		request.setAttribute("foodMenu", foodMenu);
		request.setAttribute("board", board);
		request.setAttribute("anonymousBoard", anonymousBoard);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}

}
