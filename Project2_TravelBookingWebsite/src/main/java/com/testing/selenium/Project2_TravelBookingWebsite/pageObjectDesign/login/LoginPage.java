package com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(linkText="Dont have an account? Signup")
	WebElement signUpBtn;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement submitBtn;
	
	public void sendEmail(String Email){
		email.sendKeys(Email);
	}
	
	public void sendPassword(String Password){
		password.sendKeys(Password);
	}
	
	public void clickSignUp() {
		signUpBtn.click();
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}

}
