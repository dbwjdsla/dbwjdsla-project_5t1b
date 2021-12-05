package com.otlb.semi.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageFormServlet
 */
@WebServlet("/message/messageForm")
public class MessageFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _senderNo = request.getParameter("senderNo");
		//System.out.println("_empNo" + _senderNo);
		
		//empNo의 값이 넘어올때만
		if(_senderNo != null) {
			int senderNo = Integer.valueOf(_senderNo);
			request.setAttribute("senderNo", senderNo);
		}
		
		request
			.getRequestDispatcher("/WEB-INF/views/message/messageForm.jsp")
			.forward(request, response);
	}


}
