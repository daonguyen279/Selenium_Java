package com.logigear.training.pages;

import com.logigear.training.drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.logigear.training.utilities.ElementHelper;
import org.openqa.selenium.support.ui.Select;

public class GeneralPage {
	ElementHelper lnkMyAccount = new ElementHelper(By.cssSelector("ul.head-menu > li:nth-of-type(5) [href='#']"));

	ElementHelper lnkLogout = new ElementHelper(By.cssSelector("a[href='logout.do']"));

	ElementHelper txtLoginSuccessMessage = new ElementHelper(By.cssSelector("a[href='#Welcome']"));

	ElementHelper lnkReponsitory = new ElementHelper(By.cssSelector("a[href='#Repository']"));

	ElementHelper bntReponsitory = new ElementHelper(By.cssSelector("ul#ulListRepositories [href='#']"));

	ElementHelper cbbReponsitory = new ElementHelper(By.cssSelector("a[href='#Repository'] > span"));

	public void swithReponsitoryinDashboard(){
		lnkReponsitory.click();
		bntReponsitory.click();
	}

	public void clickMyAccount() {
		txtLoginSuccessMessage.click();
		lnkMyAccount.click();
	}

	public String getLoginSuccessText() {
		return txtLoginSuccessMessage.getText();
	}

	public String getReponsitoryonDaboard(){
		return cbbReponsitory.getText();
	}

	public void logout() {
		try {
			txtLoginSuccessMessage.click();
			lnkLogout.click();
		} catch (NoSuchElementException ex) {

		}
	}
}