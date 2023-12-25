package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.basetest.BaseTest;
import com.qa.hubspot.pages.HomePageClass;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("These scenatrios are used to test -Homepage functionaliy")
@Feature("Homepage feature testing") 
public class HomePageTest extends BaseTest {

	
	
	
	HomePageClass homepageclass;
	
	@BeforeClass
	public void setupHomepage(){
		homepageclass=loginpageclass.doLogin(prop.getProperty("username"), prop.getProperty("pasword"));	
	}
	@Test (priority=4)
	
	
	@Description("this will get your homepagetitle ")
	@Severity(SeverityLevel.CRITICAL) 
	public void verfyHomePageTitle() throws InterruptedException  {
		System.out.println("HOME PAGE TITLE IS " +homepageclass.doGetTitleHomePage());
		Assert.assertEquals(homepageclass.doGetTitleHomePage(), Constants.HOME_PAGE_TITLE);
	}
	
	
	@Description("this will verify your homepage header ")
	@Severity(SeverityLevel.TRIVIAL)
	@Test (priority=5)
	
	public void verfyHomePageHeader() {
		System.out.println("HOME PAGE Headeer IS " +homepageclass.doGetHomePageHeader());
		Assert.assertEquals(homepageclass.doGetHomePageHeader(), Constants.HOME_PAGE_Header);
	}
	
	@Description("this will verify your logged in account ")
	@Severity(SeverityLevel.CRITICAL)
@Test (priority=6)
	
	public void verfyLoggedInAccount() {
		System.out.println("HOME PAGE Logged in account IS" +homepageclass.doGetLoggedinAccount());
		Assert.assertEquals(homepageclass.doGetLoggedinAccount(),prop.getProperty("accountName"));
	}
	
	
	

	
}
