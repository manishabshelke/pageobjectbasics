package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.Page;

public class LoginPage extends Page {

	

	public ZohoAppPage doLogin(String uname,String pass) throws InterruptedException {
		
		type("email_CSS", uname);
		click("emailNextbtn_XPATH");
		type("pass_CSS", pass);
		click("passNextbtn_XPATH");
	
		System.out.println(driver.getTitle());
		return new ZohoAppPage();
	}

	
}
