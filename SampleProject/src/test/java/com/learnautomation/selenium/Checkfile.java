package com.learnautomation.selenium;

import java.io.File;
import java.io.IOException;

public class Checkfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:\\mytest");
		f.mkdir();
		File f1 = new File(f,"test33.txt");
		
		System.out.println(f1.exists());
		try {
			f1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(f.);
		
/*File f = new File("D:\\Test","efcabcd1234.txt");
System.out.println(f.exists());
try {
	f.createNewFile();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(f.exists());*/
	}

}
