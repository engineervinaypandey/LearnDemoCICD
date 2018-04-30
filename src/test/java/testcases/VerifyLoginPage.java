package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPage {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUp() {
		report = new ExtentReports("./Reports/LoginPageReport.html", true);
		logger = report.startTest("Verify Login Page");

		driver = BrowserFactory.getBrowser("Chrome");

		logger.log(LogStatus.INFO, "Browser is up and running");

		driver.get(DataProviderFactory.getConfig().getURL());

		logger.log(LogStatus.PASS, "Browser opened successfully and website open successfully.");
	}

	@Test
	public void testVerifyLoginPage() {
		logger.log(LogStatus.INFO, "Verify the Login Page");

		LoginPage loginP = PageFactory.initElements(driver, LoginPage.class);

		/*
		 * Executed the sendLogin method(Method will take user name and password
		 * form excel and click on submit button)
		 */
		loginP.sendLogin(DataProviderFactory.getExcel().getData(0, 0, 0),
				DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.PASS, "User logged in successfully.");

		logger.log(LogStatus.INFO, "Verify Dashboard Button after login");

		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.CaptureScreenShots(driver, "UserLoggedInSuccesfully")));
		loginP.verifyCreateButtonLink();
		logger.log(LogStatus.PASS, "Create Button successfully visible after login");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		// Screenshot if any test case get fails.
		if (result.getStatus() == ITestResult.FAILURE) {

			String path = Helper.CaptureScreenShots(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		// ***********

		// Browser Close code with extent report
		BrowserFactory.closeDriver(driver);
		report.endTest(logger);
		report.flush();
		// **********
	}
}
