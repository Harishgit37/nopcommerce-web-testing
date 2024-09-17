package com.hk.pom;


import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hk.helper.Base;

public class LoginPage extends Base {

	@FindBy(xpath = "//label[@class='cb-lb']//input[@type='checkbox']")
	WebElement verificationCheckBox;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailBtn;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordBtn;
	
	@FindBy(id="RememberMe")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	public WebElement getVerificationCheckBox() {
		return verificationCheckBox;
	}

	public WebElement getEmailBtn() {
		return emailBtn;
	}

	public WebElement getPasswordBtn() {
		return passwordBtn;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void clickVerificationCheckBox() {
		
		wait.until(ExpectedConditions.elementToBeClickable(verificationCheckBox)).click();
	}
	
}
