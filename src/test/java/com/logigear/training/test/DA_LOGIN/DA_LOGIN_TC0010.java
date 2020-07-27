package com.logigear.training.test.DA_LOGIN;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DA_LOGIN_TC0010 extends BaseTest {
	LoginPage loginPage = new LoginPage();
	DashBoardPage dashBoardPage = new DashBoardPage();

	@Test(description = "Verify that the page works correctly for the case when no input entered to Password and Username field")
	public void TC0010() {
		loginPage.loginWithBlankUsernameAndPassword();
		Assert.assertEquals( Constant.LOGIN_ERROR_MESSAGE, loginPage.getLoginErrorMessageText());
	}

}
