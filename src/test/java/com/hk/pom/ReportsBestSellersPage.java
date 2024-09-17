package com.hk.pom;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hk.helper.Base;

public class ReportsBestSellersPage extends Base{

	private WebDriverWait wait;	

	@FindBy(xpath = "//p[normalize-space()='Reports']//i[contains(@class,'right fas fa-angle-left')]")
	private WebElement reportsIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/Report/Bestsellers']")
	private WebElement bestSellersOption;
	
	@FindBy(xpath = "//input[@id='StartDate']")
	private WebElement startDate;
	
	@FindBy(xpath = "//input[@id='EndDate']")
	private WebElement endDate;
	
	@FindBy(xpath = "//select[@id='StoreId']")
	private WebElement store;
	
	@FindBy(xpath = "//select[@id='OrderStatusId']")
	private WebElement orderStatus;
	
	@FindBy(xpath = "//select[@name='PaymentStatusId']")
	private WebElement paymentStatus;
	
	@FindBy(xpath = "//select[@name='CategoryId']")
	private WebElement category;
	
	@FindBy(xpath = "//select[@id='ManufacturerId']")
	private WebElement manufacturer;
	
	@FindBy(xpath = "//select[@id='BillingCountryId']")
	private WebElement billingCountry;
	
	@FindBy(xpath = "//select[@name='VendorId']")
	private WebElement vendor;
	
	@FindBy(xpath = "//button[@id='search-salesreport']")
	private WebElement runReportButton;

	@FindBy(xpath = "(//div[@class='card-body'])[2]")
    private WebElement viewingReports;
	
	@FindBy(xpath = "//td[normalize-space()='Science & Faith']")
	private WebElement checkingForSearchedReport;
	
	@FindBy(xpath = "//a[@href='/Admin/Product/Edit/36']")
	private WebElement viewIcon;
	
	@FindBy(xpath = "//input[@id='AvailableStartDateTimeUtc']")
	private WebElement updatingAvailableStartDate;
	
	@FindBy(xpath = "//input[@name='AvailableEndDateTimeUtc']")
	private WebElement updatingAvailableEndDate;
	
	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;
	
	public ReportsBestSellersPage(WebDriver driver) {

		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	    PageFactory.initElements(driver, this);
	}
	
	public void clickOnReportsIcon() {
		
		wait.until(ExpectedConditions.elementToBeClickable(reportsIcon)).click();
	}
	
    public void clickOnBestSellersOption() {
		
		wait.until(ExpectedConditions.elementToBeClickable(bestSellersOption)).click();
	}
    
    public void enterStartDate(String sDate) {
    	
		wait.until(ExpectedConditions.elementToBeClickable(startDate)).sendKeys(sDate);
    }
    
    public void enterEndDate(String eDate) {
    	
		wait.until(ExpectedConditions.elementToBeClickable(endDate)).sendKeys(eDate);
    }
    
    public void selectStore() {
    	
    	Select s1 = new Select(store);
    	s1.selectByVisibleText("Your store name");
    	wait.until(ExpectedConditions.elementToBeClickable(store)).click();
    }
    
    public void selectOrderStatus() {
    	
    	Select s1 = new Select(orderStatus);
    	s1.selectByVisibleText("Pending");
    	wait.until(ExpectedConditions.elementToBeClickable(orderStatus)).click();
    }
    
    public void selectPaymentStatus() {
    	
    	Select s1 = new Select(paymentStatus);
    	s1.selectByVisibleText("Pending");
    	wait.until(ExpectedConditions.elementToBeClickable(paymentStatus)).click();
    }
    
    public void selectCategory() {
    	
    	Select s1 = new Select(category);
    	s1.selectByVisibleText("Digital downloads");
    	wait.until(ExpectedConditions.elementToBeClickable(category)).click();
    }
    
    public void selectManufacturer() {
    	
    	Select s1 = new Select(manufacturer);
    	s1.selectByVisibleText("All");
    	wait.until(ExpectedConditions.elementToBeClickable(manufacturer)).click();
    }
    
    public void selectBillingCountry() {
    	
    	Select s1 = new Select(billingCountry);
    	s1.selectByVisibleText("United Kingdom");
    	wait.until(ExpectedConditions.elementToBeClickable(billingCountry)).click();
    }
    
    public void selectVendor() {
    	
    	Select s1 = new Select(vendor);
    	s1.selectByVisibleText("All");
    	wait.until(ExpectedConditions.elementToBeClickable(vendor)).click();
    }
    
    public void clickOnRunReportsButton() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(runReportButton)).click();
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1000)");
    }
    
    public void viewingSearchedReports(String sDate,String eDate) {
    	
    	try {
    		if (viewingReports.isDisplayed()) {
    			if(checkingForSearchedReport.isDisplayed())
    		    wait.until(ExpectedConditions.elementToBeClickable(viewIcon)).click();
		        wait.until(ExpectedConditions.elementToBeClickable(updatingAvailableEndDate)).sendKeys(sDate);
		        wait.until(ExpectedConditions.elementToBeClickable(updatingAvailableEndDate)).sendKeys(eDate);
    		    wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    		}else
    	        System.out.println("Element is not displayed.");
		} catch (NoSuchElementException e) {
		    System.out.println("Element not found: " + e.getMessage());
	      }
    }
}
