package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.base.Page;
import com.qa.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page{
	


	public void gotoBook() {
		
		driver.findElement(By.xpath("//span[@class='_logo-books _logo-x96 zod-app-logo']")).click();
	}

	public void gotoCalender() {
		driver.findElement(By.xpath("//span[@class='_logo-calendar _logo-x96 zod-app-logo']")).click();
	}


	public void gotoCampaigns() {
		driver.findElement(By.xpath("//span[@class='_logo-campaigns _logo-x96 zod-app-logo']")).click();
}

	public void gotoCliq() {
		driver.findElement(By.xpath("//span[@class='_logo-chat _logo-x96 zod-app-logo']")).click();
	
}
    public void gotoConnect() {
    	
    driver.findElement(By.xpath("//span[@class='_logo-connect _logo-x96 zod-app-logo']")).click();
    	
	
}

    public CRMHomePage gotoCrm() {
    	
    	driver.findElement(By.xpath("//*[@id='zl-myapps']/div[1]/div[7]/div/a")).click();
    	
    	System.out.println(driver.getTitle());
		return new CRMHomePage();

    
	
}



}
