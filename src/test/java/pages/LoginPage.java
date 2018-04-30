package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	// Constructor of class to load the driver
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	// Elements (Locators of Login screen)
	@FindBy(xpath = "//input[@name='txtUsername']") WebElement userName;
	@FindBy(xpath = "//input[@name='txtPassword']") WebElement passWord;
	@FindBy(xpath = ".//input[@name='Submit']") WebElement submitButton;

	By dashboardLink = By.linkText("Dashboard");

	// Method to login and click on sing in button.
	public void sendLogin(String user, String pass) {
		userName.sendKeys(user);
		passWord.sendKeys(pass);
		submitButton.click();
	}

	public void verifyCreateButtonLink() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement DashboardElement = wait.until(ExpectedConditions.presenceOfElementLocated(dashboardLink));

		String DashboardText = DashboardElement.getText();

		assertEquals(DashboardText, "Dashboard", "Login case is not verified, as Dashboard text is not visible");
	}
}
