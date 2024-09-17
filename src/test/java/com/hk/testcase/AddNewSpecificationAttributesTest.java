package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.SpecificationAttributesPage;
import com.hk.utilities.Utility;

public class AddNewSpecificationAttributesTest extends Base{
  @Test
  public void verifyUserCanAddNewSpecificationAttributesTest() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Specification attributes Page is opened");

	  SpecificationAttributesPage specificationAttributesPage = PageFactory.initElements(driver, SpecificationAttributesPage.class);
	  
	  specificationAttributesPage.clickOnCatalogIcon();
	  
	  specificationAttributesPage.clickOnAttributesIcon();
	  
	  specificationAttributesPage.clickOnSpecificationAttributeIcon();
	  
	  specificationAttributesPage.clickOnAddNewButton();
	  
	  specificationAttributesPage.fillSpecificationAttributeName("mobile");
	  
	  specificationAttributesPage.selectSpecificationAttributeGroup();
	  
	  specificationAttributesPage.fillSpecificationAttributeDisplayOrder("9");
	  
	  specificationAttributesPage.clickOnSaveButton();
	  
	  Thread.sleep(3000);
	  logger.info("Validation Started!");
	  
      boolean res = driver.getPageSource().contains("The new attribute has been added successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test Case Passed");

	  }else {
	    logger.info("Test Case Failed");
        captureScreenShot(driver, "specificationAttributesPage");
		Assert.assertTrue(false);
	  }
  }
}
