package com.hk.testcase;

import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.ProductTagsPage;
import com.hk.utilities.Utility;

public class ProductTagsTest extends Base{
  @Test
  public void verifyUserCanSearchForProducstTags() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");

	  logger.info("Product tags Page is opened");

	  ProductTagsPage productTags = PageFactory.initElements(driver, ProductTagsPage.class);
	  
	  productTags.clickOnCatalogIcon();
	  
	  productTags.clickOnProductTagsIcon();
	  
	  productTags.fillProductTagName("computer");
	  
	  productTags.clickOnSearchButton();
	  
	  productTags.editingTagNameAndSave("laptop");
	  
	  Thread.sleep(3000);
	  logger.info("Validation Started!");
	  
      boolean res = driver.getPageSource().contains("The product tag has been updated successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test Case Passed");

	  }else {
	    logger.info("Test Case Failed");
        captureScreenShot(driver, "searchMessageTemplatesPage");
		Assert.assertTrue(false);
	  }
  }
  
}
