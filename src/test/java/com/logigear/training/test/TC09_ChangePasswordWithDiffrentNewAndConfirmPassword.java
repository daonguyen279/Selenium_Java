package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.AccountInfo;
import com.logigear.training.common.Constant;
import com.logigear.training.page.ChangePasswordPage;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.Mailinator;
import com.logigear.training.page.RegisterPage;

public class TC09_ChangePasswordWithDiffrentNewAndConfirmPassword extends BaseTest {
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	Mailinator mailinator = new Mailinator();

	
	@Test
	public void TC09() {
		AccountInfo accountInfo = registerPage.navigateAndRegisterWithRandomValue();
		registerPage.activateAccount(accountInfo.getEmail());

		loginPage.open();
		loginPage.loginWith(accountInfo.getEmail(), accountInfo.getPassword());
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.open();
		changePasswordPage.changePasswordWith(accountInfo.getPassword(), "a123:\"/{}!@$\\", "b456:\"/{}!@$\\");
		Assert.assertEquals(changePasswordPage.getChangePasswordErrorMessageText(), Constant.CHANGE_PASSWORD_ERR_MESSAGE);
	}
}
