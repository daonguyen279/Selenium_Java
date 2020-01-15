package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.page.LoginPage;


public class TC03_LoginWithInvalidPassword extends BaseTest {
	LoginPage loginPage = new LoginPage();

	@Test
	public void TC03() {
		loginPage.open();
		loginPage.loginWith(Constant.VALID_EMAIL, Constant.INVALID_PASSWORD);
		Assert.assertEquals(loginPage.getLoginErrorMessageText(), Constant.LOGIN_ERR_MESSAGE_WITH_INVALID_VALUES);
	}

}
