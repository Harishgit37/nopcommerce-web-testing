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

public class ManufacturersPage extends Base{
   
	 private WebDriverWait wait;
	
     @FindBy(xpath = "//li[@class='nav-item has-treeview']//following-sibling::p")
 	 private WebElement catalogIcon;
     
     @FindBy(xpath = "//a[@href='/Admin/Manufacturer/List']")
     private WebElement manufacturersIcon;
     
     @FindBy(xpath = "//a[@class='btn btn-primary']")
     private WebElement addNewButton;
     
     @FindBy(xpath = "//input[@id='Name']")
     private WebElement manufacturerName;
     
     @FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']")
     private WebElement manufacturerDescriptionFrame;

     @FindBy(xpath = "//body[@data-id='Description']")
     private WebElement manufacturerDescription;
     
     @FindBy(xpath = "//input[@title='file input']")
     private WebElement pictureUpload;
     
//     @FindBy(xpath = "(//button[@class='btn btn-tool'])[2]")
//     private WebElement displayPlusButton;
     
     @FindBy(xpath = "//input[@id='Published']")
     private WebElement publishedCheckBox;
     
     @FindBy(xpath = "//input[@id='PageSizeOptions']")
     private WebElement pageSize;

     @FindBy(xpath = "//input[@id='PriceRangeFiltering']")
     private WebElement priceRangeFiltering;
     
     @FindBy(xpath = "//input[@data-val-required='The Enter price range manually field is required.']")
     private WebElement enterPriceRangeManually;

     @FindBy(xpath = "//input[@name='PriceFrom']")
     private WebElement priceFrom;
     
     @FindBy(xpath = "//input[@name='PriceTo']")
     private WebElement priceTo;
     
     @FindBy(xpath = "(//input[@type='number'])[4]")
     private WebElement displayOrder;

     @FindBy(xpath = "//button[@class='btn btn-primary']")
     private WebElement saveButton;
     
     @FindBy(xpath = "//input[@class='form-control text-box single-line']")
     private WebElement searchManufacturerName;
     
     @FindBy(xpath = "(//select[@class='form-control'])[2]")
     private WebElement searchPublished;
     
     @FindBy(xpath = "//button[@id='search-manufacturers']")
     private WebElement searchButton;
     
     public ManufacturersPage(WebDriver driver) throws InterruptedException {
    	 
    	 this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	     PageFactory.initElements(driver, this);
     }
     
     public void clickOnCatalogIcon() throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
     }
     
     public void clickOnManufacturersIcon() throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(manufacturersIcon)).click();
     }
     
     public void clickOnAddNewButton() throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
     }
     
     public void fillManufacturersName(String manfName) throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(manufacturerName)).sendKeys(manfName);
     }
     
     public void switchToManufacturerDescriptionFrame() {
    	 
    	 driver.switchTo().frame(manufacturerDescriptionFrame);
     }
     
     public void fillManufacturerDescription(String desc) throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(manufacturerDescription)).sendKeys(desc);
     }
     
     public void switchToDefaultContent() {
 		
	     driver.switchTo().defaultContent();
	 }
     
     public void uploadPicture(String uplPicture) throws InterruptedException {
    	     	 
    	 wait.until(ExpectedConditions.elementToBeClickable(pictureUpload)).sendKeys(uplPicture);
     }
//     
//     public void clickDisplayPlusButton() throws InterruptedException {
//    	 
//    	 Thread.sleep(3000);
//
//    	 displayPlusButton.click();
//     }
     
     public void clickPublisedCheckBox() throws InterruptedException {
     	
         boolean check = publishedCheckBox.isSelected();
         if (check==true) {
        	 wait.until(ExpectedConditions.elementToBeClickable(publishedCheckBox)).click();
         }else {
         	System.out.println("It's already clicked!");
         }
     }
     
     public void enterPageSizeOptions(String size) throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(pageSize)).clear();
    	 wait.until(ExpectedConditions.elementToBeClickable(pageSize)).sendKeys(size);
     }
     
     public void clickPriceRangeFilteringCheckBox() throws InterruptedException {
      	
         boolean check = priceRangeFiltering.isSelected();
         if (check==true) {
        	 wait.until(ExpectedConditions.elementToBeClickable(priceRangeFiltering)).click();
         }else {
         	System.out.println("It's already clicked!");
         }
     }
     
     public void clickEnterPriceRangeManuallyCheckBox() throws InterruptedException {
      	
         boolean check = enterPriceRangeManually.isSelected();
         if (check==true) {
        	 wait.until(ExpectedConditions.elementToBeClickable(enterPriceRangeManually)).click();
         }else {
         	System.out.println("It's already clicked!");
         }
     }
     
     public void enterPriceFrom(String pFrom) throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(priceFrom)).clear();
    	 wait.until(ExpectedConditions.elementToBeClickable(priceFrom)).sendKeys(pFrom);
     }
     
     public void enterPriceTo(String pTo) throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(priceTo)).clear();
    	 wait.until(ExpectedConditions.elementToBeClickable(priceTo)).sendKeys(pTo);
     }

     
     public void enterDisplayOrder(String order) throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(displayOrder)).clear();
    	 wait.until(ExpectedConditions.elementToBeClickable(displayOrder)).sendKeys(order);
     }
     
     public void clickOnSaveButton() throws InterruptedException {
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click(); 
     } 
     
     public void searchingAddedProduct(String name) throws InterruptedException {
    	      	 
    	 wait.until(ExpectedConditions.elementToBeClickable(searchManufacturerName)).sendKeys(name);
		
         Select s1 = new Select(searchPublished);
 	     s1.selectByVisibleText("All");
    	 
    	 if (searchManufacturerName.equals("Adidas")){
        	 wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click(); 
    	 } else {
             System.out.println("The Manufacturer name you are trying to search is not found!");
 		}
     }
}
