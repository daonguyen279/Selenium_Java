package com.logigear.training.test.DA_MP;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DA_MP_TC012_VerifyThatUserIsAbleToAddAdditionalPagesBesidesOverviewPagesSuccessfully extends BaseTest {
	LoginPage loginPage = new LoginPage();
	DashBoardPage dashBoardPage = new DashBoardPage();

	@Test
	public void TC0012() {
		loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
		dashBoardPage.clickAddPage();
		dashBoardPage.enterPageName("dao xin dep");
		dashBoardPage.submitPageInformation();
	}

}
