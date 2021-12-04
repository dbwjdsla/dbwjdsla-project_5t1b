package com.otlb.semi.chat.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import com.otlb.semi.emp.model.vo.Emp;

public class OtoChatAlarmWebsocketConfig extends Configurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		//	
		HttpSession session = (HttpSession) request.getHttpSession();
		Emp	ssEmp	=	(Emp)session.getAttribute("loginEmp"); 
		
		if(ssEmp != null) {
			String userId	=	""+ssEmp.getEmpNo();
			
			// config 
			Map<String, Object> userProp = sec.getUserProperties();
			userProp.put("userId", userId);
		}
	}
	
	
}
