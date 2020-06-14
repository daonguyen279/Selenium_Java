package com.logigear.training.utilities;

import com.logigear.training.drivermanager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    public static void setUpBrowser(String browser) {
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            DriverManager.setDriver(new ChromeDriver());
        } else if (browser.equals("IE")) {
            WebDriverManager.iedriver().setup();
            DriverManager.setDriver(new InternetExplorerDriver());
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            DriverManager.setDriver(new FirefoxDriver());
        }
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
}
