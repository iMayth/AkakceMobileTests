package com.dias.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Driver {
    public static AppiumDriver driver;

    private Driver() {
    }

    public static void setUpDriver() {
        AppiumDriverLocalService service;
        String platform = System.getProperty("platform");
        if (platform == null) {
            platform = ConfigLoader.getProperty("platform");
        }
        platform = platform.toLowerCase();
        switch (platform) {
            case "android":
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
//                options.setApp(ConfigLoader.getProperty("app.android"));
                options.setDeviceName(ConfigLoader.getProperty("device.android"));
                options.setAutomationName("UiAutomator2");
                options.setAppPackage(ConfigLoader.getProperty("package"));
                options.setAppActivity(ConfigLoader.getProperty("activity"));
                service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
                service.start();
                driver = new AppiumDriver(service, options);
                break;
            case "ios":
                XCUITestOptions optionsios = new XCUITestOptions();
                optionsios.setPlatformName("iOS");
                optionsios.setApp(ConfigLoader.getProperty("app.ios"));
                optionsios.setDeviceName(ConfigLoader.getProperty("device.ios"));
                optionsios.setAutomationName("XCUITest");
                service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
                service.start();
                driver = new AppiumDriver(service, optionsios);
                break;
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}