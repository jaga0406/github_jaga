package com.testscenarios;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.Commonfunctions;

public class XcelApache extends Commonfunctions {
    Locators loc = new Locators();
    @Test
    public void fb() throws Exception {
    FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
       prop.load(propertyfilepath);               //fileinputstream .load
       chromebrowserlaunch(); 
       driver.get(prop.getProperty("FB_URL")); 
  
  
       
	   String path = "C:\\Users\\admin\\FB.xlsx";
       FileInputStream fi = new FileInputStream(path);
       Workbook wb = new XSSFWorkbook(fi);
       Sheet ws = wb.getSheet("Sheet1");
      
       Row row = ws.getRow(1);
      Cell c = row.getCell(0);
       String un = c.getStringCellValue();
       
       Cell c1 = row.getCell(1);
       String pwd = c1.getStringCellValue();
       
       int lastrow = ws.getLastRowNum();
       System.out.println(lastrow);
       int lastcel = row.getLastCellNum();
       System.out.println(lastcel);
       SendkeysByAnyLocator(loc.FBlogin_Email_Editbox, un);
       SendkeysByAnyLocator(loc.FBlogin_Password_Editbox, pwd);
       explicitlyWaitForElementToBeClickable(loc.FBlogin_Login_Button);
       ClickByAnyLocator(loc.FBlogin_Login_Button);
       Thread.sleep(5000);
       
       String wpwd = driver.findElement(By.xpath("//*[contains(text(), 'The password')]")).getText();
       System.out.println(wpwd);
       if (wpwd.contains("The password that you've entered is" )) {
		System.out.println("Type the correct password");
	} else {
		System.out.println("The password is correct");
	}
    }    
}     
     
      
     
       
//       for (int i = 0; i <= lastrow; i++) {
//		  Row row = ws.getRow(i);   
//		  int lastcell = row.getLastCellNum();   
//		  for (int j = 0; j < lastcell; j++) {
//			  Cell cell = row.getCell(j);   
//			  String value = cell.getStringCellValue();
//			  System.out.println(value);
//		}
//		  System.out.println();
//	}
       

       
       
       
       
       
	
