package com.hk.testcase;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.CustomerRolesPage;
import com.hk.utilities.Utility;

public class AddNewCustomerRolesTest extends Base{
  @Test
  public void verifyUserCanAddNewCustomerRolesTest() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Customer roles Page is opened");
	  
	  CustomerRolesPage customerRolesPage = PageFactory.initElements(driver,CustomerRolesPage.class);
	  
	  customerRolesPage.clickOnCustomerOptions();
	  
	  customerRolesPage.clickOnCustomerRolesIcon();
	  
	  customerRolesPage.clickOnAddNewButton();
	  
	  customerRolesPage.enterCustomerRoleName("Guests");
	  
	  customerRolesPage.activeCheckBox();
	  
	  customerRolesPage.freeShippingCheckBox();
	  
	  customerRolesPage.taxExemptCheckBox();
	  
	  customerRolesPage.overrideDefaultTaxDisplayTypeCheckBox();
	  
	  customerRolesPage.enablePasswordLifetimeCheckBox();
	  
	  customerRolesPage.selectPurchasedWithProduct();
	  
	  customerRolesPage.searchingPurchasedProductName("Asus N551JK-XO076H Laptop");
	  
	  customerRolesPage.searchButton();
      
	  customerRolesPage.selectingPurchasedProductName();
      
	  customerRolesPage.fillSystemName("Guests");
	  
	  customerRolesPage.clickOnSaveButton();
	  
	  Thread.sleep(3000);
		
	  logger.info("Validation Started!");
	  
	  boolean res = driver.getPageSource().contains("The new customer role has been added successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test case Passed!");

	  }else {
	    logger.info("Test case Failed!");
        captureScreenShot(driver, "customerRolesPage");
        Assert.assertTrue(false);
	  }
  }
}
