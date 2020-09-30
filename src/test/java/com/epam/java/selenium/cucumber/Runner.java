package com.epam.java.selenium.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/background.feature"}, glue = "com/epam/java/selenium/cucumber")
public class Runner extends AbstractTestNGCucumberTests {
}
