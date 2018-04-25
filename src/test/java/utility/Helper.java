package utility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Helper {
	
	public static String CaptureScreenShots(WebDriver driver, String ScreenShots){
		
		//We have type case the screenshot with driver
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = "C:\\workspacetwo\\com.mobiletechnician.hybrid\\Screenshots\\"+ScreenShots+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(scr, new File(destination));
		} catch (IOException e) {
			System.out.println("Unable to take screenshot" + e.getMessage());
		}
		
		return destination;
	}
}
