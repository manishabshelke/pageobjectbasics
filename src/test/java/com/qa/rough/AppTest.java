package com.qa.rough;



import com.qa.base.Page;
import com.qa.base.TopMenu;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ZohoAppPage;
import com.qa.pages.crm.accounts.AccountsPage;
import com.qa.pages.crm.accounts.CreateAccounts;

public class AppTest {
public static void main(String[] args) throws InterruptedException {
		
		  
		
		HomePage hp=new HomePage();
		LoginPage lp=hp.gotoLogin();
		
		ZohoAppPage zp=lp.doLogin("mpseli.6@gmail.com","pihu@Prafull");
	    zp.gotoCrm();
	    
	    Thread.sleep(1000);
	    //TopMenu menu=new TopMenu();
	    AccountsPage ap=Page.menu.gotoAccounts();
	    CreateAccounts  cap=ap.gotoCreateAccount();
	    cap.createAccount("manisha");
	 
		
	}

}
