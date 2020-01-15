package com.logigear.training.page;

import org.openqa.selenium.By;

import com.logigear.training.common.DriverManager;
import com.logigear.training.common.ElementHelper;

public class MyTicketPage extends BasePage {
	ElementHelper tbxUserName = new ElementHelper(By.id("username"));

	ElementHelper tbxPassword = new ElementHelper(By.id("password"));

	ElementHelper btnLogIn = new ElementHelper(By.xpath("//input[@value='login']"));

	ElementHelper lnkForgotPassword = new ElementHelper(By.xpath("//a[@href = '/Account/ForgotPassword.cshtml']"));

	ElementHelper txtLoginErrorMessage = new ElementHelper(By.cssSelector(".message"));

	ElementHelper txtLoginSuccessMessage = new ElementHelper(By.cssSelector(".account"));

	public MyTicketPage() {
		super(By.xpath("//span[.='My ticket']"));
	}

	public void cancelTicket(int ticketIndex) {
		ElementHelper lnkDeleteTicket = new ElementHelper(
				By.xpath("//table[@class='MyTable']/tbody/tr[" + (ticketIndex + 1) + "]/td[11]/input"));
		lnkDeleteTicket.click();
		DriverManager.getDriver().switchTo().alert().accept();
	}
}
