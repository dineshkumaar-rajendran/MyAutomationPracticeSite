package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.baseclass.Baseclass;
import com.automationsite.pages.Homepage;
import com.automationsite.pages.LoginPage;

public class LoginPageTest extends Baseclass {

	Homepage homepage;
	LoginPage loginpage;

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		initializeDriver();
		homepage = new Homepage();
		loginpage = homepage.NavigatetoSignPage();
	}

	@Test
	public void VerifyLoginPagetitle() {
		String pagetitle = loginpage.VerifyLoginPagetitle();
		Assert.assertEquals(pagetitle, "My account - My Store");
	}
	
	@Test
	public void LogontoAccount() {
		loginpage.LogintoPage(prop.getProperty("username"),prop.getProperty("password"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
