package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.Page;

public class HomePage extends Page{
	
	
	public void gotoCustomer() throws InterruptedException {// 
		click("customer_CSS");
		
	}
	
	
	public void gotoSupport() {
		
		driver.findElement(By.cssSelector("a.zh-support")).click();
		
	}

	public void gotoContactsales() {
		
		driver.findElement(By.cssSelector("a.zh-contact")).click();
		
	}
	
	

	public LoginPage gotoLogin() throws InterruptedException {
		click("loginLink_XPATH");
		return new LoginPage();
		
		
	}

	public void gotoFreeSingUp() {
		driver.findElement(By.cssSelector("a.zh-signup")).click();
		
	
}

	public void gotoSearch() {
		driver.findElement(By.cssSelector("span.menu-search-icon")).click();
		
	
}


	public void gotoLearnMore() {
		driver.findElement(By.cssSelector("span.a-lm")).click();
		
	
}


	public void validateFooterLinks() {
		driver.findElement(By.cssSelector("div.footer-sec-wrap")).click();
		
	
}


}
