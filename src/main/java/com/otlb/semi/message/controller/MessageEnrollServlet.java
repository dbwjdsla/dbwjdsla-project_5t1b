package com.otlb.semi.message.controller;

import java.io.IOException;
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
 * Servlet implementation class MessageEnrollServlet
 */
@WebServlet("/message/messageEnroll")
public class MessageEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		
		//보내는사람
		Emp emp = (Emp) session.getAttribute("loginEmp");
		int sender = emp.getEmpNo();
		//받는사람
		int receiver = Integer.valueOf(request.getParameter("receiver"));
		String content = request.getParameter("content");
		Message message = new Message(0, content, sender, receiver, null, null, null, null);
		
		int result = messageService.insertMessage(message);
		String msg = result > 0 ? "쪽지를 성공적으로 발송했습니다!" : "쪽지 발송에 실패했습니다...";
		System.out.println(msg);
		
		session.setAttribute("msg", msg);
		String location = request.getContextPath() + "/message/messageForm";
		response.sendRedirect(location);
		
	}

}
