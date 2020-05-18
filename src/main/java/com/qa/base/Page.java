package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

import com.qa.utilities.ExcelReader;
import com.qa.utilities.ExtentManager;
import com.qa.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	
	public static WebDriver driver;
	public static Properties config= new Properties();                                
	public static Properties OR= new Properties();
	public static FileInputStream fis;
	public static Logger log =Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static TopMenu menu;
	
	
	public Page()  {
		if(driver==null) {
			
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
		
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			log.debug("Config file Loded");
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			log.debug("OR file Loded");
			

			
			//jenkins browser filter configuration
			if(System.getenv("browser")!=null &&!System.getenv("browser").isEmpty())
			{
				 browser=System.getenv("browser");
				
				}else {
					
					browser=config.getProperty("browser");
				}
			
				config.setProperty("browser", browser);
			
				if(config.getProperty("browser").equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					 driver=new FirefoxDriver();
					
				}else
					if(config.getProperty("browser").equals("chrome")) {
				
			
		WebDriverManager.chromedriver().setup();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");

		driver = new ChromeDriver(options);
		
		}else
			   if(config.getProperty("browser").equals("ie")) {
						WebDriverManager.iedriver().setup();
						driver=new InternetExplorerDriver();
						
					}

				driver.get(config.getProperty("testsiteurl"));
				log.debug("Navigate to : "+config.getProperty("testsiteurl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
				wait= new WebDriverWait(driver,10);
				menu=new TopMenu(driver);
     
		}
	
	}
	
	public static void quit() {
		driver.quit();
	}
	
	static WebElement dropdown;
	public void select(String locator,String value) {
		if (locator.endsWith("_CSS")) {
			
			dropdown= driver.findElement(By.cssSelector(OR.getProperty(locator)));
			}
			else if (locator.endsWith("_XPATH")) {
				dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
				
			}
		else if (locator.endsWith("_ID")) {
			
			dropdown=driver.findElement(By.id(OR.getProperty(locator)));
			}
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);
		 log.debug("Selecting from an element :"+locator+"value as :"+value);
		 test.log(LogStatus.INFO, " Selecting frome dropdown :"+locator+" value as: "+value);
		}

		
	

	
	public void click(String locator) throws InterruptedException {  
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			
			
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
			
		}
		
		log.debug("Clicking on "+locator);
		//test.log(LogStatus.INFO, "Clicking on : " +locator );
		
	}

	
	public void type(String locator,String value) {
		if (locator.endsWith("_CSS")) {
			
		 driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			
		}
	else if (locator.endsWith("_ID")) {
		
		driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		
		log.debug( "Typeing in :"+locator+" entered value "+value);
		//	test.log(LogStatus.INFO, "Typeing in :"+locator+"entered value "+value);
		//test.log(LogStatus.INFO, " Typeing in :"+locator+" entered value "+value);
	}

	
	
	public boolean isPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e) {
			
			return false;
			
		}
		
	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		}

	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}

		log.debug("test execution completed !!!");
	}

	
	
	

}
