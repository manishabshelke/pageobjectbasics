package com.qa.testcases;


import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;


import com.qa.utilities.Utilities;


public class LoginTest {

	//test 1 st
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException{
		
		HomePage home = new HomePage();
		LoginPage lp = home.gotoLogin();
		lp.doLogin(data.get("uname"), data.get("pass"));
	//Assert.fail("Login test failed");
	
		
	}																																																																							

}


