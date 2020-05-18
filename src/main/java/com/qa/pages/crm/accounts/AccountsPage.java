package com.qa.pages.crm.accounts;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.qa.base.Page;

public class AccountsPage extends Page {
	
	public CreateAccounts gotoCreateAccount() {
		
		driver.findElement(By.cssSelector("button.newwhitebtn.customPlusBtn ")).click();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Accounts"));
		return new CreateAccounts();
	}

	public void gotoImportsAccount() {
		
	}
}
