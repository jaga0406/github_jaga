package com.testscenarios;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;


import com.objectrepository.Locators;
import com.utilities.Commonfunctions;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;

import java.io.IOException;


import org.testng.annotations.AfterClass;

public class DataDrivenJxl extends Commonfunctions  {
	  
	   Locators loc = new Locators();
	   String[][] data = null;
	   
	   @DataProvider(name= "logindata")
	   public String[][] Logindataprovider() throws BiffException, IOException{
		   data = getExcelData();
		   return data;
	   }
	  public String[][] getExcelData() throws BiffException, IOException {
		  FileInputStream excel = new FileInputStream("C:\\Users\\admin\\testleaf.xls");
	      Workbook workbook = Workbook.getWorkbook(excel);
	      Sheet sheet = workbook.getSheet(0);
	      int rowscount = sheet.getRows();
	      int columncount = sheet.getColumns();
	      String testdata[][] = new String[rowscount-1][columncount];
	      for (int i = 1; i < rowscount; i++) {
	    	  for (int j = 0; j < columncount; j++) {
	    		  testdata[i-1][j] = sheet.getCell(j, i).getContents();	
			}
		}	      
	      return testdata;
	  }
   
   @Test(dataProvider = "logindata")
     public void bothcorrect(String Uname, String pass) throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
	           driver.get(prop.getProperty("Orange_Hrm"));
	      SendkeysByAnyLocator(loc.Ousername, Uname);      
	      SendkeysByAnyLocator(loc.Opass, pass);
	      ClickByAnyLocator(loc.Ologin);
	      implicitwait(10);
	  }
   
  @Parameters("browsername") 
  @BeforeClass
  public void beforeClass(@Optional("chrome") String browsername) throws Exception {
	  if (browsername.equalsIgnoreCase("chrome")) {
		   chromebrowserlaunch();
	} else if (browsername.equalsIgnoreCase("edge")) {
		   edgebrowserlaunch();
	} else if (browsername.equalsIgnoreCase("firefox")) {
		   firefoxdriverlaunch();
	} else if (browsername.equalsIgnoreCase("opera")) {
		   operabrowserlaunch();
	} else {
		System.out.println("enter valid browsers from chrome/firefox/edge");
	}
 }
  
  @AfterClass
  public void afterClass() {
	     driver.quit();
  }

}
