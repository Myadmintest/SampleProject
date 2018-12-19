package com.excel.xpath;

import java.util.HashMap;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloFileReader {
	
		public Map<String, String> readData(String column1)
		{
		// TODO Auto-generated method stub
    Fillo fill = new Fillo();
    System.out.println("this is suresh commit");
    System.out.println("this is suresh commit2");
	Connection con;
	Map<String, String> testdata = new HashMap();
	try {
		con = fill.getConnection("D:\\Test\\xpathsheet.xlsx");
	
	String strquery="select * from Sheet1";
	// where Lable='input_UserName'
	Recordset recordset = con.executeQuery(strquery);
	String str1,str2;
	
	while(recordset.next()){
		str1= recordset.getField("Lable");
		str2= recordset.getField("xpath");
		//System.out.println(str1);
		//System.out.println(str2);
		testdata.put(str1, str2);
	}
	
	recordset.close();
    con.close();
	} catch (FilloException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return testdata;
	
	}
public static void main(String[] args) throws FilloException {
FilloFileReader filereader = new FilloFileReader();
Map<String, String> read1 =filereader.readData("Lable");
System.out.println(read1);
}
}
