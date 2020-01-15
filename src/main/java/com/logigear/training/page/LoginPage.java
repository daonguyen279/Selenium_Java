package com.logigear.training.page;

import org.openqa.selenium.By;

import com.logigear.training.common.ElementHelper;

public class LoginPage extends BasePage {
	ElementHelper tbxUserName = new ElementHelper(By.id("username"));

	ElementHelper tbxPassword = new ElementHelper(By.id("password"));

	ElementHelper btnLogIn = new ElementHelper(By.xpath("//input[@value='login']"));

	ElementHelper lnkForgotPassword = new ElementHelper(By.xpath("//a[@href = '/Account/ForgotPassword.cshtml']"));

	ElementHelper txtLoginErrorMessage = new ElementHelper(By.cssSelector(".message"));

	ElementHelper txtLoginSuccessMessage = new ElementHelper(By.cssSelector(".account"));

	public LoginPage() {
		super(By.xpath("//span[.='Login']"));
	}

	public String getLoginErrorMessageText() {
		return txtLoginErrorMessage.getText();
	}

	public String getLoginSuccessMessageText() {
		return txtLoginSuccessMessage.getText();
	}

	public void loginWith(String Username, String Password) {
		tbxUserName.type(Username);
		tbxPassword.type(Password);
		btnLogIn.click();
	}

	public void clickForgotPassword() {
		lnkForgotPassword.click();
	}
}
