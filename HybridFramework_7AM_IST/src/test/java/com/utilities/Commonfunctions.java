package com.utilities;

import java.io.File;






import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Commonfunctions extends BaseClass {
	
	public Commonfunctions() {
		File f = new File("./screenshots");
		if (f.exists()) {
			System.out.println("system has screenshots folder already...");
		}else {
			f.mkdir();
			System.out.println("system has created a new screenshot folder...");
		}
	}
	
	
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
		 WebDriverWait ww =  new WebDriverWait(driver, Duration.ofSeconds(20));    //explicitwait
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
     
     
     public void printAllDropdownValues(By locator) {
    	 WebElement element = driver.findElement(locator);
    	 if (element.isDisplayed()) {
    		 if (element.isEnabled()) {
    			 Select dropdown = new Select(element);
    			 List<WebElement> dropdownvalues = dropdown.getOptions();
				 System.out.println(dropdownvalues.size());
				 for (WebElement allvalues : dropdownvalues) {
					 System.out.println(allvalues.getText());
				}
    		 }else  {
				 System.out.println("The element is not enabled");
    		 }
			}else {
				System.out.println("The element is not displayed");
			}
    	 
		}
   
    public void  selectCustomiseOptionFromTheDropdownValue(By locator, String visibletext) {
    	 WebElement element = driver.findElement(locator);
    	 if (element.isDisplayed()) {
    		 if (element.isEnabled()) {
    			 Select dropdown = new Select(element);
    			 List<WebElement> dropdownvalues = dropdown.getOptions();
				 System.out.println(dropdownvalues.size());
				 for (int i = 0; i < dropdownvalues.size(); i++) {
					 System.out.println(dropdownvalues.get(i).getText());
					if (dropdownvalues.get(i).getText().equals(visibletext)) {
						dropdown.selectByIndex(i);
						break;
					}
				} 
    		 } else { 
    			 System.out.println("The element is not enabled");
			}
    	 }else {
    		 System.out.println("The element is not displayed");
		}
     }
     
     public void moveToonElement(By locator) {
    	 Actions actions = new Actions(driver);
    	 try {
		   WebElement element = driver.findElement(locator);
    	   actions.moveToElement(element).build().perform();
    	 } catch (Exception e) {
 			System.out.println("Error in description: " + e.getStackTrace());
 		}
    	 
    	 
     }
      public int iFramesCount() {
    	  driver.switchTo().defaultContent();
    	  js=(JavascriptExecutor)driver;
    	  int numberofFrames = 0;
    	  numberofFrames = Integer.parseInt(js.executeScript("return window.length").toString());
    	  System.out.println("No of iframes on this page is:" + numberofFrames);
    	  return numberofFrames;
      }
      
      public void switchToFramebyInt(int i) {
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame(i);
     }
      
      public int loopAllFramesForElement(By locator) {
    	  int elementpresencecount = 0;
    	  int loop = 0;
    	  int maxFrameCount = iFramesCount();
    	  elementpresencecount = driver.findElements(locator).size();
    	  while (elementpresencecount == 0 && loop<maxFrameCount) {
    		 try {
			  switchToFramebyInt(loop);
    		  elementpresencecount = driver.findElements(locator).size();
    		  System.out.println("Try LoopAllframesAndReturnWebEL : " + loop + "; ElementpresenceCount: "
						+ elementpresencecount);
    		  if (elementpresencecount > 0 || loop>maxFrameCount ) {
				        break;
			}
    			} catch (Exception ex) {
    				System.out.println("Catch LoopAllframesAndReturnWebEL Old:" + loop + ";" + ex);
    			}
		 
    	  loop++;
     }
        return elementpresencecount;
   }
   
      public void getSelectedOption(By locator) {
    	  Select select = new Select(driver.findElement(locator));
    	  WebElement options = select.getFirstSelectedOption();
    	  String defaultItem = options.getText();
    	  System.out.println(defaultItem);
      }
      
      public void selectByVisibleText(By locater, String visibleText) {

  		WebElement element = driver.findElement(locater);
  		if (element.isDisplayed()) {
  			if (element.isEnabled()) {
  				Select dropdown = new Select(element);
  				dropdown.selectByVisibleText(visibleText);
  			} else {
  				System.out.println("The webelement is NOT Enabled, please check**************");
  			}
  		} else {
  			System.out.println("The webelement is NOT displayed, please check**************");
  		}

  	}
      
      public void assertByElementText(By locator, String expectedText) {
    	  WebElement element = driver.findElement(locator);
  		try {
  			String ActualMsg = element.getText();
  			String ExpectedMsg = expectedText;
  			Assert.assertEquals(ActualMsg, ExpectedMsg);
  			System.out.println("************Assertion Done**********");
  		} catch (StaleElementReferenceException e) {
  			System.out.println("Element - " + element + " is not attached to the page document " + e.getStackTrace());
  		} catch (NoSuchElementException e) {
  			System.out.println("Element " + element + " was not found in DOM" + e.getStackTrace());
  		} catch (Exception e) {
  			System.out.println("Unable to find element " + e.getStackTrace());
  		}
  	}
     public void fluentwait(final WebElement El)  {
      Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			  .withTimeout(Duration.ofSeconds(30))
			  .pollingEvery(Duration.ofSeconds(2))
			  .ignoring(NoSuchElementException.class);

		WebElement visible =  wait.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	    	        return El;
			 }
	 });
		
     }  
  
 }
     
     
     
     

	
	
	