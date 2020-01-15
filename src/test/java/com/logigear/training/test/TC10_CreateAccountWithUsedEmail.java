package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.AccountInfo;
import com.logigear.training.common.Constant;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.Mailinator;
import com.logigear.training.page.RegisterPage;


public class TC10_CreateAccountWithUsedEmail extends BaseTest {
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	Mailinator mailinator = new Mailinator();
	@Test
	public void TC10() {
		AccountInfo accountInfo = registerPage.navigateAndRegisterWithRandomValue();
		registerPage.activateAccount(accountInfo.getEmail());
		RegisterPage registerPage = new RegisterPage();
		registerPage.open();
		registerPage.registerWith(accountInfo.getEmail(), accountInfo.getPassword(), accountInfo.getPid());
		Assert.assertEquals(registerPage.getRegisterErrorMessageText(), Constant.REGISTER_ERR_MESSAGE_EMAIL);
	}

}
