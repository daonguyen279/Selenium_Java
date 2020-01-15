package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.AccountInfo;
import com.logigear.training.common.Constant;
import com.logigear.training.page.ForgotPasswordPage;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.Mailinator;
import com.logigear.training.page.PasswordResetPage;
import com.logigear.training.page.RegisterPage;


public class TC12_ResetPasswordWithBlankResetToken extends BaseTest {
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	Mailinator mailinator = new Mailinator();

	
	@Test
	public void TC12() {
		AccountInfo accountInfo = registerPage.navigateAndRegisterWithRandomValue();
		registerPage.activateAccount(accountInfo.getEmail());

		loginPage.open();
		loginPage.clickForgotPassword();

		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
		forgotPasswordPage.sendInstructionsWith(accountInfo.getEmail());
		mailinator.openLinkInLatestEmail(accountInfo.getEmail());

		PasswordResetPage passwordResetPage = new PasswordResetPage();
		Assert.assertTrue(passwordResetPage.doesPassworChangeFormExist());
		passwordResetPage.setResetToken("");
		passwordResetPage.resetPasswordWithRandomValues();
		
		Assert.assertEquals(passwordResetPage.getResetPasswordErrorMessageText(),
				Constant.RESET_PASSWORD_ERR_MESSAEGE_INVALID_TOKEN);
		Assert.assertEquals(passwordResetPage.getResetPasswordTokenErrorMessageText(),
				Constant.RESET_PASSWORD_TOKEN_ERR_MESSAGE);
	}

}
