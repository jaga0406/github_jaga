package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	public final By FBlogin_Email_Editbox = By.id("email");
	public final By FBlogin_Password_Editbox = By.xpath("(//input[@type='password'])[1]");
	public final By FBlogin_Login_Button = By.xpath("(//button[@name='login'])[1]");
	
    public final By Stqa_2rowdelete_button = By.xpath("//table/tbody/tr[2]/td[6]/button");   //tablexpath
    public final By Stqa_Close_button = By.xpath("(//button[text()='Close'])[2]");           //xpath
    
    public final By city_print = By.xpath("//table/tbody/tr[14]/td[5]");
    public final By day_time_print = By.xpath("//table/tbody/tr[14]/td[6]");
    public final By Temp_print = By.xpath("//table/tbody/tr[14]/td[8]");
    
    public final By click_to_open = By.xpath("/html/body/div[1]/div/div[2]/a[2]/button");
    
    public final By New_tab = By.xpath("//button[@id='tabButton']");
    public final By New_window = By.xpath("//button[@id='windowButton']");
    
    public final By username = By.id("txtUsername");
    public final By password = By.id("txtPassword");
    
    public final By ttd_select = By.xpath("//select[@name='countryS']");
    public final By zonal = By.name("P-2Alist");
    public final By element = By.xpath("/html/body/table/tbody/tr[7]/td[5]/span");
    
    public final By downloadbutton = By.xpath("//*[@id=\'delivery_method\']/div/ul/li[2]/a/div/div");
    
    public final By Ousername = By.id("txtUsername");
    public final By Opass = By.id("txtPassword");
    public final By Ologin = By.id("btnLogin");
    
    public final By careers = By.xpath("//a[text()='Careers']");
    public final By searchForJob = By.xpath("(//input[@id='typehead'])[2]");
    public final By Location = By.xpath("//input[@id='gllocationInput']");
    public final By SearchButton = By.xpath("(//button[@id='ph-search-backdrop'])[2]");
    public final By Title = By.xpath("//*[starts-with(text(), 'Test Automation')]");
    public final By responsibilities = By.xpath("//*[@style = 'margin-bottom: 6.0pt;text-align: justify;']/following::li[1]");
    public final By general = By.xpath("//*[@style = 'margin-bottom: 6.0pt;text-align: justify;']/following::li[30]");
    public final By technical = By.xpath("//*[@style = 'margin-bottom: 6.0pt;text-align: justify;']/following::li[40]"); 
    public final By JOBID = By.xpath("//span[@class = 'au-target jobId']");
    public final By applynow = By.xpath("(//a[@role = 'button'])[3]");
    public final By back = By.xpath("(//button[@type = 'button'])[2]");
    
    public final By calculator = By.xpath("(//span[@class = 'icon icon-fin-calculator'])[9]");
    public final By car = By.xpath("//select[@id = 'codeweaversModels']");
 
}
