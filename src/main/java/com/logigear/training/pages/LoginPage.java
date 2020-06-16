package com.logigear.training.pages;
import com.logigear.training.controls.common.LGButton;
import com.logigear.training.controls.common.LGTextBox;
import com.logigear.training.drivermanager.DriverManager;
import org.openqa.selenium.By;

import com.logigear.training.utilities.ElementHelper;

public class LoginPage {
	LGTextBox tbxUserName = new LGTextBox("id=username");

	LGTextBox tbxPassword = new LGTextBox ("id=password");

	LGButton btnLogIn = new LGButton("class=btn-login");

	public String getLoginErrorMessageText() {
		return DriverManager.getDriver().switchTo().alert().getText();
	}

	public void loginWith(String Username, String Password) {
		tbxUserName.type(Username);
		tbxPassword.type(Password);
		btnLogIn.click();
	}

	public void loginWithBlankUsernameAndPassword() {
		btnLogIn.click();
	}

}
