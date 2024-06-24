package com.zettamine.java.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelDocTest {

	public static void main(String[] args) {
		/*
		Workbook wb = new HSSFWorkbook();  
        try(OutputStream fileOut = new FileOutputStream("zettamine.xls")) { 
        	Sheet sheet1 = wb.createSheet("First Sheet");  
            Sheet sheet2 = wb.createSheet("Second Sheet");  
            
            Row row     = sheet1.createRow(2);  
            Cell cell   = row.createCell(5);  
            cell.setCellValue("Zettamine");
            
            wb.write(fileOut);  
        }catch(Exception e) {  
            System.out.println(e.getMessage());  
        }  
		*/
        Workbook workbook = new HSSFWorkbook(); 
        
        // Creating a blank Excel sheet 
        Sheet sheet 
            = workbook.createSheet("student Details"); 
  
        // Creating an empty TreeMap of string and Object][] 
        // type 
        Map<String, Object[]> data 
            = new TreeMap<String, Object[]>(); 
  
        // Writing data to Object[] 
        // using put() method 
        data.put("1", 
                 new Object[] { "ID", "NAME", "LASTNAME" }); 
        data.put("2", 
                 new Object[] { 1, "Pankaj", "Kumar" }); 
        data.put("3", 
                 new Object[] { 2, "Prakashni", "Yadav" }); 
        data.put("4", new Object[] { 3, "Ayan", "Mondal" }); 
        data.put("5", new Object[] { 4, "Virat", "kohli" }); 
  
        // Iterating over data and writing it to sheet 
        Set<String> keyset = data.keySet(); 
  
        int rownum = 0; 
  
        for (String key : keyset) { 
  
            // Creating a new row in the sheet 
            Row row = sheet.createRow(rownum++); 
  
            Object[] objArr = data.get(key); 
  
            int cellnum = 0; 
  
            for (Object obj : objArr) { 
  
                // This line creates a cell in the next 
                //  column of that row 
                Cell cell = row.createCell(cellnum++); 
  
                if (obj instanceof String) 
                    cell.setCellValue((String)obj); 
  
                else if (obj instanceof Integer) 
                    cell.setCellValue((Integer)obj); 
            } 
        } 
  
        // Try block to check for exceptions 
        try { 
  
            // Writing the workbook 
            FileOutputStream out = new FileOutputStream( new File("zettamine.xls")); 
            workbook.write(out); 
  
            // Closing file output connections 
            out.close(); 
  
            // Console message for successful execution of 
            // program 
            System.out.println( "zettamine.xlsx written successfully on disk."); 
        } 
  
        // Catch block to handle exceptions 
        catch (Exception e) { 
  
            // Display exceptions along with line number 
            // using printStackTrace() method 
            e.printStackTrace(); 
        } 

	}

}
