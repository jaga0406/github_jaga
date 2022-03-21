package com.testscenarios;

import org.testng.annotations.Test;




import com.objectrepository.Locators;
import com.utilities.Commonfunctions;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;

import java.util.ArrayList;

import java.util.Set;

import org.testng.annotations.AfterClass;

public class PopUpHandle extends Commonfunctions  {
	  
	   Locators loc = new Locators();
   @Test
     public void popup() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
	   driver.get(prop.getProperty("Stqa_window"));
	   String mainWindowName = driver.getWindowHandle();
	   System.out.println(mainWindowName);
	   ClickByAnyLocator(loc.click_to_open);
	   implicitwait(20); 
	   Set<String> allWindowNames = driver.getWindowHandles();
	   System.out.println(allWindowNames);
	   Thread.sleep(2000);
	   for (String abc: allWindowNames) { 
		     if (!mainWindowName.equalsIgnoreCase(abc)) {
				driver.switchTo().window(abc);
				driver.close();
			}
		
		
	}
   }
   
   @Test
   public void tab() throws Exception {
	       
	   FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
       prop.load(propertyfilepath);
    	    driver.get(prop.getProperty("Demo_tab"));
    	    String mainWindow = driver.getWindowHandle();
    	    System.out.println(mainWindow);
    	    ClickByAnyLocator(loc.New_tab);
    	    implicitwait(20);
    	    ArrayList<String> AllTabs = new ArrayList<String>(driver.getWindowHandles());
    	    driver.switchTo().window(AllTabs.get(2));
    	    Thread.sleep(2000);
    	    driver.close();
	        Thread.sleep(2000);
    }
   
   @Test
   public void popup2() throws Exception {
	      
	    FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
        prop.load(propertyfilepath);
    	driver.get(prop.getProperty("Demo_tab"));
    	String mainWindow = driver.getWindowHandle();
    	System.out.println(mainWindow);
	    ClickByAnyLocator(loc.New_window);
	    implicitwait(20);
	    Set<String> allwindowpops = driver.getWindowHandles();
	    Thread.sleep(2000);
	    for (String def : allwindowpops) {
			if (!mainWindow.equalsIgnoreCase(def)) {
				driver.switchTo().window(def);
				driver.close();
				
   }
  
	    }  
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
  
  @AfterClass
  public void afterClass() {
	      driver.quit();
  }

}
