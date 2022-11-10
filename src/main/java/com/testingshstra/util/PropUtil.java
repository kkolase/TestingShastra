package com.testingshstra.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropUtil {

	private static final Logger log = Logger.getLogger(PropUtil.class);
	public String getValue(String filepath, String key) {
		FileInputStream fis=null;
		try {
		fis=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			log.error("File Not Found"+filepath);
		}
		
		Properties prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			log.error("Unable to load properties file"+filepath);
		}
		return prop.getProperty(key);
	}
	
	/**	
	 * This method can be used on OR.properties file only
	 * @param key for which we want the locator
	 * @return the locator value in the form of @String
	 */
	public String[] getLocator(String key) {
		String baseDir= System.getProperty("user.dir");//return the current user working directory
		return getValue(baseDir+"\\src\\main\\resources\\OR.properties",key).split("##");
	}
	
	public String getEnvData(String key) {
		String baseDir= System.getProperty("user.dir");//return the current user working directory
		return getValue(baseDir+"\\src\\main\\resources\\Environment.properties",key);
		
	}


	public String testData(String key) {
		String baseDir= System.getProperty("user.dir");//return the current user working directory
		return getValue(baseDir+"\\src\\main\\resources\\TestData.properties",key);
		
	}
	
}
