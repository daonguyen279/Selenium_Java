package com.logigear.training.pages;
import com.logigear.training.drivermanager.DriverManager;
import org.openqa.selenium.By;
import com.logigear.training.utilities.ElementHelper;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	ElementHelper tbxUserName = new ElementHelper(By.id("username"));

	ElementHelper tbxPassword = new ElementHelper(By.id("password"));

	ElementHelper btnLogIn = new ElementHelper(By.className("btn-login"));

	public String getLoginErrorMessageText() {
		return DriverManager.getDriver().switchTo().alert().getText();
	}

	public void loginWith(String Username, String Password) {
		tbxUserName.type(Username);
		tbxPassword.type(Password);
		btnLogIn.click();
	}

	public void switchRepositoryLV2inLoginPage(){
		Select dropdown = new Select(DriverManager.getDriver().findElement(By.xpath("//select[@id='repository']")));
		dropdown.selectByValue("SampleRepositoryLV2");
	}

	public void loginWithBlankUsernameAndPassword() {
		btnLogIn.click();
	}

}
