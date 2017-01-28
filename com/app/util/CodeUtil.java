package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
   
	private String genStr(int size){
		
		UUID ob=UUID.randomUUID();
		String s=ob.toString().replace("-","").substring(0,size);
		return s;
	}
	
	public String genTok(){
		return genStr(8);
	}
	
	public String genPwd(){
		return genStr(6);
	}
}
