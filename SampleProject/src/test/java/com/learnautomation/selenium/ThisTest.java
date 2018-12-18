package com.learnautomation.selenium;

public class ThisTest {
	ThisTest(int a,int b,int c)
	{
		this(b,c);
		System.out.println("diplay of A: "+a);
	}
	ThisTest(int b,int c)
	{
		this(c);
		System.out.println("diplay of B: "+b);
	}
	ThisTest(int c)
	{
		System.out.println("diplay of C: "+c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThisTest t = new ThisTest(1,2,3);
		
	}

}
