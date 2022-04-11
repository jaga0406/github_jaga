package com.testscenarios;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.utilities.Commonfunctions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class AutomateTest extends Commonfunctions  {
	  Locators loc = new Locators();
   @Test
     public void f() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
	                
	          logger = Logger.getLogger(AutomateTest.class);
	          PropertyConfigurator.configure("log4j.properties");
	          
	          testcase = reports.createTest("verify Data");
	          testcase.log(Status.INFO, "Navigating to UI test");
	               
	           driver.get(prop.getProperty("UItest_URl"));
	           testcase.log(Status.INFO, "Successfully logged into website");
	           logger.info("Successfully logged into website");
	           implicitwait(20);
	           
	           ClickByAnyLocator(loc.button);
	           testcase.log(Status.INFO, "Successfully clicked the button");
	           logger.info("Successfully clicked the button");
	           
	           fluentwait(driver.findElement(loc.validate));
	           testcase.log(Status.INFO, "Successfully applied the wait script");
	           logger.info("Successfully executed the wait script");
	           
	           assertByElementText(loc.validate, "Data calculated on the client side.");
	           testcase.log(Status.PASS, "Data sucessfully calculated");
	           logger.info("Validation is successful");
 }
  @Parameters("browsername") 
  @BeforeClass
  public void beforeClass(@Optional("chrome") String browsername) throws Exception {
	  reports.attachReporter(htmlreporter);
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
	     reports.flush();
	     driver.quit();
  }

}
