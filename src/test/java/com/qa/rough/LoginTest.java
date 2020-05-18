package com.qa.rough;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.base.Page;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest  {
	public static void main(String[] args) throws InterruptedException {
		
		HomePage hp=new HomePage();
		hp.gotoLogin();
		
		LoginPage lp=new LoginPage();
		
		lp.doLogin("mpseli.6@gmail.com","pihu@Prafull");
	    
		
		
	}
}
