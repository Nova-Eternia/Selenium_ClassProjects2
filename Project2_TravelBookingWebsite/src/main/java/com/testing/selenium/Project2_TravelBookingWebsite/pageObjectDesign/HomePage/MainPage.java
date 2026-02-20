package com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.HomePage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	public WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Search']")
	WebElement SearchCheckBox;
	
	@FindBy(css=".rounded-full")
	WebElement goBtn;
	
	@FindBy(css=".mt-10 button")
	List<WebElement> topOffersList;
	
	@FindBy()
	List<WebElement> topPackagesList;
	
	@FindBy()
	List<WebElement> latestPackagesList;
	
	@FindBy()
	List<WebElement> bestOffersList;
	
	public void search(String placeName) {
		SearchCheckBox.sendKeys(placeName);
		goBtn.click();
	}
	
	public void ClickBestOffers() {
		for(WebElement x : topOffersList) {
			if(x.getText().contains("Best Offers")) {
				x.click();
			}
		}
	}
	
	public void clickTopRated() {
		for(WebElement x : topOffersList) {
			if(x.getText().contains("Top Rated")) {
				x.click();
			}
		}
	}
	
	public void clickLatest() {
		for(WebElement x : topOffersList) {
			if(x.getText().contains("Latest")) {
				x.click();
			}
		}
	}
	
	public void clickMostRated() {
		for(WebElement x : topOffersList) {
			if(x.getText().contains("Most Rated")) {
				x.click();
			}
		}
	}
	

}
