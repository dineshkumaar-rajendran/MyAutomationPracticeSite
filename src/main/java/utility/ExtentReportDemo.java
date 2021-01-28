package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReportDemo {

	private ExtentReportDemo() {
	}

	private static ExtentReports extent;
	public static ExtentTest test;

	public static void initializeReports() {
		if (Objects.nonNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("My Automation report");
			spark.config().setReportName("MyAutomationPracticeSite Report");

		}
	}

	public static void CreateTest(String TestCaseName) {

		ExtentManager.setExtentTest(extent.createTest(TestCaseName));

	}

	/*
	 * public static void addAuthors(String[] authors) { for(String temp:authors) {
	 * ExtentManager.getExtentTest().assignAuthor(temp); } }
	 */

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}

	}
}
