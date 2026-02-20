package com.testing.selenium.Project2_TravelBookingWebsite.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports  extent;
	public static ExtentSparkReporter reporter;

	public static ExtentReports getReport() {
		if(extent == null) {
			String reportPath = System.getProperty("user.dir")+ "/reports/ExtentReport.html";
			reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setReportName("Automation Test Reports");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Project" , "Online Travel Booking Website");
		}
		return extent;
	}
}
