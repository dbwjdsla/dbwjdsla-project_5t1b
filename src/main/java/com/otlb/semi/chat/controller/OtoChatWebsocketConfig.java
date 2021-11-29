package com.otlb.semi.chat.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class OtoChatWebsocketConfig extends Configurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		
		System.out.println("////OtoChatWebsocketConfig////////////");	
		System.out.println("////OtoChatWebsocketConfig//////////getParameterMap//"+request.getParameterMap());	
		
		Map<String,List<String>> reqParamMap	=	request.getParameterMap();
		
		//	sender and receiver info check 
		String otoSenderId	=	reqParamMap.get("otoSenderId").get(0);
		String otoReceiverId=	reqParamMap.get("otoReceiverId").get(0);
		String otoSRTp=	reqParamMap.get("otoSRTp").get(0);

		//	
		HttpSession session = (HttpSession) request.getHttpSession();
//		String userId = (String) session.getAttribute("userId");
//		
		
		String otoSenderNm	=	"";
		String otoReceiverNm	=	"";
		
		//	name setting
		if(otoSenderId.equals("001")) {
			otoSenderNm	=	"해";
		}else if(otoSenderId.equals("002")){
			otoSenderNm	=	"닭";
		}else{
			otoSenderNm	=	"별";
		}
		if(otoReceiverId.equals("001")) {
			otoReceiverNm	=	"해";
		}else if(otoReceiverId.equals("002")){
			otoReceiverNm	=	"닭";
		}else {
			otoReceiverNm	=	"별";
		}
		//	아이디 설정 처리 
		String userId	=	"";
		String userNm	=	"";
 		

		if("R".equals(otoSRTp)) {
			userId = otoReceiverId; 
			userNm = otoReceiverNm; 
		}else {
			userId = otoSenderId; 
			userNm = otoSenderNm; 
		}
		
		// config 
		Map<String, Object> userProp = sec.getUserProperties();
		userProp.put("userId", userId);
		userProp.put("userNm", userNm);
		userProp.put("otoSenderId", otoSenderId);
		userProp.put("otoSenderNm", otoSenderNm);
		userProp.put("otoReceiverId", otoReceiverId);
		userProp.put("otoReceiverNm", otoReceiverNm);
		userProp.put("otoSRTp", otoSRTp);
		
		
//		System.out.println("userProp = " + userProp);
		// {userId=honggd, org.apache.tomcat.websocket.pojo.PojoEndpoint.methodMapping=org.apache.tomcat.websocket.pojo.PojoMethodMapping@38207a35}
	}
	
	
}
