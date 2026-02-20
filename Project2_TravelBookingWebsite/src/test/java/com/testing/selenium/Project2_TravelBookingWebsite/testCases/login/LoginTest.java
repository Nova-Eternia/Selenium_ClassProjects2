package com.testing.selenium.Project2_TravelBookingWebsite.testCases.login;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;

import com.testing.selenium.Project2_TravelBookingWebsite.base.TestBase;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.header.HeaderPage;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.login.LoginPage;

public class LoginTest extends TestBase {

	public LoginPage login;
	public HeaderPage header;
	public Alert alert;

	@BeforeMethod
	public void atTestStart() {
		header = new HeaderPage(driver);
		login = new LoginPage(driver);
	}

	@Test
	public void TC_Login_01() {
		header.clickLoginAtTop();
		login.sendEmail("nayan123@gmail.com");
		login.sendPassword("Nayan@123");
		login.clickSubmitBtn();

		wait.until(ExpectedConditions.alertIsPresent());

		alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
	}
	
	

}
