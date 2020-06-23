package com.logigear.training.pages;

import com.logigear.training.controls.common.LGLink;
import com.logigear.training.controls.common.LGTextBox;
import com.logigear.training.controls.common.LGButton;
import com.logigear.training.controls.common.LGSelectBox;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.logigear.training.utilities.ElementHelper;

public class DashBoardPage {
	LGLink lnkMyAccount = new LGLink("css=ul.head-menu > li:nth-of-type(5) [href='#']");

	LGLink lnkLogout = new LGLink("css=[href='logout.do']");

	LGLink txtLoginUsername= new LGLink("css=a[href='#Welcome']");

	LGLink lnkGlobal = new LGLink("xpath=//li[@class='mn-setting']/a[@href='javascript:void(0);']");

	LGLink lnkAddPage = new LGLink("xpath=//a[.='Add Page']");

	LGTextBox txtPageName = new LGTextBox("id=name");

	LGSelectBox sltParentPage = new LGSelectBox("id=parent");

	LGSelectBox sltColumnNumber = new LGSelectBox("id=columnnumber");

	LGSelectBox sltPossition = new LGSelectBox("id=afterpage");

	LGButton btnOK = new LGButton("id=OK");

	LGLink lnkPageName= new LGLink("xpath=//a[@href='/TADashboard/c3nrdyly98ad.page']");



	public void clickMyAccount() {
		txtLoginUsername.click();
		lnkMyAccount.click();
	}

	public void clickAddPage(){
		lnkGlobal.click();
		lnkAddPage.click();
	}

	public void enterPageName(String pageName){
		txtPageName.type(pageName);
	}

	public  void inputPageInformation(String pageName, String parentPage, String columnNumber, String position){
		txtPageName.type(pageName);
		sltParentPage.selectByVisibleText(parentPage);
		sltColumnNumber.selectByVisibleText(columnNumber);
		sltPossition.selectByVisibleText(position);
	}

	public void submitPageInformation(){
		btnOK.click();
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