package com.logigear.training.common;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}

}
