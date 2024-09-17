package com.hk.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;

public class SearchMessageTemplatesPage extends Base{

	private WebDriverWait wait;
	
	@FindBy(xpath = "//p[normalize-space()='Content management']")
	private WebElement contentManagementIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/MessageTemplate/List']")
	private WebElement messageTemplatesOption;
	
	@FindBy(xpath = "//input[@name='SearchKeywords']")
	private WebElement searchKeywords;
	
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	private WebElement isActive;
	
	@FindBy(xpath = "//button[@id='search-templates']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[@href='Edit/37']")
	private WebElement OrderPaidStoreOwnerNotification;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement testTemplateButton;
	
	@FindBy(xpath = "//input[@name='SendTo']")
	private WebElement sendEmailTo;
	
	@FindBy(xpath= "(//button[@type='submit'])[2]")
	private WebElement sendButton;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement saveButton;
	
    public SearchMessageTemplatesPage(WebDriver driver) throws InterruptedException {
		
    	this.wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	    PageFactory.initElements(driver, this);
	}
    
    public void clickOnContentManagementIcon() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(contentManagementIcon)).click();
    }
	
    public void clickOnMessageTemplatesOption() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(messageTemplatesOption)).click();
    }
    
    public void fillSearchKeywords(String key) throws InterruptedException {
    	
		Thread.sleep(3000);
		if (key=="paid") 
			wait.until(ExpectedConditions.elementToBeClickable(searchKeywords)).sendKeys(key);
	    else 
            System.out.println("Search Not Found");
    }
    
    public void selectIsActiveProperty() throws InterruptedException {
    	
        Select s1 = new Select(isActive);
        s1.selectByVisibleText("Inactive only");
		wait.until(ExpectedConditions.elementToBeClickable(isActive)).click();
    }
    
    public void searchButton() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    
    public void editOrderPaidStoreOwnerNotification(String mail) throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(OrderPaidStoreOwnerNotification)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(testTemplateButton)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(sendEmailTo)).sendKeys(mail);
		
		wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
