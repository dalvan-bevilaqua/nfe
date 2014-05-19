package br.com.service.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class CryptUtil {
	
	public static String getMd5(String senha){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}  
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
		return hash.toString(255);
	}
	
	public static String getToken(){
		UUID uuid = UUID.randomUUID();  
		String randon = uuid.toString(); 
		return randon;
	}
	
	public static String getTokenMail(){
		UUID uuid = UUID.randomUUID();  
		String randon = uuid.toString();
		uuid = UUID.randomUUID();
		randon += uuid;
		uuid = UUID.randomUUID();
		randon += uuid;
		return randon;
	}
	
}
