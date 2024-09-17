package com.hk.testcase;

import java.io.IOException;



import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.ProductsPage;
import com.hk.utilities.Utility;

public class AddNewProductsTest extends Base {
	

	@Test
	public void verifyUserCanAddNewProduct() throws InterruptedException, IOException {
		
		Utility utility = new Utility();
		
	    logger.info("Entered Username, Password");

		utility.loginPage("admin@yourstore.com", "admin");
	
		logger.info("Products Page is opened");

		ProductsPage productsPage = PageFactory.initElements(driver,ProductsPage.class);
		
		productsPage.clickOnCatalogIcon();
		
		productsPage.clickOnProductsOption();
		
		productsPage.clickOnAddNewButton();
		
		logger.info("Providing Customer Details");
		
		productsPage.fillProductName("oneplus 7T");
		
		productsPage.fillShortDescription("The OnePlus 7T and 7T Pro are Android-based smartphones manufactured by OnePlus."
				+ "The 7T and 7T Pro's designs are similar to their predecessors, with an anodized aluminum frame and Gorilla Glass on both the front and back. ");
		
		productsPage.switchToFullDescriptionFrame();
		
		productsPage.fillFullDescription("The OnePlus 7T and 7T Pro are Android-based smartphones manufactured by OnePlus."
				+ "The 7T was unveiled on 26 September 2019, and the 7T Pro was unveiled on 10 October 2019."
				+ "The McLaren edition from the 6T returns on the 7T Pro.[2] Both have minor upgrades as with previous T phones, such as new software, upgraded cameras and a faster chipset.");
		
		productsPage.switchProductInfoContent();
		
		productsPage.fillSku("One-plus-7T");
		
		productsPage.clickOnCategoriesIcon();
		
		productsPage.clickOnManufacturesIcon();
		
		productsPage.clickPublisedCheckBox();
		
		productsPage.scrollDown();
		
		productsPage.fillProductTags("mobile");
		
		productsPage.clickOnProductType("Simple");
				
		productsPage.fillAvailableStartDate("3/12/2024 12:00 AM");
		
		productsPage.fillAvailableEndDate("3/12/2025 12:00 AM");
		
		productsPage.fillPrices("35000");
		
		productsPage.clickOnSaveButton();
		
		productsPage.scrollDown();

		productsPage.searchAndEditProduct("Lenovo Thinkpad X1 Carbon Laptop", "C:\\Users\\keerthana\\Downloads\\Lenovo Thinkpad X1 Carbon.jpg");
		
		productsPage.scrollDown();
		
		Thread.sleep(3000);
		
		logger.info("Validation Started!");
		  
		boolean res = driver.getPageSource().contains("The product has been updated successfully.");
		  
		  if (res==true) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");

		  }else {
		    logger.info("Test Case Failed");
	        captureScreenShot(driver, "productPage");
	        Assert.assertTrue(false);
		  }
	}
}
