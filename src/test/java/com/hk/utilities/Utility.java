 package com.hk.utilities;

import java.time.Duration;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.hk.helper.Base;
import com.hk.pom.LoginPage;

public class Utility extends Base{

	public void loginPage(String username , String password) {
		
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.getEmailBtn().clear();
		loginPage.getEmailBtn().sendKeys(username);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		loginPage.getPasswordBtn().clear();
		loginPage.getPasswordBtn().sendKeys(password);
		loginPage.getLoginBtn().click();
	}

	@DataProvider(name = "userData")
	public Object[][] userData(){
		  
		
	   return new Object[][] {	  
			
		 new Object[] { "admin@yourstore.com" ,"admin"},
		 
		 }; 
	  }
}
