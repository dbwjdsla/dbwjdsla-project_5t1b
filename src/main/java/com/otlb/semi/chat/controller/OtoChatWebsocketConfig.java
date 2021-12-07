package com.otlb.semi.chat.controller;

import java.util.List;
import java.util.Map;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import com.otlb.semi.emp.model.service.EmpService;
import com.otlb.semi.emp.model.vo.Emp;

public class OtoChatWebsocketConfig extends Configurator {

	private EmpService empService = new EmpService();

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {

		System.out.println("[OtoChatWebsocketConfig][getParameterMap]" + request.getParameterMap());

		Map<String, List<String>> reqParamMap = request.getParameterMap();

		// sender and receiver info check
		String otoSenderId = reqParamMap.get("otoSenderId").get(0);
		String otoReceiverId = reqParamMap.get("otoReceiverId").get(0);
		String otoSRTp = reqParamMap.get("otoSRTp").get(0);

		//
		Emp sndEmp = empService.selectOneEmp(Integer.parseInt(otoSenderId));
		Emp rcvEmp = empService.selectOneEmp(Integer.parseInt(otoReceiverId));

		String otoSenderNm = "";
		String otoReceiverNm = "";

		// 아이디 설정 처리
		String userId = "";
		String userNm = "";

		if ("R".equals(otoSRTp)) {
			userId = otoReceiverId;
			userNm = rcvEmp.getEmpName();
		} else {
			userId = otoSenderId;
			userNm = sndEmp.getEmpName();
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

		// System.out.println("userProp = " + userProp);
	}

}
