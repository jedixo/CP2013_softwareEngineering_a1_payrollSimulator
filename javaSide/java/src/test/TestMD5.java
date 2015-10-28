package test;

import controll.MD5;

public class TestMD5 {

	public static void main(String[] args) {
		MD5 md5 = new MD5("test");
		System.out.println("Instanciated Hash:");
		System.out.println("Input Text: '"+ md5.getText() +"', To MD5: "+ md5.getHash());
		System.out.println(md5.getClass());
		System.out.println("Static Hash:");
		System.out.println("Input Text: 'test', To MD5: " + MD5.hash("test"));
		
	}

}
