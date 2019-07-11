package com.discovery.automation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.discovery.automation.Enum.DriverType;
//import com.discovery.automation.Enum.EnvironmentType;




public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= "ConfigFile.properties";
 
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	
	public String getApplicationUrl(String para) {
		String url = properties.getProperty(para);
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("ieExplorer")) return DriverType.INTERNETEXPLORER;

		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
 
	 
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	

}
