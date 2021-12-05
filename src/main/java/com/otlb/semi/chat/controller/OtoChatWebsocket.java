package com.otlb.semi.chat.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint(value="/otoChatWebsocket", configurator=OtoChatWebsocketConfig.class)
public class OtoChatWebsocket {

	/**
	 * 
	 */
	public static Map<String, Session> clients = new HashMap<>();
	
	public static void logClients() {
		System.out.printf("otoChatWebsocket.logClients(%d) : %s%n", clients.size(), clients.keySet());
	}
	
	@OnOpen
	public void onOpen(EndpointConfig config, Session session) throws IOException {
		
		System.out.println("[getParameterMap][onOpen]");	
	
		
		// userId - session 
		Map<String, Object> userProp = config.getUserProperties();
		
		// 1.first get UserId from session
		String otoSenderId = (String) userProp.get("otoSenderId");
		String otoReceiverId = (String) userProp.get("otoReceiverId");
		String otoSenderNm = (String) userProp.get("otoSenderNm");
		String otoReceiverNm = (String) userProp.get("otoReceiverNm");
		String otoSRTp = (String) userProp.get("otoSRTp");
		String userId = (String) userProp.get("userId");
		String userNm = (String) userProp.get("userNm");

		System.out.println("[OtoChatWebsocket][userProp]"+userProp); 
		
		//	아이디 설정 처리 
		clients.put(userId, session);
		// 채팅 요청자와 응답자 정보 저장 
		OtoChatInfo.setPersonInfo(otoSenderId, otoReceiverId);
		
		//  접속 시작은 동시에 모두 출력 
		String jsonMsg = msgToJson("[CHATST]", otoSenderId,otoReceiverId, otoSenderNm+" 님과 1:1 대화를 시작합니다");
		//onMessage(jsonMsg, session);
		jsonMsg = msgToJson("[CHATST]", otoReceiverId,otoSenderId, otoReceiverNm+" 님과 1:1 대화를 시작합니다");
		//onMessage(jsonMsg, session);
		
		logClients();
	}
	
	/**
	 * make json data type 
	 * @param type
	 * @param sndId
	 * @param rcvId
	 * @param msg
	 * @return
	 */
	private String msgToJson(String type, String sndId,String rcvId, String msg) {
		Map<String, Object> map = new HashMap<>();
		map.put("type", type);
		map.put("sender", sndId);
		map.put("receiver", rcvId);
		map.put("msg", msg);
		map.put("time", System.currentTimeMillis());
		return new Gson().toJson(map);
	}
	
	@OnMessage
	public void onMessage(String msg, Session session) throws IOException {
		Map<String, Object> map = new Gson().fromJson(msg, HashMap.class);
		
		synchronized(clients) {
			Collection<Session> sessions = clients.values();
			
			for(Session sess : sessions) {
				//	사용자 아이디를 체크한다 
				String targetId	=	""+map.get("receiver");
				Map<String, Object> sessionUserProp = sess.getUserProperties();
				String sessUserId	=	""+sessionUserProp.get("userId");
				//	대상이 같을 때만 메세지를 출력한다 
				if(targetId.equals(sessUserId)) {
					Basic basic = sess.getBasicRemote();
					basic.sendText(msg);
				}
			}
		}
	}
	
	@OnError
	public void onError(Throwable e) {
		e.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session session) throws IOException {
		// clients 
		Map<String, Object> userProp = session.getUserProperties();
		String userId = (String) userProp.get("userId");
		String userNm = (String) userProp.get("userNm");
		
		clients.remove(userId);
		
		//  
		String msg = msgToJson("[CHATED]", "",userId, userNm+" 님과의 대화방이 종료 되었습니다");
		onMessage(msg, session);
	}
}
