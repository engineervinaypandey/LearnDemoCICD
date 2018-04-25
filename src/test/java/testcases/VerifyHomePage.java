package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
		report = new ExtentReports("./Reports/HomePageReport.html", true);
		logger = report.startTest("Verify Home Page");
		driver = BrowserFactory.getBrowser("Chrome");
		logger.log(LogStatus.INFO, "Browser is up and running");
		driver.get(DataProviderFactory.getConfig().getURL());
		logger.log(LogStatus.PASS, "Browser opened successfully and website open successfully.");
	}
	
	@Test
	public void testVerifyHomePage(){
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getHomePageTitle();
		System.out.println(title);
		logger.log(LogStatus.INFO,"To verify home page web title");
		Assert.assertTrue(title.contains("OrangeHRM"));
		logger.log(LogStatus.PASS, "Home page title is successfully verified");
	}
	
	@AfterMethod
	public void tearDown(){
		
		BrowserFactory.closeDriver(driver);
		report.endTest(logger);
		report.flush();
	}
}
