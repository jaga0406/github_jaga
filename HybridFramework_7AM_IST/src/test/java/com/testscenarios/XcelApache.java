package com.testscenarios;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelApache {

	public static void main(String[] args) throws IOException {
       FileInputStream fi = new FileInputStream("C:\\Users\\admin\\test.xlsx");
       Workbook wb = new XSSFWorkbook(fi);
       Sheet ws = wb.getSheet("sheet1");
       Row r = ws.getRow(1);
       Cell c = r.getCell(0);
       System.out.println(c.getStringCellValue());
	}

}
