package com.learnautomation.selenium;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sun.jna.platform.win32.Netapi32Util.User;

public class ReadExcel {
    private static final String PATH_TO_EXCEL="resources\\user.xlsx";
    public static void main(String[] args) {
        new ReadExcel().readExcel(PATH_TO_EXCEL);
    }
    
    private void readExcel(String pathToExcel) {
        try {
            Workbook workbook = WorkbookFactory.create(new FileInputStream(pathToExcel));
            // If you have only one sheet you can get it by index of the sheet 
            //Sheet sheet = workbook.getSheetAt(0);
            Iterator<Sheet> sheetItr = workbook.sheetIterator();
            while(sheetItr.hasNext()) {
                Sheet sheet = sheetItr.next();
                // For Users sheet create List of objects
                if(sheet.getSheetName().equals("Users")) {
                    readExcelSheet(sheet);
                }else {
                    // For other sheet just print the cell values
                    printExcelSheet(sheet);
                }
            }
                        
        } catch (EncryptedDocumentException | IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void readExcelSheet(Sheet sheet) throws ParseException{
        System.out.println("Starting to read sheet- " + sheet.getSheetName());
        Iterator<Row> rowItr = sheet.iterator();
        List<User> userList = new ArrayList<>();
        // Iterate each row in the sheet
        while(rowItr.hasNext()) {
            User user = new User();
            Row row = rowItr.next();
            // First row is header so skip it
            if(row.getRowNum() == 0) {
                continue;
            }
            Iterator<Cell> cellItr = row.cellIterator();
            // Iterate each cell in a row
            while(cellItr.hasNext()) {
                
                Cell cell = cellItr.next();
                int index = cell.getColumnIndex();
                switch(index) {
                case 0:
                    user.setFirstName((String)getValueFromCell(cell));
                    break;
                case 1:
                    user.setLastName((String)getValueFromCell(cell));
                    break;
                case 2:
                    user.setEmail((String)getValueFromCell(cell));
                    break;
                case 3:
                    user.setDOB((Date)getValueFromCell(cell));
                    break;
                }
            }
            userList.add(user);
        }
        for(User user : userList) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail() + " " +  user.getDOB());
        }
        
    }
    
    private void printExcelSheet(Sheet sheet) throws ParseException{
        System.out.println("Starting to read sheet- " + sheet.getSheetName());
        Iterator<Row> rowItr = sheet.iterator();
        while(rowItr.hasNext()) {
            Row row = rowItr.next();
            if(row.getRowNum() == 0) {
                continue;
            }
            Iterator<Cell> cellItr = row.cellIterator();
            while(cellItr.hasNext()) {                
                Cell cell = cellItr.next();
                System.out.println("Cell Type- " + cell.getCellType().toString() + " Value- " + getValueFromCell(cell));
            }        
        }
    }
    
    // Method to get cell value based on cell type
    private Object getValueFromCell(Cell cell) {
        switch(cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                }
                return cell.getNumericCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";                                
        }
    }
}
