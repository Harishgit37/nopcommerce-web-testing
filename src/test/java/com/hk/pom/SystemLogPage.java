package com.hk.pom;

import java.time.Duration;
import java.util.List;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;

public class SystemLogPage extends Base{

	private WebDriverWait wait;
	
	@FindBy(xpath = "//p[normalize-space()='System']//i[contains(@class,'right fas fa-angle-left')]")
	private WebElement systemIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/Log/List']")
	private WebElement logOption;
	
	@FindBy(xpath = "//input[@name='CreatedOnFrom']")
    private WebElement createdFrom;
	
	@FindBy(xpath = "//input[@id='CreatedOnTo']")
    private WebElement createdTo;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement message;

	@FindBy(xpath = "//select[@id='LogLevelId']")
    private WebElement logLevel;

	@FindBy(xpath = "//button[@id='search-log']")
	private WebElement searchButton;
	
	@FindBy(xpath = "(//div[@class='card-body'])[3]")
	private List<WebElement> listingAllLogs;
	
	@FindBy(xpath = "//a[@href='View/144']")
	private WebElement warningLog1View;
	
	@FindBy(xpath = "//a[@href='View/143']")
	private WebElement warningLog2View;
	
	@FindBy(xpath = "//span[@data-target='#logmodel-Delete-delete-confirmation']")
	private WebElement warningLog1DeleteIcon;
	
	@FindBy(xpath = "//button[@class='btn btn-danger float-right']")
	private WebElement warningLog1DeleteButton;
	
	@FindBy(xpath = "//span[@data-toggle='modal']")
	private WebElement warningLog2DeleteIcon;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement warningLog2DeleteButton;
	
	public SystemLogPage(WebDriver driver) {
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	    PageFactory.initElements(driver, this);
	}
	
	public void clickOnSystemIcon() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(systemIcon)).click();
	}
	
    public void clickOnLogOption() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(logOption)).click();
	}

    public void fillDateCreatedFrom(String cFrom) throws InterruptedException {
	
		wait.until(ExpectedConditions.elementToBeClickable(createdFrom)).sendKeys(cFrom);
    }

    public void fillDateCreatedTo(String cTo) throws InterruptedException {
	
		wait.until(ExpectedConditions.elementToBeClickable(createdTo)).sendKeys(cTo);
    }

    public void enterMessage(String msg) throws InterruptedException {
    	
		wait.until(ExpectedConditions.elementToBeClickable(message)).sendKeys(msg);
    }

    public void selectLogLevel() throws InterruptedException {
	 	    
	    Select s1 = new Select(logLevel);
	    s1.selectByVisibleText("Warning");
	    
		wait.until(ExpectedConditions.elementToBeClickable(logLevel)).click();
    }

    public void clickOnSearchButton() throws InterruptedException {
	
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    
    public List<WebElement> listingAllLogs() throws InterruptedException {
    	 
		System.out.println("List of all logs: "+ listingAllLogs.size());
		
		for (WebElement list : listingAllLogs) {
			String text = list.getText();
			System.out.println("List: " + text);
        }
		return listingAllLogs;
    }
    
    public void warningLogLevelViewAndDeleting() throws InterruptedException {
    	        
		wait.until(ExpectedConditions.elementToBeClickable(warningLog1View)).click();
        
		wait.until(ExpectedConditions.elementToBeClickable(warningLog1DeleteIcon)).click();

		wait.until(ExpectedConditions.elementToBeClickable(warningLog1DeleteButton)).click();
                
		wait.until(ExpectedConditions.elementToBeClickable(warningLog2View)).click();
        
		wait.until(ExpectedConditions.elementToBeClickable(warningLog2DeleteIcon)).click();

		wait.until(ExpectedConditions.elementToBeClickable(warningLog2DeleteButton)).click();
    }
}
