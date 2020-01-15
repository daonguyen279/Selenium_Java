package com.logigear.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.logigear.training.common.ElementHelper;

public class BasePage {
	By menuLocator;

	ElementHelper lnkMenu;

	ElementHelper lnkMyAccount = new ElementHelper(By.id("account"));

	ElementHelper lnkLogout = new ElementHelper(By.xpath("//span[.='Log out']"));

	public BasePage(By menuLocator) {
		this.menuLocator = menuLocator;
		lnkMenu = new ElementHelper(menuLocator);
	}
	public void clickMyAccount() {
		lnkMyAccount.click();
	}

	public void logout() {
		try {
			lnkLogout.click();
		} catch (NoSuchElementException ex) {

		}
	}
	public void open() {
		lnkMenu.click();
	}
}