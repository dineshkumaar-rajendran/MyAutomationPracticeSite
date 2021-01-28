package com.automationsite.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.Baseclass;

import utility.ExtentReportDemo;

public class Homepage extends Baseclass {

	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@placeholder='Search']")
	@CacheLookup
	WebElement SearchTxtBox;

	@FindBy(xpath = "//*[@name='submit_search']")
	WebElement SearchBtn;

	@FindBy(xpath = "//p[@class='alert alert-warning']")
	WebElement ResultHeader;

	@FindBy(xpath = "//a[@class='login']")
	@CacheLookup
	WebElement SiginBtn;

	@FindBy(xpath = "//a[@title='Women']")
	WebElement WomentTitle;

	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	WebElement DressesTitle;

	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	WebElement TShirtsTitle;

	@FindBy(xpath = "//input[@name='email']")
	WebElement EnterEmailBox;

	@FindBy(xpath = "//button[@name='submitNewsletter']")
	WebElement SubmitNewsLetter;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement GetSucessHeader;
	
	@FindBy(xpath="//p[@class='alert alert-danger']")  
	WebElement GetFailureHeader;
	
	
	public SearchResultPage SearchTheProduct(String ProductName) {
		SearchTxtBox.sendKeys(ProductName);
		SearchBtn.click();

		return new SearchResultPage();
	}

	public String getPageTitle() {
		//ExtentReportDemo.test.pass("WebPage Title Recieved");
		return driver.getTitle();
	}

	public String getWomenTitle() {
		//ExtentReportDemo.test.pass("Women Header Title Recieved");
		return WomentTitle.getText();
	}

	public String getDressTitle() {
		//ExtentReportDemo.test.pass("Dress Header Title Recieved");
		return DressesTitle.getText();
	}

	public String getTshirtsTitle() {
		//ExtentReportDemo.test.pass("Tshirt Header Title Recieved");
		return TShirtsTitle.getText();
	}

	public void EnterEmail(String email) {
		EnterEmailBox.clear();
		//ExtentReportDemo.test.pass("Cleared the TextBox");
		EnterEmailBox.sendKeys(email);
		//ExtentReportDemo.test.pass("Entered the Email Address");
	}

	public void SubmitNewsLetter() {
		SubmitNewsLetter.click();
		//ExtentReportDemo.test.pass("Clicked the Submitt button for the NewsLetter");
	}
	
	public String GetSuccessheader() {
		//ExtentReportDemo.test.pass("Get the Sucesss Header Message");
		return GetSucessHeader.getText();
		
	}
	
	public String GetFailureheader() {
		//ExtentReportDemo.test.pass("Get the Failure Header Message");
		return GetFailureHeader.getText();
	}
	
	
	public LoginPage NavigatetoSignPage() {
		//ExtentReportDemo.test.pass("Click Signin Button");
		SiginBtn.click();
		//ExtentReportDemo.test.pass("Entered in Login Page");
		return new LoginPage();
		
	}

}
