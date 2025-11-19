package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.BaseClass.BaseClass;

public class ExcelReder extends BaseClass{
	
	public static FileInputStream readExcelData(String excelname) throws FileNotFoundException {
		FileInputStream fis=new FileInputStream(projectpath +"/src/main/resources/ExcelData/"+excelname);
		return fis;
		
	}
	public static Sheet readSheet(String sheetname,FileInputStream fis) throws  IOException {
		
		Sheet sh= WorkbookFactory.create(fis).getSheet(sheetname);
		return sh;
	
	}
	public static Object readSingelCellData(Sheet sh,int rownum,int cellnum) {
		if(sh.getRow(rownum).getCell(cellnum).getCellType().toString().equalsIgnoreCase("String"))
		   return sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		   else
	 
				return sh.getRow(rownum).getCell(cellnum).getNumericCellValue();
	}
	public static Map<String, Object> readRowData(Sheet sh,int rownum) {
		
		int cellnum=sh.getRow(rownum).getLastCellNum();
		Map<String,Object> rowdata=new HashMap<String, Object>();
		for(int i=0;i<cellnum;i++) {
			if(sh.getRow(rownum).getCell(i).getCellType().toString().equalsIgnoreCase("String"))
				rowdata.put(sh.getRow(0).getCell(i).getStringCellValue(), 
						sh.getRow(rownum).getCell(i).getStringCellValue());
			else
				rowdata.put(sh.getRow(0).getCell(i).getStringCellValue(),
						sh.getRow(rownum).getCell(i).getNumericCellValue());
				}
		return rowdata;
		}
	public static Object[][] readAllData(Sheet sh) {
		
		int rowcount=sh.getLastRowNum();
		Object[][] exceldata=new Object[rowcount][1];
		for(int i=0;i<rowcount;i++) {
			Map<String,Object> rowdata=new HashMap<String, Object>();
			int cellnum=sh.getRow(i).getLastCellNum();
			for(int j=0;j<cellnum;j++) {
				if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("String"))
					rowdata.put(sh.getRow(0).getCell(j).getStringCellValue(), 
							sh.getRow(i+1).getCell(j).getStringCellValue());
				else
					rowdata.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i+1).getCell(j).getNumericCellValue());
				
			}
			exceldata[rowcount][0]=rowdata;
		}
		return exceldata;
		
	}
	
	
	
}
