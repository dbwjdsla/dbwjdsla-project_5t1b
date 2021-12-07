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

//ServerEndpoint라는 어노테이션에서 본 서버가 어떤 주소를 바인딩하는지 정의 웹소켓 endpoint의 경로를 넣는다 
//value는 경로 configurator는 소켓 통신에 대한 전반적인 환경 설정을 담당한다 
@ServerEndpoint(value = "/otoChatAlarmWebsocket", configurator = OtoChatAlarmWebsocketConfig.class)
public class OtoChatAlarmWebsocket {
	//웹 소켓이 연결되면 호출
	@OnOpen
	public void onOpen(EndpointConfig config, Session session) throws IOException {

		// 소켓 세션 조회
		Map<String, Object> userProp = session.getUserProperties();
		String userId = (String) userProp.get("userId");
		String loginYn = (String) userProp.get("loginYn");

		// 로그인 한 경우 채팅 창 오픈, 아닐 경우 소멸
		if (loginYn != null && loginYn.equals("Y")) {
			// 아이디 설정 처리
			OtoChatInfo.addAlarmClients(userId, session);

		}
	}

	/**
	 * make json data type
	 * 
	 * @param type
	 * @param sndId
	 * @param rcvId
	 * @param msg
	 * @return
	 */
	private String msgToJson(String type, String sndId, String rcvId, String sRTp, String sndNm, String rcvNm,
			String msg) {
		Map<String, Object> map = new HashMap<>();
		map.put("type", type); //String 타입으로 리턴 
		map.put("sender", sndId); //채팅 송신자 아이디
		map.put("receiver", rcvId); //채팅 수신자 아이디 
		map.put("sRTp", sRTp); //sender인지 receiver인지 (SenderReceiverType)
		map.put("senderNm", sndNm); //채팅 요청자 이름 
		map.put("receiverNm", rcvNm); //채팅 수신자 이름 
		map.put("msg", msg); //메세지 
		map.put("time", System.currentTimeMillis()); //전송 시각 
		return new Gson().toJson(map);
	}
	//웹 소켓으로부터 메세지가 오면 호출 
	@OnMessage
	public void onMessage(String msgInfo, Session session) throws IOException {

		Map<String, Object> msgMap = new Gson().fromJson(msgInfo, HashMap.class);
		
		Map<String, Session> alarmClients = OtoChatInfo.getAlramClients();

		// 대상의 소켓 세션을 가져온다
		Map<String, Object> userProp = session.getUserProperties();
		String userId = (String) userProp.get("userId"); //유저 아이디
		String loginYn = (String) userProp.get("loginYn"); //로그인 여부 

		// 메세지 정리 
		String type = "" + msgMap.get("type");
		String otoSenderId = "" + msgMap.get("sender");
		String otoReceiverId = "" + msgMap.get("receiver");
		String otoSenderNm = "" + msgMap.get("senderNm");
		String otoReceiverNm = "" + msgMap.get("receiverNm");
		String otoMsg = "" + msgMap.get("msg");
		
		if (type != null && type.equals("REQCHAT")) {
			// 본인의 세션을 조회한다 (본인이 로그인 되어 있는지 체크한다)
			Session thisUserSession = OtoChatInfo.getAlramClientUser(otoSenderId);

			// 본인이 로그인 안된 경우 오류 처리 (회원제 사이트지만 혹시 모를 경우를 대비해)
			if (thisUserSession == null) {
				System.out.println("[OtoChatAlarmWebsocket][onMessage]" + thisUserSession + ":" + otoSenderId);
				String chatReqErrMsg = "로그인 후 사용 가능합니다.";
				//Session 오브젝트 사용해 메세지 보내기 
				//session 인스턴스의 getBasicRemote()메소드는 웹소켓의 상대쪽인 RemoteEndpoint를 리턴한다 
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT", otoSenderId, otoReceiverId, "S", otoSenderNm, otoReceiverNm,
						chatReqErrMsg)); // 에러 메세지 출력 액션 실행 
				return; //송신자에게 리턴 값을 준다 
			}
			// 본인에게 채팅요청 할 경우 오류 처리
			if (otoSenderId.equals(otoReceiverId)) {
				System.out.println("[OtoChatAlarmWebsocket][onMessage]" + thisUserSession + ":" + otoSenderId + ":"
						+ otoReceiverId);
				String chatReqErrMsg = "대화 상대방이 본인 입니다.";
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT", otoSenderId, otoReceiverId, "S", otoSenderNm, otoReceiverNm,
						chatReqErrMsg)); // 에러 메세지 출력 액션 실행 
			}
			// 세션의 아이디와 요청자의 아이디가 다른 경우 오류
			if (!otoSenderId.equals(userId)) {
				System.out.println("[OtoChatAlarmWebsocket][onMessage]" + thisUserSession + ":" + otoSenderId + ":"
						+ otoReceiverId);
				String chatReqErrMsg = "로그인 사용자가 요청자가 아닙니다.";
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT", otoSenderId, otoReceiverId, "S", otoSenderNm, otoReceiverNm,
						chatReqErrMsg)); // 에러 메세지 출력 액션 실행 
			}
			// 본인이 대화중인지 확인한다
			Map<String, String> partyMap = OtoChatInfo.getOtoChatParty();
			
			
			String thisPartyStr = partyMap.get(userId);
			
			if (thisPartyStr == null) {
				thisPartyStr = "";
			}
			if (thisPartyStr.indexOf(otoReceiverId) != -1) {
				System.out.println("[OtoChatAlarmWebsocket][onMessage]" + thisUserSession + ":" + otoSenderId + ":"
						+ otoReceiverId);
				String chatReqErrMsg = "이미 대화중입니다.";
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT", otoSenderId, otoReceiverId, "S", otoSenderNm, otoReceiverNm,
						chatReqErrMsg)); // 에러 메세지 출력 후 액션 실행 
			} 

			// 상대방 세션을 조회한다
			Session alramSession = OtoChatInfo.getAlramClientUser(otoReceiverId);
			
			// 현재 시간을 조회한다
			int thisHH = 0;

			try {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat thisFmt = new SimpleDateFormat("HH");
				thisHH = Integer.parseInt(thisFmt.format(cal.getTime()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 상대방이 로그인 상태가 아니면 오류 처리
			if (alramSession == null) {
				System.out.println("[OtoChatAlarmWebsocket][onMessage]" + thisUserSession + ":" + otoSenderId + ":"
						+ otoReceiverId + ":" + alramSession);
				String chatReqErrMsg = "대화 상대방이 로그인 상태가 아닙니다.";
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT", otoSenderId, otoReceiverId, "S", otoSenderNm, otoReceiverNm,
						chatReqErrMsg)); // 에러 메세지 출력 후 액션을 실행하게 한다
			} else if (thisHH > 18 || thisHH < 9) {
				// 현재 시간이 9~18시 사이에만 채팅이 가능하다
				String chatReqErrMsg = "현재 채팅 가능 시간이 아닙니다.";
				Basic basic = session.getBasicRemote();
				basic.sendText(msgToJson("ERRCHAT", otoSenderId, otoReceiverId, "S", otoSenderNm, otoReceiverNm,
						chatReqErrMsg)); // 에러 메세지 출력 후 액션을 실행하게 한다
			} else {
				// 송수신 모두 채팅을 실행한다
				
				// 송신자
				Basic sndBasic = session.getBasicRemote();
				sndBasic.sendText(msgToJson(type, otoSenderId, otoReceiverId, "S", otoSenderNm, otoReceiverNm, otoMsg)); // 메세지 전송 액션 실행 

				// 수신자
				Basic rcvBasic = alramSession.getBasicRemote();
				rcvBasic.sendText(msgToJson(type, otoSenderId, otoReceiverId, "R", otoSenderNm, otoReceiverNm, otoMsg)); // 메세지 전송 액션 실행 																																																			// 한다
			}
		}

	}
	//웹 소켓이 에러가 나면 호출 
	@OnError
	public void onError(Throwable e) {
		e.printStackTrace();
	}
	//웹 소켓이 닫히면 호출 
	@OnClose
	public void onClose(Session session) throws IOException {
		// clients
		Map<String, Object> userProp = session.getUserProperties();
		String userId = (String) userProp.get("userId");

		OtoChatInfo.removeAlramClientsUser(userId);
	}
}
