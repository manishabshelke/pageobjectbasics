package com.qa.pages.crm;

import org.openqa.selenium.By;

import com.qa.base.Page;

public class CRMHomePage extends Page {
	
	public void registerupcommingcrm() {
	
		driver.findElement(By.xpath("//tr[@id='123785000000136503']//td[1]")).click();
		
	}

    public void referCRMVideos() {
    	
    	driver.findElement(By.xpath("//a[@id='homePage_123785000000136501']")).click();
		
		
    }
}
