package com.automationsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.Baseclass;

public class LoginPage {
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
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
		// ExtentReportDemo.CreateTest("Entered the New Email Id");
		password.sendKeys(pasd);
		// ExtentReportDemo.CreateTest("Entered the Password");
		Signinbtn.click();
		// ExtentReportDemo.CreateTest("Clicked the Signin button");
		return new MyAccountPage();
	}

	public String VerifyLoginPagetitle() {
		// ExtentReportDemo.CreateTest("Recieved the Login Page Title");
		return Baseclass.getDriver().getTitle();
	}

	public void createAccount(String NewEmail) {
		CreateAccountEmail.sendKeys(NewEmail);
		// ExtentReportDemo.CreateTest("Entered the New Email Id");
		CreateanAccount.click();
		// ExtentReportDemo.CreateTest("Click Created Account button");
	}
}
