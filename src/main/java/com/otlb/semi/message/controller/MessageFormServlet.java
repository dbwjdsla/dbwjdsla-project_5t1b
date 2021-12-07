package com.otlb.semi.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.emp.model.vo.Emp;
import com.otlb.semi.message.model.service.MessageService;

/**
 * Servlet implementation class MessageFormServlet
 */
@WebServlet("/message/messageForm")
public class MessageFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _senderNo = request.getParameter("senderNo");
		System.out.println(_senderNo);
		//System.out.println("_empNo" + _senderNo);
		String sender = null;
		if(_senderNo != null) {
			Emp emp = messageService.selectOneMember(Integer.valueOf(_senderNo));
			sender = emp.getEmpNo() + "-" + emp.getEmpName();
			
		}
		System.out.println(sender);
		request.setAttribute("sender", sender);
		
		request
			.getRequestDispatcher("/WEB-INF/views/message/messageForm.jsp")
			.forward(request, response);
	}


}
