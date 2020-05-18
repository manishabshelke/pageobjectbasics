package com.qa.testcases;

import org.testng.annotations.BeforeSuite;

import com.qa.base.Page;

public class BaseTest {
	@BeforeSuite
	public void tearDown() {
		Page.quit();
	}

}
