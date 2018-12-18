package com.excel.xpath;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.poi.util.SystemOutLogger;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

public class Pagebase {
	 private static WebDriver driver;
	 FilloFileReader reader = new FilloFileReader();
	
	 log4j.appender.file.File="C:\\Setups\\Logs\\Selenium.txt";
	 Logger logger=Logger.getLogger(getClass());
			 //.getLogger("Google");
	 @BeforeTest
	 public void openBrowser()
     {
		 System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
         getDriver().get("https://opensource-demo.orangehrmlive.com/");
         logger.info("Browser is opened and Navigated to url");
       getDriver().manage().window().maximize();
       
     }
	 @Before
	public static WebDriver getDriver()
	{
		return driver;
	}

	 	/*public Collection<String> getMapValues() 
		{
			ExcelReadData data = new ExcelReadData();
			Map<String, String> test12;
			TreeMap<String, String> newMap = new TreeMap<String, String>();
			try {
				test12 = data.testdata();
				
	for (String key : test12.keySet()) {
		//for (String value : test12.values()) {
			return test12.values();
			//return newMap;
		}} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
		}
		*/
	public String getxpath(String xpath)
		{
			Map<String, String> params=reader.readData(xpath);
			String val=params.get(xpath);
			//System.out.println(val);
			return val;
		}
	public void verify_Page(String element)
	{
	String homepage=getDriver().findElement(By.xpath(getxpath(element))).getText();
	assertEquals(homepage, "Welcome Admin");
	logger.info("Navigated to home page");
	}
	
/*	public void OpenBrowser(String Browser,String Baseurl)
	{
	getDriver().findElement(By.xpath(getxpath(element))).sendKeys(value);
	} */	
	
	public void enterData(String element,String value)
	{
		//System.out.println("The element enter "+element+ " and the value "+value);
	getDriver().findElement(By.xpath(getxpath(element))).sendKeys(value);
	logger.info("The element enter "+element+ " and the value "+value);
	} 	
	
	public void clickon(String element)
	{
		
		driver.findElement(By.xpath(getxpath(element))).click();
		//System.out.println("Clicked on element "+element);
		logger.info("Clicked on element "+element);
	}
	
	public static void main(String args[])
	{
		Pagebase page = new Pagebase();
		//page.getData("Sheet1", "button_Submit");
				
	}
	//@AfterTest
}
