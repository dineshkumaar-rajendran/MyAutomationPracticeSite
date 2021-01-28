package com.automation.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.baseclass.Baseclass;
import com.automationsite.pages.Homepage;
import com.automationsite.pages.LoginPage;

import utility.ExtentReportDemo;

public class LoginPageTest extends Baseclass {

	Homepage homepage;
	LoginPage loginpage;

	public LoginPageTest() {
		super();
	}
	
	/*
	 * @BeforeSuite public void BeforeSuite() {
	 * ExtentReportDemo.initializeReports(); }
	 * 
	 * @AfterSuite public void AfterSuite() { ExtentReportDemo.flushReports(); }
	 */
	
	@BeforeClass
	public void setup() throws MalformedURLException {
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
		//ExtentReportDemo.flushReports(); 
	}
}
