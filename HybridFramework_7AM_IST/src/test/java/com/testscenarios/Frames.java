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

public class Frames extends Commonfunctions  {
	  
	   Locators loc = new Locators();
   @Test
     public void f() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
	           driver.get(prop.getProperty("toyota_URL"));
	           loopAllFramesForElement(loc.downloadbutton);
	           ClickByAnyLocator(loc.downloadbutton);
//	           Thread.sleep(3000);
//	           loopAllFramesForElement(loc.element);
//	           System.out.println(driver.findElement(loc.element).getText());
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
