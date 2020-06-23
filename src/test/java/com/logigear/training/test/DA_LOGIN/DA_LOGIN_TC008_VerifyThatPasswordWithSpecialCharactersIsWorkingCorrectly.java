package com.logigear.training.test.DA_LOGIN;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DA_LOGIN_TC008_VerifyThatPasswordWithSpecialCharactersIsWorkingCorrectly extends BaseTest {
	LoginPage loginPage = new LoginPage();
	DashBoardPage dashBoardPage = new DashBoardPage();

	@Test
	public void TC008() {
		loginPage.loginWith(Constant.SPECIALPASSWORD_USERNAME, Constant.SPECIAL_PASSWORD);
		Assert.assertEquals( Constant.SPECIALPASSWORD_USERNAME, dashBoardPage.getLoginSuccessText());
		dashBoardPage.logout();
	}

}
