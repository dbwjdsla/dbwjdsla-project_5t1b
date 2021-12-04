package com.otlb.semi.message.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.otlb.semi.common.DateFormatUtils;
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
		
		int empNo = emp.getEmpNo();
		List<Message> list = messageService.selectAllSentMessage(empNo);
		//System.out.println("[MessageListServlet] list = " + list);
		List<String> sentDateList = new ArrayList<>();
		List<String> readDateList = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			sentDateList.add(DateFormatUtils.formatDate(list.get(i).getSentDate()));
			readDateList.add(DateFormatUtils.formatDate(list.get(i).getReadDate()));
		}
		request.setAttribute("list", list);
		request.setAttribute("sentDateList", sentDateList);
		request.setAttribute("readDateList", readDateList);
		request
			.getRequestDispatcher("/WEB-INF/views/message/sentMessageList.jsp")
			.forward(request, response);
	}

}
