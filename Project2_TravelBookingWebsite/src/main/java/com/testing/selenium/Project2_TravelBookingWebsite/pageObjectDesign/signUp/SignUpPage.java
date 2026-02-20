package com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.signUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	public WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Signup']")
	WebElement frontText;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(linkText="Have an account? Login")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[text()='Signup']")
	WebElement submitBtn;
	
	public void getFrontText() {
		frontText.getText();
	}
	
	public void sendUsername(String Username) {
		username.sendKeys(Username);
	}
	
	public void sendEmail(String Email) {
		email.sendKeys(Email);
	}

	public void sendPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void sendAddress(String Address) {
		address.sendKeys(Address);
	}
	
	public void sendPhone(String PhoneNo) {
		phone.sendKeys(PhoneNo);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}

}
