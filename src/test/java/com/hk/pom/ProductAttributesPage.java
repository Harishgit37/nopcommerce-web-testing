package com.hk.pom;

import java.time.Duration;


import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;

public class ProductAttributesPage extends Base{

	private WebDriverWait wait;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']//following-sibling::p")
	private WebElement catalogIcon;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']")
	private WebElement attributesIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/ProductAttribute/List']")
	private WebElement productAttributeIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/ProductAttribute/Create']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@data-val-required='Please provide a name.']")
	private WebElement productAttributeName;
	
	@FindBy(xpath = "//iframe[@title='Rich Text Area']")
    private WebElement productAttributeDescriptionFrame;
	
	@FindBy(xpath = "//body[@contenteditable='true']")
	private WebElement productAttributeDescription;
	
	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;
	
	public ProductAttributesPage(WebDriver driver) throws InterruptedException {
		 
   	     this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	     PageFactory.initElements(driver, this);
	}
	
	public void clickOnCatalogIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
	}
	
    public void clickOnAttributesIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(attributesIcon)).click();
	}
	
	public void clickOnProductsAttributeIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(productAttributeIcon)).click();
	}
	
	public void clickOnAddNewButton() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
	}
	
    public void fillProductAttributeName(String name) throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(productAttributeName)).sendKeys(name);
	}
	
    public void switchToProductAttributeDescriptionFrame() {
		
    	driver.switchTo().frame(productAttributeDescriptionFrame);
	}
	
    public void fillProductAttributeDescription(String desc) throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(productAttributeDescription)).sendKeys(desc);
	}
	
    public void switchProductInfoContent() {
    	
    	driver.switchTo().defaultContent();
    }
    
    public void clickOnSaveButton() throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
