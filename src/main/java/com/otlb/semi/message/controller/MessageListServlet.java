package com.otlb.semi.message.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.otlb.semi.emp.model.vo.Emp;
import com.otlb.semi.message.model.service.MessageService;
import com.otlb.semi.message.model.vo.Message;

/**
 * Servlet implementation class MessageList
 */
@WebServlet("/message/messageList")
public class MessageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("loginEmp"));
		Emp emp = (Emp) session.getAttribute("loginEmp");
		
		int empNo = emp.getEmpNo();
		List<Message> list = messageService.selectAllReceivedMessage(empNo);
		System.out.println("[MessageListServlet] list = " + list);
		
//		System.out.println(list.get(0).getSentDate().getTime());
		
		request.setAttribute("list", list);
		request
			.getRequestDispatcher("/WEB-INF/views/message/messageList.jsp")
			.forward(request, response);
	}

}
