package com.automation.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.baseclass.Baseclass;
import com.automationsite.pages.Homepage;

import java.util.Properties;

import org.testng.Assert;

public class HomepageTest extends Baseclass {

	Homepage homepage;
	
	public HomepageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		initializeDriver();
		homepage = new Homepage();
	}

	@Test(priority=1)
	public void VerifythePageTitle() {
		String PageTitle = homepage.getPageTitle();
		Assert.assertEquals(PageTitle, "My Store");
	}

	@Test(priority=1)
	public void VerifytheLinkText() {
		String LinkOneTxt = homepage.getDressTitle();
		Assert.assertEquals(LinkOneTxt, "DRESSES");

	}

	@Test(priority=1)
	public void VerifytheLinkTextTwo() {
		String LinkTwoTxt = homepage.getWomenTitle();
		Assert.assertEquals(LinkTwoTxt, "WOMEN");
	}

	@Test(priority=1)
	public void VerifytheLinkTextThree() {
		String LinkThreeTxt = homepage.getTshirtsTitle();
		Assert.assertEquals(LinkThreeTxt, "T-SHIRTS");
	}
	
	@Test(priority=0)
	public void SuccessfullSubmitNewsletter() {
		homepage.EnterEmail(prop.getProperty("email"));
		homepage.SubmitNewsLetter();
		String SuccessMessage = homepage.GetSuccessheader();
		Assert.assertEquals(SuccessMessage,"Newsletter : You have successfully subscribed to this newsletter.");
	}
	
	@Test(priority=1)
	public void UnSuccessfullSubmitNewsletter() {
		homepage.EnterEmail(prop.getProperty("email"));
		homepage.SubmitNewsLetter(); 
		String FailureMessage = homepage.GetFailureheader();
		Assert.assertEquals(FailureMessage,"Newsletter : This email address is already registered.");
	}
	
	@Test(priority=2)
	public void EnterSigninPage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage.NavigatetoSignPage();
		String Pagetitle = homepage.getPageTitle();
		Assert.assertEquals(Pagetitle,"Login - y Store");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
