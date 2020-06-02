package com.logigear.training.test;

import com.logigear.training.common.Constant;
import com.logigear.training.page.BasePage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DA_LOGIN_TC0010_VerifyThatThePageWorksCorrectlyForTheCaseWhenNoInputEnteredToPasswordAndUsernamefield extends BaseTest {
	LoginPage loginPage = new LoginPage();
	BasePage basePage = new BasePage();

	@Test
	public void TC0010() {
		loginPage.loginWithBlankUsernameAndPassword();
		Assert.assertEquals( Constant.LOGIN_ERROR_MESSAGE, loginPage.getLoginErrorMessageText());
	}

}
