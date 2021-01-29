package com.automationsite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.Baseclass;

public class Homepage {
	
	private WebDriver driver;

	public Homepage(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	
	private By SearchTxtBox = By.xpath( "//*[@placeholder='Search']");
	private By SearchBtn= By.xpath("//*[@name='submit_search']");

	/*FindBy(xpath = "//*[@name='submit_search']") WebElement SearchBtn; */

	/* @FindBy(xpath = "//p[@class='alert alert-warning']") WebElement ResultHeader;*/
	
	private By ResultHeader= By.xpath("//p[@class='alert alert-warning']");

	/* @FindBy(xpath = "//a[@class='login']") @CacheLookup WebElement SiginBtn; */

	/*@FindBy(xpath = "//a[@title='Women']") WebElement WomentTitle; */
	
	private By SiginBtn= By.xpath( "//a[@class='login']");
	
	private By WomentTitle = By.xpath("//a[@title='Women']");
	private By DressesTitle = By.xpath("(//a[@title='Dresses'])[2]");
	private By TShirtsTitle = By.xpath( "(//a[@title='T-shirts'])[2]");
	private By EnterEmailBox = By.xpath("//input[@name='email']");
	private By SubmitNewsLetter = By.xpath("//button[@name='submitNewsletter']");
	private By GetSucessHeader = By.xpath("//p[@class='alert alert-success']");
	private By GetFailureHeader = By.xpath("//p[@class='alert alert-danger']");

	/* @FindBy(xpath = "(//a[@title='Dresses'])[2]") WebElement DressesTitle; */

	/* @FindBy(xpath = "(//a[@title='T-shirts'])[2]") WebElement TShirtsTitle; */

	/* @FindBy(xpath = "//input[@name='email']") WebElement EnterEmailBox; */

	/* @FindBy(xpath = "//button[@name='submitNewsletter']") WebElement SubmitNewsLetter;*/
	/* @FindBy(xpath = "//p[@class='alert alert-success']") WebElement GetSucessHeader; 
	/ * @FindBy(xpath = "//p[@class='alert alert-danger']")WebElement GetFailureHeader; */
	
	public SearchResultPage SearchTheProduct(String ProductName) {
		//SearchTxtBox.sendKeys(ProductName);
		driver.findElement(SearchTxtBox).sendKeys(ProductName);
		driver.findElement(SearchBtn).click();

		return new SearchResultPage();
	}

	public String getPageTitle() {
		// ExtentReportDemo.test.pass("WebPage Title Recieved");
		return driver.getTitle();
	}

	public String getWomenTitle() {
		// ExtentReportDemo.test.pass("Women Header Title Recieved");
		return driver.findElement(WomentTitle).getText();
	}

	public String getDressTitle() {
		// ExtentReportDemo.test.pass("Dress Header Title Recieved");
		return driver.findElement(DressesTitle).getText();
		//return DressesTitle.getText();
	}

	public String getTshirtsTitle() {
		// ExtentReportDemo.test.pass("Tshirt Header Title Recieved");
		//return TShirtsTitle.getText();
		return driver.findElement(TShirtsTitle).getText();
	}

	public void EnterEmail(String email) throws InterruptedException {
		Thread.sleep(5000);
		//EnterEmailBox.clear();
		Baseclass.getDriver().findElement(EnterEmailBox).clear();
		// ExtentReportDemo.test.pass("Cleared the TextBox");
		Baseclass.getDriver().findElement(EnterEmailBox).sendKeys(email);
		//EnterEmailBox.sendKeys(email);
		// ExtentReportDemo.test.pass("Entered the Email Address");
	}

	public void SubmitNewsLetter() {
		Baseclass.getDriver().findElement(SubmitNewsLetter).click();
		//SubmitNewsLetter.click();
		// ExtentReportDemo.test.pass("Clicked the Submitt button for the NewsLetter");
	}

	public String GetSuccessheader() {
		// ExtentReportDemo.test.pass("Get the Sucesss Header Message");
		//return GetSucessHeader.getText();
		return Baseclass.getDriver().findElement(GetSucessHeader).getText();

	}

	public String GetFailureheader() throws InterruptedException {
		// ExtentReportDemo.test.pass("Get the Failure Header Message");
		Thread.sleep(5000);
		//return GetFailureHeader.getText();
		return Baseclass.getDriver().findElement(GetFailureHeader).getText();
	}

	public LoginPage NavigatetoSignPage() {
		// ExtentReportDemo.test.pass("Click Signin Button");
	//	SiginBtn.click();
		Baseclass.getDriver().findElement(SiginBtn).click();
		// ExtentReportDemo.test.pass("Entered in Login Page");
		return new LoginPage(driver);

	}

}
