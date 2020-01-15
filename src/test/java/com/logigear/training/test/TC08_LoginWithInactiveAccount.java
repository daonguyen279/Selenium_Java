package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.AccountInfo;
import com.logigear.training.common.Constant;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.RegisterPage;


public class TC08_LoginWithInactiveAccount extends BaseTest {
	RegisterPage registerPage = new RegisterPage();
	
	@Test
	public void TC08() {
		AccountInfo accountInfo = registerPage.navigateAndRegisterWithRandomValue();
		LoginPage loginPage = new LoginPage();
		loginPage.open();
		loginPage.loginWith(accountInfo.getEmail(), accountInfo.getPassword());
		Assert.assertEquals(loginPage.getLoginErrorMessageText(), Constant.LOGIN_ERR_MESSAGE_WITH_INVALID_VALUES);
	}
}
