package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.SearchMessageTemplatesPage;
import com.hk.utilities.Utility;

public class SearchMessageTemplatesTest extends Base{
  @Test
  public void verifyUserCanAbleToSearchMessageTemplates() throws InterruptedException ,IOException{
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Search message templates Page is opened");

	  SearchMessageTemplatesPage searchMessageTemplatesPage = PageFactory.initElements(driver, SearchMessageTemplatesPage.class);
	  searchMessageTemplatesPage.clickOnContentManagementIcon();
	  searchMessageTemplatesPage.clickOnMessageTemplatesOption();
	  searchMessageTemplatesPage.fillSearchKeywords("paid");
	  searchMessageTemplatesPage.selectIsActiveProperty();
	  searchMessageTemplatesPage.searchButton();
	  searchMessageTemplatesPage.editOrderPaidStoreOwnerNotification("sharishkumar377@gmail.com");
	  
	  Thread.sleep(3000);
	  logger.info("Validation Started!");
	  
      boolean res = driver.getPageSource().contains("The message template has been updated successfully.");
	  
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
