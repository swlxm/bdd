package com.epam.java.selenium.cucumber;

import com.epam.java.selenium.driver.DriverSingleton;
import com.epam.java.selenium.entities.User;
import com.epam.java.selenium.pages.HomePage;
import com.epam.java.selenium.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;

public class Outline {

    protected static WebDriver driver;

    private By composeBy = By.xpath("//div[text()='Compose']");
    private User user;

    @Given("^email (.*) and password (.*)$")
    public void email_and_password(String email, String password) throws IOException {
        driver = DriverSingleton.getDriver("qa", "chrome");
        driver.get("http://mail.google.com");

        user = new User();
        user.setUsername(email);
        user.setPassword(password);

    }

    @When("^click login button 2$")
    public void click_login_button() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(user);
    }

    @Then("^login gmail successfully 2$")
    public void login_gmail_successfully() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(composeBy));

    }

}
