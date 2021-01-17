package com.automationsite.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.Baseclass;

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
		return driver.getTitle();
	}

	public String getWomenTitle() {
		return WomentTitle.getText();
	}

	public String getDressTitle() {
		return DressesTitle.getText();
	}

	public String getTshirtsTitle() {
		return TShirtsTitle.getText();
	}

	public void EnterEmail(String email) {
		EnterEmailBox.clear();
		EnterEmailBox.sendKeys(email);
	}

	public void SubmitNewsLetter() {
		SubmitNewsLetter.click();
	}
	
	public String GetSuccessheader() {
		return GetSucessHeader.getText();
	}
	
	public String GetFailureheader() {
		return GetFailureHeader.getText();
	}
	
	
	public LoginPage NavigatetoSignPage() {
		SiginBtn.click();
		return new LoginPage();
		
	}

}
