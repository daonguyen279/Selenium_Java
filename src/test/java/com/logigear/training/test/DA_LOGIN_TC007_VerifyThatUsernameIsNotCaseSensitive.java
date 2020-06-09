package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.pages.DashboardPage;


public class DA_LOGIN_TC007_VerifyThatUsernameIsNotCaseSensitive extends BaseTest {
	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();

	@Test
	public void TC007() {
		loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
		Assert.assertEquals( Constant.UPERCASE_USERNAME, dashboardPage.getLoginSuccessText());
		dashboardPage.logout();
		loginPage = new LoginPage();
		loginPage.loginWith(Constant.LOWERCASE_USERNAME, Constant.PASSWORD);
		dashboardPage = new DashboardPage();
		Assert.assertEquals( Constant.LOWERCASE_USERNAME.toUpperCase(), dashboardPage.getLoginSuccessText());
	}

}
