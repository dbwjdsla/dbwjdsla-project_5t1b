package com.otlb.semi.chat.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

public class OtoChatInfo {

	//	
	private static Map<String, String> chatPersonInfoMap = new HashMap<String, String>();

	
	//	알람이 있는 경우 처리 
	public static Map<String, Session> alarmClients = new HashMap<>();

	
	public static void addAlarmClients(String userId, Session session) { 
		alarmClients.put(userId, session); 
	}
	
	public static void logAlramClients() {
		System.out.printf("OtoChatAlarmWebsocket.logClients(%d) : %s%n", alarmClients.size(), alarmClients.keySet());
	}	
	
	public static Map<String, Session>  getAlramClients(){
		return alarmClients;
	}
	
	public static Collection<Session>  getAlramClientList(){
		return alarmClients.values();
	}
	
	//	알람을 주려는 대상자를 조회한다 
	public static Session  getAlramClientUser(String userId){
		Collection<Session> sessions = alarmClients.values();
		
		for(Session sess : sessions) {
			//	사용자 아이디를 체크한다  
			Map<String, Object> sessionUserProp = sess.getUserProperties();
			String sessUserId	=	""+sessionUserProp.get("userId");
			//	대상이 같을 때만 메세지를 출력한다 
			if(userId.equals(sessUserId)) {
				return sess;
			}
		}		
		
		
		return null;
	}
	
	
	public static void  removeAlramClientsUser(String userId){
		alarmClients.remove(userId);
	}
	
	
	
	
	public static void setPersonInfo(String sndId, String rcvId) {

		String personInfoStr = sndId + "_" + rcvId;

		chatPersonInfoMap.put(personInfoStr, "Y");
		System.out.println("OtoChatInfo: " + personInfoStr);
	}

	public static boolean isReqYn(String personId) {
//		chatPersonInfoMap.
		return true;
	}

	// sndMsgMap
	// 001|20211128153011000,002|20211128153011000|�븞�뀞�븯�꽭�슂
	//
	// rcvMsgMap
	// 002|20211128153011000,001|20211128153011000|�븞�뀞�븯�꽭�슂
 
}
