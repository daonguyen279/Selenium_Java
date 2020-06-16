package com.logigear.training.test.DA_LOGIN;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.pages.GeneralPage;


public class DA_LOGIN_TC007_VerifyThatUsernameIsNotCaseSensitive extends BaseTest {
	LoginPage loginPage = new LoginPage();
	GeneralPage generalPage = new GeneralPage();

	@Test
	public void TC007() {
		loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
		Assert.assertEquals( Constant.UPERCASE_USERNAME, generalPage.getLoginSuccessText());
		generalPage.logout();
		loginPage = new LoginPage();
		loginPage.loginWith(Constant.LOWERCASE_USERNAME, Constant.PASSWORD);
		generalPage = new GeneralPage();
		Assert.assertEquals( Constant.LOWERCASE_USERNAME.toUpperCase(), generalPage.getLoginSuccessText());
	}

}
