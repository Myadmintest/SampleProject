package com.learnautomation.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader
{
    public static void main(String[] args)
    {
        try
        {
            String excelPath = "D:\\mytest\\Sample.xlsx";
            FileInputStream fileInputStream = new FileInputStream(new File(excelPath));

            // Create Workbook instance holding .xls file
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            Iterator<Sheet> sheetIterator;
            sheetIterator = workbook.sheetIterator();
            while(sheetIterator.hasNext()){
                Sheet sheet = sheetIterator.next();
                System.out.println(sheet.getSheetName());
                String str1=sheet.getSheetName();
            if (str1.equalsIgnoreCase("ADD")) {
				System.out.println("This is Add");
				Sheet sheet1 = workbook.getSheet("ADD");
				for (Row row : sheet) {
				    for (Cell cell : row) {
				    	printcellvalue(cell,row);
				    	
				    }
				}
				
			} else if (str1.equalsIgnoreCase("SUB")) {
				System.out.println("This is Sub");
			} else if (str1.equalsIgnoreCase("Div")) {
				System.out.println("This is Div");
			}else if (str1.equalsIgnoreCase("Mult")) {
				System.out.println("This is Multi");
			}
             }

          /*  System.out.println(workbook.getNumberOfSheets());
            int numberofsheets=workbook.getNumberOfSheets();
            for (int i = 0; i <= numberofsheets; i++) {
				switch (workbook.getSheetAt(i).get) {
				case value:
					
					break;

				default:
					break;
				}
			}
            
            // Get the first worksheet
            XSSFSheet sheet = workbook.getSheetAt(0);
            int noofsheets=sheet.getSheetName().length();
            System.out.println(noofsheets);

            // Iterate through each rows
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext())
            {
                // Get Each Row
                Row row = rowIterator.next();

                // Iterating through Each column of Each Row
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();

                    // Checking the cell format
                    switch (cell.getCellType())
                    {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    }
                }
                System.out.println("");
            }
*/
        } catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }
    public static void printcellvalue(Cell cell,Row row)
    {
    	switch (cell.getCellTypeEnum()) {
		case BOOLEAN:
			System.out.println(cell.getBooleanCellValue());
			break;
		case STRING:
			System.out.println(cell.getStringCellValue());
			cell.getRow().iterator();
			break;
		case NUMERIC:
			System.out.println(cell.getNumericCellValue());
			for (int i = 0; i < row.getRowNum(); i++) {
				for (int j = 0; j <= row.getLastCellNum(); j++) {
					double t1=row.getCell(j).getNumericCellValue();
					double t2=row.getCell(j+1).getNumericCellValue();
					double t3=t1+t2;
					System.out.println(t3);	
					}	
			}
			
			break;
		default:
			break;
		}
    }
}

