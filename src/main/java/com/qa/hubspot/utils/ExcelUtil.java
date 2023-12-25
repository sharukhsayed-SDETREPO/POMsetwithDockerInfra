package com.qa.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	
	
	
	  private static Workbook book;
	  private static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public  static Object[][] GetExcelUtilData(String ExcelName,String SheetName) {
		
		Object[][] data=null;
		try {
			FileInputStream ip =new FileInputStream("./src/main/java/com/qa/hubspot/testdata/"+ExcelName+".xlsx");
			book =WorkbookFactory.create(ip);
			sheet=book.getSheet(SheetName);
			int lastrow=sheet.getLastRowNum();
			int lastcol=sheet.getRow(0).getLastCellNum();
			data=new Object[lastrow][lastcol];
			
			
			for (int i=0;i<lastrow;i++) {
				
				for(int j= 0;j<lastcol;j++) {
					
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return data;
		
	}
	
	
	


}
