package com.logigear.training.page;

import org.openqa.selenium.By;

import com.logigear.training.common.ElementHelper;

public class LoginPage {
	ElementHelper tbxUserName = new ElementHelper(By.id("username"));

	ElementHelper tbxPassword = new ElementHelper(By.id("password"));

	ElementHelper btnLogIn = new ElementHelper(By.className("btn-login"));


//	public LoginPage() {
//		super(By.xpath("//span[.='Login']"));
//	}
//
//	public String getLoginErrorMessageText() {
//		return txtLoginErrorMessage.getText();
//	}
//
	public void loginWith(String Username, String Password) {
		tbxUserName.type(Username);
		tbxPassword.type(Password);
		btnLogIn.click();
	}
}
