package com.callor.bbs.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExA {
	
	private void FileEx() throws FileNotFoundException {
		String fileName = "score.txt";
		FileInputStream is = null;
		Scanner scan = null;
		
		is = new FileInputStream(fileName);
		scan = new Scanner(is);
		
	}
	
	public static void main(String[] args) {
		
	}
}
