package com.dias.stepdefinitions;

import com.dias.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    org.apache.logging.log4j.Logger Logger = LogManager.getLogger(Hooks.class);

    @Before
    public void openThePage(Scenario scenario) {
        Driver.setUpDriver();
        Logger.info("The scenario '" + scenario.getName() + "' started to run");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
            Logger.info("The scenario '" + scenario.getName() + "' is failed ");
        }
        Logger.info("The scenario '" + scenario.getName() + "' is " + scenario.getStatus() + " ");
        // Driver.closeDriver();
        }}