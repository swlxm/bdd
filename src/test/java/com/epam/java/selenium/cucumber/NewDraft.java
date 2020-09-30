package com.epam.java.selenium.cucumber;

import com.epam.java.selenium.driver.DriverSingleton;
import com.epam.java.selenium.entities.Email;
import com.epam.java.selenium.entities.EmailBuilder;
import com.epam.java.selenium.pages.DraftMailPage;
import com.epam.java.selenium.utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class NewDraft {

    protected static WebDriver driver;

    private By composeBy = By.xpath("//div[text()='Compose']");
    private By toBy = By.name("to");
    private By subjectBy = By.name("subjectbox");
    private By bodyBy = By.xpath("//div[@aria-label='Message Body']");
    private By closeBtnBy = By.xpath("//img[@alt='Close']");
    private By draftBy = By.linkText("Drafts");
    private String subject;

    @Given("^click Compose button$")
    public void click_Compose_button() throws InterruptedException, IOException {
        driver = DriverSingleton.getDriver("qa", "chrome");
        driver.findElement(composeBy).click();
        Thread.sleep(3000);

    }

    @Given("^set to and subject and body$")
    public void set_to_and_subject_and_body() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(toBy));
        Utils utils = new Utils();
        subject = utils.genTimestamp();
        Email email = new EmailBuilder().setBody("send by selenium").setTo("module7.epam@gmail.com").setSubject(subject).build();
        driver.findElement(toBy).sendKeys(email.getTo());
        driver.findElement(subjectBy).sendKeys(email.getSubject());
        driver.findElement(bodyBy).sendKeys(email.getBody());
    }

    @When("^click save button$")
    public void click_save_button() throws InterruptedException {
        driver.findElement(closeBtnBy).click();
        Thread.sleep(1000);
    }

    @Then("^the mail will be added to draft list$")
    public void the_mail_will_be_added_to_draft_list() throws InterruptedException {
        driver.findElement(draftBy).click();
        Thread.sleep(10*1000);
        DraftMailPage draftMailPage = new DraftMailPage(driver);
        WebElement mail = draftMailPage.getLatestMail();
        String text = draftMailPage.getMailText(mail);
        assertTrue(text.contains(subject));
//        logout();
    }

}
