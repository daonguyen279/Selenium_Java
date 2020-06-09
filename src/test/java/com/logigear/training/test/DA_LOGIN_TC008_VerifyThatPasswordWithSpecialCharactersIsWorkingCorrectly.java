package com.logigear.training.test;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DA_LOGIN_TC008_VerifyThatPasswordWithSpecialCharactersIsWorkingCorrectly extends BaseTest {
	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();

	@Test
	public void TC008() {
		loginPage.loginWith(Constant.SPECIALPASSWORD_USERNAME, Constant.SPECIAL_PASSWORD);
		Assert.assertEquals( Constant.SPECIALPASSWORD_USERNAME, dashboardPage.getLoginSuccessText());
		dashboardPage.logout();
	}

}
