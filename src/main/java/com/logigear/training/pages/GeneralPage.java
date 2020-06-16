package com.logigear.training.pages;

import com.logigear.training.controls.common.LGLink;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.logigear.training.utilities.ElementHelper;

public class GeneralPage {
	LGLink lnkMyAccount = new LGLink("css=ul.head-menu > li:nth-of-type(5) [href='#']");

	LGLink lnkLogout = new LGLink("css=[href='logout.do']");

	LGLink txtLoginUsername= new LGLink("css=a[href='#Welcome']");

	public void clickMyAccount() {
		txtLoginUsername.click();
		lnkMyAccount.click();
	}

	public String getLoginSuccessText() {
		return txtLoginUsername.getText();
	}

	public void logout() {
		try {
			txtLoginUsername.click();
			lnkLogout.click();
		} catch (NoSuchElementException ex) {

		}
	}
}