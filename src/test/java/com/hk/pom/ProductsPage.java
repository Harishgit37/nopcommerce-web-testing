package com.hk.pom;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hk.helper.Base;

public class ProductsPage extends Base{

	private WebDriverWait wait;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview']//following-sibling::p")
	private WebElement catalogIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/Product/List']//following-sibling::p")
	private WebElement productsOption;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@name='Name']")
	private WebElement productName;
	
	@FindBy(xpath = "//textarea[@name='ShortDescription']")
	private WebElement shortDescription;
	
	@FindBy(xpath = "//iframe[@id='FullDescription_ifr']")
	private WebElement fullDescriptionFrame;
	
	@FindBy(xpath = "//body[@data-id='FullDescription']")
	private WebElement fullDescription;

	@FindBy(xpath = "//input[@id='Sku']")
	private WebElement sku;

	@FindBy(xpath = "//select[@id='SelectedCategoryIds']")
	private WebElement categories;

	@FindBy(xpath = "//select[@id='SelectedManufacturerIds']")
	private WebElement manufactures;

	@FindBy(xpath = "//input[@name='Published']")
	private WebElement published;
	
	@FindBy(tagName = "html")
	private WebElement scrollDown;
	
	@FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
	private WebElement productTags;
    
	@FindBy(xpath = "//input[@id='ShowOnHomepage']")
	private WebElement showOnHomePage;
	
	@FindBy(xpath = "//select[@name='ProductTypeId']")
	private WebElement productType;

	@FindBy(xpath = "//input[@id='VisibleIndividually']")
	private WebElement visibleIndividually;
	
	@FindBy(xpath = "//input[@aria-owns='SelectedCustomerRoleIds_taglist SelectedCustomerRoleIds_listbox']")
	private WebElement customerRoles;

	@FindBy(xpath = "//input[@data-val-required='The Allow customer reviews field is required.']")
	private WebElement allowCustomerReviews;
	
	@FindBy(xpath = "//input[@id='AvailableStartDateTimeUtc']")
	private WebElement availableStartDate;

	@FindBy(xpath = "//input[@id='AvailableEndDateTimeUtc']")
	private WebElement availableEndDate;

	@FindBy(xpath = "//input[@id='Price']")
	private WebElement prices;

	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@name='SearchProductName']")
	private WebElement searchProductName;
	
	@FindBy(xpath = "//button[@id='search-products']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[@href='Edit/9']")
	private WebElement editButton;
	
	@FindBy(xpath = "(//input[@title='file input'])[1]")
	private WebElement pictureUploadFiles;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary'])[1]")
	private WebElement editProductSaveButton;
	
	public ProductsPage(WebDriver driver) throws InterruptedException {
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    PageFactory.initElements(driver, this);
	}
	
	public void clickOnCatalogIcon() throws InterruptedException {
		
        wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
    }
	
	public void clickOnProductsOption() throws InterruptedException{
		

        wait.until(ExpectedConditions.elementToBeClickable(productsOption)).click();
	}
	
	public void clickOnAddNewButton() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
    }
	
	public void fillProductName(String name) throws InterruptedException {
		

        wait.until(ExpectedConditions.elementToBeClickable(productName)).sendKeys(name);
	}
	
    public void fillShortDescription(String sD) throws InterruptedException {
    	

        wait.until(ExpectedConditions.elementToBeClickable(shortDescription)).sendKeys(sD);
	}
    
    public void switchToFullDescriptionFrame() {
    	
    	driver.switchTo().frame(fullDescriptionFrame);
    }
    
    public void fillFullDescription(String fD) throws InterruptedException {
    	

        wait.until(ExpectedConditions.elementToBeClickable(fullDescription)).sendKeys(fD);
    }
    
    public void switchProductInfoContent() {
    	
    	driver.switchTo().defaultContent();
    }
    
    public void fillSku(String sKu) throws InterruptedException {
    	

        wait.until(ExpectedConditions.elementToBeClickable(sku)).sendKeys(sKu);
    }
    
    public void clickOnCategoriesIcon() throws InterruptedException {
    	        
        Select s1 = new Select(categories);
	    s1.selectByVisibleText("Electronics >> Cell phones");
	    
        wait.until(ExpectedConditions.elementToBeClickable(categories)).click();

	    
    }
    
    public void clickOnManufacturesIcon() throws InterruptedException {
    	
        Select s1 = new Select(manufactures);
	    s1.selectByVisibleText("Apple");
	    
        wait.until(ExpectedConditions.elementToBeClickable(manufactures)).click();
    }
    
    public void clickPublisedCheckBox() throws InterruptedException {
    	
        boolean check = published.isSelected();
        if (check==true) 
           System.out.println("It's already clicked!");
        else 
           wait.until(ExpectedConditions.elementToBeClickable(published)).click();    
    }
    
    public void scrollDown() {
    	 
       JavascriptExecutor executor = (JavascriptExecutor) driver;
       executor.executeScript("window.scrollBy(0,1000)");
       wait.until(ExpectedConditions.elementToBeClickable(scrollDown)).click();
    }
    
    public void fillProductTags(String pTags) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(productTags)).sendKeys(pTags);
    }
    
    public void clickShowOnHomePageCheckBox() throws InterruptedException {
    	
        boolean check = showOnHomePage.isSelected();
        if (check==true) 
        	System.out.println("It's already clicked!");
        else 
            wait.until(ExpectedConditions.elementToBeClickable(showOnHomePage)).click();
    }

    public void clickOnProductType(String pType) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(productType)).sendKeys(pType);
    }
    
    public void clickVisibleIndividuallyCheckBox() throws InterruptedException {
     	
        boolean check = visibleIndividually.isSelected();
        if (check==true) 
        	System.out.println("It's already clicked!");
        else 
            wait.until(ExpectedConditions.elementToBeClickable(visibleIndividually)).click();
    }
    
    public void clickAllowCustomerReviewsCheckBox() throws InterruptedException {
     	
    	boolean check = allowCustomerReviews.isSelected();
        if (check==true) 
        	System.out.println("It's already clicked!");
        else 
            wait.until(ExpectedConditions.elementToBeClickable(allowCustomerReviews)).click();
    }
    
    public void fillAvailableStartDate(String avlStartDate) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(availableStartDate)).sendKeys(avlStartDate);
    }
    
    public void fillAvailableEndDate(String avlEndDate) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(availableEndDate)).sendKeys(avlEndDate);
    }
    
    public void fillPrices(String price) throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(prices)).sendKeys(price);
    }
    
    public void clickOnSaveButton() throws InterruptedException {
    	
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    
    public void searchAndEditProduct(String name,String uplFiles) throws InterruptedException {
    	
    	driver.navigate().back();
    	        
        wait.until(ExpectedConditions.elementToBeClickable(searchProductName)).sendKeys(name);
        
        if (searchProductName.equals("Lenovo Thinkpad X1 Carbon Laptop")) 
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        else 
            System.out.println("The Product your trying to search is not found!");
        
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(pictureUploadFiles)).sendKeys(uplFiles);
        
        wait.until(ExpectedConditions.elementToBeClickable(editProductSaveButton)).click();
    }
}
