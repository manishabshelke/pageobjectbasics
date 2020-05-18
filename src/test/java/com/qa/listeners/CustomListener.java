package com.qa.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.qa.base.Page;
import com.qa.utilities.MonitoringMail;
import com.qa.utilities.TestConfig;

import com.qa.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;





public class CustomListener extends Page implements ITestListener,ISuiteListener{

String body;
	
	public void onTestStart(ITestResult result) {
		test = rep.startTest(result.getName().toUpperCase());

		 if(!Utilities.isTestRunnable(result.getName(), excel)) {
			  
			  throw new
			  SkipException("Skipping the test"+result.getName()+"as the runmode is no"); }
			 
		
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" pass ");
	     rep.endTest(test);
	     rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		//capturing screenshot
		
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
	try {
		Utilities.captureScreenshot();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed the Exception "+result.getThrowable());
	test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
		Reporter.log("click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" hieght=300 width=300></img></a>");
		 rep.endTest(test);
		rep.flush();
	}
			
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+"Skipping the test as run mode is no ");
	     rep.endTest(test);
	     rep.flush();
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		MonitoringMail mail= new MonitoringMail();
		
		try {
			body = "http://" + InetAddress.getLocalHost().getHostAddress()+":8080/job/PageObjectModel/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject,body);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
