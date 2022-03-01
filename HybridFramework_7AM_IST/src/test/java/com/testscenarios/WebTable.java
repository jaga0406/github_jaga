package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class WebTable extends Locators {
	WebDriver driver;
	Properties prop = new Properties();      //properties
	
   @Test
     public void f() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
		 
		  WebElement delete = driver.findElement(Stqa_2rowdelete_button);
		  delete.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		  Thread.sleep(3000);
		  WebElement close = driver.findElement(Stqa_Close_button);
		  close.click();
		  Thread.sleep(3000); 
  }
   
  @BeforeClass
  public void beforeClass() throws InterruptedException, IOException {
	     WebDriverManager.chromedriver().browserVersion("98.0").setup();                   //webdrivermanager
	     driver = new ChromeDriver();
FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
         prop.load(propertyfilepath);              
	     
	     driver.get(prop.getProperty("Stqa_URl"));       //prop.getproperty
	     driver.manage().window().maximize();
	     Thread.sleep(3000);
  }
  
  @AfterClass
  public void afterClass() {
	     driver.quit();
  }

}
