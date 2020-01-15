package com.logigear.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.logigear.training.common.FakeValueHelper;
import com.logigear.training.common.ElementHelper;

public class PasswordResetPage extends BasePage {
	ElementHelper frmPasswordChange = new ElementHelper(By.xpath("//form[./fieldset/legend = 'Password Change Form']"));

	ElementHelper tbxNewPassword = new ElementHelper(By.id("newPassword"));

	ElementHelper tbxConfirmPassword = new ElementHelper(By.id("confirmPassword"));

	ElementHelper tbxResetToken = new ElementHelper(By.id("resetToken"));

	ElementHelper btnResetPassword = new ElementHelper(By.xpath("//input[@value='Reset Password']"));

	ElementHelper txtResetPasswordErrorMessage = new ElementHelper(By.cssSelector(".message"));

	ElementHelper txtResetPasswordTokenErrorMessage = new ElementHelper(By.cssSelector(".reset-token .validation-error"));

	ElementHelper txtResetPasswordConfirmPasswordErrorMessage = new ElementHelper(
			By.cssSelector(".confirm-password .validation-error"));

	public PasswordResetPage() {
		super(null);
	}

	public String getResetPasswordErrorMessageText() {
		return txtResetPasswordErrorMessage.getText();
	}

	public String getResetPasswordTokenErrorMessageText() {
		return txtResetPasswordTokenErrorMessage.getText();
	}

	public String getResetPasswordConfirmPasswordErrorMessageText() {
		return txtResetPasswordConfirmPasswordErrorMessage.getText();
	}

	public boolean doesPassworChangeFormExist() {
		try {
			return frmPasswordChange.getRuntimeElement().isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public void setResetToken(String resetToken) {
		tbxResetToken.type(resetToken);
	}

	public void resetPasswordWith(String newPassword, String confirmPassword) {
		tbxNewPassword.type(newPassword);
		tbxConfirmPassword.type(confirmPassword);

		btnResetPassword.click();
	}

	public void resetPasswordWithRandomValues() {
		final String password = FakeValueHelper.getFakeValuesService().bothify("????????");
		resetPasswordWith(password, password);
	}
}
