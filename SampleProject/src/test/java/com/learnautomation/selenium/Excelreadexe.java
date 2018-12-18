package com.learnautomation.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreadexe {

	
		// TODO Auto-generated method stub
		File f = new File("D:\\mytest\\Sample.xlsx");
//FileInputStream file = new FileInputStream(f);
//XSSFWorkbook workbook = new XSSFWorkbook(file);
public String path;
FileInputStream fis;
XSSFWorkbook workbook;
XSSFSheet sheet = null;
XSSFRow row=null;
XSSFCell cell = null;

public void excel_read(String path)
{
this.path=path;
try {
	fis=new FileInputStream(path);
	workbook = new XSSFWorkbook(fis);
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
}

	public void getcelldata()
	{
		try {			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				
		//	System.out.println(workbook.getSheetAt(i).getSheetName());
			String sheetname = workbook.getSheetAt(i).getSheetName();
			if (sheetname.equalsIgnoreCase("ADD"))
			{
			 Row row;
			 Cell cell;
			 
			}}						
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
public static void main(String[] args) throws IOException {
	Excelreadexe obj = new Excelreadexe();
	obj.excel_read("D:\\mytest\\Sample.xlsx");
	obj.getcelldata();
}
}