package pages;

import org.openqa.selenium.WebDriver;


public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver){
		
		this.driver = ldriver;
	}
	
	//Method to get title in the string form
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
}
