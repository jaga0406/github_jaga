package com.testscenarios;

import java.io.FileInputStream;
import java.util.ArrayList;


import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.Commonfunctions;

public class ToyotaAsst extends Commonfunctions {
	   
	Locators loc = new Locators();
	
	@Test
    public void Fb() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
	       driver.get(prop.getProperty("toyota_URL")); 
	       implicitwait(10);
	       
	       loopAllFramesForElement(loc.calculator);
	       Thread.sleep(3000);
	       ClickByAnyLocator(loc.calculator);
	       
	       
	       ArrayList<String> AllTabs = new ArrayList<String>(driver.getWindowHandles());
   	       driver.switchTo().window(AllTabs.get(1));
   	       implicitwait(10);
   	       loopAllFramesForElement(loc.car);
   	       Select yourcar = new Select(driver.findElement(loc.car));
   	       yourcar.selectByVisibleText("Corolla");
   	       
   	       Thread.sleep(5000);
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
			  implicitwait(10);  
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
