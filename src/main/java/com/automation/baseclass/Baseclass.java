package com.automation.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
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

	public static void initializeDriver() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		
		} else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else {
			System.out.println("Enter the Valid browser name");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new MyEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
