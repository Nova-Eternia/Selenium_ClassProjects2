package com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.HomePage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By searchBox = By.cssSelector("input[placeholder='Search']");
    private By goButton = By.cssSelector(".rounded-full");
    private By topOffersButtons = By.cssSelector(".mt-10 button");

    // ================================
    // Actions
    // ================================

    public void search(String placeName) {

        WebElement searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        searchField.clear();
        searchField.sendKeys(placeName);

        driver.findElement(goButton).click();
    }

    public void clickBestOffers() {

        List<WebElement> offers = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(topOffersButtons)
        );

        for (WebElement element : offers) {
            if (element.getText().trim().equalsIgnoreCase("Best Offers")) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
    }

    public void clickTopRated() {

        List<WebElement> offers = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(topOffersButtons)
        );

        for (WebElement element : offers) {
            if (element.getText().trim().equalsIgnoreCase("Top Rated")) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
    }

    public void clickLatest() {

        List<WebElement> offers = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(topOffersButtons)
        );

        for (WebElement element : offers) {
            if (element.getText().trim().equalsIgnoreCase("Latest")) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
    }

    public void clickMostRated() {

        List<WebElement> offers = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(topOffersButtons)
        );

        for (WebElement element : offers) {
            if (element.getText().trim().equalsIgnoreCase("Most Rated")) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
    }
}
