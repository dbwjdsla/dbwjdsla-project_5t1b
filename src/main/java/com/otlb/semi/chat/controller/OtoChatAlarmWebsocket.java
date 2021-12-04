package com.otlb.semi.chat.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

@ServerEndpoint(value="/otoChatAlarmWebsocket", configurator=OtoChatAlarmWebsocketConfig.class)
public class OtoChatAlarmWebsocket {

	@OnOpen
	public void onOpen(EndpointConfig config, Session session) throws IOException {
		
		// config 
		Map<String, Object> userProp = session.getUserProperties();
		//userProp.put("userId", userId);
		String userId	=	(String)userProp.get("userId");
		
		//	아이디 설정 처리 
		OtoChatInfo.addAlarmClients(userId, session); 
		
		//  접속 시작은 동시에 모두 출력 
		
		OtoChatInfo.logAlramClients();
	}
	
	/**
	 * make json data type 
	 * @param type
	 * @param sndId
	 * @param rcvId
	 * @param msg
	 * @return
	 */
	private String msgToJson(String type, String sndId,String rcvId, String sRTp, String sndNm,String rcvNm, String msg) {
		Map<String, Object> map = new HashMap<>();
		map.put("type", type);
		map.put("sender", sndId);
		map.put("receiver", rcvId);
		map.put("sRTp", sRTp);
		map.put("senderNm", sndNm);
		map.put("receiverNm", rcvNm);
		map.put("msg", msg);
		map.put("time", System.currentTimeMillis());
		return new Gson().toJson(map);
	}
	
	@OnMessage
	public void onMessage(String msgInfo, Session session) throws IOException { 

		Map<String, Object> msgMap = new Gson().fromJson(msgInfo, HashMap.class);
		Map<String, Session> alarmClients = OtoChatInfo.getAlramClients();
		
		// 대상의 세션을 가져온다
		String type = "" + msgMap.get("type");
		String otoSenderId = "" + msgMap.get("sender");
		String otoReceiverId = "" + msgMap.get("receiver");
		String otoSenderNm = "" + msgMap.get("senderNm");
		String otoReceiverNm = "" + msgMap.get("receiverNm");
		String otoMsg = "" + msgMap.get("msg");

		if(type != null && type.equals("REQCHAT")) {
			// 상대방 세션을 조회한다 
			Session alramSession =	OtoChatInfo.getAlramClientUser(otoReceiverId);
			//	현재 시간을 조회한다 
			int thisHH	=	0;
			
			try {
				Calendar cal = Calendar.getInstance();	
				SimpleDateFormat	thisFmt	=	new SimpleDateFormat("HH");
				thisHH = Integer.parseInt(thisFmt.format(cal.getTime()));
			 }catch(Exception e) {
				 e.printStackTrace();
			 }

			//	본인에게 채팅요청 할 경우 오류 처리 
			if(otoSenderId.equals(otoReceiverId)) {
				String	chatReqErrMsg	=	"대화 상대방이 본인 입니다.";
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT",otoSenderId, otoReceiverId, "S", otoSenderNm,otoReceiverNm, chatReqErrMsg)); // 액션을 실행하게 한다 
			}else if(alramSession == null) {
				//만일 세션이 null이면 오류를 본인에게 보낸다
				String	chatReqErrMsg	=	"대화 상대방이 로그인 상태가 아닙니다.";
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT",otoSenderId, otoReceiverId, "S", otoSenderNm,otoReceiverNm, chatReqErrMsg)); // 액션을 실행하게 한다 
			}else if(thisHH > 21 || thisHH < 6){
				//	현재 시간이 9시에서 6시 사이면 채팅 불가처리 한다  
				String	chatReqErrMsg	=	"현재 채팅 가능 시간이 아닙니다.";
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT",otoSenderId, otoReceiverId, "S", otoSenderNm,otoReceiverNm, chatReqErrMsg)); // 액션을 실행하게 한다 
			}else {
				//	송수신 모두 채팅을 실행한다 
				// 송신자 
				Basic sndBasic = session.getBasicRemote();
				sndBasic.sendText(msgToJson(type,otoSenderId, otoReceiverId, "S", otoSenderNm,otoReceiverNm, otoMsg)); // 액션을 실행하게 한다 

				// 수신자 
				Basic rcvBasic = alramSession.getBasicRemote();
				rcvBasic.sendText(msgToJson(type,otoSenderId, otoReceiverId, "R", otoSenderNm,otoReceiverNm, otoMsg)); // 액션을 실행하게 한다 
				
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
		
		OtoChatInfo.removeAlramClientsUser(userId);
	}
}
