package com.excel.xpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData {
	public Map<String, String> testdata() throws IOException
	{
File file = new File("D:\\Test\\xpathsheet.xlsx");
FileInputStream fis = new FileInputStream(file);
XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sheet = wb.getSheetAt(0);
XSSFRow row = null;
XSSFCell cell;
XSSFCell cell1;
String val1=null;
String val2=null;
 int lastrow =sheet.getLastRowNum()+1;
 int lastcell =sheet.getRow(0).getLastCellNum();
 HashMap <String, String> datamap = new HashMap<String, String>();
for (int i = 1; i < lastrow; i++) {
	row = sheet.getRow(i);
	for (int j = 0; j < lastcell-1; j++) {		
		 cell= row.getCell(j);
		 cell1 = row.getCell(j+1);
		 val1 =cell.getStringCellValue();
		 val2 =cell1.getStringCellValue();
		 datamap.put(val1, val2);
	}}
return datamap;

	}
	public String getdata(String element) throws IOException
	{
		ExcelReadData data = new ExcelReadData();
		Map<String, String> test12=data.testdata();
for (String key : test12.keySet()) {
	if (key.contains(element)) {
		for (String value : test12.values()) {
			return value;
		}
	}
}
return null;	
}
	public static void main(String args[]) throws IOException
	{
		/*ExcelReadData data = new ExcelReadData();
		Map<String, String> test12=data.testdata();
		for (String key : test12.keySet()) {
			System.out.println("key = "+key);
		}
		for (String value : test12.values()) {
			System.out.println("Value ="+value);
		}
	}*/
ExcelReadData obj = new ExcelReadData();
String data1=obj.getdata("button");
	System.out.println(data1);
	}
}