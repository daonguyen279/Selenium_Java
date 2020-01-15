package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.page.LoginPage;

public class TC01_ValidLogin extends BaseTest {
	LoginPage loginPage = new LoginPage();

	@Test
	public void TC01() {
		loginPage.open();
		loginPage.loginWith(Constant.VALID_EMAIL, Constant.VALID_PASSWORD);
		Assert.assertEquals("Welcome" + " " + Constant.VALID_EMAIL, loginPage.getLoginSuccessMessageText());
		loginPage.logout();
	}

}
