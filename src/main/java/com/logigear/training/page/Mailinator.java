package com.logigear.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.logigear.training.common.DriverManager;
import com.logigear.training.common.ElementHelper;

public class Mailinator {
	static String inboxUrl = "https://www.mailinator.com/v3/#/#inboxpane";

	ElementHelper tbxInbox = new ElementHelper(By.id("inbox_field"));

	ElementHelper elmFirstEmail = new ElementHelper(By.cssSelector("#inboxpane .table-responsive tbody tr td a"));

	ElementHelper iframeMsgBody = new ElementHelper(By.id("msg_body"));

	ElementHelper lnkInEmail = new ElementHelper(By.xpath("html/body/a"));

	public void openInbox(String email) {
		DriverManager.getDriver().get(inboxUrl);
		tbxInbox.clear();
		tbxInbox.type(email.replace("@mailinator.com", ""));
		tbxInbox.type(Keys.ENTER);
	}

	public void clickLatestEmail() {
		elmFirstEmail.waitForVisibility();
		elmFirstEmail.click();
	}

	public void openLinkInEmail() {
		iframeMsgBody.waitForFrameToBeAvailableAndSwitchToIt();
		lnkInEmail.waitForVisibility();
		String link = lnkInEmail.getAttribute("href");
		DriverManager.getDriver().get(link);
		DriverManager.getDriver().switchTo().defaultContent();
	}

	public void openLinkInLatestEmail(String email) {
		openInbox(email);
		clickLatestEmail();
		openLinkInEmail();
	}
}
