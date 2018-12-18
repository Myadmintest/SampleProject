package com.learnautomation.selenium;

public class Demo {
	int a,b;
	public void demo(int a, int b)
	{
		this.a = a;
		this.b = b;
		
	}
	public void m1()
	{
		System.out.println(a+"---"+b);	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Demo d = new Demo();
d.demo(1,2);
d.m1();
	}

}
