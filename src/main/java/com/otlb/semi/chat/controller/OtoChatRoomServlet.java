package com.otlb.semi.chat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatroomServlet
 */
@WebServlet("/otochat/otochatroom")
public class OtoChatRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OtoChatRoomServlet() {
		System.out.println("////ChatroomServlet////...create");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

System.out.println("////ChatroomServlet///////doGet//////");		
		
		// 1. 
		String otoSenderId = request.getParameter("otoSenderId");
		String otoReceiverId = request.getParameter("otoReceiverId");	
		String otoSRTp = request.getParameter("otoSRTp");
 		
System.out.println("////ChatroomServlet///////otoSenderId//////"+otoSenderId);		
System.out.println("////ChatroomServlet///////otoReceiverId//////"+otoReceiverId);		
System.out.println("////ChatroomServlet///////otoSRTp//////"+otoSRTp);		
		
		String otoSenderNm = "";		
		String otoReceiverNm = "";		
		
		// initialize
		if (otoSenderId == null) {
			otoSenderId = "";
		}
		if (otoReceiverId == null) {
			otoReceiverId = "";
		}

		//GET REceiver's Name
		//Need DB check
		if(otoSenderId.equals("202002")) {
			otoSenderNm	=	"양소영";
		}else if(otoSenderId.equals("202103")){
			otoSenderNm	=	"홍길동";
		}else{
			otoSenderNm	=	"이송이";
		}
		if(otoReceiverId.equals("202002")) {
			otoReceiverNm	=	"양소영";
		}else if(otoReceiverId.equals("202103")){
			otoReceiverNm	=	"홍길동";
		}else {
			otoReceiverNm	=	"이송이";
		} 
		// 2. 
		// websocket session 
		request.getSession().setAttribute("otoSenderId", otoSenderId);
		request.getSession().setAttribute("otoReceiverId", otoReceiverId);

		request.setAttribute("otoSenderId", otoSenderId);
		request.setAttribute("otoSenderNm", otoSenderNm);
		request.setAttribute("otoReceiverId", otoReceiverId);
		request.setAttribute("otoReceiverNm", otoReceiverNm);
		request.setAttribute("otoSRTp", otoSRTp);

		// 3. view 
		request
			.getRequestDispatcher("/WEB-INF/views/chat/otoChatRoom.jsp")
			.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     System.out.println("[OtoChatRoomServlet][doPost][called]");
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		System.out.println("[OtoChatRoomServlet][doProcess][called]");
	}	 
}
