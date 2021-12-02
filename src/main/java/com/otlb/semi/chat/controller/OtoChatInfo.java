package com.otlb.semi.chat.controller;

import java.util.HashMap;
import java.util.Map;

public class OtoChatInfo {

	/**
	 * saved sender receiver message info
	 */
	public static Map<String, String> sndMsgMap = new HashMap<>();
	public static Map<String, String> rcvMsgMap = new HashMap<>();

	private static Map<String, String> chatPersonInfoMap = new HashMap<String, String>();

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
	// 001|20211128153011000,002|20211128153011000|안녕하세요
	//
	// rcvMsgMap
	// 002|20211128153011000,001|20211128153011000|안녕하세요

	/**
	 * save message...
	 * 
	 * @param sndId
	 * @param rcvId
	 * @param msg
	 */
	public static void saveMsg(String sndId, String rcvId, String msg) {

		String thisTime = "" + System.currentTimeMillis();

		String sndMsg = rcvId + "|" + msg;
		String rcvMsg = sndId + "|" + msg;

		// save message info to send and receive
		sndMsgMap.put(sndId + "|" + thisTime, sndMsg);
		rcvMsgMap.put(rcvId + "|" + thisTime, rcvMsg);
	}

	public static void logMsg() {
		// System.out.printf("otoChatWebsocket.logClients(%d) : %s%n", clients.size(),
		// clients.keySet());
		System.out.println("[OtoChatMsg][sndMsgMap]" + sndMsgMap);
		System.out.println("[OtoChatMsg][rcvMsgMap]" + rcvMsgMap);

	}

}
