package com.hk.testcase;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hk.helper.Base;
import com.hk.pom.CategoriesPage;
import com.hk.utilities.Utility;

public class CategoriesTest extends Base {
	
	
  @Test
  public void verifyUserCanAddNewCategoriesTest() throws IOException  {
	  
	  Utility utility = new Utility();
	  
	  logger.info("Entered Username, Password");

	  utility.loginPage("admin@yourstore.com", "admin");

      logger.info("Categories Page is opened");

	  CategoriesPage categoriesPage = PageFactory.initElements(driver, CategoriesPage.class);
	  
	  categoriesPage.clickOnCatalogIcon();
	  
	  categoriesPage.clickCategoriesOption();
	  
	  categoriesPage.clickOnAddNewButton();
	  
	  categoriesPage.fillCategoryName("Book");
	  
	  categoriesPage.switchToCategoryDescriptionFrame();
	  
	  categoriesPage.fillCategoryDescription("For over a decade, Mahendra Singh Dhoni has captivated the world of cricket and over a billion Indians with his incredible ingenuity as captain, wicketkeeper and batsman. Bharat Sundaresan tracks down the cricketer's closest friends in Ranchi and artfully presents the different shades of Dhoni-the Ranchi boy, the fauji, the diplomat, Chennai's beloved Thala, the wicketkeeping Pythagoras-and lays bare the man underneath. He discovers a certain je ne sais quoi about the man who has a magical ability to transform and elevate everything which comes into his orbit-the Dhoni Touch.\n"
	  		+ "\n"
	  		+ "Funny, candid, and peppered with delicious anecdotes, The Dhoni Touch reveals an ordinary man living an extraordinary life.\n"
	  		+ "\n"
	  		+ "'Dhoni is adored, respected, loved wildly, and yet, remains mysterious. Don't we want to know more? I do. And this book by Bharat, a fine journalist, helps'\n"
	  		+ "HARSHA BHOGLE");
	  
	  categoriesPage.switchToDefaultContent();
	  
	  categoriesPage.clickOnParentCategory();
	  
      categoriesPage.pictureUploadFile("C:\\Users\\keerthana\\Downloads\\CaptainCoolBook.jpg");
	  
	  categoriesPage.publishedCheckBox();
	  
	  categoriesPage.showOnHomePageCheckBox();
	  
	  categoriesPage.includeInTopMenuCheckBox();
	  	  
	  categoriesPage.enterPageSize("6");
	  
	  categoriesPage.priceRangeFilteringCheckBox();
	  
	  categoriesPage.enterPriceRangeManuallyCheckBox();
	  
	  categoriesPage.fillPriceFrom("21000");
	  
	  categoriesPage.fillPriceTo("70000");
	  
	  categoriesPage.enterDisplayOrder("2");
	  
	  categoriesPage.clickOnSaveButton();
	  
	  logger.info("Validation Started!");
	  
	  boolean res = driver.getPageSource().contains("The new category has been added successfully.");
	  
	  if (res==true) {
		Assert.assertTrue(true);
		logger.info("Test case Passed!");

	  }else {
	    logger.info("Test case Failed!");
        captureScreenShot(driver, "categoriesPage");
        Assert.assertTrue(false);
	  }
   }
  
//   @DataProvider(name = "testdata")
//   public String[][] getData() throws IOException{
//	   
//	  String path = "\\src\\test\\resources\\testdata\\testdata.xlsx";
//	  XLUtils xlUtils = new XLUtils(path);
//	  
//	  int totalrows = xlUtils.getRowCount("Categories");
//	  int totalcols = xlUtils.getCellCount("Categories", 1);
//	  
//	  String testdata[][] = new String[totalrows][totalcols];
//	  
//	  for (int i = 1; i <=totalrows; i++) {
//		
//		  for (int j = 0; j < totalcols; j++) {
//			
//			  testdata[i-1][j] = xlUtils.getCellData("Categories", i, j);
//		  }
//	  }
//	  
//	  return testdata;
//   }
}
