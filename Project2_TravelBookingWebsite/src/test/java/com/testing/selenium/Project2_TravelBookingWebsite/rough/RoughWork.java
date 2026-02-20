package com.testing.selenium.Project2_TravelBookingWebsite.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class RoughWork {
	public static FileInputStream file;
	public static Properties config = new Properties();
	public static Properties global = new Properties();
	
	public static void main(String[] args) throws IOException 
	{
	
			file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/config.properties");
			config.load(file);
			
			file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/global.properties");
			global.load(file);
			
			String browser = global.getProperty("browser");
			System.out.println(browser);
		
	}

}
