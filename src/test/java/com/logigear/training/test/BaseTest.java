package com.logigear.training.test;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.logigear.training.common.Constant;
import com.logigear.training.drivermanager.DriverManager;

public class BaseTest {
	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		DriverManager.setDriver(new ChromeDriver());
		DriverManager.getDriver().manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.getDriver().get(Constant.BASE_URL);
	}

//	@AfterMethod
//	public void afterMethod() {
//		new LoginPage().logout();
//	}

	@AfterClass
	public void afterClass() {
		DriverManager.getDriver().quit();
	}
}
