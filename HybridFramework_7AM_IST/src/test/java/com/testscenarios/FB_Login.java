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

public class FB_Login extends Commonfunctions {
	
	   Locators loc = new Locators();
	
   @Test
     public void Fb() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
	        driver.get(prop.getProperty("FB_URL")); 
	       implicitwait(10);
	       SendkeysByAnyLocator(loc.FBlogin_Email_Editbox, prop.getProperty("Username"));
	       SendkeysByAnyLocator(loc.FBlogin_Password_Editbox, prop.getProperty("Password"));
	       explicitlyWaitForElementToBeClickable(loc.FBlogin_Login_Button);
	       ClickByAnyLocator(loc.FBlogin_Login_Button);
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

  
  @Test
  public void ttd() {
	  driver.get(prop.getProperty("ttd_URL"));
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
