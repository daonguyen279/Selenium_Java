package com.logigear.training.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void waitForPageLoaded(int timeOut) {
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
            wait.until(driver -> {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                return (Boolean) (executor
                        .executeScript("return angular.element(document).injector().get('$http').pendingRequests.length === 0;"));
            });
        } catch (Exception e) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }
}
