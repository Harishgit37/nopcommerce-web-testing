package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.ShipmentsSearchPage;
import com.hk.utilities.Utility;

public class ShipmentsSearchTest extends Base{
	

  @Test
  public void verifyUserCanSearchShipmentsTest() throws IOException, InterruptedException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin"); 
	  
	  logger.info("Shipments Page is opened");

	  ShipmentsSearchPage searchPage = PageFactory.initElements(driver, ShipmentsSearchPage.class);
	  searchPage.clickOnSalesIcon();
	  searchPage.clickOnOrdersOption();
	  searchPage.fillStartDate("03-03-2024");
	  searchPage.fillEndDate("03-05-2024");
	  searchPage.fillTrackingNumber("TN01");
	  searchPage.selectWareHouse();
	  searchPage.clickLoadNotDeliveredCheckBox();
	  searchPage.selectCountry();
	  searchPage.selectStateOrProvince();
	  searchPage.fillCountyOrRegion("Nil");
	  searchPage.fillCity("Chennai");
	  searchPage.clickLoadNotShippedCheckBox();
	  searchPage.clickLoadNotReadyForPickUpCheckBox();
	  //searchPage.clickOnSearchButton();
	  searchPage.scrollDown();
	  searchPage.listingAllShipmentDetails();
	  searchPage.displayingShipmentDetails();
	  searchPage.printPackingSlip();
	  
	  Thread.sleep(3000);
	  logger.info("Validation Started!");
	  
      boolean res = driver.getPageSource().contains("Print packaging slip");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test Case Passed");

	  }else {
	    logger.info("Test Case Failed");
        captureScreenShot(driver, "searchPage");
		Assert.assertTrue(false);
	  }
  }
}
