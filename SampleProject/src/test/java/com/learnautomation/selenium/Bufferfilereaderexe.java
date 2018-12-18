package com.learnautomation.selenium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Bufferfilereaderexe {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileReader fl = new FileReader("D:\\Test\\hello.txt");
BufferedReader br = new BufferedReader(fl);
String str = br.readLine();
while (str!=null) {
	//System.out.println(str);
	
	if (str.contains("bhanuhhhhh")) {
		System.out.println("Bhanu present");
		
	}
	else
	{
		System.out.println("bhanu not present");

	}
	str=br.readLine();
}
br.close();
	}

}
