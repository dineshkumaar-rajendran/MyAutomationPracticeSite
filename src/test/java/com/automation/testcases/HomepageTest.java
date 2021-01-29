package com.automation.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.baseclass.Baseclass;
import com.automationsite.pages.Homepage;

public class HomepageTest extends Baseclass {

	Homepage homepage;
	
	
	@BeforeClass
	public void setup() throws Exception {
		Baseclass.initializeDriver();
		homepage = new Homepage(Baseclass.getDriver());
	}

	@Test(priority=1)
	public void VerifythePageTitle()  throws Exception {
		
		Thread.sleep(2000);
		//ExtentReportDemo.CreateTest("VerifythePageTitle");
		String PageTitle = homepage.getPageTitle();
		Assert.assertEquals(PageTitle, "My Store");
	}

	@Test(priority=1)
	public void VerifytheLinkText() {
		//ExtentReportDemo.CreateTest("VerifytheLinkText");
		//getDriver().get(prop.getProperty("url"));
		String LinkOneTxt = homepage.getDressTitle();
		Assert.assertEquals(LinkOneTxt, "DRESSES");

	}

	@Test(priority=1)
	public void VerifytheLinkTextTwo() {
		//ExtentReportDemo.CreateTest("VerifytheLinkTextTwo");
		//getDriver().get(prop.getProperty("url"));
		String LinkTwoTxt = homepage.getWomenTitle();
		Assert.assertEquals(LinkTwoTxt, "WOMEN");
	}

	@Test(priority=1)
	public void VerifytheLinkTextThree() {
		//ExtentReportDemo.CreateTest("VerifytheLinkTextThree");
		//getDriver().get(prop.getProperty("url"));
		String LinkThreeTxt = homepage.getTshirtsTitle();
		Assert.assertEquals(LinkThreeTxt, "T-SHIRTS");
	}
	
	@Test(priority=0)
	public void SuccessfullSubmitNewsletter() throws InterruptedException {
		//ExtentReportDemo.CreateTest("SuccessfullSubmitNewsletter");
		getDriver().get(prop.getProperty("url"));
		homepage.EnterEmail(prop.getProperty("email"));
		homepage.SubmitNewsLetter();
		String SuccessMessage = homepage.GetSuccessheader();
		Assert.assertEquals(SuccessMessage,"Newsletter : You have successfully subscribed to this newsletter.");
	}
	
	@Test(priority=2)
	public void UnSuccessfullSubmitNewsletter() throws InterruptedException {
		//ExtentReportDemo.CreateTest("UnSuccessfullSubmitNewsletter");
		//getDriver().get(prop.getProperty("url"));
		homepage.EnterEmail(prop.getProperty("email"));
		homepage.SubmitNewsLetter(); 
		Thread.sleep(5000);
		
		String FailureMessage = homepage.GetFailureheader();
		Assert.assertEquals(FailureMessage,"Newsletter : This email address is already registered.");
	}
	
	@Test(priority=3)
	public void EnterSigninPage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ExtentReportDemo.CreateTest("EnterSigninPage");
		//getDriver().get(prop.getProperty("url"));
		homepage.NavigatetoSignPage();
		String Pagetitle = homepage.getPageTitle();
		Assert.assertEquals(Pagetitle,"Login - My Store");
	}

	@AfterClass
	public void tearDown() {
		Baseclass.getDriver().close();
		//ExtentReportDemo.flushReports(); 
	}
}
