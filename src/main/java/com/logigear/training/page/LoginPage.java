package com.logigear.training.page;

import org.openqa.selenium.By;

import com.logigear.training.common.ElementHelper;

public class LoginPage extends BasePage {
	ElementHelper tbxUserName = new ElementHelper(By.id("username"));

	ElementHelper tbxPassword = new ElementHelper(By.id("password"));

	ElementHelper cbbRespository = new ElementHelper(By.xpath("//select[@id='repository']/option[contains(text(),'SampleRepositoryLV2')]"));

	ElementHelper btnLogIn = new ElementHelper(By.className("btn-login"));

	public void loginWith(String Username, String Password) {
		tbxUserName.type(Username);
		tbxPassword.type(Password);
		btnLogIn.click();
	}

	public void clickRespository(){
		cbbRespository.click();
	}

}
