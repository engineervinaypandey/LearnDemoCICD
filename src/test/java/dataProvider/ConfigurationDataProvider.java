package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigurationDataProvider 
{
	
	Properties pro;
	
	public ConfigurationDataProvider() 
	{
		File src = new File("./Configuration/config.properties");
		
		try 
		{
		   	FileInputStream fis = new FileInputStream(src);
			 pro = new Properties();
			 pro.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Expecion is" + e.getMessage());
		}
	}
	
	//Three methods to get data from config file
	public String getURL() {
		String URL = pro.getProperty("url");
		return URL;
	}

	public String getChromeDriver() {
		String chrome = pro.getProperty("chromePath");
		return chrome;
	}

	public String getFireFoxPath() {
		String friefox = pro.getProperty("fireFoxPath");
		return friefox;
	}
}

