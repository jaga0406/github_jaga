package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Weather extends Locators {
	WebDriver driver;
	Properties prop = new Properties();      //properties
	
   @Test
     public void f() throws Exception {
	FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
	                prop.load(propertyfilepath);               //fileinputstream .load
		 
		  WebElement city = driver.findElement(city_print);
		  String location = city.getText(); 
		  System.out.println("mana ooru:" +location);
		  WebElement dt = driver.findElement(day_time_print);
		  String neram = dt.getText(); 
		  System.out.println(neram);
		  WebElement element = driver.findElement(Temp_print);
		  String temp = element.getText(); 
		  System.out.println("temperature is:" +temp);
		  Thread.sleep(2000);  
  }
   
  @BeforeClass
  public void beforeClass() throws InterruptedException, IOException {
	     WebDriverManager.chromedriver().browserVersion("98.0").setup();                   //webdrivermanager
	     driver = new ChromeDriver();
FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/inputs.properties");
         prop.load(propertyfilepath);              
	     
	     driver.get(prop.getProperty("Weather_URL"));       //prop.getproperty
	     driver.manage().window().maximize();
	     Thread.sleep(3000);
  }
  
  @AfterClass
  public void afterClass() {
	     driver.quit();
  }

}
