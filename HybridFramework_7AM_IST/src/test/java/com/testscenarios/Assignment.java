package com.testscenarios;

import org.testng.annotations.Test;





import com.objectrepository.Locators;
import com.utilities.Commonfunctions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import java.io.FileInputStream;
import java.util.ArrayList;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Assignment extends Commonfunctions { 
	
	   Locators loc = new Locators();
	   
	   String Jobtitle = "Test Automation Engineer/Jr. Software Developer in Durham, North Carolina";
       String tasks = "Create test automation scripts for UI applications";
	   String skills = "Bachelor's degree (or higher) or equivalent in Electrical or Electronics Engineering";
	   String skills1 = "Automation tools: Selenium, Cucumber/Gherkin, TestNg, Jenkins/CICD pipeline integration";
	   String JobID = "Job Id : 22-79588";
	   
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
	       ClickByAnyLocator(loc.SearchButton);
	       implicitwait(10);
	       
           ClickByAnyLocator(loc.Title);
	       implicitwait(10);
	       
	       String pagetitle = driver.getTitle();
	       System.out.println(pagetitle);
		   Assert.assertTrue(pagetitle.contains(Jobtitle));
		   
		   loopAllFramesForElement(loc.responsibilities);
		   String jlocat = driver.findElement(loc.responsibilities).getText();
		   System.out.println(jlocat);
		   Assert.assertTrue(jlocat.contains(tasks));
		   
		   loopAllFramesForElement(loc.general);
		   String degree = driver.findElement(loc.general).getText();
		   System.out.println(degree);
		   Assert.assertTrue(degree.contains(skills));
		   
		   loopAllFramesForElement(loc.technical);
		   String automation = driver.findElement(loc.technical).getText();
		   System.out.println(automation);
		   Assert.assertTrue(automation.contains(skills1));
		   
           loopAllFramesForElement(loc.JOBID);
		   String id = driver.findElement(loc.JOBID).getText();
		   System.out.println(id);
		   Assert.assertEquals(id, JobID);
		   
		   loopAllFramesForElement(loc.applynow);
		   ClickByAnyLocator(loc.applynow);
		   
		   ArrayList<String> AllTab = new ArrayList<String>(driver.getWindowHandles());
   	       driver.switchTo().window(AllTab.get(3));
   	       
   	       loopAllFramesForElement(loc.back);
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
