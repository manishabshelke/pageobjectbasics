package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.pages.crm.accounts.AccountsPage;

public class TopMenu  {

	
	  WebDriver driver;
	  
	  public TopMenu(WebDriver driver) { this.driver=driver;
	  
	  }
	 
	public void gotohome() {
		
		driver.findElement(By.xpath("//crm-tab//div[1]//a[1]")).click();
		
	}

    public void gotoLeades() {
    	
    	driver.findElement(By.cssSelector("div.lyteItem.lyteMenuActive")).click();
		
		
	}
    
    public void gotoContact() {
		driver.findElement(By.xpath("//div[@class='newTopbar']//div[3]//a[1]")).click();
		
		
	}
	
	public AccountsPage gotoAccounts() {
		
		driver.findElement(By.xpath("//div[@class='lyteMenuItems']//div[4]")).click();
		
		System.out.println(driver.getTitle());
		return new AccountsPage();
		
	}

	
	
	public void gotoActivites() {
		driver.findElement(By.xpath("//a[contains(text(),'Activities')]")).click();
		
	}

	
	public void gotoReport() {
		driver.findElement(By.xpath("//a[contains(text(),'Reports')]")).click();
		//System.out.println(driver.getTitle());
		
	}
	public void gotoMarketplace() {
		driver.findElement(By.xpath("//div[@class='lyteMenuItems']//div[8]")).click();
		
	}
	
	public void signOut() {
		driver.findElement(By.xpath("//img[@id='topdivuserphoto_123785000000132001']")).click();
	}


}
