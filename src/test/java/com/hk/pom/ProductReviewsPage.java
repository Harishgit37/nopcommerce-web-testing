package com.hk.pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;


public class ProductReviewsPage extends Base{
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']//following-sibling::p")
	private WebElement catalogIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/ProductReview/List']")
	private WebElement productReviewsIcon;
	
	@FindBy(xpath = "//input[@name='CreatedOnFrom']")
	private WebElement searchDateCreatedFrom;
	
	@FindBy(xpath = "//input[@id='CreatedOnTo']")
	private WebElement searchDateCreatedTo;
	
	@FindBy(xpath = "//input[@class='form-control text-box single-line']")
	private WebElement searchInTitleMessage;
	
	@FindBy(xpath = "//select[@data-val-required='The Approved field is required.']/option[1]")
	private WebElement searchApprovedProperty;

	@FindBy(xpath = "//input[@id='search-product-name']")
	private WebElement searchSpecificProduct;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-search']")
	private WebElement searchButton;
	
	@FindBy(tagName = "html")
	private WebElement scrollDown;
	
	@FindBy(xpath = "//a[@href='Edit/7']")
	private WebElement editButton;

	@FindBy(xpath = "//input[@id='Title']")
	private WebElement editTitle;
	
	@FindBy(xpath = "//textarea[@id='ReviewText']")
	private WebElement editReviewText;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement saveButton;

	public ProductReviewsPage(WebDriver driver) throws InterruptedException {
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    PageFactory.initElements(driver, this);
	}
	
	public void clickOnCatalogIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
	}
	
    public void clickOnProductReviewsIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(productReviewsIcon)).click();
	}
	
	public void fillSearchDateCreatedFrom(String createdFrom) throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(searchDateCreatedFrom)).sendKeys(createdFrom);
	}
	
	public void fillSearchDateCreatedTo(String createdTo) throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(searchDateCreatedTo)).sendKeys(createdTo);
	}
	
	public void fillSearchInTitleMessage(String title) throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(searchInTitleMessage)).sendKeys(title);
	}
	
	public void selectSearchApprovedProperty() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(searchApprovedProperty)).click();
   }
	
	public void fillSearchSpecificProduct(String product) throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(searchSpecificProduct)).sendKeys(product);
	}
	
	public void clickOnSearchButton() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}
	
	public void scrollDown() throws InterruptedException {
   	 
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.elementToBeClickable(scrollDown)).click();
    }
 
	public void editProductReviewDetails() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
				
        wait.until(ExpectedConditions.elementToBeClickable(editTitle)).clear();
        
        wait.until(ExpectedConditions.elementToBeClickable(editTitle)).sendKeys("Mobile Phone");
        
        wait.until(ExpectedConditions.elementToBeClickable(editReviewText)).clear();

		wait.until(ExpectedConditions.elementToBeClickable(editReviewText)).sendKeys("This mobile phone review is for the Windows 8 Pro. I've been waiting for this product to be available. It is priced just right.");
		
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	}
}
