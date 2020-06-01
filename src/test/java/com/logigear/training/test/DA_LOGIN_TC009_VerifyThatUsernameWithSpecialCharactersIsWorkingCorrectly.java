package com.logigear.training.test;

import com.logigear.training.common.Constant;
import com.logigear.training.page.BasePage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DA_LOGIN_TC009_VerifyThatUsernameWithSpecialCharactersIsWorkingCorrectly extends BaseTest {
	LoginPage loginPage = new LoginPage();
	BasePage basePage = new BasePage();

	@Test
	public void TC009() {
		loginPage.loginWith(Constant.SPECIAL_USERNAME, Constant.SPECIALUSERNAME_PASSWORD);
		Assert.assertEquals( Constant.SPECIAL_USERNAME, basePage.getLoginSuccessText());
		basePage.logout();
	}

}
