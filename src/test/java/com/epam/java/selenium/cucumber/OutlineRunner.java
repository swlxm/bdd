package com.epam.java.selenium.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/outline.feature", glue = "com/epam/java/selenium/cucumber")
public class OutlineRunner extends AbstractTestNGCucumberTests {
}
