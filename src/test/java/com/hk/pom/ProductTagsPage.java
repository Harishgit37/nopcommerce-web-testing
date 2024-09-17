package com.hk.pom;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;

public class ProductTagsPage extends Base{
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']//following-sibling::p")
	private WebElement catalogIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/Product/ProductTags']")
	private WebElement productTags;
	
	@FindBy(xpath = "//input[@name='SearchTagName']")
	private WebElement productTagName;
	
	@FindBy(xpath = "//button[@id='search-product-tags']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[@href='EditProductTag/6']")
	private WebElement editButton;
	
	@FindBy(xpath = "//input[@id='Name']")
	private WebElement editSearchedTagName;
	
	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;
	
	public ProductTagsPage(WebDriver driver) throws InterruptedException {
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    PageFactory.initElements(driver, this);
	}
	
	public void clickOnCatalogIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
	}
	
	public void clickOnProductTagsIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(productTags)).click();
	}
	
    public void fillProductTagName(String name) throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(productTagName)).sendKeys(name);
	}
	
	public void clickOnSearchButton() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}
	
	public void editingTagNameAndSave(String tName) throws InterruptedException {
				
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(editSearchedTagName)).clear();
		
        wait.until(ExpectedConditions.elementToBeClickable(editSearchedTagName)).sendKeys(tName);
		
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	}
}
