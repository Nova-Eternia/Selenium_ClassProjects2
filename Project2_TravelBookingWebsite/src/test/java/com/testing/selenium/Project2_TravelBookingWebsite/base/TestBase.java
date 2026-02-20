package com.testing.selenium.Project2_TravelBookingWebsite.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.testing.selenium.Project2_TravelBookingWebsite.utilities.ExtentManager;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static FileInputStream file;
	public static Properties config = new Properties();
	public static Properties global = new Properties();
	
	public static ExtentReports extent = ExtentManager.getReport();
	public static ExtentTest test;
	

	@SuppressWarnings("unused")
	@BeforeClass
	public void atClassStart() throws IOException {

		file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
		config.load(file);

		file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/global.properties");
		global.load(file);

		String browser = global.getProperty("browser");
		if (browser == null) {
			throw new RuntimeException("Browser not defined in global.properties");
		}
		if (browser != null) {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		} else {
			throw new IllegalArgumentException("Browser name is not valid : " + browser);
		}

		String url = global.getProperty("websiteURL");
		if (url == null) {
			throw new RuntimeException("Website URL missing.");
		} else {
			driver.get(url);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));

	}

	@AfterClass
	public void atClassEnd() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(3000);
			driver.quit();
		}
	}
	
}
