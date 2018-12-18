package com.learnautomation.selenium;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;

public class CallBack {
	public static void main(String args[]) throws FilloException
	{
	Fillo fillo=new Fillo();
	Connection connection=fillo.getConnection("D:\\eclipse-jee-photon-M6-win32-x86_64\\eclipse\\Test.xlsx");
	String strQuery="Select * from Sheet1 where ID=100 and Name='chander'";
	Recordset recordset=connection.executeQuery(strQuery);
	while(recordset.next()){
	    System.out.println(recordset.getField("project"));
	}

	recordset.close();
	connection.close();

}
}
