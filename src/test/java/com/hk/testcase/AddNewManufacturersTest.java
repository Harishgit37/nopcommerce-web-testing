package com.hk.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.ManufacturersPage;
import com.hk.utilities.Utility;

public class AddNewManufacturersTest extends Base{
  @Test
  public void verifyUserCanAddNewManufacturerTest() throws InterruptedException, IOException {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");
	  
	  utility.loginPage("admin@yourstore.com", "admin");

	  logger.info("Manufacturers Page is opened");

	  ManufacturersPage manufacturersPage = PageFactory.initElements(driver, ManufacturersPage.class);
	  
	  manufacturersPage.clickOnCatalogIcon();
	  
	  manufacturersPage.clickOnManufacturersIcon();
	 
	  manufacturersPage.clickOnAddNewButton();
	  
	  manufacturersPage.fillManufacturersName("Adidas");
	  
	  manufacturersPage.switchToManufacturerDescriptionFrame();
	  
	  manufacturersPage.fillManufacturerDescription("The adidas x Pabllo Vittar Pride collection features some of adidas' classic silhouettes, with each piece infused with Vittar's on-stage signature style. "
	  		+ "Drawing inspiration from Brazilian swimwear, the collection is designed to complement different body shapes so everyone can feel powerful in their own skin."
	  		+ " With the rallying cry of \"Love Unites,\" the collection celebrates individuality, our bodies as they are and encourages allyship.");
	  
	  manufacturersPage.switchToDefaultContent();
	  
	  manufacturersPage.uploadPicture("C:\\Users\\keerthana\\Downloads\\pride-cap.jpg");
	  	  
	  manufacturersPage.clickPublisedCheckBox();
	  
	  manufacturersPage.enterPageSizeOptions("6");
	  
	  manufacturersPage.clickPriceRangeFilteringCheckBox();
	  
	  manufacturersPage.clickEnterPriceRangeManuallyCheckBox();
	  
	  manufacturersPage.enterPriceFrom("1499");
	  
	  manufacturersPage.enterPriceTo("2499");
	  
	  manufacturersPage.enterDisplayOrder("2");
	  
	  manufacturersPage.clickOnSaveButton();
	  
	  manufacturersPage.searchingAddedProduct("Adidas");
      
      Thread.sleep(3000);
		
	  logger.info("Validation Started!");
	  
	  boolean res = driver.getPageSource().contains("The new manufacturer has been added successfully.");
	  
	  if (res==true) {
		  
		 Assert.assertTrue(true);
		 logger.info("Test Case Passed");

	  }else {
		  
	    logger.info("Test Case Failed");
        captureScreenShot(driver, "manufacturersPage");
        Assert.assertTrue(false);
	  }
  }
}
