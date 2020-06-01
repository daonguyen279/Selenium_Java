package com.logigear.training.test;

import com.logigear.training.common.Constant;
import com.logigear.training.page.BasePage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DA_LOGIN_TC008_VerifyThatPasswordWithSpecialCharactersIsWorkingCorrectly extends BaseTest {
	LoginPage loginPage = new LoginPage();
	BasePage basePage = new BasePage();

	@Test
	public void TC008() {
		loginPage.loginWith(Constant.SPECIALPASSWORD_USERNAME, Constant.SPECIAL_PASSWORD);
		Assert.assertEquals( Constant.SPECIALPASSWORD_USERNAME, basePage.getLoginSuccessText());
		basePage.logout();
	}

}
