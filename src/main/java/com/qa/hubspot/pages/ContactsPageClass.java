package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPageClass extends BasePage {
	
	
	//Webdriver and element util
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	
	//Constructor
	public ContactsPageClass(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
	}
	
	//Bylocator
	
	
	
	By header = By.cssSelector("h1[class*=IndexPageRedesignHeader]");
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-test-id='email-input']");
	By firssadtName = By.xpath("//input[@data-test-id='firstname-input']");
	By lastNtfhfme = By.xpath("//input[@data-test-id='lastname-input']");
	By jobTitle = By.xpath("//input[@data-test-id='jobtitle-input']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[position()=2]");
	By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=1]");
	
	
	
	//reusable methods
	public String doGetContactPageTitle() {

		return elementUtil.doGetPageTitleWithIsTitle(70, Constants.Contact_PAGE_TITLE);
	
		
	}
	
	
	
	public String getPageHeader() {
		return elementUtil.waitforelementtobevisible(header, 2).getText()
		
		;
	}
	
	
	
//	
	
	
public void creawawadsatContact(String mail,String FirstName,String Lastname) {
		
		elementUtil.ClickWhenReady(createContactPrimary, 10);
		driver.switchTo().frame("object-builder-ui");
		elementUtil.waitforelementtobevisible(email, 10);
		elementUtil.doSendKeys(this.email, mail);
		elementUtil.doSendKeys(firssadtName, FirstName);
		elementUtil.doSendKeys(lastNtfhfme, Lastname);
		
	

		elementUtil.doClick(createContactSecondary);
		
		elementUtil.ClickWhenReady(contactsBackLink, 10);
		////
//		ele.ClickWhenReady(CreateContactfirts, 10);
//		driver.switchTo().frame("object-builder-ui");
//		ele.waitforelementstobevisible(email, 30);
//		ele.doSendKeys(email, mail);
//		ele.doActionsSendKeys(Firstname, FirstName);
//		ele.doActionsSendKeys(LastName, Lastname);
//		ele.ClickWhenReady(CreateContactFinal,30);
//		
//		ele.waitForElementPresent(CreateContactFinal, 10);
//		ele.ClickWhenReady(CreateContactFinal, 10);
//		driver.switchTo().defaultContent();
//		ele.ClickWhenReady(contactsBackLink, 10);
//		
		
		
		
		
	}
	
	
	
}

	
	
	
	
