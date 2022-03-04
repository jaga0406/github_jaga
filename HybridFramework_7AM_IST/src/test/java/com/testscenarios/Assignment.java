package com.testscenarios;

import org.testng.annotations.Test;




import com.objectrepository.Locators;
import com.utilities.Commonfunctions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Assignment extends Commonfunctions {
	
	   Locators loc = new Locators();
	   
	   String Jobtitle = "Senior Systems Specialist (Testing) in Bangalore, India | Business Development "
	   		               + "and Commercial at Labcorp";
	   
	   String Description = "Implement processes and methods that result in faster and efficient QA cycle.";		                
	   String JobID = "Job Id : 61994";
	   
   @Test
     public void Fb() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
	        driver.get(prop.getProperty("labcorp_URL")); 
	       implicitwait(10);
	       ClickByAnyLocator(loc.careers);
	       implicitwait(10);
	       ArrayList<String> AllTabs = new ArrayList<String>(driver.getWindowHandles());
   	       driver.switchTo().window(AllTabs.get(2));
	       SendkeysByAnyLocator(loc.searchForJob, prop.getProperty("Jobtitle"));
	       SendkeysByAnyLocator(loc.Location, prop.getProperty("jobLocation"));
	       ClickByAnyLocator(loc.SearchButton);
	       implicitwait(10);
	       ClickByAnyLocator(loc.searchbutton2);
	       implicitwait(10);
	       ClickByAnyLocator(loc.Title);
	       implicitwait(10);
	       String pagetitle = driver.getTitle();
	       System.out.println(pagetitle);
		   Assert.assertEquals(pagetitle, Jobtitle);
		   loopAllFramesForElement(loc.Implements);
		   String jlocat = driver.findElement(loc.Implements).getText();
		   System.out.println(jlocat);
		   Assert.assertEquals(jlocat, Description);
		   loopAllFramesForElement(loc.JOBID);
		   String id = driver.findElement(loc.JOBID).getText();
		   System.out.println(id);
		   Assert.assertEquals(id, JobID);
		   loopAllFramesForElement(loc.applynow);
		   ClickByAnyLocator(loc.applynow);
		   ArrayList<String> AllTab = new ArrayList<String>(driver.getWindowHandles());
   	       driver.switchTo().window(AllTab.get(3));
   	       ClickByAnyLocator(loc.back);
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
