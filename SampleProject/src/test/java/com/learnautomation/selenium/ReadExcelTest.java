package com.learnautomation.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.graphbuilder.math.func.SumFunction;

public class ReadExcelTest {

    public static void main(String[] args) throws Exception {
		String[][] data = null;
    	try {
    		
    		File file = new File("D:\\Test\\Sample.xlsx");
    		FileInputStream fileinput = new FileInputStream(file);
    		XSSFWorkbook wb = new XSSFWorkbook(fileinput);
    		XSSFSheet sheet = null;
    		double value=0;
			double value2=0;
			double sum=0;
			double substract=0;
			double division=0;
			double multiplication=0;
			XSSFCell cell=null;
			XSSFCell cell1=null;
    			

for (int h = 0; h < wb.getNumberOfSheets(); h++) {
	sheet=wb.getSheetAt(h);
	int rowNum =sheet.getLastRowNum() + 1;

    			int colNum = sheet.getRow(0).getLastCellNum();

    			data = new String[rowNum][colNum];
    			
				// Get the row

    			for (int i = 1; i < rowNum; i++) {
    				
    				XSSFRow row = sheet.getRow(i);

    				for (int j = 0; j < colNum-1; j++) {
    					
    					 cell= row.getCell(j);
    					 cell1 = row.getCell(j+1);
    					 value = cellToString(cell);
    					 value2 = cellToString(cell1);
    					 if (sheet.getSheetName().equalsIgnoreCase("ADD")) {
    						 sum =value+value2;
    	    					System.out.println("Value ADD:" +sum );	
						} else if (sheet.getSheetName().equalsIgnoreCase("SUB")) {
							substract =value-value2;
	    					System.out.println("Value SUB:" +substract );	
						}else if (sheet.getSheetName().equalsIgnoreCase("DIV")) {
							division =value/value2;
    					System.out.println("Value division:" +division );	
					}else if (sheet.getSheetName().equalsIgnoreCase("MULT")) {
						multiplication =value*value2;
    					System.out.println("Value Multiplication:" +multiplication );
					}  }}} }catch (Exception e) {
e.printStackTrace();
		}   }
    	private static double cellToString(XSSFCell cell) {
    		double result;
    		switch (cell.getCellType()) {
    		case Cell.CELL_TYPE_NUMERIC:
    			result = cell.getNumericCellValue();
    			break;
    		/*case Cell.CELL_TYPE_STRING:

    			result = cell.getStringCellValue();

    			break;



    		case Cell.CELL_TYPE_BOOLEAN:

    			result = cell.getBooleanCellValue();

    			break;



    		case Cell.CELL_TYPE_FORMULA:

    			result = cell.getCellFormula();

    			break;

*/

    		default:
    			throw new RuntimeException("Unknown Cell Type");
    		}
    		return result;
} }
