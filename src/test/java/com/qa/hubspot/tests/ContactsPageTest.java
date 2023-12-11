package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.basetest.BaseTest;
import com.qa.hubspot.pages.ContactsPageClass;
import com.qa.hubspot.pages.HomePageClass;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest{
	
	
	
	
	HomePageClass homepageclass;
	ContactsPageClass cpc;
	@BeforeClass
	public void contactPageSetup() {
		homepageclass=loginpageclass.doLogin(prop.getProperty("username"), prop.getProperty("pasword"));
		cpc=homepageclass.GotoContactPage();
	}

	
	
	
	
//	@Test(priority=2)
//	public void VerifycontactsTitle() {
//		String title=cpc.doGetContactPageTitle();
//		System.out.println("title is "+ title );
//		Assert.assertEquals(title, Constants.Contact_PAGE_TITLE);
//	}
//	
//	
//	@Test (priority=3)
//	public void VerifyHeaderContacts() {
//		String header=cpc.getPageHeader();
//		System.out.println("Header sis " + header);
//		Assert.assertEquals(header, Constants.Contact_PAGE_Header);
//	}
	
	
@DataProvider
public Object[][] ProvidedataforConatcspage() {
	Object[][]data =ExcelUtil.GetExcelUtilData("HubsportTestData", "contacts");
	return data;
}
@Test(priority=1,dataProvider = "ProvidedataforConatcspage")
	public void CreateContact(String eamil,String Fnam,String LName) {
		cpc.creawawadsatContact(eamil, Fnam, LName);
	}
}
