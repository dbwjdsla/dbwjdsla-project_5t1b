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
 * Servlet implementation class SentMessageListServlet
 */
@WebServlet("/message/sentMessageList")
public class SentMessageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
//		System.out.println(session.getAttribute("loginEmp"));
		Emp emp = (Emp) session.getAttribute("loginEmp");
		
		int no = emp.getNo();
		List<Message> list = messageService.selectAllSentMessage(no);
		System.out.println("[MessageListServlet] list = " + list);
		
		request.setAttribute("list", list);
		request
			.getRequestDispatcher("/WEB-INF/views/message/sentMessageList.jsp")
			.forward(request, response);
	}

}
