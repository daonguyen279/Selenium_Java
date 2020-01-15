package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.page.RegisterPage;

public class TC07_CreateNewAccount extends BaseTest {
	RegisterPage registerPage = new RegisterPage();

	@Test
	public void TC07() {
		registerPage.open();
		registerPage.registerWithRandomValue();
		Assert.assertTrue(registerPage.doesRegisterSuccessMessageExist());
	}

}
