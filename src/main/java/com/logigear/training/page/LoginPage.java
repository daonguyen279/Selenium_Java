package com.logigear.training.page;

import com.logigear.training.common.DriverManager;
import org.openqa.selenium.By;
import com.logigear.training.common.ElementHelper;

public class LoginPage {
    ElementHelper txtUserName = new ElementHelper(By.id("username"));
    ElementHelper txtPassword = new ElementHelper(By.id("password"));
    ElementHelper btnLogIn = new ElementHelper(By.cssSelector(".btn-login"));

	public void login(String username, String password) {
		txtUserName.type(username);
		txtPassword.type(password);
        btnLogIn.click();
        DriverManager.waitForPageLoaded(60);
    }
}
