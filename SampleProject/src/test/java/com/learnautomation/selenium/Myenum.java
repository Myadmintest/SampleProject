package com.learnautomation.selenium;

enum beer
{
	KF,OF,TF,MF
}
public class Myenum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		switch (beer.OF) {
		case OF:
			System.out.println("this is OF");
			break;
		case KF:
			System.out.println("this is KF");
			break;
		case MF:
			System.out.println("this is MF");
			break;
		default:
			System.out.println("This is TF");
			break;
		}

	}

}
