package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.basetest.BaseTest;
import com.qa.hubspot.testlisteners.TestAllureListener;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;





@Epic("These scenatrios are used to test -Login functionaliy")
@Feature("Login feature testing") 
@Listeners(TestAllureListener.class)//This is not mandatory only use when no screenshots are generating
public class LoginTest extends BaseTest {

	
	

	
	//If priority is not defined it will excute based on alpbetical order
	

	
	@Description("this will get your title ")
	@Severity(SeverityLevel.CRITICAL)

	@Test(priority=3)
	public void GetTitleTest() {
		
		System.out.println("getyour title test");
		Assert.assertEquals(loginpageclass.doLoginPageGetTitle(),Constants.LOGIN_PAGE_TITLE);
	}
	
	
	@Description("this will verify your sign up link")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=2)
	public void VerifySignupLink() {
		System.out.println("Verfy Signuplink test is running");
		Assert.assertEquals(loginpageclass.verifySignUp(), true);
	}
	
	@Description("this will validate your login ")                              
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4)
	public void DOLogin() {
		System.out.println("Verfy LOGIN test is running");
		loginpageclass.doLogin(prop.getProperty("username"), prop.getProperty("pasword"));
	} 
	
	
	
	
	
	
	
	
}
