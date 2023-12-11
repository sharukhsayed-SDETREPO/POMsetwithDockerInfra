package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePageClass extends BasePage {
	
	
	
	
	
	
	//
	private WebDriver driver;
	
	public ElementUtil elementutil;
	
	
	public HomePageClass(WebDriver driver) {
		this.driver =driver;
		elementutil= new ElementUtil(this.driver);
		
		}
	
	
	//By locators
	
	By pageHeader= By.cssSelector("h1.private-header__heading.private-header__heading--solo");
	By accountName =By.id("span.account-name");
	
	///to land on contacts page

	By ContactsNavigation =By.cssSelector("#nav-primary-contacts-branch");
	By ContactsNavigationsecondary =By.cssSelector	("#nav-secondary-contacts");
	
	//REusable actions
	
	
	public String doGetTitleHomePage()    {
		
		return elementutil.doGetPageTitleWithContains(60, Constants.HOME_PAGE_TITLE);
	}
	
	
	public String doGetHomePageHeader() {
	return 	elementutil.waitForElementPresent(pageHeader, 10).getText();
	}
	
	public String doGetLoggedinAccount() {
		
		return elementutil.waitforelementtobevisible(accountName, 60).getText();
	}
	
	
	
	//to return contact page object
	public ContactsPageClass GotoContactPage() {
		navigatetoConatcspage();
		
		return new ContactsPageClass(driver);
	}
	
	private void navigatetoConatcspage() {
		elementutil.waitForElementToBeClickable(ContactsNavigation, 70).click();
		elementutil.ClickWhenReady(ContactsNavigationsecondary, 70);
	}
	
	
	

}