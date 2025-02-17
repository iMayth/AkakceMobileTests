package com.dias.pages;

import com.dias.utilities.Driver;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class MainPage extends BasePage {
    private final By notificationDontAllow = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");
    private final By withoutRegistrationButton = AppiumBy.id("com.akakce.akakce:id/continueWithoutRegister");
    private final By searchBox = AppiumBy.id("com.akakce.akakce:id/searchTextView");
    private final By filterButton = AppiumBy.id("com.akakce.akakce:id/filterText");
    private final By applyFilter = AppiumBy.id("com.akakce.akakce:id/applyFilterTextView");
    private final By filterName = AppiumBy.xpath("//android.widget.TextView[@text=\"Bilgisayar, Donanım\"]");
    private final By searchBoxInside = AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"com.akakce.akakce:id/searchTextView\"])[2]");
    private final By sort = AppiumBy.id("com.akakce.akakce:id/sortText");
    private final By detailBtn = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/detailBtnTextView\"]");
    private final By goToSeller = AppiumBy.xpath("//android.widget.TextView[@text=\"Satıcıya Git\"]");
    private final By item = AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.akakce.akakce:id/cellContainer\"])[3]");


    public void clickWithoutRegistrationButton() {
        click(withoutRegistrationButton);
    }

    public void clickApplyFilter() {
        click(applyFilter);
    }

    public void sort() {
        click(sort);
    }

    public void selectOption(String optionName) {
        Driver.getDriver().findElement(AppiumBy.xpath(String.format("//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/sort_name\" and @text='%s']", optionName))).click();

    }

    public void clickFilterButton() {
        click(filterButton);
    }

    public void confirmButton() {
        String btnText = getText(goToSeller);
        Assert.assertEquals("Satıcıya Git", btnText);

    }

    public void filter(String filterName) {
        Driver.getDriver().findElement(AppiumBy.xpath(String.format("//android.widget.TextView[@text='%s']", filterName))).click();

    }
    public void clickIndex(String index) {
        Driver.getDriver().findElement(AppiumBy.xpath(String.format("(//android.view.ViewGroup[@resource-id=\"com.akakce.akakce:id/cellContainer\"])[%s]", index))).click();

    }

    public void clickDontAllow() {
        click(notificationDontAllow);
    }

    public void scrollLastElementToTop() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.akakce.akakce:id/cellContainer']"));


        System.out.println(elements.size());

        if (elements.isEmpty()) {
            System.out.println("Liste boş, işlem yapılamaz.");
            return;
        }

        WebElement lastElement = elements.get(elements.size() - 1);

        boolean isAtTop = false;

        while (!isAtTop) {
            int startX = lastElement.getLocation().getX();
            int startY = lastElement.getLocation().getY();
            int endY = startY - 400;


            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence scroll = new Sequence(finger, 1);


            scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));


            scroll.addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), startX, endY));


            scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


            Driver.getDriver().perform(List.of(scroll));


            elements = Driver.getDriver().findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.akakce.akakce:id/cellContainer']"));


            if (!elements.isEmpty() && elements.get(0).equals(lastElement)) {
                isAtTop = true;
                System.out.println("Son öğe en üste taşındı.");
            }
        }
    }


    public void clickDetailBtn() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.akakce.akakce:id/cellContainer']"));

        WebElement lastElement = elements.get(elements.size() - 1);
        int startX = lastElement.getLocation().getX();
        int startY = lastElement.getLocation().getY();
        int endY = startY - 400;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence scroll = new Sequence(finger, 1);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Driver.getDriver().perform(List.of(scroll));

        click(detailBtn);
    }

    public void sendKeysIntoSearchBox(String product) {
        waitUntilElementVisible(searchBox);
        click(searchBox);
        sendKeys(product, searchBoxInside);
        click(searchBoxInside);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.RETURN);  // Enter tuşuna basma
        actions.build().perform();
    }

}
