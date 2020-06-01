package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.BasePage;


public class DA_LOGIN_TC007_VerifyThatUsernameIsNotCaseSensitive extends BaseTest {
	LoginPage loginPage = new LoginPage();
	BasePage basePage = new BasePage();

	@Test
	public void TC007() {
		loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
		Assert.assertEquals( Constant.UPERCASE_USERNAME, basePage.getLoginSuccessText());
		basePage.logout();
		loginPage = new LoginPage();
		loginPage.loginWith(Constant.LOWERCASE_USERNAME, Constant.PASSWORD);
		basePage = new BasePage();
		Assert.assertEquals( Constant.LOWERCASE_USERNAME.toUpperCase(), basePage.getLoginSuccessText());
	}

}
