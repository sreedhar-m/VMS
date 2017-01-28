package com.app.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CoDecUtil {
    
	private String genericEncode(String str){
		byte[] byteArray=Base64.encodeBase64(str.getBytes());
		String strr=new String(byteArray);
		return strr;
	}
	
	private String genericDecode(String str){
		byte[] byteArray=Base64.decodeBase64(str.getBytes());
		String strr=new String(byteArray);
		return strr;
	}
	
	
	
	public String doEncode(String enStr){
		return genericEncode(enStr);
	}
	
	public String doDecode(String str){
		return genericDecode(str);
	}
}
