package com.testscenarios;

import org.testng.annotations.Test;



import com.objectrepository.Locators;
import com.utilities.Commonfunctions;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;


import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TTDdropdownsGetOptions extends Commonfunctions  {
	  
	   Locators loc = new Locators();
   @Test
     public void f() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
	           driver.get(prop.getProperty("ttd_URL2"));
	      implicitwait(20);
	      ClickByAnyLocator(loc.clickcnd);
	      Thread.sleep(3000);
	      selectByVisibleText(loc.year, "2012");
	      Thread.sleep(3000);
	      selectByVisibleText(loc.month, "September");
	      Thread.sleep(3000);
	      ClickByAnyLocator(loc.date);
	      selectByVisibleText(loc.country, "Antarctica");
	      getSelectedOption(loc.country);
	      SendkeysByAnyLocator(loc.address, prop.getProperty("My_address"));
          Thread.sleep(2000);
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
  
  
  @AfterMethod
  public void TakeScreenshotofEachMethod(ITestResult res) throws Exception {
	  TakeScreenshot(res);
  }
  
  @AfterClass
  public void afterClass() {
	     driver.quit();
  }

}
