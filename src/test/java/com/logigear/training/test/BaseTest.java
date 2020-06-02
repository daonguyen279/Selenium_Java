package com.logigear.training.test;

import com.logigear.training.common.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        DriverManager.setDriver(new ChromeDriver());
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        DriverManager.getDriver().quit();
    }
}
