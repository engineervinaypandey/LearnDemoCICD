package factory;

import dataProvider.ConfigurationDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory 
{
	//Method create with return type ConfigurationDataProvider (We have kept ConfigurationDataProvider as retrun data type becuse we are
	//creating object of 'ConfigurationDataProvider' class.) 
	public static ConfigurationDataProvider getConfig(){
		ConfigurationDataProvider config = new ConfigurationDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel(){
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}
}
