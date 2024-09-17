package com.hk.testcase;

import java.io.IOException;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.CustomersPage;
import com.hk.utilities.Utility;

public class AddNewCustomersTest extends Base{
  @Test
  public void verifyUserCanAddNewCustomers() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Customers Page is opened");

	  CustomersPage customersPage = PageFactory.initElements(driver, CustomersPage.class);
	  
	  customersPage.clickOnCustomerOptions();
	  
	  customersPage.clickOnCustomersIcon();
	  
	  customersPage.clickOnAddNewButton();
	  
	  customersPage.fillEmail("sharishkumar3720@gmail.com");
	  
	  customersPage.fillPassword("hknop19#");
	  
	  customersPage.fillFirstName("Harish");
	  
	  customersPage.fillLastName("kumar");
	  
	  customersPage.clickOnGender();

	  customersPage.fillDateOfBirth("03-07-2000");
	  
	  customersPage.fillCompanyName("abc");
	  
	  customersPage.isTaxExempt();
	  
	  customersPage.clickOnNewsLetter();
	  
	  //addNewCustomersPage.clickOnCustomerRoles();
	  
	  customersPage.clickOnManagerOfVendor();
	  
	  customersPage.active();
	  
	  customersPage.fillAdminComment("Nice");
	  
	  customersPage.clickOnSaveButton();  
	  
	  Thread.sleep(3000);
		
	  logger.info("Validation Started!");
	  
	  boolean res = driver.getPageSource().contains("The new customer has been added successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test case Passed!");

	  }else {
	    logger.info("Test case Failed!");
        captureScreenShot(driver, "customersPage");
        Assert.assertTrue(false);
	  }
  }
}
