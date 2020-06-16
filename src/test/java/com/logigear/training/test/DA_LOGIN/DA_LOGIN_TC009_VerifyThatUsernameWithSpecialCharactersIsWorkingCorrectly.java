package com.logigear.training.test.DA_LOGIN;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.GeneralPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DA_LOGIN_TC009_VerifyThatUsernameWithSpecialCharactersIsWorkingCorrectly extends BaseTest {
	LoginPage loginPage = new LoginPage();
	GeneralPage generalPage = new GeneralPage();

	@Test
	public void TC009() {
		loginPage.loginWith(Constant.SPECIAL_USERNAME, Constant.SPECIALUSERNAME_PASSWORD);
		Assert.assertEquals( Constant.SPECIAL_USERNAME, generalPage.getLoginSuccessText());
		generalPage.logout();
	}

}
