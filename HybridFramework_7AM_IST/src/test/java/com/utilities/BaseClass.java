package com.utilities;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop = new Properties();  //properties
	public static String projectDir;
	public static String screenshotPath;
	public static String className;
	public static String methodName;
	public static Actions actions;
	public static JavascriptExecutor js;
    public static ExtentReports reports = new ExtentReports();
    public static ExtentTest testcase; 
    public static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("ExtentReport.html");
    public static Logger logger;
    
   
    
}
