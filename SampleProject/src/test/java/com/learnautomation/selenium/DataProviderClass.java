package com.learnautomation.selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	@Test (dataProvider="getData")
    // Number of columns should match the number of input parameters
 public void loginTest(String Uid, String Pwd){
 System.out.println("UserName is "+ Uid);
 System.out.println("Password is "+ Pwd);
 }
@DataProvider(name="getdata")
public Object[][] getdata()
{
	Object [][] data = new Object [2][2];
	 
	 data [0][0] = "FirstUid";
	 data [0][1] = "FirstPWD";
	 
	 data[1][0] = "SecondUid";
	 data[1][1] = "SecondPWD";
	 
	 return data;
}


}
