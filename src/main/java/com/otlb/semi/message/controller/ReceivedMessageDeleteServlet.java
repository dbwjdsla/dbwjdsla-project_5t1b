package com.otlb.semi.message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageDeleteServlet
 */
@WebServlet("/message/receivedMessageDelete")
public class ReceivedMessageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		System.out.println("no: " + no);
		
		request.getSession().setAttribute("msg", "페이지 넘어옴");
		response.sendRedirect(request.getContextPath() + "/message/messageList");
	}

}
