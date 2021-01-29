package com.automation.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportDemo;
import utility.MyEventListener;

public class Baseclass {

	private WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static MyEventListener eventListener;

	public Baseclass() {
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./src/main/java/config/configuration.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static WebDriver initializeDriver() throws Exception {
		String browserName = prop.getProperty("browser");
		
		if (browserName.contains("chrome")) {

			DesiredCapabilities dr = null;
			dr = DesiredCapabilities.chrome();
			dr.setBrowserName("chrome");
			dr.setPlatform(Platform.WINDOWS);

			tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr));

			// driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr));

			// WebDriverManager.chromedriver().setup(); driver =new ChromeDriver();

		} else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver=new FirefoxDriver();
		} else {
			System.out.println("Enter the Valid browser name");
		}

		/*
		 * e_driver = new EventFiringWebDriver(driver); eventListener = new
		 * MyEventListener(); e_driver.register(eventListener); driver = e_driver;
		 */
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

	//	getDriver().get(prop.getProperty("url"));
		ExtentReportDemo.initializeReports();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {// if someone calls the get driver method then it will return the
														// threadlocal
		// instance , where we have initialized chrome driver
		return tlDriver.get();

	}

}
