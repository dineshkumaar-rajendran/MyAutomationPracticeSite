package com.automationsite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.Baseclass;

public class LoginPage extends Baseclass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	@CacheLookup
	WebElement Emailid;

	@FindBy(id = "passwd")
	@CacheLookup
	WebElement password;

	@FindBy(id = "email_create")
	WebElement CreateAccountEmail;

	@FindBy(id = "SubmitLogin")
	@CacheLookup
	WebElement Signinbtn;

	@FindBy(id = "SubmitCreate")
	WebElement CreateanAccount;

	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement ForgotPassword;

	public MyAccountPage LogintoPage(String username, String pasd) {
		Emailid.sendKeys(username);
		password.sendKeys(pasd);
		Signinbtn.click();
		return new MyAccountPage();
	}

	public String VerifyLoginPagetitle() {
	return	driver.getTitle();
	}
	
	public void createAccount(String NewEmail) {
		CreateAccountEmail.sendKeys(NewEmail);
		CreateanAccount.click();
	}
}
