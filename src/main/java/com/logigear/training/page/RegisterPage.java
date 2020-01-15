package com.logigear.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.logigear.training.common.AccountInfo;
import com.logigear.training.common.FakeValueHelper;
import com.logigear.training.common.ElementHelper;

public class RegisterPage extends BasePage {
	ElementHelper tbxEmail = new ElementHelper(By.id("email"));

	ElementHelper tbxPassword = new ElementHelper(By.id("password"));

	ElementHelper tbxConfirmPassword = new ElementHelper(By.id("confirmPassword"));

	ElementHelper tbxPid = new ElementHelper(By.id("pid"));

	ElementHelper btnRegister = new ElementHelper(By.xpath("//input[@value='Register']"));

	ElementHelper txtRegisterSuccessMessage = new ElementHelper(
			By.xpath("//h1[.='Thank you for registering your account']"));

	ElementHelper txtRegisterErrorMessage = new ElementHelper(By.cssSelector(".message"));

	ElementHelper txtRegisterPasswordErrorMessage = new ElementHelper(By.cssSelector(".password .validation-error"));

	ElementHelper txtRegisterPidErrorMessage = new ElementHelper(By.cssSelector(".pid-number .validation-error"));

	public RegisterPage() {
		super(By.xpath("//span[.='Register']"));
	}

	public String getRegisterErrorMessageText() {
		return txtRegisterErrorMessage.getText();
	}

	public String getRegisterPasswordErrorMessageText() {
		return txtRegisterPasswordErrorMessage.getText();
	}

	public String getRegisterPidErrorMessageText() {
		return txtRegisterPidErrorMessage.getText();
	}

	public void registerWith(String email, String password, String pid) {
		tbxEmail.type(email);
		tbxPassword.type(password);
		tbxConfirmPassword.type(password);
		tbxPid.type(pid);

		btnRegister.click();
	}

	public AccountInfo registerWithRandomValue() {
		final String email = FakeValueHelper.getFakeValuesService().bothify("????##@mailinator.com");
		final String password = FakeValueHelper.getFakeValuesService().bothify("????????");
		final String pid = FakeValueHelper.getFakeValuesService().bothify("????????");
		tbxEmail.type(email);
		tbxPassword.type(password);
		tbxConfirmPassword.type(password);
		tbxPid.type(pid);

		btnRegister.click();

		return new AccountInfo(email, password, pid);
	}

	public AccountInfo navigateAndRegisterWithRandomValue() {
		open();
		return registerWithRandomValue();
	}

	public AccountInfo registerAndLoginWithRandomValue() {
		AccountInfo accountInfo = navigateAndRegisterWithRandomValue();
		activateAccount(accountInfo.getEmail());

		LoginPage loginPage = new LoginPage();
		loginPage.open();
		loginPage.loginWith(accountInfo.getEmail(), accountInfo.getPassword());

		return accountInfo;
	}

	public void activateAccount(String email) {
		Mailinator mailinator = new Mailinator();
		mailinator.openInbox(email);
		mailinator.clickLatestEmail();
		mailinator.openLinkInEmail();
	}

	public boolean doesRegisterSuccessMessageExist() {
		try {
			return txtRegisterSuccessMessage.getRuntimeElement().isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
