package com.learnautomation.selenium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int count=0;
Pattern p = Pattern.compile("ab");
Matcher m = p.matcher("abcdabbba");
while (m.find()) {
	++count;
}
System.out.println(++count);
	}

}
