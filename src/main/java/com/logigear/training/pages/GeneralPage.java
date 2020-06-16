package com.logigear.training.pages;
import com.logigear.training.controls.common.LGLink;
import com.logigear.training.controls.common.LGTextBox;
import org.openqa.selenium.NoSuchElementException;

public class GeneralPage {
	LGLink lnkMyAccount = new LGLink("css=ul.head-menu > li:nth-of-type(5) [href='#']");

	LGLink lnkLogout = new LGLink("css=[href='logout.do']");

	LGLink txtLoginUsername= new LGLink("css=a[href='#Welcome']");

	LGLink lnkReponsitory = new LGLink("a[href='#Repository']");

	LGLink bntReponsitory = new LGLink("ul#ulListRepositories [href='#']");

	LGTextBox txtReponsitory = new LGTextBox("a[href='#Repository'] > span");

	public void swithReponsitoryinDashboard(){
		lnkReponsitory.click();
		bntReponsitory.click();
	}

	public void clickMyAccount() {
		txtLoginUsername.click();
		lnkMyAccount.click();
	}

	public String getLoginSuccessText() {
		return txtLoginUsername.getText();
	}

	public String getReponsitoryonDaboard(){
		return txtReponsitory.getText();
	}

	public void logout() {
		try {
			txtLoginUsername.click();
			lnkLogout.click();
		} catch (NoSuchElementException ex) {

		}
	}
}