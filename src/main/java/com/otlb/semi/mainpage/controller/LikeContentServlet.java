//package com.otlb.semi.mainpage.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.otlb.semi.mainpage.model.service.SelectService;
//import com.otlb.semi.mainpage.model.vo.LikeContent;
//
//
///**
// * Servlet implementation class LikeContent
// */
//@WebServlet("/5t1b")
//public class LikeContentServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	SelectService selectService = new SelectService();
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 * 인기 게시글 조회 
//	 *
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		LikeContent likeContent = selectService.selectLikeContent();
//		
//		request.setAttribute("likeContent", likeContent);
//		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//	}
//
//}
