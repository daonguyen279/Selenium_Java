package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.Mailinator;
import com.logigear.training.page.RegisterPage;


public class TC11_CreateAccountWithPasswordAndPidEmpty extends BaseTest {
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	Mailinator mailinator = new Mailinator();

	
	@Test
	public void TC11() {
		registerPage.open();
		registerPage.registerWith(Constant.VALID_EMAIL, "", "");
		Assert.assertEquals(registerPage.getRegisterErrorMessageText(), Constant.REGISTER_ERR_MESSAGE_WITH_INVALID_VALUES);
		Assert.assertEquals(registerPage.getRegisterPasswordErrorMessageText(),
				Constant.REGISTER_ERR_MESSAGE_INVALID_PASSWORD);
		Assert.assertEquals(registerPage.getRegisterPidErrorMessageText(), Constant.REGISTER_ERR_MESSAGE_INVALID_PID);
	}

	
}
