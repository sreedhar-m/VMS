package com.app.util;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class Test {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		Test t=new Test();
		System.out.println(t.genTok());
		System.out.println(t.genPwd());
		System.out.println(t.genericEncode("sreedhar"));
	}

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
	
	
	
	private String genericEncode(String str){
		byte[] byteArray=Base64.encodeBase64(str.getBytes());
		String encodedString=new String(byteArray);
		return encodedString;
	}
	
	public static void main(String[] args) {
		CoDecUtil util=new CoDecUtil();
		String enc=util.doEncode("sreedhar");
		System.out.println(enc);
		String dec=util.doDecode(enc);
		System.out.println(dec);
	}

}
