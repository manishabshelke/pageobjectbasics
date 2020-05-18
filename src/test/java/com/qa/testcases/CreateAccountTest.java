package com.qa.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.qa.base.Page;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ZohoAppPage;
import com.qa.pages.crm.accounts.AccountsPage;
import com.qa.pages.crm.accounts.CreateAccounts;
import com.qa.utilities.Utilities;

public class CreateAccountTest {
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String,String> data) throws InterruptedException{
		ZohoAppPage zp=new ZohoAppPage();
		
		zp.gotoCrm();
		    
		    Thread.sleep(1000);
		    //TopMenu menu=new TopMenu();
		    AccountsPage ap=Page.menu.gotoAccounts();
		    CreateAccounts  cap=ap.gotoCreateAccount();
		    Thread.sleep(1000);
		    cap.createAccount(data.get("name"));
		 
		
		
	}

}
