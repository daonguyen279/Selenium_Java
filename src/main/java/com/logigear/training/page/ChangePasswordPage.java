package com.logigear.training.page;

import org.openqa.selenium.By;

import com.logigear.training.common.ElementHelper;

public class ChangePasswordPage extends BasePage {
	ElementHelper tbxCurrentPassword = new ElementHelper(By.id("currentPassword"));

	ElementHelper tbxNewPassword = new ElementHelper(By.id("newPassword"));

	ElementHelper tbxConfirmPassword = new ElementHelper(By.id("confirmPassword"));

	ElementHelper btnChangePassword = new ElementHelper(By.xpath("//input[@value='Change Password']"));

	ElementHelper txtChangePasswordErrorMessage = new ElementHelper(By.cssSelector(".message"));

	public ChangePasswordPage() {
		super(By.xpath("//span[.='Change password']"));
	}

	public String getChangePasswordErrorMessageText() {
		return txtChangePasswordErrorMessage.getText();
	}

	public void changePasswordWith(String currentPassword, String newPassword, String confirmPassword) {
		tbxCurrentPassword.type(currentPassword);
		tbxNewPassword.type(newPassword);
		tbxConfirmPassword.type(confirmPassword);

		btnChangePassword.click();
	}
}
