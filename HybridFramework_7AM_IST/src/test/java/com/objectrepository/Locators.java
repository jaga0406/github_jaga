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
    
    
    
    
}
