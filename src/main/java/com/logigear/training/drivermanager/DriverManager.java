package com.logigear.training.drivermanager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class DriverManager {
    static HashMap<Long, WebDriver> drivers = new HashMap<Long, WebDriver>();

    private static ThreadLocal<Long> driverKey = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return drivers.get(driverKey.get());
    }

    public static void setDriver(WebDriver driver) {
        Long key = Thread.currentThread().getId();
        driverKey.set(key);
        DriverManager.drivers.put(key, driver);
    }

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(expectation);
        } catch (Throwable error) {
        }
    }
}
