package com.logigear.training.pages;

import com.logigear.training.controls.common.LGButton;
import com.logigear.training.controls.common.LGTextBox;
import com.logigear.training.drivermanager.DriverManager;
import io.qameta.allure.Step;

public class LoginPage {
    LGTextBox tbxUserName = new LGTextBox("id=username");

    LGTextBox tbxPassword = new LGTextBox("id=password");

    LGButton btnLogIn = new LGButton("class=btn-login");

    public String getLoginErrorMessageText() {
        return DriverManager.getDriver().switchTo().alert().getText();
    }

    @Step("Login with username '{username}' and password '{password}'")
    public void loginWith(String username, String password) {
        tbxUserName.type(username);
        tbxPassword.type(password);
        btnLogIn.click();
    }

    @Step("Login with blank username and password")
    public void loginWithBlankUsernameAndPassword() {
        btnLogIn.click();
    }

}
