package com.elquineas.hello.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class BCryptMain{
	public static void main(String[] args) {
		Map<String, String> envList = System.getenv();
//		List<String> envKeys = new ArrayList<>(envList.keySet());
//		
//		for(String env : envKeys) {
//			System.out.printf("%s : %s\n",env, envList.get(env));
//		}
		System.out.println(envList.get("elquineas.com"));
		
		String saltKey = envList.get("elquineas.com");
		// 암호문을 만드는 도구
		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		
		//MD5 와 DES 방식으로 암호화를 하겠다
		pbe.setAlgorithm("PBEWithMD5AndDES");
		pbe.setPassword(saltKey);
		
		// plan Text 를 암호화 시키는 method
		String encString = pbe.encrypt("elquineas");
		System.out.println(encString);
		
		String s1 = "1BDZ4COtqNtOXSpsb2Ir18B/8wqdnVMW";
		String s2 = "f5pWiYLXbm126hDjijtceWZXuXpymi/0";
		String s3 = "Z1lvG6i1WeuG4qMlcq5jpfj6zCfX9Mr9";
		
		// 암호화된 Text 를 복호화(plan Text) 시키는 method
		System.out.println(pbe.decrypt(s1));
		System.out.println(pbe.decrypt(s2));
		System.out.println(pbe.decrypt(s3));
		
		String savePath = "./src/main/webapp/WEB-INF/spring/properties/db_info.properties";
		
		try {
			PrintWriter out = new PrintWriter(savePath);
			out.println("username=elquinese");
			out.println("password=1234");
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}