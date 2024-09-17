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


public class DiscountsPage extends Base{
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//p[normalize-space()='Promotions']")
	private WebElement promotionsOption;
	
	@FindBy(xpath = "//a[@href='/Admin/Discount/List']")
	private WebElement discountsIcon;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@id='IsActive']")
	private WebElement isActive;

	@FindBy(xpath = "//input[@data-val-required='Please provide a name.']")
	private WebElement discountName;

	@FindBy(xpath = "//select[@name='DiscountTypeId']")
	private WebElement discountType;

	@FindBy(xpath = "//input[@id='UsePercentage']")
	private WebElement usePercentage;

	@FindBy(xpath = "//input[@id='DiscountPercentage']")
	private WebElement discountPercentage;
	
    @FindBy(xpath = "//input[@id='MaximumDiscountAmount']")	
	private WebElement maximumDiscountAmount;

	@FindBy(xpath = "//input[@id='RequiresCouponCode']")
	private WebElement requiresCouponCode;

	@FindBy(xpath = "//input[@name='CouponCode']")
	private WebElement couponCode;
	
	@FindBy(xpath = "//input[@id='StartDateUtc']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@id='EndDateUtc']")
	private WebElement endDate;

	@FindBy(xpath = "//input[@data-val-required='The Cumulative with other discounts field is required.']")
	private WebElement cumulativeWithOtherDiscounts;
	
	@FindBy(xpath = "//select[@id='DiscountLimitationId']")
	private WebElement discountLimitation;
	
	@FindBy(xpath = "//textarea[@class='form-control']")
	private WebElement adminComment;

	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@id='SearchStartDate']")
	private WebElement searchStartDate;
	
	@FindBy(xpath = "//input[@name='SearchEndDate']")
	private WebElement searchEndDate;
	
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement searchDiscountType;
	
	@FindBy(xpath = "//input[@id='SearchDiscountCouponCode']")
	private WebElement searchCouponCode;
	
	@FindBy(xpath = "//input[@id='SearchDiscountName']")
	private WebElement searchdiscountName;
	
	@FindBy(xpath = "//select[@data-val-required='The Is Active field is required.']")
	private WebElement searchIsActive;
	
	@FindBy(xpath = "//button[@id='search-discounts']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[@href='Edit/3']")
	private WebElement editButton;
	
	@FindBy(xpath = "//input[@id='CouponCode']")
	private WebElement editingCouponCode;
	
	@FindBy(xpath = "//button[@name='save-continue']")
	private WebElement saveAndContinueEditButton;
	
	@FindBy(xpath = "//span[@id='discount-delete']")
	private WebElement deleteIcon;
	
	@FindBy(xpath = "(//button[@type='submit'])[10]")
	private WebElement deleteButton;
	
	public DiscountsPage(WebDriver driver) throws InterruptedException {
		
		   this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	       PageFactory.initElements(driver, this);
	}
	
	public void clickOnPromotionsOption() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(promotionsOption)).click();
	}
	
    public void clickOnDiscountsIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(discountsIcon)).click();
	}
    
    public void clickOnAddNewButton() throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
    }
    
    public void clickOnIsActiveBox() throws InterruptedException {
    	
   	    boolean check = isActive.isSelected();
        if (check==true) {
     	    System.out.println("It's already clicked!");
        }else {
            wait.until(ExpectedConditions.elementToBeClickable(isActive)).click();
        }
    }
    
    public void fillDiscountName(String name) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(discountName)).sendKeys(name);
    }
    
    public void selectDiscountType() throws InterruptedException {
    	
   	    Select s1 = new Select(discountType);
   	    s1.selectByVisibleText("Assigned to products");
   	    
        wait.until(ExpectedConditions.elementToBeClickable(discountType)).click();
    }
    
    public void clickOnUsePercentageBox() throws InterruptedException {
    	
   	    boolean check = usePercentage.isSelected();
        if (check==true) {
     	    System.out.println("It's already clicked!");
        }else {
            wait.until(ExpectedConditions.elementToBeClickable(usePercentage)).click();
        }
    }
    
    public void enterDiscountPercentage(String perc) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(discountPercentage)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(discountPercentage)).sendKeys(perc);
    }
    
    public void enterMaximumDiscountAmount(String amt) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(maximumDiscountAmount)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(maximumDiscountAmount)).sendKeys(amt);
    }
     
    public void clickOnRequiresCouponCodeBox() throws InterruptedException {
    	
   	    boolean check = requiresCouponCode.isSelected();
        if (check==true) {
     	    System.out.println("It's already clicked!");
        }else {
            wait.until(ExpectedConditions.elementToBeClickable(requiresCouponCode)).click();
        }
    }
    
    public void enterCouponCode(String code) {
    	
        wait.until(ExpectedConditions.elementToBeClickable(couponCode)).sendKeys(code);
    }
    
    public void startDate(String sDate) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(startDate)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(startDate)).sendKeys(sDate);
    }
    
    public void endDate(String eDate) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(endDate)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(endDate)).sendKeys(eDate);
    }
    
    public void cumulativeWithOtherDiscounts() throws InterruptedException {
    	
   	    boolean check = cumulativeWithOtherDiscounts.isSelected();
        if (check==true) {
     	    System.out.println("It's already clicked!");
        }else {
            wait.until(ExpectedConditions.elementToBeClickable(cumulativeWithOtherDiscounts)).click();
        }
    }
    
    public void selectDiscountLimitation() throws InterruptedException {
    	
   	    Select s1 = new Select(discountLimitation);
   	    s1.selectByVisibleText("Unlimited");
   	    
        wait.until(ExpectedConditions.elementToBeClickable(discountLimitation)).click();
    }
    
    public void fillAdminComment(String comment) throws InterruptedException {
    	    	
        wait.until(ExpectedConditions.elementToBeClickable(adminComment)).sendKeys(comment);
    }
    
    public void clickOnSaveButton() throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    
    public void searchingAddedProductEditingAndDeleting(String sDate,String eDate,String cCode,String dName,String edCode) throws InterruptedException {
           	    
        wait.until(ExpectedConditions.elementToBeClickable(searchStartDate)).sendKeys(sDate);
   	    
        wait.until(ExpectedConditions.elementToBeClickable(searchEndDate)).sendKeys(eDate);

   	    Select s1 = new Select(searchDiscountType);
	    s1.selectByVisibleText("Assigned to products");
        wait.until(ExpectedConditions.elementToBeClickable(searchDiscountType)).click();
	       	    
        wait.until(ExpectedConditions.elementToBeClickable(searchCouponCode)).sendKeys(cCode);
   	    
        wait.until(ExpectedConditions.elementToBeClickable(searchdiscountName)).sendKeys(dName);
   	    
   	    Select se = new Select(searchIsActive);
   	    se.selectByVisibleText("Active only");
        wait.until(ExpectedConditions.elementToBeClickable(searchIsActive)).click();
   	    
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
   	       	    
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
   	    
        wait.until(ExpectedConditions.elementToBeClickable(editingCouponCode)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(editingCouponCode)).sendKeys(edCode);
   	    
        wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueEditButton)).click();
   	    
        wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();
   	    
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }
}
