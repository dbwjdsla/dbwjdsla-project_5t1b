package com.otlb.semi.message.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.message.model.service.MessageService;

/**
 * Servlet implementation class SentMessageDeleteServlet
 */
@WebServlet("/message/sentMessageDelete")
public class SentMessageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//넘어온 글 번호
		String _no = request.getParameter("no");
		
		//,기준으로 문자열 split
		String[] no = _no.split(",");
		List<Integer> list = new ArrayList<>();
		
		//문자열 숫자를 정수형으로 형변환
		for(String str : no) {
			list.add(Integer.parseInt(str));
		}
		String msg = "";
		for(int i = 0; i < list.size(); i++) {
			int result = messageService.updateSenderDelYn(list.get(i));
			if(result > 0) {
				msg = (i+1) + "개의 쪽지 삭제에 성공하였습니다.";
			}else {
				msg = "일부 쪽지 삭제에 실패 하였습니다.";
				break;
			}
			
		}
		
		request.getSession().setAttribute("msg", msg);
		response.sendRedirect(request.getContextPath() + "/message/messageList");
	}

}
