package com.otlb.semi.chat.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import com.otlb.semi.emp.model.vo.Emp;

//서버측에서 보다 세밀한 기능 구현을 위해 Configurator 클래스 상속 
public class OtoChatAlarmWebsocketConfig extends Configurator {

	// 웹 소켓 세션의 UserProperties에 userId와 loginYn으로 현재 세션의 HttpSession을 세팅해준다
	@Override
	//EndPointConfig에 HttpSession을 넣는다 
	//WebSocket을 통해 연결되는 HandShake를 수정하는 부분으로 연결에 대한 정보들을 WebSocket Session내에 Property에 등록하여 
	//채널링을 구현하는데 사용하고 있다 
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		//HttpRequest로부터 Session을 받는다
		HttpSession session = (HttpSession) request.getHttpSession();
		//Emp
		Emp ssEmp = (Emp) session.getAttribute("loginEmp");
		
		//UserProperties를 Map에 저장 
		Map<String, Object> userProp = sec.getUserProperties();
		
		if (ssEmp != null) {
			String userId = "" + ssEmp.getEmpNo();

			// 현재 사용자 아이디와 로그인 여부 세팅 
			userProp.put("userId", userId); 
			userProp.put("loginYn", "Y"); 
		} else {
			// 로그인 아닌경우는 로그인 아님을 알려준다
			userProp.put("userId", ""); 
			userProp.put("loginYn", "N"); 
		}
	}

}
