package com.excel.xpath;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Operation1 extends Pagebase{
	@Test
	public void open()
    {
		try {			
        enterData("input_UserName", "Admin");
       // getDriver().wait(1);
        enterData("input_Password", "admin123");
        //getDriver().wait(1);
        clickon("button_Submit");
        
        verify_Page("text_home");
		} catch (Exception e) {
		e.printStackTrace();
		}
	} 

}
