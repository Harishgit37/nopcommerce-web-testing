package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.SystemLogPage;
import com.hk.utilities.Utility;

public class SystemLogTest extends Base{
  @Test
  public void verifyUserCanSearchSystemLogTest() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("System log Page is opened");

	  SystemLogPage systemLogPage = PageFactory.initElements(driver, SystemLogPage.class);
	  systemLogPage.clickOnSystemIcon();
	  systemLogPage.clickOnLogOption();
	  
	  logger.info("Providing System Log Details");
	  
	  systemLogPage.fillDateCreatedFrom("05/02/2024");
	  systemLogPage.fillDateCreatedTo("");
	  systemLogPage.enterMessage("Resource string (admin.configuration.appsettings.distributedcache.publishintervalms) is not found. Language ID = 1");
	  systemLogPage.selectLogLevel();
	  systemLogPage.clickOnSearchButton();
	  systemLogPage.listingAllLogs();
	  systemLogPage.warningLogLevelViewAndDeleting();
	  
	  Thread.sleep(3000);
	  logger.info("Validation Started!");
	  
	  boolean res = driver.getPageSource().contains("The log entry has been deleted successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test Case Passed");

	  }else {
	    logger.info("Test Case Failed");
        captureScreenShot(driver, "systemLogPage");
		Assert.assertTrue(false);
	  }
  }
}
