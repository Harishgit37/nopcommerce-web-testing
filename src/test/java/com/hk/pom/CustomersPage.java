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

public class CustomersPage extends Base{
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement customersOption;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']")
	private WebElement customersIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passWord;
	
	@FindBy(xpath = "//input[@name='FirstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@name='LastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='Gender_Male']")
    private WebElement gender;
	
	@FindBy(xpath = "//input[@name='DateOfBirth']")
	private WebElement dateOfBirth;
	
	@FindBy(xpath = "//input[@id='Company']")
	private WebElement companyName;

	@FindBy(xpath = "//input[@data-val-required='The Is tax exempt field is required.']")
	private WebElement isTaxExempt;
	
	@FindBy(xpath = "//select[@id=\"SelectedNewsletterSubscriptionStoreIds\"]")
	private WebElement newsLetter;
//	
//	@FindBy(xpath = "//li[@title='Guests']")
//	private WebElement customerRoles;
	
	@FindBy(xpath = "//select[@id='VendorId']")
	private WebElement managerOfVendor;
	
	@FindBy(xpath = "//input[@data-val-required='The Active field is required.']")
	private WebElement active;
	
	@FindBy(xpath = "//textarea[@name='AdminComment']")
	private WebElement adminComment;
	
	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;
	
    public CustomersPage(WebDriver driver) throws InterruptedException {

		   this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	       PageFactory.initElements(driver, this);
    }

    public void clickOnCustomerOptions() throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(customersOption)).click();
    }
    
    public void clickOnCustomersIcon() throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(customersIcon)).click();
    }
    
    public void clickOnAddNewButton() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
    }
    
    public void fillEmail(String mail) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(mail);
    }
    
    public void fillPassword(String pass) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(passWord)).sendKeys(pass);
    }

    public void fillFirstName(String fName) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(fName);
    }
    
    public void fillLastName(String lName) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys(lName);
    }
    
    public void clickOnGender() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
    }
    
    public void fillDateOfBirth(String dob) throws InterruptedException {
    	    	
        wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth)).sendKeys(dob);
    }
    
    public void fillCompanyName(String com) throws InterruptedException {
    	    	
        wait.until(ExpectedConditions.elementToBeClickable(companyName)).sendKeys(com);
    }

    public void isTaxExempt() throws InterruptedException {
	
	    boolean check = isTaxExempt.isSelected();
        if (check==true) 
     	    System.out.println("It's already clicked!");
        else 
            wait.until(ExpectedConditions.elementToBeClickable(isTaxExempt)).click();        
    }

    public void clickOnNewsLetter() throws InterruptedException {
    	
    	Select s1 = new Select(newsLetter);
	    s1.selectByVisibleText("Your store name");   
    }
    
//    public void clickOnCustomerRoles() throws InterruptedException {
//    	
//   	    Thread.sleep(3000);
//  	    Select s1 = new Select(customerRoles);
//	    s1.selectByVisibleText("Guests");
//   	    customerRoles.clear();
//	    customerRoles.click();
//    }
    
    public void clickOnManagerOfVendor() throws InterruptedException {
    	

   	    Select s1 = new Select(managerOfVendor);
	    s1.selectByVisibleText("Not a vendor");
	    
        wait.until(ExpectedConditions.elementToBeClickable(managerOfVendor)).click();
    }

    public void active() throws InterruptedException {
    	
    	
    	 boolean check = active.isSelected();
         if (check==true) 
      	    System.out.println("It's already clicked!");
         else 
             wait.until(ExpectedConditions.elementToBeClickable(active)).click();
    }
    
    public void fillAdminComment(String cmt) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(adminComment)).sendKeys(cmt);
    }
    
    public void clickOnSaveButton() throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
