package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.ProductReviewsPage;
import com.hk.utilities.Utility;

public class ProductReviewsTest extends Base{
  @Test
  public void verifyUserCanReviewProductsTest() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Product reviews Page is opened");

	  ProductReviewsPage productReviews = PageFactory.initElements(driver, ProductReviewsPage.class);

	  productReviews.clickOnCatalogIcon();
	  
	  productReviews.clickOnProductReviewsIcon();
	  
	  productReviews.fillSearchDateCreatedFrom("13-03-2017");
	  
	  productReviews.fillSearchDateCreatedTo("");
	  
	  productReviews.fillSearchInTitleMessage("");
	  
	  productReviews.selectSearchApprovedProperty();
	  
	  productReviews.fillSearchSpecificProduct("Windows 8 Pro");
	  	  
	  productReviews.clickOnSearchButton();
	  
	  productReviews.scrollDown();
	  
	  productReviews.editProductReviewDetails();
	  
	  Thread.sleep(3000);
	  logger.info("Validation Started!");
	  
      boolean res = driver.getPageSource().contains("The product review has been updated successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test Case Passed");

	  }else {
	    logger.info("Test Case Failed");
        captureScreenShot(driver, "productReviews");
		Assert.assertTrue(false);
	  }
  }
}
