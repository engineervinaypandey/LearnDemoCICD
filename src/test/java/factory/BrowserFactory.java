package factory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
	
	static WebDriver driver;

	//Created the method to get the driver.
	public static WebDriver getBrowser(String Browser) 
	{
		if (Browser.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromeDriver());
			driver =  new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("FireFox")) 
		{
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getFireFoxPath());
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeDriver(WebDriver ldriver){
		ldriver.quit();
	}
}
