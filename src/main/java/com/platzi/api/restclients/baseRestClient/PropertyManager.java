package com.platzi.api.restclients.baseRestClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	public static final String defaultPropertyfilePath = System.getProperty("user.dir");
	public static final String propertyFilePath = defaultPropertyfilePath + "//src//main//resources//application.properties";
	public static Properties properties =  new Properties();;
	public static FileInputStream inputStream = null;
	public static final String reportPath = defaultPropertyfilePath + "src//main//resources//extent.properties";

	public  Properties ConfigurePropertyFile() {
		
		try {
			inputStream = new FileInputStream(new File(propertyFilePath));
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	public  String getInputFromPropertyFile(String input) {

		String propertyInput = " ";
		if (input == null || input.isEmpty())
			return propertyInput;
		else {
			properties = ConfigurePropertyFile();
			propertyInput = properties.getProperty(input);
		}
		return propertyInput;
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = reportPath;
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Path is Not Configured");		
	}
}
