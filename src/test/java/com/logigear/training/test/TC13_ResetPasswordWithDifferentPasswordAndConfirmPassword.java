package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.AccountInfo;
import com.logigear.training.common.Constant;
import com.logigear.training.common.FakeValueHelper;
import com.logigear.training.page.ForgotPasswordPage;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.Mailinator;
import com.logigear.training.page.PasswordResetPage;
import com.logigear.training.page.RegisterPage;


public class TC13_ResetPasswordWithDifferentPasswordAndConfirmPassword extends BaseTest {
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	Mailinator mailinator = new Mailinator();


	@Test
	public void TC13() {
		AccountInfo accountInfo = registerPage.navigateAndRegisterWithRandomValue();
		registerPage.activateAccount(accountInfo.getEmail());

		loginPage.open();
		loginPage.clickForgotPassword();

		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
		forgotPasswordPage.sendInstructionsWith(accountInfo.getEmail());
		mailinator.openLinkInLatestEmail(accountInfo.getEmail());

		PasswordResetPage passwordResetPage = new PasswordResetPage();
		passwordResetPage.resetPasswordWith(FakeValueHelper.getFakeValuesService().bothify("????????"),
				FakeValueHelper.getFakeValuesService().bothify("????????"));
		
		Assert.assertEquals(passwordResetPage.getResetPasswordErrorMessageText(),
				Constant.RESET_PASSWORD_ERR_MESSAGE);
		Assert.assertEquals(passwordResetPage.getResetPasswordConfirmPasswordErrorMessageText(),
				Constant.RESET_PASSWORD_CONFIRM_PASSWORD_ERR_MESSAGE);

	}


}
