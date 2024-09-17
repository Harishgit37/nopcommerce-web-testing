package com.hk.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;

public class ShipmentsSearchPage extends Base {
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-shopping-cart']")
	private WebElement salesIcon;
	
	@FindBy(xpath = "//p[text()=' Shipments']")
	private WebElement shipmentsOption;
	
	@FindBy(xpath = "//input[@name='StartDate']")
	private WebElement startDate;
	
	@FindBy(xpath = "//input[@id='EndDate']")
	private WebElement endDate;
	
	@FindBy(xpath = "//input[@id='TrackingNumber']")
	private WebElement trackingNumber;
	
	@FindBy(xpath = "//select[@name='WarehouseId']")
	private WebElement wareHouse;
	
	@FindBy(xpath = "//input[@id='LoadNotDelivered']")
	private WebElement loadNotDelivered;
	
	@FindBy(xpath = "//select[@data-val-required='The Country field is required.']")
	private WebElement country;
	
	@FindBy(xpath = "//select[@id=\"StateProvinceId\"]/option")
	private WebElement stateOrProvince;
	
	@FindBy(xpath = "//input[@name='County']")
	private WebElement countyOrRegion;
	
	@FindBy(xpath = "//input[@id='City']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@data-val-required='The Load not shipped field is required.']")
	private WebElement loadNotShipped;
	
	@FindBy(xpath = "//input[@name='LoadNotReadyForPickup']")
	private WebElement loadNotReadyForPickup;
	
	@FindBy(xpath = "//button[@id='search-shipments']")
	private WebElement searchButton;
	
	@FindBy(tagName = "html")
	private WebElement scrollDown;
	
	@FindBy(xpath = "(//a[text()='View'])[1]")
	private WebElement listingAllShippingDetails;
	
	@FindBy(xpath = "(//div[@class='card-body'])[2]")
	private WebElement displayingShipmentDetails;
	
	@FindBy(xpath = "//a[@href='/Admin/Order/PdfPackagingSlip?shipmentId=3']")
    private WebElement printPackagingSlip;
	
	public ShipmentsSearchPage(WebDriver driver) throws InterruptedException {

    	this.wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	    PageFactory.initElements(driver, this);
	}
	
	public void clickOnSalesIcon() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(salesIcon)).click();
	}
	
    public void clickOnOrdersOption() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(shipmentsOption)).click();
	}
    
    public void fillStartDate(String sDate) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(startDate)).sendKeys(sDate);
	}
    
    public void fillEndDate(String eDate) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(endDate)).sendKeys(eDate); 
	}

    public void fillTrackingNumber(String tNum) throws InterruptedException {
	
	    wait.until(ExpectedConditions.elementToBeClickable(trackingNumber)).sendKeys(tNum);
    }

    public void selectWareHouse() throws InterruptedException {
	
	    Select s1 = new Select(wareHouse);
	    s1.selectByVisibleText("All");
	    wait.until(ExpectedConditions.elementToBeClickable(wareHouse)).click();	    
    }

    public void clickLoadNotDeliveredCheckBox() throws InterruptedException {
	
	    boolean check = loadNotDelivered.isSelected();
        if (check==true) 
        	System.out.println("It's already clicked!");
        else
       	    wait.until(ExpectedConditions.elementToBeClickable(loadNotDelivered)).click();
    }


    public void selectCountry() throws InterruptedException {

	    Select s1 = new Select(country);
	    s1.selectByVisibleText("India");
	    wait.until(ExpectedConditions.elementToBeClickable(country)).click();
    }

    public void selectStateOrProvince() throws InterruptedException {
	
	    wait.until(ExpectedConditions.elementToBeClickable(stateOrProvince)).click();
    }

    public void fillCountyOrRegion(String county) throws InterruptedException {
	
	    wait.until(ExpectedConditions.elementToBeClickable(countyOrRegion)).sendKeys(county);
    }

    public void fillCity(String cty) throws InterruptedException {
	
	    wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys(cty);
    }

    public void clickLoadNotShippedCheckBox() throws InterruptedException {
	
	   boolean check = loadNotShipped.isSelected();
       if (check==true) 
          System.out.println("It's already clicked!");
       else 
    	  wait.until(ExpectedConditions.elementToBeClickable(loadNotShipped)).click();
    }

    public void clickLoadNotReadyForPickUpCheckBox() throws InterruptedException {
	
    	 boolean check = loadNotReadyForPickup.isSelected();
         if (check==true) 
            System.out.println("It's already clicked!");
         else 
      	  wait.until(ExpectedConditions.elementToBeClickable(loadNotReadyForPickup)).click();
    }
    
    public void clickOnSearchButton() throws InterruptedException {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void scrollDown() {
    	 
       JavascriptExecutor executor = (JavascriptExecutor) driver;
       executor.executeScript("window.scrollBy(0,1000)");
   	   wait.until(ExpectedConditions.elementToBeClickable(scrollDown)).click();
    }
    
    public void listingAllShipmentDetails() throws InterruptedException {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(listingAllShippingDetails)).click();
    }
    
    public void displayingShipmentDetails() throws InterruptedException {
    	
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1000)");
    	
    	WebElement element = driver.findElement(By.xpath("//th[normalize-space()='Product']"));
         
        WebElement element1 = driver.findElement(By.xpath("//td[@class='text-left']//div"));
         
        System.out.println(element.getText() + " : " + element1.getText());
         
        WebElement element2 = driver.findElement(By.xpath("//th[normalize-space()='SKU']"));

        WebElement element3 = driver.findElement(By.xpath("//div[normalize-space()='LV_511_JN']"));

        System.out.println(element2.getText() + " : " + element3.getText());
         
        WebElement element4 = driver.findElement(By.xpath("//th[normalize-space()='Warehouse']"));

        System.out.println(element4.getText() + " : " + "Nil");
        
        WebElement element5 = driver.findElement(By.xpath("//th[normalize-space()='Item weight']"));

        System.out.println(element5.getText() + " : " + "Nil");
        
        WebElement element6 = driver.findElement(By.xpath("//th[normalize-space()='Item dimensions']"));
        
        WebElement element7 = driver.findElement(By.xpath("//td[normalize-space()='2.00 x 2.00 x 2.00 [inch(es)]']"));
        
        System.out.println(element6.getText() + " : " + element7.getText());

        WebElement element8 = driver.findElement(By.xpath("//th[normalize-space()='Qty shipped']"));

        WebElement element9 = driver.findElement(By.xpath("//td[normalize-space()='1']"));

        System.out.println(element8.getText() + " : " + element9.getText());

    }
    
    public void printPackingSlip() throws InterruptedException {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(printPackagingSlip)).click();
    }
}