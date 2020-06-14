package com.logigear.training.drivermanager;

import org.openqa.selenium.WebDriver;

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
}
