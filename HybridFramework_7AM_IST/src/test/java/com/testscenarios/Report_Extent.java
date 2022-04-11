package com.testscenarios;

import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.utilities.Commonfunctions;




import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;

public class Report_Extent extends Commonfunctions  {
	  
	   Locators loc = new Locators();
   @Test
     public void opengoogle() throws Exception {
         driver.get(prop.getProperty("google_URL"));
         testcase = reports.createTest("verify google");
         testcase.log(Status.INFO, "Navigating to google");
	String title = driver.getTitle();
	     testcase.log(Status.INFO, "Actual title:" +title);
	     testcase.log(Status.INFO, "Expected title:" + "Google");
	     testcase.log(Status.INFO, "Verification of Actual & Expected title");
	if (title.equals("Google")) {
        testcase.log(Status.PASS, "Actual title & expected title are equal");
	} else {
        testcase.log(Status.FAIL, "Actual title & expected title are not equal");	
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = ".\\screenshots\\" ;
     	FileHandler.copy(scr, new File(screenshotPath+ "google.png"));
     	System.out.println("screenshot Taken");
     	 testcase.addScreenCaptureFromPath("google.png");
     }
}
   
   @Test
   public void openbing() throws Exception {
	   driver.get(prop.getProperty("bing_URl"));
       testcase = reports.createTest("verify bing");
       testcase.log(Status.INFO, "Navigating to bing");
	String title = driver.getTitle();
	     testcase.log(Status.INFO, "Actual title:" +title);
	     testcase.log(Status.INFO, "Expected title:" + "bing");
	     testcase.log(Status.INFO, "Verification of Actual & Expected title");
	if (title.equals("bing")) {
      testcase.log(Status.PASS, "Actual title & expected title are equal");
	} else {
      testcase.log(Status.FAIL, "Actual title & expected title are not equal");	
      File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String screenshotPath = ".\\screenshots\\" ;
   	  FileHandler.copy(scr, new File(screenshotPath+ "bing.png"));
   	  System.out.println("screenshot Taken"); 
   	  testcase.addScreenCaptureFromPath("bing.png");
}
   }  
   
 @Test
   public void openwiki() throws Exception {
	   driver.get(prop.getProperty("Wiki_URl"));
       testcase = reports.createTest("verify wikipedia");
       testcase.log(Status.INFO, "Navigating to wikipedia");
	String title = driver.getTitle();
	     testcase.log(Status.INFO, "Actual title:" +title);
	     testcase.log(Status.INFO, "Expected title:" + "Wikipedia");
	     testcase.log(Status.INFO, "Verification of Actual & Expected title");
	if (title.equals("Wikipedia")) {
      testcase.log(Status.PASS, "Actual title & expected title are equal");
	} else {
      testcase.log(Status.FAIL, "Actual title & expected title are not equal");	
      File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String screenshotPath = ".\\screenshots\\" ;
   	  FileHandler.copy(scr, new File(screenshotPath+ "wiki.png"));
   	  System.out.println("screenshot Taken"); 
   	  testcase.addScreenCaptureFromPath("wiki.png");
}
   } 
 
  @BeforeSuite
  public void beforeClass() throws Exception {
	  
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
        prop.load(propertyfilepath);               //fileinputstream .load
        reports.attachReporter(htmlreporter);
      String browser = prop.getProperty("browser_name");
	  if (browser.equalsIgnoreCase("chrome")) {
		   chromebrowserlaunch();
	} else if (browser.equalsIgnoreCase("edge")) {
		   edgebrowserlaunch();
	} else if (browser.equalsIgnoreCase("firefox")) {
		   firefoxdriverlaunch();
	} else if (browser.equalsIgnoreCase("opera")) {
		   operabrowserlaunch();
	} else {
		System.out.println("enter valid browsers from chrome/firefox/edge");
	}
}
  
  @AfterSuite
  public void afterClass() {
	    reports.flush();
	     driver.quit();
  }

}
