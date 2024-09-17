
package com.hk.testcase;

import java.io.IOException;




import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hk.helper.Base;
import com.hk.pom.DashboardPage;
import com.hk.pom.LoginPage;
import com.hk.utilities.Utility;

public class LoginTest extends Base {
	 
  
  public String sheetName = "sheetName";
  
  @Test
  public void verifyUserCanLoginWithValidCred() throws  IOException {
	  
      LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
      loginPage.clickVerificationCheckBox();
      
	  Utility utility = new Utility();
	  logger.info("Entered Username, Password");
	  utility.loginPage("admin@yourstore.com", "admin");
	  logger.info("Login Page is opened");
	  DashboardPage adminDashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	  Assert.assertTrue(adminDashboardPage.getDashBoardTitle().isDisplayed());
	  logger.info("Login Test Passed");
  }
}
