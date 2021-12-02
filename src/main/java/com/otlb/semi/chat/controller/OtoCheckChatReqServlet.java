package com.otlb.semi.chat.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ChatClientsServlet
 */
@WebServlet("/otochat/otocheckchatreq")
public class OtoCheckChatReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("////OtoCheckChatReqServlet////doGet////////");	
		
		//1. 클라이언트 
		Map<String, String> rtnMap = new HashMap<String, String>();
		boolean reqYn = OtoChatInfo.isReqYn("202002");
		System.out.println("OtoCheckChatReqServlet: " + reqYn);
		if (reqYn == true) {
			rtnMap.put("reqYn", "Y");
			rtnMap.put("otoSenderId", "202002");
			rtnMap.put("otoReceiverId", "202103");
			rtnMap.put("otoSRTp", "R");
		} else {
			rtnMap.put("reqYn", "N");
		}
		
		//2. 
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(rtnMap, response.getWriter());
	}
}





