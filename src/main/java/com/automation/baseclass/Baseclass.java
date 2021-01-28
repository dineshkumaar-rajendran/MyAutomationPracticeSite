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
	
	public static WebDriver driver;
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

	public static void initializeDriver() throws MalformedURLException {
		String browserName = prop.getProperty("browser");
		String NodeT = " http://192.168.8.100:4444/wd/hub";
		
		if (browserName.contains("chrome")) {
			
			DesiredCapabilities dr=null;
			dr=DesiredCapabilities.chrome();
	        dr.setBrowserName("chrome");
	        dr.setPlatform(Platform.WINDOWS);

	     driver=new RemoteWebDriver(new    URL("http://localhost:4444/wd/hub"), dr);

			// WebDriverManager.chromedriver().setup(); driver =new ChromeDriver();
			 
		
		} else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else {
			System.out.println("Enter the Valid browser name");
		}
		
		/*
		 * e_driver = new EventFiringWebDriver(driver); eventListener = new
		 * MyEventListener(); e_driver.register(eventListener); driver = e_driver;
		 */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		 ExtentReportDemo.initializeReports();
	}

}
