package com.qa.pages.crm.accounts;

import org.openqa.selenium.By;

import com.qa.base.Page;

public class CreateAccounts extends Page {
	
	public void createAccount(String name) {
		driver.findElement(By.xpath("//input[@id='Crm_Accounts_ACCOUNTNAME']")).sendKeys(name);
		
	}

	
}
