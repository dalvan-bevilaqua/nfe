package br.com.service.common;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class SHA256 {
	public static String encrypt(String paramValue) throws NoSuchAlgorithmException{
		MessageDigest hash = MessageDigest.getInstance("SHA-256");
		try{
			byte[] digest = hash.digest(paramValue.getBytes("UTF-8"));
			return byteToBase64(digest);
		}catch(Exception e){}
		return null;
	}
	public static byte[] base64ToByte(String data) throws IOException {
       BASE64Decoder decoder = new BASE64Decoder();
       
       return decoder.decodeBuffer(data);
   }
   public static String byteToBase64(byte[] data){
       BASE64Encoder endecoder = new BASE64Encoder();
       return endecoder.encode(data);
   }

}
