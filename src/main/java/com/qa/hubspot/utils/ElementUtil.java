package com.qa.hubspot.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementUtil extends BasePage {

	private WebDriver driver;
	JavascriptUtil jsutil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsutil=new JavascriptUtil(this.driver);
	}

	/**
	 * this is used to create the webelement on the basis of by locator
	 * @param locator
	 * @return webelement
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			
			if (prop.getProperty("highlight").equalsIgnoreCase("YES")) {
			jsutil.flash(element);
			
			}
			
		} catch (Exception e) {
			System.out.println("element could not be created..." + locator);
		}

		return element;
	}
	
	public void doClick(By locator){
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value){
		getElement(locator).sendKeys(value);
	}
	
	public String doGetText(By locator){
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator){
		return getElement(locator).isDisplayed();
	}
	
	
	//**********************Actions Methods ********************
	public void doActionsClick(By locator){
		Actions ac = new Actions(driver);
		ac.click(getElement(locator)).perform();
	}
	
	public void doActionsSendKeys(By locator, String value){
		Actions ac = new Actions(driver);
		ac.sendKeys(getElement(locator), value).perform();
	}
	
	//********************drop down utils **************************
	
	public void doSelectValuesByVisibleText(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public void doSelectValuesByIndex(By locator, int index){
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectValuesByValue(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public List<String> getDropDownOptionsValues(By locator) {
		List<String> optionsList = new ArrayList<String>();

		Select select = new Select(getElement(locator));

		List<WebElement> dropList = select.getOptions();
		System.out.println(dropList.size());

		for (int i = 0; i < dropList.size(); i++) {
			String text = dropList.get(i).getText();
			optionsList.add(text);
		}

		return optionsList;
	}
	
	/**
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectValuesFromDropDown(By locator, String value){
		List<WebElement> daysList = driver.findElements(locator);
		
		for(int i=0; i<daysList.size(); i++){
			String text  = daysList.get(i).getText();
			if(text.equals(value)){
				daysList.get(i).click();
				break;
			}
		}
	}
	
	
	//***************************wait utils ******************************
	public String doGetPageTitleWithContains(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public String doGetPageTitleWithIsTitle(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
	
	public String doGetPageCurrentUrl(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.urlContains(urlValue));
		return  driver.getCurrentUrl();
	}
	
	public WebElement waitForElementPresent(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitforelementtobevisible(By locator, int timeOut){
		getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	public List<WebElement> waitforelementstobevisible(By locator, int timeOut){
		getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public WebElement waitForElementToBeClickable(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void  ClickWhenReady(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();;
	}
	
	
	public Alert WaitforAlert(int timeoute) {
		WebDriverWait waot= new WebDriverWait(driver, Duration.ofSeconds(timeoute));
		
		return waot.until(ExpectedConditions.alertIsPresent());
		
	}
	
	
	///VVVIP Method without explicit wait of any sort of explicit wait 
	public  boolean WaitForElementToBEDisplayedwithoutExplicit(By locator, int timeout)   {
		WebElement element =null;
		boolean flag=false;
		for (int i=0;i<timeout;i++) {
		try {
			element=driver.findElement(locator);
		     flag=element.isEnabled();
		     break;
		} catch (Exception e) {
		System.out.println("waiting for element with locator" + locator +" to be visible for " + i);
		try{
			Thread.sleep(1000);
		}
		catch (Exception e1) {
		}
		
		}
		}
		return flag;	
		
	}
	
	
	
	////****************************FLUENT WAIT *********************************************************************
	
	public  WebElement  WaitforWebelement(  final By locator,int  timeout) {
		Wait<WebDriver> wat=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(1)).
				ignoring(NoSuchElementException.class)
				;
				
	WebElement ele= wat.until(new Function<WebDriver,WebElement>(){
		public WebElement apply(WebDriver driver) {
			 	return  driver.findElement(locator); 
		}
	});
	return ele;
	}
	///Similar can be achieved by 
	public   WebElement  WaitforWebelementB( By locator,int  timeout) {
		Wait<WebDriver> wat=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(1)).
				ignoring(NoSuchElementException.class)
				;
				;
		return wat.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}