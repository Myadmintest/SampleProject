package com.learnautomation.selenium;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderExe {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		File f = new File("D:\\Test\\hello.txt");
		char[] ch = new char[(int)f.length()];
		FileReader fr = new FileReader(f);
		fr.read(ch);
		for (char c : ch) {
			System.out.print(c);
		}

	}

}
