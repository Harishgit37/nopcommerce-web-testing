package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.CheckOutAttributesPage;
import com.hk.utilities.Utility;

public class AddNewCheckoutAttributesTest extends Base{
  @Test
  public void verifyUserCanAddNewCheckOutAttributesTest() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Checkout attributes Page is opened");

	  CheckOutAttributesPage checkOutAttributesPage = PageFactory.initElements(driver,CheckOutAttributesPage.class);
	  
	  checkOutAttributesPage.clickOnCatalogIcon();
	  
	  checkOutAttributesPage.clickOnAttributesIcon();
	  
	  checkOutAttributesPage.clickOnCheckoutAttributesIcon();
	  
	  checkOutAttributesPage.clickOnAddNewButton();
	  
	  checkOutAttributesPage.enterCheckoutAttributeName("Coupon code");
	  
	  checkOutAttributesPage.enterTextPrompt("");
	  
	  checkOutAttributesPage.selectCheckoutAttributeControlType();
	  
	  checkOutAttributesPage.requiredCheckBox();
	  
	  checkOutAttributesPage.enterCheckoutAttributeDisplayOrder("2");
	  
	  checkOutAttributesPage.shippableProductRequiredCheckBox();
	  	  
	  checkOutAttributesPage.selectTaxCategory();
	  	  
	  checkOutAttributesPage.clickOnSaveButton();
	  
	  Thread.sleep(3000);
		
	  logger.info("Validation Started!");
	  
	  boolean res = driver.getPageSource().contains("The new attribute has been added successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test case Passed!");

	  }else {
	    logger.info("Test case Failed!");
        captureScreenShot(driver, "checkOutAttributesPage");
        Assert.assertTrue(false);
	  }
  }
}
