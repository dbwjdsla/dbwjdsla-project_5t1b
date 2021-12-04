package com.otlb.semi.chat.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ChatClientsServlet
 */
@WebServlet("/otochat/clients")
public class OtoChatClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("////ChatClientsServlet////doGet////////");	
		
		//1. 클라이언트 목록 
		Set<String> clients = OtoChatWebsocket.clients.keySet();
		
		//2. 
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(clients, response.getWriter());
		
		
		
	}
}





