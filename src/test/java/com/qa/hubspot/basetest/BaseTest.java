package com.qa.hubspot.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPageClass;

public class BaseTest    {

	public WebDriver driver;
	public Properties prop;
	public BasePage basepage;
	public LoginPageClass loginpageclass;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String BNAMEW) {
		basepage =new BasePage();
		prop=basepage.init_Prop();
		prop.setProperty("browser", BNAMEW);
		driver=basepage.init_Driv(prop);
		loginpageclass=new LoginPageClass(driver);
	}
	
	
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
		System.out.println("Last method of After test");
		
}
}
