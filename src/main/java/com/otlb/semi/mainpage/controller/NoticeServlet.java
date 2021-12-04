package com.otlb.semi.mainpage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.mainpage.model.service.SelectService;
import com.otlb.semi.mainpage.model.vo.Notice;


/**
 * Servlet implementation class Notice
 */
//@WebServlet("/mainpage/Notice")
@WebServlet("/5t1b/")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) 공지사항 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet test");
		Notice notice = selectService.selectNoticeContent();
		System.out.println(notice);

		request.setAttribute("notice", notice);

	}

}
