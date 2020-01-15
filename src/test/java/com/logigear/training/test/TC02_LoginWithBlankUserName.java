package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.page.LoginPage;


public class TC02_LoginWithBlankUserName extends BaseTest {
	LoginPage loginPage = new LoginPage();

	@Test
	public void TC02() {
		loginPage.open();
		loginPage.loginWith("", Constant.VALID_PASSWORD);
		Assert.assertEquals(loginPage.getLoginErrorMessageText(), Constant.LOGIN_ERR_MESSAGE_WITH_BLANK_VALUES);
	}
}
