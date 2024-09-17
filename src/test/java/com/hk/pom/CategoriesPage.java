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

public class CategoriesPage extends Base{
	
	private WebDriverWait wait;	

	@FindBy(xpath = "//li[@class='nav-item has-treeview']//following-sibling::p")
	private WebElement catalogIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/Category/List']")
	private WebElement categoriesOption;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@data-val-required='Please provide a name.']")
	private WebElement categoryName;
	
	@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']")
	private WebElement categoryDescriptionFrame;
	
	@FindBy(xpath = "//body[@data-id='Description']")
	private WebElement categoryDescription;
	
	@FindBy(xpath = "//select[@data-val-required='The Parent category field is required.']")
	private WebElement parentCategory;
	
	@FindBy(css   = "input[title='file input']")
	private WebElement uploadFile;

	@FindBy(xpath = "//input[@id='Published']")
	private WebElement published;
	
	@FindBy(xpath = "//input[@id='ShowOnHomepage']")
	private WebElement showOnHomePage;
	
	@FindBy(xpath = "(//input[@class='check-box'])[3]")
	private WebElement includeInTopMenu;

	@FindBy(xpath = "(//input[@type='number'])[4]")
	private WebElement pageSize;
	
	@FindBy(xpath = "//input[@id='PriceRangeFiltering']")
	private WebElement priceRangeFiltering;
	
	@FindBy(id  = "ManuallyPriceRange")
	private WebElement enterPriceRangeManually;
	
	@FindBy(xpath = "//input[@id='PriceFrom']")
	private WebElement priceFrom;

	@FindBy(xpath = "//input[@id='PriceTo']")
	private WebElement priceTo;

	@FindBy(xpath = "//input[@id='DisplayOrder']")
	private WebElement displayOrder;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement saveButton;
	
	
	public CategoriesPage(WebDriver driver)  {
		
		   this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	       PageFactory.initElements(driver, this);
	}

	public void clickOnCatalogIcon()  {

		wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
	}

    public void clickCategoriesOption()  {     

		wait.until(ExpectedConditions.elementToBeClickable(categoriesOption)).click();
	}

	public void clickOnAddNewButton()  {
            
		wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
	}

    public void fillCategoryName(String name)  {
            
		wait.until(ExpectedConditions.elementToBeClickable(categoryName)).sendKeys(name);
	}

	public void switchToCategoryDescriptionFrame() {
		
	    driver.switchTo().frame(categoryDescriptionFrame);
	}

	public void fillCategoryDescription(String description)  {
       
		wait.until(ExpectedConditions.elementToBeClickable(categoryDescription)).sendKeys(description);
	}

	public void switchToDefaultContent() {
		
	    driver.switchTo().defaultContent();
	}
	    
	public void clickOnParentCategory()   {
       
		Select s1 = new Select(parentCategory);
		s1.selectByVisibleText("Books");
		wait.until(ExpectedConditions.elementToBeClickable(parentCategory));
	}

    public void pictureUploadFile(String filePath)   {
         
    	uploadFile.sendKeys(filePath);
	}
	
    public void publishedCheckBox()  {
    	
    	boolean check = published.isSelected();
        if (check==true) 
     	    System.out.println("It's already clicked!");
        else 
    		wait.until(ExpectedConditions.elementToBeClickable(published)).click();
    }
    
    public void showOnHomePageCheckBox()   {
    	
    	boolean check = showOnHomePage.isSelected();
        if (check==true) 
     	    System.out.println("It's already clicked!");
        else 
    		wait.until(ExpectedConditions.elementToBeClickable(showOnHomePage)).click();
    }
    
    public void includeInTopMenuCheckBox()   {
    
    	boolean check = includeInTopMenu.isSelected();
        if (check==true) 
     	    System.out.println("It's already clicked!");
        else 
    		wait.until(ExpectedConditions.elementToBeClickable(includeInTopMenu)).click();
    }
    
    public void enterPageSize(String size)  {
    	
    	pageSize.clear();
		wait.until(ExpectedConditions.elementToBeClickable(pageSize)).sendKeys(size);
    }
    
    public void priceRangeFilteringCheckBox()  {

    	boolean check = priceRangeFiltering.isSelected();
        if (check==true) 
     	    System.out.println("It's already clicked!");
        else 
    		wait.until(ExpectedConditions.elementToBeClickable(priceRangeFiltering)).click();
    }
    
    public void enterPriceRangeManuallyCheckBox()  {
    	

    	boolean check = enterPriceRangeManually.isSelected();
        if (check==true) 
     	    System.out.println("It's already clicked!");
        else 
    		wait.until(ExpectedConditions.elementToBeClickable(enterPriceRangeManually)).click();
    }
    
	public void fillPriceFrom(String pFrom)  {
        
        priceFrom.clear();
		wait.until(ExpectedConditions.elementToBeClickable(priceFrom)).sendKeys(pFrom);
	}
	
	public void fillPriceTo(String pTo)  {

        priceTo.clear();
		wait.until(ExpectedConditions.elementToBeClickable(priceTo)).sendKeys(pTo);
	}

	public void enterDisplayOrder(String order)  {
	    	
        displayOrder.clear();
		wait.until(ExpectedConditions.elementToBeClickable(displayOrder)).sendKeys(order);
    }
	
	public void clickOnSaveButton()  {

		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	}  
}
