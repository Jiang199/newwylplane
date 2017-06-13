package com.plane.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encodingbymd5 {
	
	static String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	@SuppressWarnings("unused")
	public  String encodeByMD5(String password) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("md5");
		byte[] results = digest.digest(password.getBytes());
		return byteArrayToString(results);
	}
	
	private static String byteArrayToString(byte[] results) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<results.length;i++) {
			//per byte to string
			sb.append(byteToString(results[i]));
		}
		return sb.toString();
	}

	//per byte to String (Algorithms)
	private static Object byteToString(byte b) {
		int n = b;
		if(n<0) {
			n = 256+n;
		}
		int d1 = n/16;
		int d2 = n%16;		
		return hex[d1]+hex[d2];
	}
}
