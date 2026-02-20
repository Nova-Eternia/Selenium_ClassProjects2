package com.testing.selenium.Project2_TravelBookingWebsite.testCases.endToEndTesting;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.selenium.Project2_TravelBookingWebsite.base.TestBase;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.HomePage.HomePage;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.header.HeaderPage;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.login.LoginPage;
import com.testing.selenium.Project2_TravelBookingWebsite.pageObjectDesign.signUp.SignUpPage;

public class MainTest extends TestBase {

    public SignUpPage signup;
    public LoginPage login;
    public HeaderPage header;
    public HomePage home;
    public Alert alert;

    @BeforeMethod
    public void atTestStart() {
        logger.info("Initializing Page Objects...");

        header = new HeaderPage(driver);
        login = new LoginPage(driver);
        signup = new SignUpPage(driver);
        home = new HomePage(driver);

        logger.info("Page Objects initialized successfully.");
    }

    @Test
    public void mainTest() {

        logger.info("===== Starting End-To-End Main Test =====");

        // Login Page Navigation
        logger.info("Clicking on Login at Top Header...");
        header.clickLoginAtTop();

        logger.info("Navigating to SignUp page...");
        login.clickSignUp();

        // SignUp Page
        logger.info("Entering SignUp details...");
        signup.sendUsername("Nayan Patel");
        signup.sendEmail("nayan123@gmail.com");
        signup.sendPassword("Nayan@123");
        signup.sendAddress("Bhopal, Madhya Pradesh");
        signup.sendPhone("1298763455");

        logger.info("Submitting SignUp form...");
        signup.clickSubmitBtn();

        logger.info("Waiting for SignUp alert...");
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();
        logger.info("SignUp Alert message: {}", alert.getText());

        alert.accept();
        logger.info("SignUp alert accepted successfully.");

        logger.info("Clicking on Login button after SignUp...");
        signup.clickLoginBtn();

        // Login Page
        logger.info("Entering Login credentials...");
        login.sendEmail("nayan123@gmail.com");
        login.sendPassword("Nayan@123");

        logger.info("Submitting Login form...");
        login.clickSubmitBtn();

        logger.info("Waiting for Login alert...");
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();
        logger.info("Login Alert message: {}", alert.getText());

        alert.accept();
        logger.info("Login alert accepted successfully.");

        // Home Page
        logger.info("Navigating to Best Offers section...");
        home.clickBestOffers();

        logger.info("===== End-To-End Main Test Completed Successfully =====");
    }
}
