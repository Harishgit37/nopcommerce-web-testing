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

public class CheckOutAttributesPage extends Base{

	private WebDriverWait wait;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']//following-sibling::p")
	private WebElement catalogIcon;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']")
	private WebElement attributesIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/CheckoutAttribute/List']")
	private WebElement checkoutAttributesIcon;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@class='form-control text-box single-line']")
	private WebElement checkoutAttributeName;
	
	@FindBy(xpath = "//input[@name='TextPrompt']")
	private WebElement textPrompt;
		
	@FindBy(xpath = "//select[@id='AttributeControlTypeId']")
	private WebElement checkoutAttributeControlType;
	
	@FindBy(xpath = "//input[@id='IsRequired']")
	private WebElement checkoutAttributeRequired;
	
	@FindBy(xpath = "//input[@name='DisplayOrder']")
	private WebElement checkoutAttributeDisplayOrder;
	
	@FindBy(xpath = "(//input[@name='ShippableProductRequired'])[1]")
	private WebElement shippableProductRequired;
	
	@FindBy(xpath   = "//select[@id=\"TaxCategoryId\"]/option[2]")
	private WebElement taxCategory;
	
	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;
	
    public CheckOutAttributesPage(WebDriver driver) throws InterruptedException {

		   this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	       PageFactory.initElements(driver, this);
		
    }
	
    public void clickOnCatalogIcon() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
	}
	
    public void clickOnAttributesIcon() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(attributesIcon)).click();
	}
    
    public void clickOnCheckoutAttributesIcon() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(checkoutAttributesIcon)).click();
    }
    
    public void clickOnAddNewButton() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
    }
    
    public void enterCheckoutAttributeName(String name) throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(checkoutAttributeName)).sendKeys(name);
    }
    
    public void enterTextPrompt(String text) throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(textPrompt)).sendKeys(text);
    }
        
    public void selectCheckoutAttributeControlType() throws InterruptedException {
    	
		Select s1 = new Select(checkoutAttributeControlType);
		s1.selectByVisibleText("Drop-down list");
		
		wait.until(ExpectedConditions.elementToBeClickable(checkoutAttributeControlType)).click();
    }
    
    public void requiredCheckBox() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(checkoutAttributeRequired)).click();
    }
    
    public void enterCheckoutAttributeDisplayOrder(String order) throws InterruptedException {
    	
        checkoutAttributeDisplayOrder.clear();
		wait.until(ExpectedConditions.elementToBeClickable(checkoutAttributeDisplayOrder)).sendKeys(order);
    }
    
    public void shippableProductRequiredCheckBox() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(shippableProductRequired)).click();
    }
    
    public void selectTaxCategory() throws InterruptedException {
    			
		wait.until(ExpectedConditions.elementToBeClickable(taxCategory)).click();
    }
    
    public void clickOnSaveButton() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    } 
}
