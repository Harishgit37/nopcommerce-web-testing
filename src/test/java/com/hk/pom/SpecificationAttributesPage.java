package com.hk.pom;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;

public class SpecificationAttributesPage extends Base{
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']//following-sibling::p")
	private WebElement catalogIcon;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']")
	private WebElement attributesIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/SpecificationAttribute/List']")
	private WebElement specificationAttributesIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/SpecificationAttribute/CreateSpecificationAttribute']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@name='Name']")
	private WebElement specificationAttributeName;

	@FindBy(xpath = "//select[@name='SpecificationAttributeGroupId']")
	private WebElement specificationAttributeGroup;
	
	@FindBy(xpath = "//input[@data-val-required='The Display order field is required.']")
	private WebElement specificationAttributeDisplayOrder;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement saveButton;
	
	public SpecificationAttributesPage(WebDriver driver) throws InterruptedException {
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	    PageFactory.initElements(driver, this);
	}
	
   public void clickOnCatalogIcon() throws InterruptedException {
	   
		wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
	}
	
    public void clickOnAttributesIcon() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(attributesIcon)).click();
	}
	
	public void clickOnSpecificationAttributeIcon() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(specificationAttributesIcon)).click();
	}
	
	public void clickOnAddNewButton() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
	}
	
	public void fillSpecificationAttributeName(String name) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(specificationAttributeName)).sendKeys(name);
	}
	
    public void selectSpecificationAttributeGroup() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(specificationAttributeGroup)).click();
	}
	
    public void fillSpecificationAttributeDisplayOrder(String order) throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(specificationAttributeDisplayOrder)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(specificationAttributeDisplayOrder)).sendKeys(order);
	}
	
    public void clickOnSaveButton() throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
