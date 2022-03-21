package com.testscenarios;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.objectrepository.Locators;


public class ApachePOI extends DataDrivenJxl {
	Locators loc = new Locators();
	static List<String> usernamelist = new ArrayList<String>();
	static List<String> passwordlist = new ArrayList<String>();
	
	public void readExcel() throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\admin\\test.xlsx");
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowiterator = sheet.iterator();
		while (rowiterator.hasNext()) {
			  Row rowvalue = rowiterator.next();
	    Iterator<Cell> columniterator = rowvalue.iterator();
	        int i = 2;
			while (columniterator.hasNext()) {
				if (i%2==0) {
					usernamelist.add(columniterator.next().getStringCellValue());
				}else {
					passwordlist.add(columniterator.next().getStringCellValue());
				}
				 i++;	
			}  	  
		}
	}
	
 
	public void executetest() throws Exception {
		for (int i = 0; i < usernamelist.size(); i++) {
			bothcorrect(usernamelist.get(i), passwordlist.get(i));
		}
	}
	
	
	

	public static void main(String[] args) throws Exception {
		ApachePOI exceldata = new ApachePOI();
		exceldata.beforeClass("chrome");
		exceldata.readExcel();
		System.out.println("usernamelist is:" +usernamelist);
		System.out.println("usernamelist is:" +passwordlist);
		exceldata.executetest();
		exceldata.afterClass();
	}
}



	

