package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPageClass extends BasePage {
	
	
	
	public WebDriver driver;
	
	ElementUtil elemenetutil;
	
	
	//Constructor
	
	
	public LoginPageClass(WebDriver driver) {
		this.driver=driver;
		elemenetutil= new ElementUtil(this.driver);
	}
	
	///By locators for this page 
	
	By email= By.id("username");
	By pwd= By.id("password");
	By LgnBtn= By.id("loginBtn");
	By SgnP= By.linkText("Sign up");
	
	
	//Page Actions.Method
	
	
	//1.GetTitle
	
	@Step("you can write generic steps description of what your method does")
	public String doLoginPageGetTitle() {
	

		return elemenetutil.doGetPageTitleWithIsTitle(15, Constants.LOGIN_PAGE_TITLE);
	}
	//2.SignupLink present
	public boolean verifySignUp() {
		return elemenetutil.doIsDisplayed(SgnP);
	}
	//3.Perform login
	@Step("This is login with :{0} usenarme and :{1} password")
	public  HomePageClass  doLogin(String UN,String PWD) {
		elemenetutil.waitforelementtobevisible(email, 10).sendKeys(UN);;
		elemenetutil.doActionsSendKeys(pwd, PWD);
		elemenetutil.waitForElementToBeClickable(LgnBtn, 10).click();
		return new HomePageClass(driver);
	}
	

	

}
