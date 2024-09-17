package com.hk.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hk.helper.Base;

public class XLUtils extends Base{

	public  FileInputStream fis;
	public  FileOutputStream fos;
	public  XSSFWorkbook wb;
	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  CellStyle cellStyle;
	public  String path = null;
	
	public XLUtils(String path) {

		this.path = path;
	}
	
	public  int getRowCount(String sheetName) throws IOException {
		
		fis = new FileInputStream(sheetName);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	public  int getCellCount(String sheetName,int rowNum) throws IOException {
		
		fis = new FileInputStream(sheetName);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;	
	}
	
	public  String getCellData(String sheetName,int rowNum,int colNum) throws IOException {
		
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fis.close();
		return data;
	}
	
    public String setCellData(String sheetName,int rowNum,int colNum,String data) throws IOException {
		
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		
		fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		return data;
	}

}
