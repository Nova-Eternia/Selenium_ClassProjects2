package com.testing.selenium.Project2_TravelBookingWebsite.testCases.signUp;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;

import com.testing.selenium.Project2_TravelBookingWebsite.base.TestBase;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.header.HeaderPage;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.login.LoginPage;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.signUp.SignUpPage;

public class SignUpTest extends TestBase{
	public LoginPage login;
	public SignUpPage signUp;
	public HeaderPage header;
	public Alert alert;
	
	@BeforeMethod
	public void atTestStart() {
		login = new LoginPage(driver);
		signUp = new SignUpPage(driver);
		header = new HeaderPage(driver);
	}
	
	// Successfull SignUp
	@Test
	public void TC_SIGNUP_01() {

	    header.clickLoginAtTop();
	    login.clickSignUp();
	    signUp.sendUsername("nayan");
	    signUp.sendEmail("nayan123@gmail.com");
	    signUp.sendPassword("Nayan@123");
	    signUp.sendAddress("Bhopal, Madhya Pradesh");
	    signUp.sendPhone("9283746512");
	    signUp.clickSubmitBtn();

	    wait.until(ExpectedConditions.alertIsPresent()); 

	    alert = driver.switchTo().alert(); 
	    String alertText = alert.getText();
	    System.out.println(alertText);
	    alert.accept();    
	    
	    signUp.clickLoginBtn();
	    
	}
}
