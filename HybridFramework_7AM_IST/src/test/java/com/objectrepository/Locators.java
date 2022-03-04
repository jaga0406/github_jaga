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
    public final By Title = By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/section[2]/div/div/div/div[2]/div[2]/ul/li[1]/div[1]/span/a/div/span");
    public final By Implements = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[1]/section/div/div/div[2]/div[2]/ul[1]/li[3]/span");
    public final By JOBID = By.xpath("//span[@class = 'au-target jobId']");
    public final By applynow = By.xpath("(//a[@role = 'button'])[3]");
    public final By back = By.xpath("/html/body/div[2]/div[3]/div/header/div[1]/div/ul/li[2]/a");
    public final By searchbutton2 = By.xpath("(//button[@type='submit'])[2]");
}
