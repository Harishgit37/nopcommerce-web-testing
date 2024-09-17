package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.ReportsBestSellersPage;
import com.hk.utilities.Utility;

public class ReportsBestSellersTest extends Base{
  @Test
  public void verifyUserCanCheckBestSellersReport() throws IOException {
	  
      Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");

      logger.info("BestSellers Page is opened");
      
      ReportsBestSellersPage reportsBestSellersPage = PageFactory.initElements(driver, ReportsBestSellersPage.class);
      
      reportsBestSellersPage.clickOnReportsIcon();
      
      reportsBestSellersPage.clickOnBestSellersOption();
      
      reportsBestSellersPage.enterStartDate("10-09-2010");
      
      reportsBestSellersPage.enterEndDate("");
      
      reportsBestSellersPage.selectStore();
      
      reportsBestSellersPage.selectOrderStatus();
      
      reportsBestSellersPage.selectPaymentStatus();
      
      reportsBestSellersPage.selectCategory();
      
      reportsBestSellersPage.selectManufacturer();
      
      reportsBestSellersPage.selectBillingCountry();
      
      reportsBestSellersPage.selectVendor();
      
      reportsBestSellersPage.clickOnRunReportsButton();
      
      reportsBestSellersPage.viewingSearchedReports("04-03-2023","04-03-2025");
      
      logger.info("Validation Started!");
	  
	  boolean res = driver.getPageSource().contains("The product has been updated successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test case Passed!");

	  }else {
	    logger.info("Test case Failed!");
        captureScreenShot(driver, "reportsBestSellersPage");
        Assert.assertTrue(false);
	  }
  }
}
