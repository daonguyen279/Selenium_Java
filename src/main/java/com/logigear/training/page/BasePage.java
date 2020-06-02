package com.logigear.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.logigear.training.common.ElementHelper;

public class BasePage {

	ElementHelper txtLoginSuccessMessage = new ElementHelper(By.cssSelector("a[href='#Welcome']"));
	ElementHelper lnkLogout = new ElementHelper(By.cssSelector("a[href='logout.do']"));
	ElementHelper cbbRepository = new ElementHelper(By.cssSelector("a[href='#Repository']"));
	ElementHelper lnkRepository = new ElementHelper(By.cssSelector("ul#ulListRepositories [href='#']"));

	public String getLoginSuccessText() {
		return txtLoginSuccessMessage.getText();
	}

	public void selectRepository(){
		cbbRepository.click();
		lnkRepository.click();
	}

	public String checkReponsitory(){
		return cbbRepository.getText();
	}

	public void logout() {
		try {
			txtLoginSuccessMessage.click();
			lnkLogout.click();
		} catch (NoSuchElementException ex) {

		}
	}
}