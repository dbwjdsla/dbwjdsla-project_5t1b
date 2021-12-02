package com.otlb.semi.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

public class EmpUtils {

	/**
	 * 비밀번호 암호화 처리 메소드
	 */
	public static String getEncryptedPassword(String password) {
		 
		// 1. 암호화처리
		byte[] encrypted = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] plain = password.getBytes("utf-8");
			md.update(plain);
			encrypted = md.digest();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//System.out.println(new String(encrypted));
		
		// 2. 인코딩처리
		Encoder encoder = Base64.getEncoder();
		String encryptedPassword = encoder.encodeToString(encrypted);
		
		//System.out.println(encryptedPassword);
		
		return encryptedPassword;
	}

	
}
