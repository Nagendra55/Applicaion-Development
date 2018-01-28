package com.jspiders.project.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {

	/**
	 * @param args
	 */
	public String encrypt(String salt,String unecryptedPassword) {
		/*	String salt = "LongStringForExtraSecurity@#$!%^&*(*)1234567890";
			String unecryptedPassword = "charan";
			System.out.println("Unencrypted Password: " + unecryptedPassword);*/
		MessageDigest messageDigest=null;
		try {
			messageDigest = MessageDigest.getInstance("SHA");
			messageDigest.update((unecryptedPassword+salt).getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String encryptedPassword = (new BigInteger(messageDigest.digest())).toString(16);
		return (encryptedPassword);
	}
	


}
