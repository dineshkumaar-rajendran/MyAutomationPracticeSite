package com.automation.testcases;


import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.automation.baseclass.Baseclass;

public class testcases extends Baseclass {

	public testcases() {
		super();
	}

	@BeforeClass
	public void setup() {
		initializeDriver();

	}

	@Test
	public void getPagetitle() {
		String Pagetitle = driver.getTitle();
		System.out.println(Pagetitle);
	}

	@AfterClass
	public void Teardown() {
		driver.quit();
	}

}
