package com.utilities;

import java.io.File;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Commonfunctions extends BaseClass {
	
	
	public void chromebrowserlaunch() throws Exception {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	public void operabrowserlaunch() throws Exception {
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	public void firefoxdriverlaunch() throws Exception {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	public void edgebrowserlaunch() throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
      public void SendkeysByAnyLocator(By locator, String inputdata) {
     try {  WebElement ele = driver.findElement(locator);
	   
     if (ele.isDisplayed()&&ele.isEnabled()) {
    	 highlightElement(ele);
     	ele.clear();
     	highlightElement(ele);
     	ele.sendKeys(inputdata);
       }	
    }      catch (Exception e) {
		e.printStackTrace();
    }  
  }
      
   public void ClickByAnyLocator(By locator) {
    try {  WebElement ele = driver.findElement(locator);
	   
    if (ele.isDisplayed()&&ele.isEnabled()) {
    	highlightElement(ele);
    	ele.click();
    	
      }	
   }      catch (Exception e) {
		e.printStackTrace();
   }  
       }
   
   
    public void ClickUsingJavaScript(By locator) throws Exception {
	   WebElement element = driver.findElement(locator);
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
	   highlightElement(element);
	   executor.executeScript("arguments[0].click();", element);
    }  
	public void highlightElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border = '6px groove green'" ,element);
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border = ''" ,element);
    }
	 
	
	 public void explicitlyWaitForElementToBeClickable(By locator) {
		 WebElement LoginButton = driver.findElement(locator);
		 WebDriverWait ww =  new WebDriverWait(driver, Duration.ofSeconds(25));    //explicitwait
		 ww.until(ExpectedConditions.elementToBeClickable(LoginButton));
	 }


     public void implicitwait(int time) {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    	 System.out.println("Implicit time occured");
     }
     
     public String TimeStamp() {
   	  Date d = new Date();
   	  SimpleDateFormat df = new SimpleDateFormat("ddMMyyy_HHmmss");
   	  String timestamp = df.format(d);
   	  return timestamp; 
     }
     public void TakeScreenshot() throws Exception {
   	  File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	  String screenshotPath = ".\\screenshots\\" ;
   	  FileHandler.copy(scr, new File(screenshotPath + "NordStorm" + TimeStamp() + ".PNG" ));
   	  System.out.println("screenshot Taken");
   }
     public void TakeScreenshot(ITestResult res) throws Exception {
   	  projectDir=  System.getProperty("user.dir");
   	  screenshotPath= projectDir + ".\\screenshots\\" ;
   	  className = res.getTestClass().getName().trim();
   	  methodName = res.getName().trim();
   	  //STATUS_packagename.classname_methodname_timestamp.png
   	  if (res.getStatus()==ITestResult.SUCCESS) {
   		  File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		  FileHandler.copy(scr, new File(screenshotPath+ "PASS_" +className+ "_" +methodName+ "_" +TimeStamp()+ ".PNG"));
    }
   	  if (res.getStatus()==ITestResult.FAILURE) {
   		  File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		  FileHandler.copy(scr, new File(screenshotPath+ "FAIL_" +className+ "_" +methodName+ "_" +TimeStamp()+ ".PNG"));
   	} 
   }
     
     
     
     
}
	
	
	