package com.hk.pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;

public class CustomerRolesPage extends Base{

	private WebDriverWait wait;
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement customersOption;
	
	@FindBy(xpath = "//a[@href='/Admin/CustomerRole/List']")
	private WebElement customerRolesIcon;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@data-val-required='Please provide a name.']")
	private WebElement roleName;
	
	@FindBy(xpath = "//input[@name='Active']")
	private WebElement active;
	
	@FindBy(xpath = "//input[@name='FreeShipping']")
	private WebElement freeShipping;                                                                                                                                                                                                                                                                   
	
	@FindBy(xpath = "//input[@id='TaxExempt']")
	private WebElement taxExempt;
	
	@FindBy(xpath = "//input[@data-val-required='The Override default tax display type field is required.']")
	private WebElement overrideDefaultTaxDisplayType;
	
	@FindBy(xpath = "//input[@id='EnablePasswordLifetime']")
	private WebElement enablePasswordLifetime;
	
	@FindBy(xpath = "//button[normalize-space()='Choose a product']")
	private WebElement purchasedWithProduct;

	@FindBy(xpath ="//input[@class='form-control text-box single-line valid']")
	private WebElement searchProductName;
	
	@FindBy(id = "search-products")
	private WebElement searchButton;
	
	@FindBy(xpath = "//button[normalize-space()='Select']")
	private WebElement selectProductName;
	
	@FindBy(xpath = "//input[@name='SystemName']")
	private WebElement systemName;
	
	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;
	
	public CustomerRolesPage() {
		
		   this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	       PageFactory.initElements(driver, this);	
	}
    
    public void clickOnCustomerOptions()  {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(customersOption)).click();
    }

    public void clickOnCustomerRolesIcon()  {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(customerRolesIcon)).click();
    }
    
    public void clickOnAddNewButton()  {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
    }
    
    public void enterCustomerRoleName(String name) {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(roleName)).sendKeys(name);
    }
    
    public void activeCheckBox()  {
    	
		boolean check = active.isSelected();
	        if (check==true) 
	     	    System.out.println("It's already clicked!");
	        else 
	        	wait.until(ExpectedConditions.elementToBeClickable(active)).click();
	}
 
    public void freeShippingCheckBox()   {
 	
		boolean check = freeShipping.isSelected();
	        if (check==true) 
	     	    System.out.println("It's already clicked!");
	        else 
	        	wait.until(ExpectedConditions.elementToBeClickable(freeShipping)).click();
    }
 
    public void taxExemptCheckBox()  {
 	
		boolean check = taxExempt.isSelected();
        if (check==true) 
     	    System.out.println("It's already clicked!");
        else 
        	wait.until(ExpectedConditions.elementToBeClickable(taxExempt)).click();
    }
    
    public void overrideDefaultTaxDisplayTypeCheckBox()  {
    	
		boolean check = overrideDefaultTaxDisplayType.isSelected();
	        if (check==true) 
	     	    System.out.println("It's already clicked!");
	        else 
	        	wait.until(ExpectedConditions.elementToBeClickable(overrideDefaultTaxDisplayType)).click();
    }
    
    public void enablePasswordLifetimeCheckBox()  {
    	
		boolean check = enablePasswordLifetime.isSelected();
	        if (check==true) 
	     	    System.out.println("It's already clicked!");
	        else 
	        	wait.until(ExpectedConditions.elementToBeClickable(enablePasswordLifetime)).click();
    }
    
    public void selectPurchasedWithProduct()  {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(purchasedWithProduct)).click();
    }
    
    public void searchingPurchasedProductName(String name)  {
    	
    	searchProductName.sendKeys(name);
    }
    
    public void searchButton() {
    			
    	searchButton.click();
    }
    
    public void selectingPurchasedProductName() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(selectProductName)).click();
    	//driver.navigate().back();
    }
    
    public void fillSystemName(String sName) {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(systemName)).sendKeys(sName);
    }
    
    public void clickOnSaveButton() {
    
    	wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
