package com.testing.selenium.Project2_TravelBookingWebsite.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

	public Logger logger = LogManager.getLogger(this.getClass());

	@BeforeClass
	public void atClassStart() throws IOException {

		logger.info("Loading config.properties...");
		file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
		config.load(file);
		logger.info("config.properties loaded successfully.");

		logger.info("Loading global.properties...");
		file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/global.properties");
		global.load(file);
		logger.info("global.properties loaded successfully.");

		String browser = global.getProperty("browser");
		if (browser == null) {
			throw new RuntimeException("Browser not defined in global.properties");
		}

		logger.info("Browser specified in properties: {}", browser);
		logger.info("Initializing WebDriver instance...");
		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<>();

			// Disable password manager
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			// Disable password leak detection
			prefs.put("profile.password_manager_leak_detection", false);

			options.setExperimentalOption("prefs", prefs);

			options.addArguments("--disable-notifications");
			options.addArguments("--disable-save-password-bubble");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-popup-blocking");

			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Browser name is not valid : " + browser);
		}

		logger.info("Maximizing browser window...");
		driver.manage().window().maximize();

		logger.info("Setting implicit wait to 5 seconds...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		logger.info("Initializing explicit wait (5 seconds)...");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String url = global.getProperty("websiteURL");
		if (url == null) {
			logger.error("Website URL not defined in global.properties");
			throw new RuntimeException("Website URL missing.");
		} else {
			logger.info("Navigating to URL: {}", url);
			driver.get(url);
			logger.info("Navigation successful.");
		}
	}

	@AfterClass
	public void atClassEnd() throws InterruptedException {
		logger.info("Test execution completed.");
		logger.info("Closing browser session...");
		
		Thread.sleep(3000);

		if (driver != null) {
		    driver.quit();
		    logger.info("Browser closed successfully.");
		} 
		else {
		    logger.warn("Driver was null. Nothing to close.");
		}
	}

}
