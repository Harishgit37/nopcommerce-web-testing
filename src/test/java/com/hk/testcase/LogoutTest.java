package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.LogoutPage;
import com.hk.utilities.Utility;

public class LogoutTest extends Base{
  @Test
  public void verifyUserCanBeAbleToLogout() throws InterruptedException, IOException {
	  	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Logout Page is opened");

	  LogoutPage logoutPage = PageFactory.initElements(driver, LogoutPage.class);
	  logoutPage.clickOnLogOutButton();
	  
	  Thread.sleep(3000);
	  logger.info("Validation Started!");
	  
      boolean res = driver.getPageSource().contains(url);
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test Case Passed");

	  }else {
	    logger.info("Test Case Failed");
        captureScreenShot(driver, "logoutPage");
		Assert.assertTrue(false);
	  }
  }
}
