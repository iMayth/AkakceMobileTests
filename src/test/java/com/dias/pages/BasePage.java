package com.dias.pages;

import com.dias.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    static org.apache.logging.log4j.Logger Logger = LogManager.getLogger(BasePage.class);

    public String getText(By locator) {
        waitUntilElementVisible(locator);
        String text = Driver.getDriver().findElement(locator).getText();
        Logger.info("Successfully got the text of the element");
        return text;
    }

    public static void waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Logger.info("Waiting for the element to be visible");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        waitUntilElementVisible(locator);
        Driver.getDriver().findElement(locator).click();
        Logger.info("Successfully clicked the element");
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendKeys(String keyword, By actual) {
        Driver.getDriver().findElement(actual).sendKeys(keyword);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}