package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.DiscountsPage;
import com.hk.utilities.Utility;

public class AddNewDiscountsTest extends Base{
  @Test
  public void verifyUserCanAbleToAddNewDiscountsTest() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");
	  
	  logger.info("Discounts Page is opened");

	  DiscountsPage discountsPage = PageFactory.initElements(driver,DiscountsPage.class);
	  
	  discountsPage.clickOnPromotionsOption();
	  
	  discountsPage.clickOnDiscountsIcon();

	  discountsPage.clickOnAddNewButton();

	  discountsPage.clickOnIsActiveBox();

	  discountsPage.fillDiscountName("Purchase above 1000 and avail offer worth 10% discount ");

	  discountsPage.selectDiscountType();

	  discountsPage.clickOnUsePercentageBox();
	  
	  discountsPage.enterDiscountPercentage("10%");
	  
	  discountsPage.enterMaximumDiscountAmount("1000");

	  discountsPage.clickOnRequiresCouponCodeBox();
	  
	  discountsPage.enterCouponCode("5417");
	  
	  discountsPage.startDate("04-05-2024");
	  
	  discountsPage.endDate("29-12-2024");
	  
	  discountsPage.cumulativeWithOtherDiscounts();
	  
	  discountsPage.selectDiscountLimitation();
	  
	  discountsPage.fillAdminComment("Nice");
	  
	  discountsPage.clickOnSaveButton();
	  
	  discountsPage.searchingAddedProductEditingAndDeleting("04-05-2024", "29-12-2024", "5417", "Purchase above 1000 and avail offer worth 10% discount","4725");
      
  	  Thread.sleep(3000);
	
	  logger.info("Validation Started!");
	  
	  boolean res = driver.getPageSource().contains("The new discount has been added successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test case Passed!");

	  }else {
	    logger.info("Test case Failed!");
        captureScreenShot(driver, "discountsPage");
        Assert.assertTrue(false);
	  }
  }
}
