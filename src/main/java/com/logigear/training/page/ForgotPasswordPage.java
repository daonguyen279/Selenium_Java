package com.logigear.training.page;

import org.openqa.selenium.By;

import com.logigear.training.common.ElementHelper;

public class ForgotPasswordPage extends BasePage {
	public ForgotPasswordPage() {
		super(null);
	}

	ElementHelper tbxEmail = new ElementHelper(By.id("email"));
	ElementHelper btnSendInstructions = new ElementHelper(By.xpath("//input[@value='Send Instructions']"));

	public void sendInstructionsWith(String email) {
		tbxEmail.type(email);
		btnSendInstructions.click();
	}
}
