package com.hk.testcase;

import java.io.IOException;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.ProductAttributesPage;
import com.hk.utilities.Utility;

public class AddNewProductAttributesTest extends Base{
  @Test
  public void verifyUserCanAddNewProductAttributesTest() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Product attributes Page is opened");

	  ProductAttributesPage productAttributesPage = PageFactory.initElements(driver, ProductAttributesPage.class);
	  
	  productAttributesPage.clickOnCatalogIcon();
	  
	  productAttributesPage.clickOnAttributesIcon();
	  
	  productAttributesPage.clickOnProductsAttributeIcon();
	  
	  productAttributesPage.clickOnAddNewButton();
	  
	  productAttributesPage.fillProductAttributeName("Brand");
	  
	  productAttributesPage.switchToProductAttributeDescriptionFrame();
	  
	  productAttributesPage.fillProductAttributeDescription("");
	  
	  productAttributesPage.switchProductInfoContent();
	  
	  productAttributesPage.clickOnSaveButton();
	  
	  Thread.sleep(3000);
		
	  logger.info("Validation Started!");
		  
	  boolean res = driver.getPageSource().contains("The new attribute has been added successfully.");
		  
		  if (res==true) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");

		  }else {
		    logger.info("Test Case Failed");
	        captureScreenShot(driver, "productAttributesPage");
	        Assert.assertTrue(false);
		  }
      }
}
